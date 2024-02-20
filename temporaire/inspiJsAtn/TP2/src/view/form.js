const articeService = new ArticeService();
articleService.loadArticlesFromJson(ARTICLES_JSON).forEach(a => {
    addArticleToHtml(a,'#newsList')
});

displayArticleCount();

const form = document.querySelector('form');
form.addEventListener('submit', submitForm);