import estiu.*

fun main(args: Array<String>) {
    //println("Hello World!")
    //premiersTestsMain()
    secondsTestsDansLeMain()

}

fun secondsTestsDansLeMain() {
    
}

fun premiersTestsMain(): Unit {
    test()
    boucles()
    types()
    boucles2()


    var monNom = "Siwa"
    val maChaine : String = "Coucou ${comparaisonReference1()} & ${comparaisonReference2()}"
    println("Res : " + maChaine)

    testSmartCast(12)
    testSmartCast("coucou")
    testSmartCast(12.0)

    testWhen("coucou")
    testWhen("voiture")
    testWhen(117)
    testWhen(12)
    testWhen(true)
    testWhen("camion")

    try {
        val maValeur = testErreur(78)
    } catch (e : Exception) {
        println("oups erreur : " + e.message)

    }

    try {
        val maSecondeValeur = testErreur(0)
    } catch (e : Exception) {
        println("oups erreur V2 : " + e.message)

    } finally {
        println("Dans tous les cas on passe par ici....")
    }
}