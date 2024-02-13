class ArticleHtml {
    article;

    constructor(article) {
        this.article = article;
    }

    toHtmlElement() {
        const articleHtml = document.createElement('article');
        const span = document.createElement('span');
        const p = document.createElement('p');

        span.innerText = this.article.title;
        p.innerText = this.article.description;
        articleHtml.dataset.id = this.article.id; //l'attribut dataset permet d'accéder (en lecture et écriture) aux attributs HTML data-*
        articleHtml.appendChild(span);
        articleHtml.appendChild(p);
        articleHtml.classList.add('article'); //article.setAttribute('class', 'article');

        return articleHtml;
    }

    static displayArticleCount() { //pour déclarer une fonction on utilise le mot clé function, suivi du nom puis des paramètres entre parenthèses
        const newsList = document.querySelector('#newsList');
        const articles = newsList.querySelectorAll('#newsList .article'); //retourne une liste d'élément HTML
        const h3 = document.querySelector('h3');
    
        if (articles.length > 1)
            h3.innerText = `There are ${articles.length} articles`;
        else
            h3.innerText = `There is ${articles.length} article`;
    }
}