function submitForm(event) {
    event.preventDefault(); 
    // if (!checkForm()) {
    //     return false;
    // }

    const titleToAdd = form.querySelector('input[name=titleToAdd]');
    const descriptionToAdd = form.querySelector('textarea[name=descriptionToAdd]');

    var article = new Article(titleToAdd,descriptionToAdd)

    const articleHTML = ArticleHTML(article);
    
    articleHTML.toHTML();

    displayArticleCount();

    resetForm();

    return false; 
}

document.querySelector(selector).appendChild(articleHTML.toHTML)

function resetForm(){
    const titleToAdd = form.querySelector('input[name=titleToAdd]'); //on utilise un sélecteur par attribut [attrName=attrValue]
    const descriptionToAdd = form.querySelector('textarea[name=descriptionToAdd]'); //on utilise un sélecteur par attribut [attrName=attrValue]

    titleToAdd.value = '';
    descriptionToAdd.value = '';
}