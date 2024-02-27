console.log("Debut de l'entrainement.");

message = "Coucou "
HelloWorld(message);

function HelloWorld(message) {
    console.log("Adiu a totes : " + message);
}

function Voiture(roues, nom, couleur) {
    return {
        nom, 
        roues,
        couleur, 
        afficher : function () {
            console.log("Voiture : " + this.nom + " ; roues : " + this.roues + " ; couleur : " + this.couleur);
        }
    }
}

const maVoiture1 = Voiture(4, "Julie", "verte");
maVoiture1.afficher()

let cle = "bruit";
maVoiture1[cle] = "tutuuuu";

const avancer = function () {
    console.log("La voiture avance ! ");
}

maVoiture1["avancer"] = avancer;
maVoiture1["klaxonner"] = function(nbFois) {
    
    for (let i = 0; i < nbFois; i++) {
        console.log(this.bruit);
    }
}

console.log(" ----- test avancer & klaxonner -------");
maVoiture1.avancer();
maVoiture1.klaxonner(7);

//console.log(maVoiture1)