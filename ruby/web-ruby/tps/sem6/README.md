# Gladiator API and Front-end

Ce TP a pour but de vous faire continuer l'API JSON Rails du TP4 et de vous familiariser avec :

* Comment un écrire une page Web en Rails
* Comment écrire un form 
* Comment gérer les sessions stateful dans un site Web
* Comment gérer les sessions stateless dans une API

## Repartir du TP précédent ?

Non, il faudra repartir de la correction présente ici: https://codefirst.iut.uca.fr/git/karim.bogtob/correction-tp-rails

Petite note : Il y a maintenant dans les seeds de quoi générer des combats.

## Leaderboard

On va maintenant construire un leaderboard des combats qui ont été réalisés et offrir de quoi faire une recherche de combats. C'est votre jour de chance, on vous fournit la vue pour vous faire gagner du temps.

* Pour cela vous allez devoir coller le template suivant en tant que layout (`app/views/layouts/application.html.erb`) :

```erb
<!doctype html>
<html lang="en">
  <head>
    <title>Les joyeux de la couronne WEB</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%= csrf_meta_tags %>
    <%= csp_meta_tag %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <%= stylesheet_link_tag "application", "data-turbo-track": "reload" %>
    <%= javascript_importmap_tags %>
  </head>
  <body>
    <%= yield %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.min.js" integrity="sha384-heAjqF+bCxXpCWLa6Zhcp4fu20XoNIA98ecBC1YkdXhszjoejr5y9Q77hIrv8R9i" crossorigin="anonymous"></script>
  </body>
</html>
```

Voici la vue de la page, prenez le temps de lire le code et comprendre quels attributs devra posséder le contrôleur :

```erb
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Leaderboard</a>
    <div class="justify-content-end">
      <%= form_with url: {action: :index}, method: :get, class: 'd-flex' do |form| %>
        <%= form.text_field :query, value: params[:query], class: "form-control me-2", placeholder: "Rechercher ..." %>
        <%= form.submit "OK", class: "btn btn-outline-success" %>
      <% end %>
    </div>
  </div>
</nav>

<div class='container-fluid' >
    <table class="table table-hover table-striped table-sm">
      <thead>
          <tr>
              <th>Date</th>
              <th>Nom</th>
              <th>Combatant 1</th>
              <th>Combatant 2</th>
              <th>Résultat</th>
              <th>Gagnant</th>
          </tr>
      </thead>
      <tbody>
        <% @combats.order(created_at: :desc).each do |combat| %>
          <tr>
              <td><%= l(combat.created_at, format: :short) %></td>
              <td><%= combat.name %></td>
              <td><%= combat.left_fighter.name %></td>
              <td><%= combat.right_fighter.name %></td>
              <td><%= combat.result.capitalize %></td>
              <td><%= combat.winner&.name %></td>
          </tr>
        <% end %>
      </tbody>
    </table>
</div>
```

* Créez ou générez un contrôleur `Leaderboard` avec une action index et la route correspondante.

* Copiez le template du layout comme indiqué ci-dessus si vous ne l'avez pas encore fait.

* Copiez le code fourni ci-dessus dans la vue correspondant à l'action index (`app/views/leaderboard/index.html.erb`)

* Modifiez le code de l'action index du contrôleur pour fournir à la vue ce dont elle a besoin pour afficher les combats.

* Faites fonctionner la recherche présente dans la top bar pour filter les combats en fonction de leur nom (comme on l'a déjà fait dans l'API)

* Améliorez cette recherche pour chercher également dans le nom chercher également dans le nom de la créature victorieuse.
    * Vous pouvez appeler `#or` sur la première query et repasser une nouvelle query qui fait la recherche souhaitée.
    * Petite note : La jointure nécessaire devra se faire sur les deux queries, même sur la première qui ne l'utilise pas sinon elles seront structurellement différentes et ActiveRecord n'appréciera pas.

* Eager loader les données pour limiter le nombre de requêtes

  * Vous pouvez constater dans les logs la différence de réponse de la requête :

Avant :

```
Completed 200 OK in 75ms (Views: 67.7ms | ActiveRecord: 3.1ms | Allocations: 61092)
```

