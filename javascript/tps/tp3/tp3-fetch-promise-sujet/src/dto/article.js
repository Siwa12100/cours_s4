class Article {
    id;
    userId;
    title;
    body;

    constructor(id, title, body) {
        if (!title || title.trim() === '') {
            throw new RequiredFieldError('title'); //l'instruction throw permet de déclencher une erreur
        }

        if (!body || body.trim() === '') {
            throw new RequiredFieldError('body'); //l'instruction throw permet de déclencher une erreur
        }

        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = 1;
    }
}