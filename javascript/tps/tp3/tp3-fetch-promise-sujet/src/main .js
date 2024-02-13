const articleService = new ArticleService();

async function initialisationArticles() {
    let lesArticles = await articleService.loadArticlesFromJson(ARTICLES_JSON);
    lesArticles.forEach(a => {
        addArticleToHtml(a, '#newsList');
    });
}

initialisationArticles();

console.log(articleService.loadArticlesFromJsonApi("https://jsonplaceholder.typicode.com/posts"));

ArticleHtml.displayArticleCount();

const form = document.querySelector('form');
form.addEventListener('submit', submitForm);

const exportArticlesButton = document.querySelector('#exportArticles');
exportArticlesButton.addEventListener('click', exportArticlesButtonClick);