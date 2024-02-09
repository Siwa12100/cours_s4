# ============
# Exercice 1 :
# ============

# print("debut du tp3.")

import sympy
import random

def Clefs(k):
    # Fonction pour générer une paire de clefs El Gamal

    # Étape 1 : Choix du module p
    p = sympy.randprime(10**k, 10**(k+1) - 1)

    # Étape 2 : Choix du générateur g
    g = random.randint(2, p - 1)

    # Choix de la clef privée s
    s = random.randint(2, p - 2)  # s doit être dans l'intervalle [2, p-2]

    # Calcul de h = g^s mod p
    h = pow(g, s, p)

    # Retourner la paire de clefs publique et privée
    return (p, g, h), s

# Exemple d'utilisation avec k=10
k = 10
clefs_publique, clef_privee = Clefs(k)

# Affichage des résultats
print("Clef publique (p, g, h):", clefs_publique)
print("Clef privée (s):", clef_privee)
