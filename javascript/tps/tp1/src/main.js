//console.log("Debut du main.js");
document.documentElement.style.setProperty('--couleur_erreur', 'red');

let monFormulaire = document.getElementById("formulaireCreationArticle");

monFormulaire.addEventListener("submit", (event) => {
    event.preventDefault();
    submitForm(event);
});