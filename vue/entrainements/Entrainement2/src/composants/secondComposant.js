const MonSecondComposant = {

    data() {
        return {

            description : "Description du second composant...",
            titre : "Titre du second composant",
        }
        
    },

    template : `
    <div>
        <h2> Titre : {{titre}} </h2>
        <p> Desc. : {{description}} </p>
    </div>
    `
}