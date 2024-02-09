import sympy
import random

# ============
# Exercice 1 :
# ============

# print("debut du tp3.")

import sympy
import random

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


