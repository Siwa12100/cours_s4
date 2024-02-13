function checkForm() {
    resetError();
    const titleToAdd = form.querySelector('input[name=titleToAdd]'); //ici on récupère 1 seul élément ayant le tag input et l'attribut name avec la valeur titleToAdd
    const descriptionToAdd = form.querySelector('textarea[name=descriptionToAdd]'); //ici on récupère 1 seul élément ayant le tag textarea et l'attribut name avec la valeur descriptionToAdd

    try {
        let lastId = document.querySelectorAll('#newsList article').length;

        return new Article(++lastId, titleToAdd.value, descriptionToAdd.value);
    } catch (error) {
        if (error instanceof RequiredFieldError) {
            const errorForm = form.querySelector('#errorForm');
            errorForm.setAttribute('style', `color: ${ERROR_COLOR}`);
            errorForm.innerText = error.message;
        }

        return null;
    }
}

function resetError() {
    const errorForm = form.querySelector('#errorForm');
    errorForm.innerHtml = '';
}

function resetForm(form){
    form.querySelector('input[name=titleToAdd]').value = '';
    form.querySelector('textarea[name=descriptionToAdd]').value = '';
}

function submitForm(event) {
    event.preventDefault(); //permet de bloquer le rechargement de la page à la validation du formulaire
    const article = checkForm();
    if (!article) {
        return false;
    }

    addArticleToHtml(article, '#newsList');

    ArticleHtml.displayArticleCount();

    resetForm(form);

    return false; //permet de bloquer le rechargement de la page à la validation du formulaire
}

function addArticleToHtml(article, selector) {
    const articleHtml = new ArticleHtml(article);
    document.querySelector(selector).appendChild(articleHtml.toHtmlElement());
}

function exportArticlesButtonClick() {
    const articleHtml = document.querySelectorAll('#newsList article');
    const articles = [];

    articleHtml.forEach(a => {
        const span = a.querySelector('span');
        const p = a.querySelector('p');

        articles.push(new Article(a.dataset.id, span.innerHTML, p.innerHTML));
    });

    const articleService = new ArticleService();
    articleService.exportArticleToJson(articles);
}