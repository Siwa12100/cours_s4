---
layout: post
title: "TP2 de programmation objet interprétée - les joyeux de la couronne"
categories: ruby-2a
---

# Les joyeux de la couronne

Ce TP a pour but de vous faire pratiquer les bases du langage Ruby, en particulier :

* Classes, héritage, construction, attributs, méthodes et module
* Continuer à utiliser Hash et Map

## Préliminaires

Suivez bien les indications pour la réalisation du TP, nommez les attributs et méthodes comme recommandé sinon vous vous débrouillerez pour adapter le sujet du TP dans les questions suivantes.

### Creature

Créez une classe `Creature` dotée:

* d'un nom `@nom`
* d'un nombre de points de vie `@pv`
* d'une méthode `encaisser(degats)` qui enlève des pv
* d'une méthode `to_s` pour la conversion de la créature en texte : "Nom (pv)"
* de getters pour le nom et le nombre de points de vie

N'oubliez pas, le fichier de la classe doit s'appeler `creature.rb`.

Testez!

### Troll

Créez une classe `Troll` dans son propre fichier qui hérite de `Creature`.

Faites en sorte qu'un troll affiche TOUJOURS son nom en majuscule. (`to_s`)

### Gobelin

Créez une classe Gobelin qui hérite de Creature. La méthode `encaisser` de Gobelin enlève a ses points de vie la moitié des dégâts (le gobelin est vif, agile, et difficile à viser car de petite taille).

### Besoin de heal "MEDIIIIC !"

Définissez un module `Soignable` dans son propre fichier qui contient la méthode `soigner(pv)` qui ajoute pv au nombre de points de vie de la créature. Ce module fera la supposition que la classe qui l'inclut possède un attribut `@pv`.

### La compagnie

Un groupe de gobelins et de trolls (les *joyeux de la couronne*) visite le donjon de Rhaalduck, célèbre soit disant pour ses nombreux trésors riches en pierre précieuses. Les couloirs de ce sinistre bâtiment ne permettent qu'un passage en file indienne.

* Créez une classe `Compagnie` pour stocker un groupe d'aventuriers.
* Dotez la des méthodes permettant d'ajouter des créatures. Interdisez les homonimies en lançant une exception.
* Ajoutez à ce groupe les Creatures suivantes:
  - Gruk est un troll. Il a 27pv
  - Grok est le petit frère de Gruk. Il n'a que 24pv
  - Zak est un gobelin. Il a 12pv
  - Zog n'est pas le frère de Zak mais c'est un gobelin quand même. Il a 13pv
* Créez une méthode qui permet d'afficher la compagnie

## Gestion de la mort - Expulsion de la compagnie et extension des créatures

Avant de faire plus d'aventures avec le groupe d'aventuriers, on va gérer la possible mort de nos aventuriers.

On aimerait réaliser quelque chose comme suit :

0. Quand une créature rejoint une compagnie, la compagnie dit à la créature qu'elle est acceptée dans la compagnie (`acceptee_dans(compagnie)`).
1. Quand une créature atteint un nombre de point de vie inférieur ou égal à zéro, cette dernière pousse un cri d'agonie (`cri_agonie`) en direction de la compagnie.
2. Quand un cri d'agonie est entendu, la compagnie laisse de corps de l'aventurier en arrière. Et les autres aventuriers se décalent pour prendre sa place dans la file indienne.

**On va réaliser cette implémentation dans les étapes ci-dessous.**

### Expulsion de la compagnie

Pour cela, on va déjà implémenter une méthode `observer_mort(creature)` sur la compagnie. Quand une créature sera entendue comme morte, elle sera supprimée de la liste d'aventuriers.

Exemple : Si la compagnie contient `[Gruk, Grok, Zak, Zog]` et que Zak meurt, la compagnie contiendra `[Gruk, Grok, Zog]`.

### Devenir un mortel

* On va implémenter un module `MortelObservable` qu'on incluera dans la classe `Creature`. Mais pour bien vous montrer qu'on peut réouvrir et améliorer une classe depuis un autre fichier. On va ici considérer que c'est la `Compagnie` qui vient avec son "extension" de `Creature`.
Ça veut dire qu'on ajoutera un bout de code qui fait l'include de `MortelObservable` dans la classe `Creature` dans le fichier de `Compagnie` comme ceci. **En revanche, pour cette inclusion de module, on utilisera le mot clef `prepend` et non `include`.** (On verra en cours pourquoi.)

