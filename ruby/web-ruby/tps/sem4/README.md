
# Gladiator

Ce TP a pour but de vous faire créer une API JSON Rails et de vous familiariser avec :

* La gestion des paramètres (`params`)
* La découverte d'un nouveau concept de `params` validé : les `StrongParams`
* Pratiquer les migrations
* Utiliser des scopes
* Comment écrire une API avec Rails

## -1. Repartir du TP précédent ou repartir de zéro

Vous pouvez repartir du TP précédent, c'est du travail de gagné sur ce TP et vous pourrez modifier la vue du welcome (`/`) pour ajouter du détail sur les créatures au fur et à mesure. 

Pensez à modifier `to_label` si c'est le cas.

Si vous repartez de zéro, n'oubliez pas d'ajouter le modèle créature avec les commande suivantes :

```ruby
rails g model Creature name:string health_points:integer
rails db:migrate
```

⚠️⚠️ **DANS TOUS LES CAS**, ajoutez cette ligne dans votre ApplicationController. ⚠️⚠️ 

```ruby
class ApplicationController < ActionController::Base
  skip_forgery_protection # Cette ligne
end
```

Ça permettra de faire en sorte que votre API puisse recevoir des requêtes sans passer par l'interface.

## 0. Params, où sont mes params ?

Rails vous permet de récupérer des paramètres provenant :
* de l'URL de la requête HTTP : Quand vous déclarez votre route, vous la paramétrisez. 

> Exemple dans les routes : `get "/word-length/:word", to: 'calculations#word_length'`

* des paramètres GET de l'URL de la requête HTTP (après le `?` et séparés par des `&`)

> Exemple :  On pourra récupérer les params `{ "never" => "gonnagiveyouup", "run" => "aroundanddesertyou" }` via
`www.example.org/rickroll?never=gonnagiveyouup&run=aroundanddesertyou`

* des paramètres POST/PUT dans le body de la requête en fonction de l'encodage du body (`application/x-www-form-urlencoded` ou `application/json`)

### 0.1 Petit rappels de cours :

* Params s'utilise comme un dictionnaire (`Hash`)

* Toutes les valeurs reçues dans params sont de type `String`

```ruby
class CalculationsController < ApplicationController
   # get "/word-length/:word", to: 'calculations#word_length'
  def word_length
    @result = params[:word].size
  end
end
```

* Quand votre API reçoit des requêtes HTTP avec le header `"Content-Type"` de la requête est `"application/json"`, Rails va convertir automatiquement le `JSON`, et on pourra y accéder sous forme de Hash dans `params`.

### 0.2 Les 💪 strong 💪 params :

En recevant des paramètres, on peut valider les paramètres avec le concept de StrongParameters. En partant de votre Hash magique `params`, vous pouvez appeler la méthode `require` pour spécifier que vous voulez impérativement un paramètre et `permit` pour autoriser des paramètres.

Tout paramètre non autorisé sera nettoyé.

Petit exemple issu de la documentation : https://guides.rubyonrails.org/action_controller_overview.html#strong-parameters

```ruby
class PeopleController < ActionController::Base
  # This will raise an ActiveModel::ForbiddenAttributesError exception
  # because it's using mass assignment without an explicit permit
  # step.
  def create
    Person.create(params[:person])
  end

  # This will pass with flying colors as long as there's a person key
  # in the parameters, otherwise it'll raise an
  # ActionController::ParameterMissing exception, which will get
  # caught by ActionController::Base and turned into a 400 Bad
  # Request error.
  def update
    person = current_account.people.find(params[:id])
    person.update!(person_params)
    redirect_to person
  end

  private
    # Using a private method to encapsulate the permissible parameters
    # is just a good pattern since you'll be able to reuse the same
    # permit list between create and update. Also, you can specialize
    # this method with per-user checking of permissible attributes.
    def person_params
      params.require(:person).permit(:name, :age)
    end
end
```

Pour les ressources API, on fera toujours un require du nom de la ressource au singulier. Comme dans l'exemple précédent, pour potentiellement recevoir un nom et un âge de personne à mettre à jour, on va d'abord faire un `require(:person)`.


### 0.3 Tester votre API

On vous conseille l'utilisation de Postman, qui est normalement présent sur vos machines pour tester votre API. (type de body en `raw` puis choisir encodage `json` au lieu de `text`)

