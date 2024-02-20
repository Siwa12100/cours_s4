class ArticleHTML{
    constructor(article){
        this.article = article;
    }

    toHTML(){
        const article = document.createElement('article');
        const span = document.createElement('span');
        const p = document.createElement('p');

        span.innerText = this.article.title;
        p.innerText = this.article.description;
        article.appendChild(span);
        article.appendChild(p);
        article.dataset.id = this.article.id;
        article.classList.add('article');

        return article
    }
}