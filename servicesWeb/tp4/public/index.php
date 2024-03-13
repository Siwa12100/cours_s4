<?php
use Psr\Http\Message\ResponseInterface as Response;
use Psr\Http\Message\ServerRequestInterface as Request;
use Slim\Factory\AppFactory;

$loader = require __DIR__ . '/../vendor/autoload.php';
//for namespace BL PSR4 here namespace ; dir
$loader->addPsr4('BL\\', __DIR__);
$app = AppFactory::create();

$app->get('/', function (Request $request, Response $response, $args) {
    $response->getBody()->write("Hello world!");
    return $response;
});

$app->run();