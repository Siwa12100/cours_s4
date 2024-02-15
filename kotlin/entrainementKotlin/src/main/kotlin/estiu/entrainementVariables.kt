package estiu;

import java.lang.IllegalArgumentException

fun test() {

        println("test");
}

fun boucles()  {

        println(1..5)
        println(1 until 5)
        println(1 ..< 5)
        println(1 .. 10 step 2)
}

fun boucles2() {

        val inter = 3..30 step 1
        val inter2 = 30 downTo 0 step 3

        for (i in inter) {
                println(i)
        }

        println("------")

        for (i in inter2) {
                println(i)
        }
}

fun testSmartCast(valeur : Any) {

        println("Test du smart cast : \n -------------")
        if (valeur is String) {
                println("Le mot : " + valeur + " a pour taille : " + valeur.length + ".")
        }

        if (valeur is Int) {
                println("L'entier est : " + valeur + ".")
        }
}

fun testWhen(valeur : Any) {

        println("Test du When (" + valeur + "): \n --------------")

        when (valeur) {

                is String -> {

                        when (valeur) {

                                "coucou" -> {
                                        println("Le mot est coucou")
                                }

                                "voiture" -> {
                                        println("Le mot est voiture")
                                }

                                else -> {
                                        println("Le mot est inconnu")
                                }
                        }
                }

                is Int -> {

                        when (valeur % 2) {
                                0 -> println("la valeur " + valeur + " est paire")
                                else -> println("La valeur " + valeur + " est impaire")
                        }
                }

                else -> {
                        println("ni string ni int !")               }
        }
}

fun testErreur(valeur : Int) : Int {

        if (valeur == 0) {
                throw IllegalArgumentException("Coucou je suis une erreur ! ")
        }

        var result = valeur * 4

        return valeur
}

fun testVarArgs(monMot : String, vararg  maListe : Int, monAutreMot : String? = "tant pis...") {

        println("Mon mot est --> " + monMot)
        println("Mon autre mot est --> " + monAutreMot)

        var cpt = 1

        for (valeur in maListe) {
                println("Valeur " + cpt + "/" + maListe.size + " : " + valeur + ".")
                cpt++
        }
}

fun monCalcul(valeur1 : Int, valeur2 : Int, valeur3 : Int) = (valeur1 + valeur2) * valeur3

fun comparaisonReference1() : Boolean {

        val v1 : Int = 9
        val v2 : Int = 9

        return v1 == v2
}

fun comparaisonReference2() : Boolean {
        val v1 : Int = 9
        val v2 : Int = 9

        return v1 === v2
}
fun types() {

        val entier : Int = 9
        val double : Double = 9.0
        val double2 = 3.2
        val texte = "Coucou !"
        val texte2 : String
        texte2 = "voiture !"
        // texte2 = "bateau" --> Impossible car val

        var valeur = 9.0;
        valeur = 2.9;

        var verif = true
        verif = !verif

        val entier1 = 4
        val entier2 = 4
        println("4 == 4 " + (entier1 == entier2))
        println("4 === 4 " + (entier1 === entier2))
}
