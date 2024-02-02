import math

# ============ 
# Exercice 1 :
# ============


def calculInverse(n,x) :

    for i in range(1, x) :
        if (n * i) % x == 1 :
            return i

    return "Pas d'inverse modulaire dsl l'ami"
    

print(calculInverse(5, 8))
print(calculInverse(8,4))


# ============
# Exercice 2 :
# ============


# 1.)
# ---

# x = 3 % 17
# x = 4 % 11
# x = 5 % 5

print(17 * 11 * 5)

# M = 935
# M1 = 935 / 17 = 55 | y1 * 55 = 1 mod 17 -> y1 = 12
# M2 = 935 / 11 = 85 | y2 * 85 = 1 mod 11 -> y2 = 7
# M3 =  935 / 5 = 187 | y3 * 187 = 1 mod 5 -> y3 = 3


def resteChinois(val, mod):
 M=mod[0]*mod[1]*mod[2]
 M1=M//mod[0]
 M2=M//mod[1]
 M3=M//mod[2]
 y1=calculInverse(M1,mod[0])
 y2=calculInverse(M2,mod[1])
 y3=calculInverse(M3,mod[2])
 return (val[0]*M1*y1+val[1]*M2*y2+val[2]*M3*y3)%M

print(resteChinois([3,4,5], [17,11,6]))


# ============
# Exercice 3 :
# ============

# 1.)
# --

# def verif(mods) :

#     verif = True

#     for i in range (1 ,len(mods)) :
#         # print(math.gcd(mods[i], mods[i - 1]))

#         # if math.gcd(mods[i], mods[i - 1]) != 1 :
#         #     verif = False

#     return verif

def verif(mods) :
 verif = True

 for i in range (1 ,len(mods)) :

    if math.gcd(mods[i], mods[i - 1]) != 1 :
        verif = False

 return verif

print("Premiers ? : ", verif([3, 5, 7]))
print("Premiers ? : ", verif([3, 6,  7]))


