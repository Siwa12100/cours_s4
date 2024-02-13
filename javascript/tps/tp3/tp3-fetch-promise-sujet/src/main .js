const articleService = new ArticleService();
articleService.loadArticlesFromJson(ARTICLES_JSON).forEach(a => {
    addArticleToHtml(a, '#newsList');
});
ArticleHtml.displayArticleCount();

const form = document.querySelector('form');
form.addEventListener('submit', submitForm);

const exportArticlesButton = document.querySelector('#exportArticles');
exportArticlesButton.addEventListener('click', exportArticlesButtonClick);