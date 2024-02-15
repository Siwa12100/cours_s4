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