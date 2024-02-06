console.log("Debut du main.")
document.documentElement.style.setProperty('--couleur_erreur', 'red');

let monFormulaire = document.getElementById("formulaireCreationArticle");

function submitForm(event) {
    console.log("Passe dans le submit form !")

    let titre = document.querySelector("input[name='titre']");
    let description = document.querySelector("textarea[name='description']");

    console.log("Formulaire - Titre : " + titre.value  + " | Description : " + description.value)
}

monFormulaire.addEventListener("submit", (event) => {
    event.preventDefault();
    submitForm(event);
});