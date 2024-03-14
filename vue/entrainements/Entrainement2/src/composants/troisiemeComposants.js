const troisiemeComposant = {

    name : "troisieme composant",

    props : {

        message : {
            type : String,
            required : true
        }, 

        nombre : {
            type : Number,
            required : true 
        }
    },

    data() {
        return {

            texte : this.message,
            monChiffre : this.nombre * 10
        }
    },

    

    template : `
    <div>
    <h2> Titre du troisème composant ! </h2>
    <p> Valeur de la props : {{message}} </p>
    <p> Valeur de texte : {{texte}} </p>
    <p> Valeur de monChiffre : {{monChiffre}} </p>
    </div>
    `
}