Après :

```
Completed 200 OK in 13ms (Views: 11.8ms | ActiveRecord: 0.7ms | Allocations: 9436)
```

## Gestion des utilisateurs

Nous allons ajouter à notre application des utilisateurs possédant un nom d'utilisateur et un mot de passe.

Nous devons stocker ce mot de passe de manière sécurisée dans la base de donnée.

Pour cela on va utiliser la méthode `has_secure_password` du module `ActiveModel::SecurePassword`.

* Créez ou générez un modèle `User` possédant UNIQUEMENT un `username` de type `string`. On ajoute le mot de passe dans une étape suivante.

* Faites en sorte qu'il ne puisse pas y avoir deux utilisateur créatures avec le même `username`. (Rappelez vous commment on a fait pour les créatures, deux choses à faire)

* Lisez attentivement la documentation https://api.rubyonrails.org/v7.0.4/classes/ActiveModel/SecurePassword/ClassMethods.html, et adaptez votre code :
  * Vous devez ajouter une gem spécifique à votre bundle (`bundle add xxx`)
  * Vous devez ajouter un attribut à User (`bin/rails g migration addSecurePasswordToUsers password_digest:string`) - le nom de l'attribut vient de la documentation
  * Vous pouvez maintenant appeler `has_secure_password` dans `user.rb`

* Modifiez les seeds pour créer un utilisateur `root` ayant comme mot de passe `admin123`

## Connexion

On va permettre aux utilisateurs de s'authentifier dans notre application.

Pour ça, on vous fourni la vue de l'écran de connexion :

```erb
<main class="container mt-5 m-auto">
  <% if @error_message.present? %>
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
      <i class="bi bi-radioactive"></i>
      <strong>Oups!</strong> <%= @error_message %>
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
  <% end %>

  <%= form_with url: {action: :create}, class: "text-center" do |form| %>
    <h1 class="h3 mb-3 fw-normal">Merci de vous connecter</h1>

    <div class="form-floating mt-2">
      <%= form.text_field :username, class:"form-control", placeholder:"Identifiant", value: params[:username] %>
      <label for="username">Identifiant</label>
    </div>
    <div class="form-floating mt-2">
      <%= form.text_field :password, class:"form-control", placeholder:"Mot de passe", value: params[:password] %>
      <label for="password">Mot de passe</label>
    </div>
    <%= form.submit "Connexion", class: "w-100 btn btn-lg btn-primary mt-2", data: { turbo: "false" }%>
  <% end %>
</main>
```

* Créez ou générez un controlleur `UserSessions` avec deux actions : `new` et `create`, et les routes correspondantes.

* L'action `new` affichera le formulaire, c'est pour cette action que vous utiliserez la vue fournie ci-dessus.

* Configurez la route pour brancher cet écran de connexion à l'url `http://localhost:3000/login`

* Coder l'action `create` qui :

  * Cherche l'utilisateur (`User`) correspondant à l'`username` reçu en param.
  * Vérifie que le mot de passe reçu en param est correct.
  * Si oui :
    * Met l'utilisateur en session
    * Redirige vers le leaderboard : `redirect_to controller: :leaderboard, action: :index`
  * Si non, rend la vue `new` pour afficher de nouveau le formulaire : `render :new`
    * La vue peut même afficher un message d'erreur si vous définnissez le bon attribut dans l'action

### Protégez l'application

* Modifier le leaderboard pour brider son accès aux utilisateurs connectés :
    * Si un utilisateur est connecté, le laisser accéder à la page
    * Sinon redirigez le vers le formulaire de login. (indice: `UserSessions#new`)

* Modifier les contrôleurs d'API pour brider leurs accès aux utilisateurs présents en base de données, en forçant l'envoi de l'username et mot de passe en basic auth :
    * Ajouter un contrôleur APIController (pour l'instant vide) qui hérite de ApplicationController et dont les CreaturesController et CombatsController hériteront.
    * Ajouter une before action qui vérifie l'authentification sur l'APIController. Si le client n'est pas authentifié, retourner une 403 (comme la 404).

