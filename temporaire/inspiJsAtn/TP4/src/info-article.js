export default{
    props: {
        title : '',
        description : ''
    }
    ,
    template: `<div>
                    <h2> {{ title }} </h2>

                    <p>{{ description }}</p>
                </div>`
}