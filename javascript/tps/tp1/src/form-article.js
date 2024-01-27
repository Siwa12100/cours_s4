function checkForm(titre, description) {

    let verif = true;

    if (!titre.value) {
        titre.classList.add("erreur");
        console.warn("Attention le champ titre est vide !");
        verif = false;
    }

    if (!description.value) {
        description.classList.add("erreur");
        console.warn("Attention le champ description est vide");
        verif = false;
    }

    return verif;
}

function ajouterArticle(titre, description) {

    let listeArticles = document.getElementById("listeArticles");

    let nouveauTitre = document.createElement("h3");
    nouveauTitre.textContent = titre;

    let nouvelleDescription = document.createElement("p");
    nouvelleDescription.textContent = description;

    const nouvelArticle = document.createElement("div");
    nouvelArticle.appendChild(nouveauTitre);
    nouvelArticle.appendChild(nouvelleDescription);

    listeArticles.appendChild(nouvelArticle);
} 

function submitForm(event) {

    event.preventDefault();

    let titre = document.querySelector("input[name='titre']");
    //console.log("Titre de l'article soumis : ", titre.value);

    let description = document.querySelector("textarea[name='description']");
    //console.log("Description de l'article soumis : ", description.value);

    const isValid = checkForm(titre, description);

    if (isValid) {
        titre.classList.remove("erreur");
        description.classList.remove("erreur");        

        ajouterArticle(titre.value, description.value);
        console.log("Nouvel article cree !");

        titre.value = "";
        description.value = "";     
    }
}

