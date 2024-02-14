export default {

    data : function() {

        return {

        }
    },

    methods : {

        addNews : function(news) {

            console.log('index.addNews', news);
            this.allNews.push(news);
        }


    },

    template : `<section>
    <h2>News form</h2>

    <form @submit.prevent>
        <div>
            <label>Title</label>
            <br>
            <input type="text" v-model="title"/>
        </div>

        <div>

            <label>Description</label><br>
            <textarea v-model="description"></textarea>
        </div>

        <input type="submit" value="Submit" @click="addNews"/>
    </form>
</section>`
    
}

