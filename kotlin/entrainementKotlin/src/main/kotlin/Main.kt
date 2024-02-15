import estiu.*

fun main(args: Array<String>) {
    //println("Hello World!")
    //premiersTestsMain()
    //secondsTestsDansLeMain()
    troisiemeTestsMain()

}

fun troisiemeTestsMain() {

    //premierTestLambda()
    //secondTestLambda()
    testExtension()
    testInfix()
    val tab = arrayOf(12, 71, 128, 12, 1972 , 182)
    println("Tableau de base : " + tab.joinToString(", "))
    recupValsPaires(*tab.toIntArray()).forEach({value -> println("--> " + value)})
    //recupValsPaires(*tab.toIntArray()).forEach { value -> println("--> $value") }
}

fun secondsTestsDansLeMain() {

    println("Calcul : " + monCalcul(valeur3 = 7, valeur1 =  90, valeur2 = 2))

    testVarArgs(monMot =  "Adiu ! ", 8,9,12, 89)
    println("-------------------------")
    testVarArgs(monMot = "camionnette", 9, 8, 1, 89, 1261, 18261,
        monAutreMot = "autbous")
    println("-------------------------")
    testVarArgs(monMot = "Coucou ! ",  2, 12, 1982 )

    val monTableau = arrayOf(7, 89, 1, 891)
    testVarArgs(monMot = "lunette", *monTableau.toIntArray())
}

infix fun Int.coucou(valeur:Int) : Int {
    println("Coucou " + valeur + " ; base : " + this)
    return this * valeur
}

fun testInfix() {

    println("Test infix : " + (3 coucou 6))
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