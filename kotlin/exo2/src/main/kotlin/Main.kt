fun main(args: Array<String>) {
    //println("debut main")

    var Echapement:String = "_"
    var vie:String = "♥♥♥♥"
    var motATrouver = "Lion"
    var resultat:String = ""

    while (!vie.isEmpty()) {

        println("PV : " + vie)
        print("Entrez votre proposition : ")

        var motSaisi = readln()
        resultat = verifieChaqueCaractereEtConcatener(motATrouver, motSaisi)
        println(resultat)

        if (resultat.contains(Echapement) && resultat.length != 0) {

            vie = vie.substring(0, vie.length -1)
        } else {
            break;
        }

    }

    if (!vie.isEmpty()) {
        println("Vous avez gagné !")
    } else {
        println("Vous avez perdu ! ")
    }
}

fun verifieChaqueCaractereEtConcatener(motATrouver:String, motSaisi:String):String {

    var retour:String = ""

    for (i in motSaisi.indices) {

        if (motATrouver.length > i) {

            if (prendSiIndentique(motATrouver.get(i), motSaisi.get(i))) {
                retour = retour + motSaisi.get(i).toString()
            } else {
                retour = retour + "_"
            }
        }
    }

    return retour
}

fun prendSiIndentique(aTrouver:Char, proposition:Char) :Boolean{
    return aTrouver == proposition
}