* Ce module `MortelObservable` définira une méthode `acceptee_dans(coompagnie)` pour que la créature se souvienne de la compagnie dont elle fait partie dans un attribut `@compagnie`.

* Ce module introduira aussi une méthode `cri_agonie` pour que la créature prévienne la compagnie qu'elle est morte (via `observer_mort(self)`), si elle fait partie d'une compagnie.

* Ce module surchargera la méthode `encaisser(degats)` pour appeler la méthode originelle, puis réaliser un `cri_agonie` si les `@pv` sont inférieurs ou égals à zéro.

### Notifier l'ajout dans la compagnie

Maintenant, on va partir du principe que toutes les creatures ajoutées à la compagnie sont des mortels observables. Donc, on va pouvoir les notifier via leur méthode `acceptee_dans(compagnie)` qu'ils sont acceptés dans la compagnie.

On pourra appeler cette méthode dans la méthode d'ajout de membre lorsqu'il n'y a pas eu de cas d'homonymie et que la créature est ajoutée dans la compagnie.

## L'exploration

Pour la suite des questions, dotez votre compagnie d'une méthode `exploration`, appelant éventuellement d'autres méthodes, qui simule les actions suivantes. Votre code doit être court et joli. Ça veut dire qu'il faut ouvrir la doc d'`Enumerable` et `Array` et se forcer à utiliser les méthodes les plus spécifiques.

**Note**: Quand on dit, par exemple, "Zak encaisse", vous devez retrouvez Zak grâce à votre algorithme, pas le calculer sa position à la main!

1. Le premier personnage pose le pied sur une dalle de couleur différente des autres et encaisse 10 dégats.
2.  Le groupe décide alors de faire passer Zak en tête afin de servir d'éclaireur (il passe devant, pas de permutation).
* 3 étapes : On trouve Zak, on l'enlève du tableau, on le mets à l'avant. 3 méthodes spécifiques.
3.  Gruk, blessé, échange sa place avec son frère. On trouve l'index de l'un, de l'autre et on les swap façon `a, b = b, a`.
* Il existe une méthode pour trouver l'index d'un élément en fonction d'un prédicat.
4.  Une trappe s'ouvre sous les pieds du deuxième personnage (le gobelin de tête étant trop léger pour activer le piège). Celui-ci encaisse 14 dégats.
5.  Le groupe trouve une potion de soins et la fait boire à celui qui a le moins de points de vie (+5pv).
* Il existe une méthode pour trouver le minimum selon un prédicat.
6. Au détour d'un couloir mal éclairé, la première créature marche sur une rune étrange sournoisement dissimulée sous un tapis. Le groupe entier encaisse 10 dégats mais s'embrase de façon très esthétique.
7. Alerté par le bruit de l'explosion, le grand et vil Zangdar s'approche et leur lance une malédiction de Kozysar (petit démon du troisième cercle). Ce sort a un effet compliqué: envoyé contre un groupe, il inflige 15% du total des PV du groupe à **chacun** des membres du groupe.
8. Le groupe compte-il des survivants? En tous cas, il s'organise alors par ordre décroissant de PV, et charge!
* Il existe une méthode pour trier selon un prédicat.
9. Le groupe arrive enfin a portée de massue de Zangdar. Celui ci lance successivement cinq rayons lunaires qui viennent tour à tour frapper le premier du groupe, lui infligeant 5 points de dégats par rayon. Si celui-ci meurt, il est supprimé et remplacé naturellement par le suivant. Zangdar fait un échec critique après le cinquième sort lancé et se bannit tout seul dans les limbes.
10. Combien reste-il de survivants?
11. Combien de créatures ont plus de 3PV?

## Utilisation d'un linter/correcteur de code : Installation de `Rubocop`

`rubocop` est un vérificateur de syntaxe et de style Ruby. Usage classique: `rubocop programme.rb`. D'autres options sont aussi très utiles, à vous de chercher.

Pour installer la gemme qui contient `Rubocop`, vous pouvez utiliser:
~~~~
gem install --user-install rubocop
~~~~

Notez bien les mofifications à votre `PATH` que vous proposera `gem`.

Utilisation de Rubocop:

~~~~
rubocop fichier.rb
~~~~

Si vous voulez corriger les choses triviales (après avoir vérifié)
~~~~
rubocop -a fichier.rb
~~~~

