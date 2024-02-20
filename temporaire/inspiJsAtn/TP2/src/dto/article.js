
class Article {
    constructor(id, titre, description) {
        if(!titre){
            throw new RequiredFieldError('title')
        }
        if(!description){
            throw new RequiredFieldError('description')
        }
        this.id = id;
        this.titre = titre;
        this.description = description;
    }
}
