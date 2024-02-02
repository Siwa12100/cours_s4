import math
import binascii


def stringToBinaire(message) :
    resultat = []
    
    for i in range (len(message)) :
        resultat.append(bin(ord(message[i])))
        # print("Xor : ", bin(ord(message[i])) ^ bin(ord(message[i])))

    return resultat



def binaireToString(message) :
    
    resultat = ""

    for i in message : 
        resultat = resultat + (chr(int(i,2)))

    return resultat


# print(stringToBinaire("coucou"))
#print(binaireToString(stringToBinaire("coucou")))


# def chiffrementParfait(message, cle) :

    resultat = 0
    cleBinaire = stringToBinaire(cle)
    messageBinaire = stringToBinaire(message)

    print("cle binaire : ", cleBinaire)
    print("message binaire : ", messageBinaire)
    #print("type : ", messageBinaire.type())

    print()
    print("================")
    print("conversion test : ", binaireToString(messageBinaire))
    print("================")
    print()


    if (len(message) != len(cle)) :
        return "erreur"

    # for i in range (len(messageBinaire)) :
    #     print("messageBinaire[i] :", int(messageBinaire[i][2:]))
    #     print("cleBinaire[i] :", int(cleBinaire[i][2:]))

    #     resultat = resultat + (int(messageBinaire[i][2:]) ^ int(cleBinaire[i][2:]))

    for i in range (len(messageBinaire ) - 2) :
        for i in range (int(messageBinaire[i][2:])) :
            print("I  ---> ", i)
        
    return resultat


def chiffrementParfait(message, cle) :
    resultat = ""

    for i in range (len(message)) :

        lettreBinaireMessage = stringToBinaire(message[i])
        lettreBinaireCle = stringToBinaire(cle[i])


        print("taille : ", len(lettreBinaireMessage))
        print("lettreBinaireMessage : ", lettreBinaireMessage[0][2:])

        valeurTraiteeMessage = lettreBinaireMessage[0][2:]
        valeurTraiteeCle = lettreBinaireCle[0][2:]

        print("taille valeurTraitee : ", len(valeurTraiteeMessage))

        xor = int(valeurTraiteeMessage[0]) ^ int(valeurTraiteeCle[0])

        for b in range(1, len(valeurTraiteeMessage)) :
            # print("M --> ", valeurTraiteeMessage[b])
            # print("C --> ", valeurTraiteeCle[b])

            # print("Xor ... : " , int(valeurTraiteeMessage[b]) ^ int(valeurTraiteeCle[b]))
            xor = xor + int(valeurTraiteeMessage[b]) ^ int(valeurTraiteeCle[b])

        print("Xor final : ", xor)

    return resultat    

print(chiffrementParfait("coucou", "voitur"))






