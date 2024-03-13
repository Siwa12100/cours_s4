<?php
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Http\Message\ServerRequestInterface as Request;
use Slim\Factory\AppFactory;

require __DIR__ . '/../modele/Employe.php';

$loader = require __DIR__ . '/../vendor/autoload.php';
// for namespace BL PSR4 here namespace; dir
$loader->addPsr4('BL\\', __DIR__);

$app = AppFactory::create();

$app->addBodyParsingMiddleware();
$app->addRoutingMiddleware();
$app->addErrorMiddleware(true, true, true);

$listeEmployes = [];
for ($i = 1; $i < 10; $i++) {
    $listeEmployes[$i] = new Employe(($i), "Employe $i");
}

$app->get('/', function (Request $request, Response $response, $args) {
    $response->getBody()->write("Hello world!");
    return $response;
});

$app->get('/adiu', function (Request $request, Response $response, $args) {
    $response->getBody()->write("Adiu !");
    return $response;
});

$app->get('/employees', function (Request $request, Response $response, $args) use ($listeEmployes) {
    $jsonEmployes = json_encode($listeEmployes, JSON_PRETTY_PRINT);
    $response->getBody()->write($jsonEmployes);
    return $response;
});

$app->get('/employees/{id}', function (Request $request, Response $response, $args) use ($listeEmployes) {
    $id = $args['id'];

    if (isset($listeEmployes[$id])) {
        $Employe = $listeEmployes[$id];

        $jsonEmploye = json_encode($Employe, JSON_PRETTY_PRINT);
        $response->getBody()->write($jsonEmploye);
    } else {
        $response->getBody()->write("Employé non trouvé pour l'ID : $id");
        $response = $response->withStatus(404);
    }

    return $response;
});

$app->post('/employees', function (Request $request, Response $response, $args) use ($listeEmployes) {
    $data = $request->getParsedBody();


    $nouvelEmploye = new Employe(count($listeEmployes) + 1, $data['nom']); // Assurez-vous que 'nom' est défini dans les données


    $listeEmployes[] = $nouvelEmploye;

    $jsonEmploye = json_encode($nouvelEmploye, JSON_PRETTY_PRINT);
    $response->getBody()->write($jsonEmploye);

    return $response->withStatus(201); 
});

$app->put('/employees/{id}', function (Request $request, Response $response, $args) use ($listeEmployes) {
    $id = $args['id'];

    if (isset($listeEmployes[$id])) {
        $data = $request->getParsedBody();

        $listeEmployes[$id]->setNom($data['nom']);

        $jsonEmploye = json_encode($listeEmployes[$id], JSON_PRETTY_PRINT);
        $response->getBody()->write($jsonEmploye);
    } else {
        $response->getBody()->write("Employé non trouvé pour l'ID : $id");
        $response = $response->withStatus(404);
    }

    return $response;
});

$app->delete('/employees/{id}', function (Request $request, Response $response, $args) use ($listeEmployes) {
    $id = $args['id'];

    if (isset($listeEmployes[$id])) {
        
        unset($listeEmployes[$id]);

        $response->getBody()->write("Employé avec l'ID $id supprimé");
    } else {
        $response->getBody()->write("Employé non trouvé pour l'ID : $id");
        $response = $response->withStatus(404);
    }

    return $response;
});

$app->run();