Sinon vous pouvez aussi vous débrouiller avec des requêtes `curl`. 
`
Dans tous les cas, pensez au header `Content-Type: application/json`. Il y a des exemples dans le cours.


## 1. Fais rouler les dés 

On veut créer une URL qui retourne un jet de dé.

On peut lancer uniquement d2, d4, d6, d8, d10, d20, et d100

L'URL sera de la forme http://localhost:3000/dice-rolls/TYPE_DE_DÉ/

Elle retourne le résultat du lancé au format JSON.

Exemple http://localhost:3000/dice-rolls/d10/ retourne :

```json
{
  "dice": "d10",
  "rolls": [
    5
  ]
}
```

* Créez le contrôleur `DiceRollsController` avec un action `rolls`.

* Ajoutez la route qui va appeler le contrôleur et l'action. 

* Codez l'action qui prend le dé en paramètre et retourne le JSON. Pour retourner du JSON plutôt que du HTML à partir d'une vue, regardez la documentation de `render` : https://guides.rubyonrails.org/v5.1/layouts_and_rendering.html#using-render (2.2.8 Rendering JSON)

* Si le type de dé n'est pas connu, retournez un status code `404` (voir https://guides.rubyonrails.org/layouts_and_rendering.html#the-status-option)

* Testez

On souhaite améliorer notre contrôleur pour que notre URL accepte un nombre de lancé

Exemple http://localhost:3000/dice-rolls/d6/3 retourne :

```json
{
  "dice": "d6",
  "rolls": [
    2,
    6,
    1 
  ]
}
```

http://localhost:3000/dice-rolls/d6 continue de fonctionner, et effectue 1 lancé :

```json
{
  "dice": "d6",
  "rolls": [
    3
  ]
}
```

* Modifiez la route pour ajouter le paramètre facultatif (voir cours semaine 3)

* Modifiez l'action du contrôleur

* Testez

## 2. Ajout d'un CRUD API JSON de `Creature`

On va vouloir gérer nos créatures directement via notre API. Pour cela, on va devoir ajouter 5 nouvelles routes (C + R + U + D + L).

### 2.1 Montrer une créature (READ)

* Pour montrer une créature, on va ajouter notre contrôleur de Creature que vous devrez créer à la main. 

> N.B. : Il existe des gemmes pour faciliter la génération des modèles d'API mais par défaut sans les gemmes ça marche pas top.

* Ajouter une nouvelle route GET paramétrisée pour montrer une créature. Exemple d'URL : `localhost:3000/creatures/42` -> Montre la créature dont l'ID est 42.

* Dans contrôleur, on implémentera la méthode `#show` :

  * Récupérer le paramètre `id` de l'URL
  * Query la créature qui a cet ID pour l'assigner à l'attribut `@creature`
  * retourner une vue JSON du modèle

Pour afficher du JSON, on va pouvoir utiliser la sérialisation JSON de Rails présenté dans la documentation ici : https://api.rubyonrails.org/classes/ActiveModel/Serializers/JSON.html

Un petit exemple : (ne copiez pas bêtement)

```ruby
  voiture.as_json(only: [:id, :color, :brand])
```

### 2.1 Lister les créature (LIST)

* Ajouter une nouvelle route GET pour lister les créatures. Exemple d'URL : `localhost:3000/creatures/` -> Liste toutes les créatures.

* Dans contrôleur, on implémentera la méthode `#index` :

  * Récupérer la relation qui correspond aux créatures que l'on veut afficher
  * Assigner la relation à l'attribut `@creatures`
  * retourner une vue JSON de la liste (`as_json` fonctionne pareil sur les relations et arrays)

### 2.2 Créer une créature (CREATE)

De la même manière, on va :

* Ajouter la route POST pour créer une créature. qui correspond à `localhost:3000/creatures`
* Utiliser les StrongParams pour récupérer uniquement le nom de la créature
* Ses points de vie seront tirés aléatoirement entre 3 et 30.

* Dans contrôleur, on implémentera la méthode `#create` :

  * Utiliser les StrongParams pour récupérer uniquement le nom de la créature
  * Ses points de vie seront tirés aléatoirement entre 3 et 30.
  * Assigner la créature créée à l'attribut `@creature`
  * retourner une vue JSON du modèle

### 2.3 Mettre à jour une créature (UPDATE)

Pareil :

* Ajouter la route PUT pour modifier une créature. qui correspond à `localhost:3000/creatures/42` -> On modifie la créature dont l'ID est 42

* On supportera uniquement le renommage sur cette action, pas le changement des points de vie.

* Dans contrôleur, on implémentera la méthode `#update` :

  * Récupérer le paramètre `id` de l'URL
  * Query la créature qui a cet ID pour l'assigner à l'attribut `@creature`
  * Utiliser les StrongParams pour récupérer uniquement le nom de la créature
  * Modifier la créature
  * Assigner la créature modifiée à l'attribut `@creature`
  * retourner une vue JSON du modèle

