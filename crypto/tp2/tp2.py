import math
import binascii


def chiffrementParfait(message, cle) :



def stringToBinaire(message) :
    resultat = []
    
    for i in range (len(message)) :
        resultat.append(bin(ord(message[i])))

    return resultat



def binaireToString(message) :
    
    resultat = ""
    for i in message : 
        resultat = resultat + (chr(int(i,2)))

    return resultat

print(stringToBinaire("coucou"))

print(binaireToString(stringToBinaire("coucou")))


# chiffrementParfait("coucou", "huit")