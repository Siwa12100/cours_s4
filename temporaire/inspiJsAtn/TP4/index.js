// Import essential libraries 
const express = require('express'); 
const app = express(); 
const path = require('path'); 
const router = express.Router(); 
// Setup essential routes 
router.get('/', function(req, res) { 
    res.sendFile(path.join(__dirname + '/index.html')); 
    //__dirname : It will resolve to your project folder. 
});
router.get('/form-add-article', function(req, res) { 
    res.sendFile(path.join(__dirname + '/src/form-add-article.js')); 
    //__dirname : It will resolve to your project folder. 
});
router.get('/info-article', function(req, res) { 
    res.sendFile(path.join(__dirname + '/src/info-article.js')); 
    //__dirname : It will resolve to your project folder. 
});
//add the router 
app.use('/', router); 
app.listen(process.env.port || 8080); 
console.log('Running at Port 8080'); 