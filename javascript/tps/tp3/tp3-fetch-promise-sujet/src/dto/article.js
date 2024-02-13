class Article {
    id;
    title;
    description;

    constructor(id, title, description) {
        if (!title || title.trim() === '') {
            throw new RequiredFieldError('title'); //l'instruction throw permet de déclencher une erreur
        }

        if (!description || description.trim() === '') {
            throw new RequiredFieldError('description'); //l'instruction throw permet de déclencher une erreur
        }

        this.id = id;
        this.title = title;
        this.description = description;
    }
}