#!/usr/bin/env ruby

## Consigne : Ecrivez les fonctions décrites en dessous de leurs descriptions.
## Pour executer les tests relatifs au kata, executez 'rspec'

# Signature: add(a, b)
# Retourne l'addition de a et b
def add(a, b)
  a + b
end


# Signature: cat(a, b)
# Retourne la concaténation des deux chaines a et b


# Signature: words(s)
# Indice : Regarder la documentation de string
# Retourne les mots de la string s


# Signature: upcase!(s)
# Retourne true mais modifie la string s pour que
# toutes ses lettres soient en majuscules


# Signature: dot(arr)
# Retourne une chaine de caractère avec les éléments du tableau
# séparés par un point milieu · (Attention, ce n'est pas le point de votre clavier!)
# Indice : Regarder la documentation de array
# Exemple : dot(['aut', 'eur', 'trice']) => 'aut·eur·rice'


# Signature: minimum_length_4(s)
# Retourne une chaine de caractère où les mots de moins de 3 caractères
# sont supprimés
# Exemple : minimum_length_4('I do not like potatoes') => 'like potatoes'


# Signature: multiply_array(arr, n)
# Retourne un tableau qui contient tous les nombres de arr multipliés par n
# Exemple : multiply_array([1, 2, 3], 3) => [3, 6, 9]
# Obligation : utiliser l'opérateur #map


# Signature: sum(arr)
# Retourne la somme des nombres du tableau
# Exemple : sum([1, 2, -1, 3]) => 5
# Obligation : utiliser l'opérateur #reduce


# Signature: capitalize_words(s)
# Retourne la string s avec tous les mots en capitalize
# (première lettre en majuscule)
# Exemple : capitalize_words('thanks obama') => 'Thanks Obama'


# Signature: enumeration(n)
# Retourne un tableau qui contient tous les nombres
# de 1 à n
# Indice : Regardez les Range
# Exemple : enumeration(3) => [1, 2, 3]


# Signature: compte_repetitions(arr)
# Retourne le nombre de répétition de chaque mot
# Exemple : compte_repetitions([
#  "oui", "bip", "bop", "bip", "blop", "oui", 
#  "je", "suis", "un", "robot", "oui", "robot"
# ])
# => { "oui" => 2, "bip" => 1, "robot" => 1, "bop" => 0, "blop" => 0, "je" => 0, ... }


# Signature: repetitions(s)
# Retourne le nombre de répétition dans la phrase
# Indice : Un nombre de répétition, c'est pas un nombre d'occurence.
# Indice 2 : Pensez à la casse et par quels caractères splitter`
# Exemple : repetitions("Oui bip bop bip blop. Oui, je suis un robot, oui robot.") => 4


# Signature: dictionnary(s)
# Retourne un hash qui contient les mots pour clés et
# leur définitions comme valeur.
# Exemple: dictionnary('Ours: Mammifère carnivore (ursidé)|Lapin: Mammifère rongeur très prolifique') =>
# { 'Ours' => 'Mammifère carnivore (ursidé)', 'Lapin' => 'Mammifère rongeur très prolifique' }
