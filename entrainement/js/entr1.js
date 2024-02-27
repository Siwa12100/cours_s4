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

console.log("---- Tests sur les types -----");

let maVariable = "45.3";
console.log(maVariable + " : " + typeof(maVariable));
maVariable = parseFloat(maVariable);
console.log(maVariable + " : " + typeof(maVariable));
console.log(maVariable + " : " + typeof(maVariable == 7));
let monAutreVariable = 89.8;
console.log(monAutreVariable.toString()+ " : " + typeof(monAutreVariable.toString()));
console.log(monAutreVariable.toString(2)+ " : " + typeof(monAutreVariable.toString()));
console.log(monAutreVariable.toString(16)+ " : " + typeof(monAutreVariable.toString()));
console.log(monAutreVariable.toString(10)+ " : " + typeof(monAutreVariable.toString()));

console.log("----- Test json -------")

const testJson = JSON.stringify(maVoiture1);
console.log("Format json : " + testJson);
const testRecupObj = JSON.parse(testJson);
console.log("Format classique --> nb roues : " + testRecupObj["roues"]);

console.log("---- Test boucles for -----")

const tableau =  new Array("Pomme", "Poire", "Figue", "Raisin");
for (let f in tableau) {
    console.log("Fruit in : " + f);
}

for (let f of tableau) {
    console.log("Fruit of : " + f);
}