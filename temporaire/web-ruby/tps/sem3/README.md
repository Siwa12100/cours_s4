---
layout: post
title: "TP3 de web ruby - les joyeux de la couronne web"
categories: ruby-2a
---

# Les joyeux de la couronne (web)

Ce TP a pour but de vous faire créer une première application Rails et d'en découvrir les premiers concepts, en particulier :

* L'arborescence
* Les outils en ligne de commande
* Les routes
* Les modèles
* Les migrations
* Les contrôleurs
* Les vues

## Note importante

> Si la commande n'est pas donnée, c'est qu'elle est dans le cours ou le lien fourni.

## 1. Installation de rails

* Vérifiez la version de sqlite et de ruby sur votre système

* Installez la gemme rails (comme a déjà installé `rspec`) sauf qu'il n'est pas utile d'ajouter quoi que ce soit dans notre `PATH` (c'est déjà fait).

## 2. The Rails Command Line

Pour les étapes suivantes, nous allons nous servir des outils en ligne de commande fournis par rails : 

https://guides.rubyonrails.org/command_line.html (vous avez une liste à droite)

### 2.1. Création de l'application

Créer une application rails portant le nom "jdlc"

Vous allez avoir un soucis de droit d'accès lors du `bundle install`.

On relancer va `bundle install` nous meme en lui précisant d'installer les gemmes dans un chemin précis.

* Installez bundler : `gem install --user-install bundler`

* Allez dans le dossier jdlc (`cd jdlc`)

* Executez `bundle install --path vendor/bundler`

* Revenez dans le dossier parent (`cd ..`), et refaites le `rails new jdlc` pour qu'il termine la création de l'application

* Revenez dans le dossier jdlc (`cd jdlc`)

Vous êtes à la racine de l'application.

Observez les fichiers qui sont créés et les dépendances installées.

Vous retrouvez l'arborescence décrite dans le cours, **visitez là**.

### 2.2. Lancement de l'application

`bin/rails server` lance un serveur web sur le port 3000.

C'est fait, votre application fonctionne !

Les logs de l'application sont affichés dans le terminal.

Allez voir à quoi elle ressemble avec votre navigateur préféré sur http://localhost:3000

### 2.3. Modifier la page d'accueil

On va commencer par personnaliser la page d'accueil.

* Créer un contrôleur `HomeController` avec une action `welcome`.

* Servez-vous du générateur décrit dans la documentation (`bin/rails generate`).

* Modifier `config/routes.rb` pour faire pointer la racine (/) sur l'action `welcome` de `HomeController`.

* Retournez dans le navigateur et rafraichissez la page (F5)

* Modifiez maintenant la vue concernée avec un contenu simple tel que :

``` 
<h1>Les joyeux de la couronne</h1>

<p>Bienvenue !</p>
```

* Retournez dans le navigateur et rafraichissez la page (F5)

* Affichez la source HTML de la page

Vous remarquerez que la vue ne contient que le `<body>` de la page HTML.

Si vous souhaitez modifier le layout, pour modifier la balise `<title>` par exemple, vous le trouverez dans `app/views/layouts/application.html.erb`

## 3. Créer un modèle Creature

* Générez un modèle `Creature` dotée :
  * d'un nom (`name`) en chaine de caractère (type `string`)
  * d'un nombre de points de vie (`health_points`) en entier  (type `integer`)

* Observez les fichiers créés

* Retournez dans le navigateur et rafraichissez la page (F5) : que se passe t-il ?

* Allez voir le fichier de migration indiqué sur la page.

> Les migrations sont un moyen pratique de modifier votre schéma de base de données au fil du temps de manière cohérente. Elles utilisent un DSL en ruby pour que vous n'ayez pas à écrire du SQL à la main, ce qui permet à votre schéma et à vos modifications d'être indépendants de la base de données.

* Lancez les migrations pour mettre à jour votre base de données.

* Retournez dans le navigateur et rafraichissez la page (F5) : tout est rentré dans l'ordre.

* Ajouter une méthode `to_label` à `Creature` pour la conversion de la créature en texte : "Nom (pv)"

### 3.1. Tester notre modèle Creature

On va se servir de la console rails pour tester notre modèle `Creature`.

Comme irb, elle permet d'executer du code ruby en live, mais au sein de son application Rails.

Pour créer une créature, il faut appeler la méthode create sur classe `Creature`.
Cette méthode, fournie par ActiveRecord, créé une instance de créature et la sauvegarde en base de données.

(https://guides.rubyonrails.org/active_record_basics.html#create)

* Lancez une console rails, créez des créatures et testez la méthode `to_label`.

* Observez les requêtes SQL correspondantes qui sont exécutées.

### 3.2. Peupler sa base de donnée avec des créatures (Seeds)

On veut initialiser notre application avec un nombre aléatoire de créature.

Pour ajouter des données initiales après la création d'une base de données, Rails dispose d'une fonctionnalité intégrée appelé "seeds".

Il s'agit d'un script ruby qui va peupler la base de donnée. (`db/seeds.rb`)

#### Gestion de dépendances : bundle

Pour ajouter un peu de réalisme on va donner des noms fantasy à nos créatures, pour ça on va utiliser la gemme https://github.com/folkengine/random_name_generator

* Lire la documentation de bundler https://bundler.io/guides/getting_started.html#getting-started
* Suivez la documentation pour installer la gemme (https://github.com/folkengine/random_name_generator#installation)

* Relancer le serveur

> Les binaires de `./bin` chargent le bundle de dépendances.

#### Faire un peu le ménage

Maintenant, modifiez le fichier `db/seeds.rb` :
* Créez un nombre aléatoire de créature (entre 10 et 20).
* Chaque créature à un nom réaliste (généré grace à la gemme `random_name_generator`) et un nombre de point de vie aléatoire.
* Les seeds doivent afficher chaque créature créée via `to_label`.

Voici un exemple de sortie :

```
$ bin/rails db:seed
Création de Ignacol (14)
Création de Gubress (19)
Création de Dorveds (3)
Création de Gorlduriel (19)
Création de Pabeill (17)
Création de Valdad (9)
Création de Ladakat (15)
Création de Guhanoth (7)
Création de Awbast (2)
Création de Drunafat (20)
Création de Deshignal (16)
Création de Rakbis (18)
```

## 4. Afficher les créatures sur l'accueil

On souhaite afficher sur l'accueil le nombre de créature en base et leur “labels”.

* Chargez les créatures et le count dans le contrôleur

* Modifier la vue pour les afficher, avec des `<ul>` / `<li>` (voir cours)

On remarque qu’on a en base de données les créatures créées en console en plus des seeds.

* Découvrez les commandes rails `db:drop`, `db:create`, `db:migrate`, `db:seed`, `db:setup`, `db:reset`

Par exemple pour `db:migrate`, lancez `bin/rails db:migrate -h`.

