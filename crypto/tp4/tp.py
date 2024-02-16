# ============
# Exercice 1 :
# ============
print()
print("=-=-=-=-=-=-= Exo 1 =-=-=-=-=-=-=-=")

# 1.)
# ---
# Le calcul effectué est le renvoie de la valeur ASCII du caractère passé en paramètre.
# H(Ī) = 298

def H(lettre) :
    return ord(lettre)

print(H('A'))
print(H('Ī'))

# 2.)
# ---
# G(ABC) = H(A) * 1 + H(B) * 2 + H(C) * 3
def G(chaine):
    somme = 0
    for i, caractere in enumerate(chaine, start=1):
        somme += H(caractere) * i
    return somme

print(G('coucou'))


# ============
# Exercice 2 :
# ============
print()
print("=-=-=-=-=-=-= Exo 2 =-=-=-=-=-=-=-=")
import hashlib

mot="coucou"
sha256 = hashlib.sha256(mot.encode('utf-8')).hexdigest()
# print(sha256)

mot1 = "123456789"
print(" - " , mot1," --> ", hashlib.sha256(mot1.encode('utf-8')).hexdigest())

mot2 = "tungsten"
print(" - " , mot2," --> ", hashlib.sha256(mot2.encode('utf-8')).hexdigest())


# ============
# Exercice 3 :
# ============
print()
print("=-=-=-=-=-=-= Exo 3 =-=-=-=-=-=-=-=")

def signature_RSA(message, sk, n):
    signature = pow(message, sk, n)
    return signature

pk = (17, 3233)
sk = 2753

message_to_sign = 855
signature_result = signature_RSA(message_to_sign, sk, pk[1])
print("Signature pour ", message_to_sign, " : ", signature_result)

verification = pow(signature_result, pk[0], pk[1])
print("Vérification (", verification,") : ", verification == message_to_sign)

messageAVerifier = 2197
signatureDuMessage = signature_RSA(messageAVerifier, sk, pk[1])
print(f"Signature pour {messageAVerifier}: {signatureDuMessage}")


# ============
# Exercice 4 :
# ============
print()
print("=-=-=-=-=-=-= Exo 4 =-=-=-=-=-=-=-=")