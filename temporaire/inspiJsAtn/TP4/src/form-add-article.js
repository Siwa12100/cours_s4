export default{
    data: function(){
        return {
            title : '',
            description : '',
            errorMSG : '',
            errorCOLOR : 'red'
        }
    },
    methods:{
        addNews: function(){
            if(!this.title || !this.description){
                this.errorMSG = 'Problème d\'ajout d\'article'
                return 
            }

            const news = { title: this.title, description : this.description }
            console.log('form.addNews', news)

            this.title = ''
            this.description = ''
        }
    }
    ,
    template: `<section>
                    <h2> News form </h2>

                    <form @submit.prevent>
                        <div>
                            <label>Title</label>
                            <input type="text" v-model="title"></input>
                        </div>

                        <div>
                            <label>Description</label>
                            <textarea v-model="description"/>
                        </div>
                        <input type="submit" value="Submit" @click="addNews"/>
                    </form>
                </section>`
}