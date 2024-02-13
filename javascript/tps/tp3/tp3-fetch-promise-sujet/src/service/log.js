function logMessage(message, type){
    switch(type){
        case 'error':
            console.error(message); //console.error permet de mettre en avant (en rouge) un message dans la console
            break;
        case 'warning':
            console.warn(message); //console.warn permet de mettre en avant (en jaune) un message dans la console
            break;
        default:
            console.log(message); //console.log permet d'afficher un message dans la console
            break;
    }
}