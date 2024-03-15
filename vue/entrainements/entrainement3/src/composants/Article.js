const articleComponent = {
    props: {
        ptitre: String,
        pdescription: String
    },
    template: `
    <div>
        <h3>Article : {{ ptitre }}</h3>
        <p>desc. : {{ pdescription }}</p>
    </div>    
    `
};

