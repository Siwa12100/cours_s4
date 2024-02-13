package estiu;

fun test() {

        println("test");
}

fun boucles()  {

        println(1..5)
        println(1 until 5)
        println(1 ..< 5)
        println(1 .. 10 step 2)
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
