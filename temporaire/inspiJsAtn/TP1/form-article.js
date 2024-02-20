const submitData = document.querySelector("form")
submitData.addEventListener("submit", submitForm)

const counter = document.querySelector("#nbArticle").value = 0;


function displayArticleCount(event){

    const listArticle = document.querySelector("#displayData");
    const articles = listArticle.querySelectorAll(".article");
    const counter = document.querySelector("#nbArticle");
    counter.value = articles.length;
}


function checkForm(event){
    const inputTitle = document.querySelector('input[name=title]').value;
    const inputDescr = document.querySelector('input[name=description]').value;
    let isValid = true;

    if(inputTitle === ''){
        isValid = false;
    }

    if(inputDescr === ''){
        isValid = false;
    }

}

function submitForm(event){
    event.preventDefault();
    if(!checkForm){
        return false;
    }
    // Ajout d'article ici
    const titleToAdd = document.createElement('p');
    titleToAdd.textContent = document.querySelector('input[name=title]').value;


    const descrToAdd = document.createElement('p');
    descrToAdd.textContent = document.querySelector('input[name=description]').value;

    const div = document.createElement('div');
    div.appendChild(titleToAdd);
    div.appendChild(descrToAdd);
    div.className = "article"

    // Insertion finale
    document.querySelector("#displayData").appendChild(div);
    displayArticleCount();
    return true;
}