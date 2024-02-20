function displayArticleCount() { 
    const newsList = document.querySelector('#newsList');
    const articles = newsList.querySelectorAll('.article'); 
    updateArticleCount(articles.length)
}

function updateArticleCount(count){
    const h3 = document.querySelector('h3');

    if (count) {
        h3.innerText = `There are ${count} articles`;
    }
    else {
        h3.innerText = `There is ${count} article`;
    }
}