class RequiredFieldError extends Error { //la classe Error est la classe dee plus haut niveau pour les erreurs
    constructor(field) {
        super(`Le champ ${field} est obligatoire !`);
    }
}