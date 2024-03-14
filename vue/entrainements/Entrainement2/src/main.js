let app = new Vue({
    el: '#app',
    data: {
        message: 'Adiu a totes !',
        
    }, 

    components : {
        'mon-premier-composant' : MonPremierComposant, 
        'mon-second-composant' : MonSecondComposant,
        'troisieme-composant' : troisiemeComposant
    }, 
})