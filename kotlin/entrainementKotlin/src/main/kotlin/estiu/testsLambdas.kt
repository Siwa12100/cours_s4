package estiu

fun premierTestLambda() {

    val maLambda : (Int, Int, String) -> Boolean = { val1, val2, verif -> val1 == val2
    }

    println("Verification : " + maLambda(3, 3, "coucou"))
    println("Verification 2 : " + maLambda(3, 4, "coucou"))

    val maSecondeLambda : (Int, String) -> Unit = {valeur, msg ->

        val monMsgModif = msg + valeur
        println("Test : " + monMsgModif + " ; " + valeur * 78)
    }

    maSecondeLambda(3, "camion")
}

fun secondTestLambda() {

    var maLambda1 : (Int) -> Unit = {
        println("Element : " + it)
    }

    maLambda1(78)

//    var maLambdaIterateur : (String) -> Int = {
//        monMot ->
//        println("Element : " + monMot)
//        monMot.length
//    }
//
//    val maListe = listOf<String>("Coucou","bonjour", "courgette")
//    var cpt : Int = maListe.forEach(maLambdaIterateur())

    var maLambdaIterateur: (String) -> Int = { monMot ->
        println("Element : $monMot")
        monMot.length
    }

    val maListe = listOf<String>("Coucou", "bonjour", "courgette")

// Utilisation de forEach avec la lambda maLambdaIterateur
    maListe.forEach { element ->
        val longueur = maLambdaIterateur(element)
    }
}

fun String.crier() : Unit {
    println(this.toUpperCase())
}

fun testExtension() {

    "bateau".crier()
}