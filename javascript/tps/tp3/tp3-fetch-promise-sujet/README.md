## API Fetch et Async

- Async
  - https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Statements/async_function
- Promise
  - https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Global_Objects/Promise
- API Fetch
  - https://developer.mozilla.org/fr/docs/Web/API/Fetch_API/Using_Fetch

## NPM

- Commande `npm init`
  - https://docs.npmjs.com/cli/v9/commands/npm-init

## Sujet du TP

1) Convertir la méthode `loadArticlesFromJson` en méthode asynchrone
2) Modifier la classe Article pour qu'il soit composé de la propriété title, body (à la place de description) et userId (qui sera toujours égale à 1)
3) Récupérer les articles ayant les ID de 4 à 6, via un appel HTTP sur l'URL `https://jsonplaceholder.typicode.com/posts/{id}`
4) Au clic sur le bouton "Exporter", il faudra faire un appel HTTP en POST vers l'URL `https://jsonplaceholder.typicode.com/posts/` pour chaque article, et fournir dans le body de la request l'article au format JSON
5) Initialiser le package.json de votre application

## Ressources

- Lien des slides : https://drive.google.com/drive/folders/1tFK4F2RrTWAvqqEG-RpGvnTMCGohaNcz?usp=share_link
- Lien vers la documentation : https://developer.mozilla.org/fr/docs/Web/JavaScript