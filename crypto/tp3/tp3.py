import sympy
import random

# ============
# Exercice 1 :
# ============
print()
print("----- Exo 1 : ------")
print()

def Clefs(k):
    
    p = sympy.randprime(10**k, 10**(k+1) - 1)
    g = random.randint(2, p - 1)
    s = random.randint(2, p - 2)
    h = pow(g, s, p)
    return (p, g, h), s

k = 10
clefs_publique, clef_privee = Clefs(k)

print("Clef publique (p, g, h):", clefs_publique)
print("Clef privée (s):", clef_privee)

s_secret = random.randint(2, clefs_publique[0] - 1)

h_secret = pow(clefs_publique[1], s_secret, clefs_publique[0])

print("Nombre secret (s):", s_secret)
print("h calculé avec le secret (g^s mod p):", h_secret)


# ============
# Exercice 2 :
# ============
print()
print()
print("------ Exo 2 ------")
print()

def Chiffrer(M, clefs_publique):
    p, g, h = clefs_publique
    k = random.randint(2, p - 2)

    C1 = pow(g, k, p)
    C2 = (M * pow(h, k, p)) % p

    return (C1, C2)

M = 42
chiffre = Chiffrer(M, clefs_publique)

print(f"Message à chiffrer (M): {M}")
print("Chiffré (C1, C2):", chiffre)


# ============
# Exercice 3 :
# ============
print()
print()
print("------ Exo 3 ------")
print()

def Dechiffrer(chiffre, clef_privee, clefs_publique):
    
    p, _, _ = clefs_publique
    C1, C2 = chiffre

    inverse_C1_s = pow(C1, clef_privee, p)
    M = (C2 * inverse_C1_s) % p

    return M 












    
    # p, _, _ = clefs_publique
    # C1, C2 = chiffre

    # inverse_C1_s = pow(C1, clef_privee, p) 
    # M = (C2 * inverse_C1_s) % p

    # return M

# Exemple d'utilisation avec le chiffré précédent
message_dechiffre = Dechiffrer(chiffre, clef_privee, clefs_publique)

print("Chiffré à déchiffrer (C1, C2):", chiffre)
print("Message déchiffré (M):", message_dechiffre)




