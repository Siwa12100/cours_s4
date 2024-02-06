fun main(args: Array<String>) {
    jeu()
}

fun jeu() {

    var nbVies: Int = 5
    var lettresTrouvees:String = ""
    var motATrouver = "coucou"
    var motCourant:String = ""

    while (nbVies != 0) {
        affichertMot(motATrouver, lettresTrouvees)
        afficherCoeurs(nbVies)

        motCourant = saisirMot()
        lettresTrouvees = actualiserLettresConnues(motCourant, lettresTrouvees, motATrouver)

        if (isBonMot(motCourant, motATrouver)) {
            println(" Vous avez gagne !!")
            break;
        }

        nbVies = nbVies - 1

        if (nbVies == 0) {
            println("Vous avez perdu !!")
        }

        //println()
        println()
    }
}

fun isBonMot(motCourant:String, bonMot:String) :Boolean {

    if (motCourant == bonMot) {
        return true;
    }

    return false
}

fun saisirMot():String {
    print("Entrez votre proposition : ")

    var nouveauMot:String = readln()
//    print(nouveauMot)
    println()

    return nouveauMot
}


fun affichertMot(mot:String, lettreTrouve:String) {

    var cpt:Int = 0
    print("Vous devez trouver : ")

    while (cpt != mot.length) {

        if (lettreTrouve.contains(mot[cpt])) {
            print(mot[cpt])
        } else {
            print("_")
        }

        print(" ")
        cpt = cpt + 1
    }

    println()
}

fun afficherCoeurs(nbCoeurs: Int) {

    var cpt: Int = 0
    print("PV : ")

    while (cpt != nbCoeurs) {

        print("\u2665" + "  ");
        cpt = cpt + 1
    }

    println()
}

fun actualiserLettresConnues(nouveauMot:String, anciennesLettresConnues:String, motATrouver: String):String {

    var cpt:Int = 0
    var nouvellesLettresConnues:String = anciennesLettresConnues

    while (cpt != nouveauMot.length) {

        if (motATrouver.contains(nouveauMot.get(cpt))) {

            if (!nouvellesLettresConnues.contains(nouveauMot.get(cpt))) {

                nouvellesLettresConnues = nouvellesLettresConnues + nouveauMot.get(cpt)
            }
        }

        cpt = cpt + 1
    }

    return nouvellesLettresConnues
}