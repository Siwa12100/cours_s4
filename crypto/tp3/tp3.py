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

s_secret = random.randint(2, clefs_publique[0] - 1)

h_secret = pow(clefs_publique[1], s_secret, clefs_publique[0])

print("Nombre secret (s):", s_secret)
print("h calculé avec le secret (g^s mod p):", h_secret)