### 2.4 Supprimer une créature (DELETE)

Rebelotte :

* Ajouter la route DELETE pour supprimer une créature. qui correspond à `localhost:3000/creatures/42` -> On supprime la créature dont l'ID est 42

* Dans contrôleur, on implémentera la méthode `#destroy` :

  * Récupérer le paramètre `id` de l'URL
  * Query la créature qui a cet ID pour l'assigner à l'attribut `@creature`
  * Supprime la créature

### 2.5. Scoping aux créatures vivantes

- Ajoutez un scope `alive` qui filtre les creatures ayant encore des points de vie.

- Modifiez le contrôleur de `Creature` pour n'accepter le renommage que des creatures encore vivantes (dans `#update`).

### 2.6. Ajout d'un enum pour stocker la taille des creatures

On veut ajouter une taille (petit, grand, géant) à nos créatures.

Cette taille dépend des points de vie de la créature à sa création :

* les petits ont moins de 10 points de vie

* les grands ont de 11 à 30 points de vie

* les autres sont géants

Rails propose le module `ActiveRecord::Enum` permettant de gérer facilement un enum à partir d'un attribut stocké en `integer` sur une table. (https://api.rubyonrails.org/v7.0.4.2/classes/ActiveRecord/Enum.html)

* Créez une migration pour ajouter un attribut `size` de type `integer` aux créatures.

* Utilisez l'enum de Rails pour définir les tailles (small, big, giant).

* Créez une migration pour mettre la bonne taille aux créatures présentes en base de données. 

On va modifier notre Creature pour que sa taille soit initialisée lors de sa création, pour ça on va ajouter une méthode `before_create` qui est un callback appelé automatiquement quand notre objet est créé.

(Pour en savoir plus sur les callbacks Rails, allez voir https://api.rubyonrails.org/classes/ActiveRecord/Callbacks.html)

Ajoutez cette méthode à vote classe Creature :

```
before_create do
  self.size = case health_points
    when 0..10
      :small
    when 11..30
      :big
    else
      :giant
  end    
end 
```

## 3. Gestion de combats : C'est la bagarre

On va pouvoir ajouter une gestion des combats entre deux créatures. Ça permettra d'utiliser des Foreign Keys et des jointures, tout en s'exerçant à s'abstraire des implémentations et répondre à un cahier des charges.

Le contrôleur devra s'appeler `CombatsController`. Il permettra de créer un combat et de lister les combats qui ont eu lieu.

Un objet combat ressemblera à ceci:

```json
{
  "left_fighter_id": 42,
  "right_fighter_id": 1337,
  "name": "Combat du siècle",
  "result": "domination",
  "winner_id": 42
}
```

Un combat porte un nom et pointera donc un combattant gauche (foreign key vers `creatures`), un combattant droit (foreign key vers `creatures`), un résultat qui est un enum (`domination` ou `draw`). Il pointera aussi vers un gagnant s'il y en a un (pas un draw).

Quand un combat est créé, les créatures pointées s'enlèvent mutuellement leurs points de vies.
>Exemple : Colère Jeanluk (42hp) affronte Abjecte Gérald (8). Abjecte Gérald est à 0hp après le combat et Colère Jeanluk est à 36hp.
Winner pointera donc sur Colère Jeanluk vu qu'il est en vie.

* Créez une migration pour stocker les combats dans la base de données.

### 3.1 Créer un combat 

Pour créer une bagarre, vous devrez ajouter une nouvelle route pour créer un combat entre deux créatures **VIVANTES**.

Le body du post ressemblera à la requête ci-dessous vu que les autres champs seront générés :

```json
{
  "left_fighter_id": 42,
  "right_fighter_id": 1337,
  "name": "Combat du siècle"
}
```

Pensez à ajouter vos relations sur le modèle `Combat` et le modèle `Creature`.

On peut implémenter l'algorithme de combat dans la classe Combat pour que le modèle enrichisse les autres champs (winner et result) automatiquement.

Vous ajouterez donc une méthode `baston!` qui fait les changements sur les créatures liées et les fait combattre.

### 3.2 Lister les combats

On ajoutera aussi une route pour lister les combats et on modifiera le `CombatsController`.

## 3.3 Filtrer des combats

On veut pouvoir filtrer un combat par son nom et par résultat.

* Modifiez l'action index du `CombatsController` pour prendre en compte deux paramètres `query` et `result`

* Pour filtrer les combats en fonction du résultat, un where tout simple suffira

* Pour filter sur le nom, vous devrez rechercher les combats contenant le critère de recherche. (utilisez LIKE : https://guides.rubyonrails.org/active_record_querying.html#conditions-that-use-like)