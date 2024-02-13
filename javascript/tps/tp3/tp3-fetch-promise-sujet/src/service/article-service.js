class ArticleService {

    async loadArticlesFromJson(articlesJson) {
        if (!articlesJson instanceof String)
            throw new Error('Chaine JSON non reconnue');

        const articles = [];

        JSON.parse(articlesJson).forEach(a => {
            articles.push(new Article(a.id, a.title, a.description));
        });

        return articles;
    }

    async loadArticlesFromJsonApi(cheminApi) {
        const lesArticles = await fetch(cheminApi);
        return lesArticles.json();
    }

    exportArticleToJson(articles) {
        const articlesJson = JSON.stringify(articles);
        logMessage(articlesJson, 'log');
    }
}