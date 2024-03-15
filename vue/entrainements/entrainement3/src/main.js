let app = new Vue({
    el: '#app',
    data: {
      msg: "Début de l'application Vue.js !",
      liensNavBar: window.liensNavBar
    },
    components: {
      'article-component': articleComponent,
      'navbar': navbar
    }
  });