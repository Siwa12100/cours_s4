console.log("========= Entrainement 2 au JS =========");

async function additionnerAsync(val1, val2) {

    console.log(" -> Debut de additionnerAsync")
    await attendre(5000);
    resultat = val1 + val2;

    return resultat;
}

async function attendre(nbSecondes) {
    return new Promise(resolve => {
        setTimeout(() => {
            console.log('Attente terminée après 2000 millisecondes (2 secondes).');
            resolve();
        }, nbSecondes);
    });
}


async function main() {
    const maPromesse = additionnerAsync(7, 8);
    console.log(" -> Addition async lancée...");
    
    // const monResultat = await maPromesse;
    const monResultat = maPromesse.then((valeur) => {
        console.log(" -> Resultat final : " + valeur);
    });
    
    
}

main();

const user = {
  username: "john_doe",
  password: "secret",
  isAdmin: false,
};

const jsonString = JSON.stringify(user, (key, value) => {
  if (key === "password") {
    return undefined; // Ne pas inclure le champ "password"
  }
  return value; // Sinon, utilise la valeur par défaut
});

console.log(jsonString);
// Résultat : '{"username":"john_doe","isAdmin":false}'