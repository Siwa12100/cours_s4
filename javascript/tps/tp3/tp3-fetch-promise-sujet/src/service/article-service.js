class ArticleService {
    loadArticlesFromJson(articlesJson) {
        if (!articlesJson instanceof String)
            throw new Error('Chaine JSON non reconnue');

        const articles = [];

        JSON.parse(articlesJson).forEach(a => {
            articles.push(new Article(a.id, a.title, a.description));
        });

        return articles;
    }

    exportArticleToJson(articles) {
        const articlesJson = JSON.stringify(articles);

        logMessage(articlesJson, 'log');
    }
}