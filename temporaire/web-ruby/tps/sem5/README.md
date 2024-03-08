# Gladiator API V2

Ce TP a pour but de vous faire continuer l'API JSON Rails du TP4 et de vous familiariser avec :

* Comment écrire une API avec Rails
* Utiliser des validations
* Utiliser des transactions
* Gérer les erreurs

Ce TP est une extension du précédent et peut se réaliser très vite, même s'il vous reste 30 minutes.

## Repartir du TP précédent ?

Pas le choix, il faut finir le TP précédent.

## 1. Validations

On va ajouter des validations aux modèles et changer les méthodes de création/mise à jour/suppression des records pour utiliser celles qui lèvent des erreurs si une validation apparait. (indice : `!`)

### 1.1 Faire une créature qui soit logique

* Ajoutez une validation qui force que le nom d'une créature soit présent.

* Ajoutez une validation qui s'assure que les points de vie d'une créature soient toujours `>= 0`.

* Il vous faudra peut être retaper la méthode `baston` du combat pour que les PVs soient toujours `>= 0`.

* Testez dans une console rails (`bin/rails console`).

* Vérifier dans votre API que cela fonctionne.

> N.B. : Si vous avez déjà créé des créatures non valides, libre à vous de les trouver et les détruire. (Ou réécrire la base)

### 1.2 Unicité des créatures

* Faites en sorte qu'il ne puisse pas y avoir deux créatures avec le même nom.

* Pensez à la race condition et à l'index nécessaire.

* Testez dans une console rails (`bin/rails console`).

* Vérifier dans votre API que cela fonctionne.

### 1.3 Faire des combats réalistes

* S'assurer que nous faisons bien combattre deux créatures vivantes au moment du combat.

* S'assurer que nous faisons combattre deux créatures de même taille lorsque le combat est déclaré.

* Testez dans une console rails (`bin/rails console`).

* Vérifier dans votre API que cela fonctionne.

## 2. Gérer les erreurs de façon générique

* Ajoutez des `rescue_from` pour éviter de devoir gérer l'absence des créatures et bien renvoyer une 404 avec body vide. Laissez une 404 si on essaie de créer un combat entre créatures absentes (ça devrait être le comportement après votre modification).

## 2. Petit test de callback de contrôleurs

* Ajoutez une `before_action` pour que si quelqu'un créé un combat entre créatures `big`, le message "Laissez passer les costauds !" s'affiche (avec `puts`) dans le terminal depuis lequel le serveur à été lancé.

  * Vous pouvez aussi écrire dans les logs du serveur (c'est mieux), avec `logger.debug`, voir : https://guides.rubyonrails.org/debugging_rails_applications.html#sending-messages

* Ajoutez une `before_action` pour que lorsque l'on crée une créature qui devrait avoir plus de 60 points de vie, son nom soit préfixé par "Big ". Il faudra donc aussi supporter qu'une créature puisse être créée avec le paramètre optionnel `health_points`. Jusqu'à présent, cet attribut était tiré aléatoirement et maintenant il le sera maintenant uniquement lorsque le paramètre optionnel n'est pas fourni.

## 4. Renvoyer de meilleures erreurs

### 4.1 Retourner des erreurs

* Maintenant que les modèles ont des validations, on va catcher les erreurs de validation avec un `rescue_from` pour renvoyer une 422 avec un body qui décrit les erreurs, comme ci-dessous :

Je POST une créature comme ceci : 

```json
{
  "name": " ",
  "health_points": -20
}
```

Je devrais recevoir une 422 avec le body suivant :

```json
{
  "errors": [
    "Name can't be blank",
    "Health points must be greater than 0"
  ]
}
```

### 4.2 Les combats aussi retournent de belles erreurs

* Faire en sorte que les combats renvoient un message correcte si une des créatures est absente. 

    * Pour cela, on va changer la méthode utilisée lorsqu'on récupère les créatures dans la création de combat pour `find_by(id: params[:id])` 🎉🎉🎉
    * Avec la gestion d'erreur de l'exercice 4.1, ça devrait faire l'affaire !
