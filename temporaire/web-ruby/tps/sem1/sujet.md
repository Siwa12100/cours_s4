---
layout: post
title: "TP1 de programmation objet interprétée - Entrée en matière"
categories: ruby-2a
---

# Entrée en matière

Ce TP a pour but de vous faire pratiquer les bases du langage Ruby, en particulier :

* Prendre en main l'environnement
* Bases de la bibliothèque standard
* Méthodes
* Hash et Map
* Une façon de tester
* Apprendre à mélanger intuition et parcours de la documentation pour découvrir le Ruby que l'on ignore encore

Ruby est un langage 100% objet, tout est objet, même nil (null) ! Mais avant de se lancer dans de la programmation objet, assurons nous d'avoir bien les bases : Amusons avec des scripts classiques, Ruby permet ça aussi !

## Outils

1. Votre éditeur de texte/IDE préféré! Pas de guerre de religion ici! (Liste non exhaustive en bas).
2. *irb* : le débogueur ruby. Idéal pour tester directement des commandes. Peut aussi servir à déboguer.
3. *pry*: irb, en mieux: avec debogueur et couleurs. Installable comme une gemmme (cf. votre cours).
3. *rspec* sera utile pour ce TP. C'est un outil de tests unitaires (ils vous sont fournis cette semaine).
3. *ri*: l'aide locale de ruby, plus rapide que le réseau mais moins jolie (exemple `ri String#scan`)
4. Une ancienne version d'un bon livre sur ruby a été ouverte. Vous la trouverez [là](http://ruby-doc.com/docs/ProgrammingRuby/). Elle ne couvre pas tous les ajouts récents mais toute la base du langage est toujours bonne, et bien expliquée.
5. Doc de référence: l'officielle sur [ruby-doc.org](https://ruby-doc.org/core-2.6/). Barre de recherche en haut à droite.
6. Un [cours de programmation](http://evc-cit.info/cit020/beginning-programming/index.html) écrit avec Ruby comme langage support.

Une rapide présentation des IDE ruby est disponible à la fin de ce document... Si vous avez un IDE préféré, il devrait faire l'affaire.


## 1 - Katas marrants

Télécharger les fichiers de ce répertoire (sujet, ainsi que les tests unitaires et fichiers de données nécessaires).

>De la même manière que pour un pratiquant d'art martiaux, les katas sont des exercices que font les développeurs pour améliorer leurs compétences via répétition et entraînement.

Vous devez éditer le fichier `katas.rb` qui contient une liste de fonctions à écrire.

Vous pouvez vérifier vos katas au fur et à mesure de votre dev avec les tests unitaires écrits pour cet usage. Pour cela, ouvrez un terminal, allez dans le dossier de votre projet et tapez simplement `rspec`. Si il n'est pas installé, regardez la section suivante

### Installation de `rspec`

On installe la gemme:
`gem install --user-install rspec`

On cherche le répertoire d'exécutables à ajouter au PATH:

~~~
find ~/.gem -name bin -type d
/home/delobel/.gem/ruby/2.7.0/bin
~~~

On ajoute le chemin au PATH dans le  .bashrc (attention, vous n'avez pas forcément la même version de ruby).
`echo 'PATH="$PATH:/home/delobel/.gem/ruby/2.7.0/bin"' >> ~/.bashrc`

On relit le fichier de conf:
`source ~/.bashrc`

## 2 - Calcul de fréquences
### Consignes

Le but de cet application, c'est de prendre un nom de fichier en paramètre et de ressortir les fréquences (nombre d'occurence d'un mot par rapport au nombre de mots total) des 20 mots les plus courants du fichier, en ignorant les mots de moins de 3 caractères et bien sûr les ponctuations.

On veut donc pouvoir la lancer comme suit sur le fichier exemple  `french_text.txt`:

```sh
$>ruby frequency.rb french_text.txt
```

Et avoir le résultat suivant :

```
corbeau: 0.029
que: 0.022
vous: 0.022
tes: 0.022
tre: 0.015
bec: 0.015
fromage: 0.015
renard: 0.015
peu: 0.015
monsieur: 0.015
sans: 0.015
votre: 0.015
ces: 0.015
sur: 0.007
arbre: 0.007
perch: 0.007
tenait: 0.007
son: 0.007
par: 0.007
odeur: 0.007
```

Attention, si on ne passe aucun paramètre au programme, un message d'erreur doit s'afficher sur le flux d'erreur (`$stderr`). Exemple :

```
$>ruby frequency.rb
usage: frequency.rb <text_file>
```

### Quelques pistes...

L'utilisation de [Hash](https://docs.ruby-lang.org/en/2.0.0/Hash.html) pour le comptage des mots est particulièrement utile. Surtout si vous l'initialisez avec une valeur par défaut en cas de clef absente...

On ne peut que vous conseiller de séparer l'application en plusieurs responsabilités :

* Lecture du fichier texte
* Nettoyage du texte (pour la ponctuation par exemple)
* Séparation du texte en mots
* Comptage des occurences des mots
* Calcul des fréquences (normalisation des occurences)
* Tri et affichage des 20 premiers résultats
* Programme principal qui associe les différentes responsabilités ensemble

Pour nettoyer le texte, vous pouvez regarder ce que fait `String#gsub(motif, remplacement)`. Un motif peut être une expression rationnelle Ruby (`/^lapino?s/` par exemple).

Cela vous permettra d'écrire plusieurs petites fonctions que vous pourrez tester au fur et à mesure. N'hésitez pas à vous référer aux katas écrits avant.

### Variante (si vous avez été très rapide sur le précédent)

Ajoutez une option -l à votre programme qui permet de calculer la fréquence des différentes lettres du texte.

## 3 - Détection de langues

On vous fournit un fichier JSON `stop_words.json` qui contient les [mots vides](https://fr.wikipedia.org/wiki/Mot_vide) (ou *stopwords*) les plus courants dans les langues les plus courantes.

Les mots sont au format qui suit :

```json
{
  "<label de la langue>": [
    "<mot vide 1>",
    "<mot vide 2>",
    ...
  ],
  ...
}
```

L'idée est de détecter quelle langue est utilisée dans un texte en fonction de ces mots vides. Ainsi, si le texte a la plus grande intersection avec des mots vides de la langue labellisée 'fr' (french), on pourra supposer que le texte est en Français.

L'algorithme est le suivant :

* charger le fichier cible, mettre les mots dans un tableau, supprimer les doublons
* pour chaque langue de la référence
  * récupérer la liste des mots vide de la langue courante
  * calculer l'intersection entre les mots vides de la langue courante et les mots du texte
  * retenir la taille de l'intersection pour la langue courante (un conseil ici, utilisez un hash pour associer langue et taille)
* fin pour

trouver le maximum des intersections calculées
afficher le label du maximum des intersections


On va fournir un texte à analyser via un paramètre de l'application :
```
$>ruby detect_language.rb french_text.txt
```

Et on s'attendra au résultat suivant :
```
Detected language: 'fr'
```

Attention, si on ne passe aucun paramètre au programme, je voudrais un message qui averti l'utilisateur. Exemple :
```
$>ruby detect_language.rb
usage: detect_language.rb <text_file>
```

Testez sur les fichiers `french_text.txt`, `english_text.txt` et `german_text.txt`

### Quelques pistes
On peut vous conseiller de séparer votre code en responsabilités différentes via des méthodes :

|Nom de la méthode|Paramètres|Détail|
|--------|--------|--------|
|load_reference|reference_file_path|Méthode qui renvoie le fichier JSON chargé dans un hash|
|load_text_file|text_file_path|Méthode qui fait le chargement, le nettoyage et la séparation du fichier texte en mots|
|intersection_sizes|reference, text_words| Méthode qui prend la référence et calcul l'intersection entre la liste de mots d'une langue et les mots du texte|
|detect_language|reference, text_words| Méthode qui appelle la méthode précédente et parcours les intersections pour trouver la plus grande et retourne son nom


* Attention lors de la lecture du fichier texte, se référer au deuxième exercice
* Un opérateur magique sur [Array](https://docs.ruby-lang.org/en/2.0.0/Array.html) existe... Il s'écrit comme le 'ET' binaire
* Ne vous laissez pas intimider par le [JSON](http://ruby-doc.org/stdlib-2.0.0/libdoc/json/rdoc/JSON.html), vous n'avez qu'une méthode statique à appeler sur le module pour parser le document. Cela vous renvoie un Hash qu'il vous suffira de parcourir.
* Pour charger une dépendance de Ruby, on utilise `require 'une_dependance'`.  `une_dependance` est un fichier ruby qui peut être dans l'installation standard de Ruby (C'est le cas de JSON), ou une gemme (le système de paquets de ruby que l'on verra par la suite).

## IDE

Les goûts et les couleurs, ça ne se discute pas: il y a rarement d'IDE qui fasse l'unanimité pour un langage ouvert. Voici néanmoins quelques possibilités.

* Vim colore et indente vite.
* Emacs a de bons plugins Ruby, mais nécessite pas mal de configuration pour donner son plein potentiel.
* Geany est un éditeur de texte tout simple mais qui fait bien son boulot.
* Eclipse, Faut être patient au lancement, comme toujours, mais le plugin est correct (Partie de dltk - Dynamic Language ToolKit, qui gère aussi d'autres langages interprétés).
* [Atom](https://atom.io/) est un éditeur libre, développé par github, pas packagé sur debian.
* [Aptana](http://www.aptana.com), un IDE basé sur éclipse. Bonnes capacités aussi pour Ruby On Rails. Disponible aussi sous forme indépendante (un package tout pret).
* Orable a poussé Netbeans à se concentrer sur Java, mais la communauté a repris le développement d'un plugin Ruby & Rails disponible [sur le site officiel](http://plugins.netbeans.org/plugin/38549)
* [RubyMine](https://www.jetbrains.com/ruby/index.html), un IDE dédié à Ruby et Rails, par JetBrains, qui fait aussi IntelliJ, PHPStorm, Clion, etc.
* [Sapphire](http://www.sapphiresteel.com/Products/Ruby-In-Steel/Ruby-In-Steel-Developer-Overview.html), un IDE basé sur visual studio.
* [VS Code](https://code.visualstudio.com/) n'est pas disponible sous Debian, mais un paquet debian est disponible sur le site.
* [VSCodium](https://github.com/VSCodium/vscodium) est une rebuild de VSCode avec uniquement la configuration "comminity" (Sans le branding, la télémétrie, et en licence MIT). Sous ArchLinux, il est en d&pot `aur`, sous debian, vous trouverez les paquets [dans les release](https://github.com/VSCodium/vscodium/releases) du dépot.

