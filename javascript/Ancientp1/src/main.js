
         function displayArticleCount() {
            const newsList = document.querySelector('#newsList');
            const articles = newsList.querySelectorAll('#newsList .article');
            const h3 = document.querySelector('h3');

            if (articles.length > 1)
                h3.innerText = `There are ${articles.length} articles`;
            else
                h3.innerText = `There is ${articles.length} article`;
        }

        displayArticleCount();

        const form = document.querySelector('form');
        form.addEventListener('submit', event => {
            event.preventDefault();
            if (!checkForm()) {
                return false;
            }

            const titleToAdd = form.querySelector('input[name=titleToAdd]');
            const descriptionToAdd = form.querySelector('textarea[name=descriptionToAdd]');

            const title = titleToAdd.value;
            const description = descriptionToAdd.value;

            const article = document.createElement('article');
            const span = document.createElement('span');
            const p = document.createElement('p');

            span.innerText = title;
            p.innerText = description;
            article.appendChild(span);
            article.appendChild(p);
            article.classList.add('article');
            document.querySelector('#newsList').appendChild(article);

            displayArticleCount();

            titleToAdd.value = '';
            descriptionToAdd.value = '';

            return false;
        });

        function checkForm() {
            const titleToAdd = form.querySelector('input[name=titleToAdd]');
            const descriptionToAdd = form.querySelector('textarea[name=descriptionToAdd]');
            let isValid = true;

            titleToAdd.setAttribute('style', 'border-color: inherit');
            descriptionToAdd.setAttribute('style', 'border-color: inherit');

            if (titleToAdd.value === '') {
                titleToAdd.setAttribute('style', 'border-color: red');
                isValid = false;
            }

            if (descriptionToAdd.value === '') {
                descriptionToAdd.setAttribute('style', 'border-color: red');
                isValid = false;
            }

            return isValid;
        }
    