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
def cat(a, b)
  a + b
end


# Signature: words(s)
# Indice : Regarder la documentation de string
# Retourne les mots de la string s
def words(s)
  s.split
end


# Signature: upcase!(s)
# Retourne true mais modifie la string s pour que
# toutes ses lettres soient en majuscules
def upcase!(s)
  s.upcase!
  return true
end

# Signature: dot(arr)
# Retourne une chaine de caractère avec les éléments du tableau
# séparés par un point milieu · (Attention, ce n'est pas le point de votre clavier!)
# Indice : Regarder la documentation de array
# Exemple : dot(['aut', 'eur', 'trice']) => 'aut·eur·rice'
def dot(arr)
  return arr.join("·")
end


# Signature: minimum_length_4(s)
# Retourne une chaine de caractère où les mots de moins de 3 caractères
# sont supprimés
# Exemple : minimum_length_4('I do not like potatoes') => 'like potatoes'
def minimum_length_4(s)
  resultat = []
  tab = s.split
  tab.each do |mot|
    if mot.size >= 4
      resultat.push(mot)
    end
  end

  return resultat.join(" ")
end 


# Signature: multiply_array(arr, n)
# Retourne un tableau qui contient tous les nombres de arr multipliés par n
# Exemple : multiply_array([1, 2, 3], 3) => [3, 6, 9]
# Obligation : utiliser l'opérateur #map
def multiply_array(arr, n)
  arr.map{|val| val * n}
end


# Signature: sum(arr)
# Retourne la somme des nombres du tableau
# Exemple : sum([1, 2, -1, 3]) => 5
# Obligation : utiliser l'opérateur #reduce
def sum(arr)
  somme = 0
  arr.each do |val|
    somme = somme + val
  end

  return somme
end


# Signature: capitalize_words(s)
# Retourne la string s avec tous les mots en capitalize
# (première lettre en majuscule)
# Exemple : capitalize_words('thanks obama') => 'Thanks Obama'
def capitalize_words(s)
  tab = words(s)
  resultat = []

  tab.each do |mot|
    resultat.push(mot.capitalize)
  end
  return resultat.join(" ")
    
end


# Signature: enumeration(n)
# Retourne un tableau qui contient tous les nombres
# de 1 à n
# Indice : Regardez les Range
# Exemple : enumeration(3) => [1, 2, 3]
def enumeration(n)
  resultat = []

  if n > 1
    ((1..n).step(1).to_a).each do |val|
      resultat.push(val)
    end
  else
    ((n..1).step(1).to_a).each do |val|
      resultat.push(val)
    end
  end
  return resultat
end


# Signature: compte_repetitions(arr)
# Retourne le nombre de répétition de chaque mot
# Exemple : compte_repetitions([
#  "oui", "bip", "bop", "bip", "blop", "oui", 
#  "je", "suis", "un", "robot", "oui", "robot"
# ])
# => { "oui" => 2, "bip" => 1, "robot" => 1, "bop" => 0, "blop" => 0, "je" => 0, ... }
def compte_repetitions(arr)
  compteur = Hash.new()

  arr.each do |mot|

    if compteur.include?(mot)
      compteur[mot] += 1
    else 
      compteur[mot] = 0
    end
  end

  compteur
end

# Signature: repetitions(s)
# Retourne le nombre de répétition dans la phrase
# Indice : Un nombre de répétition, c'est pas un nombre d'occurence.
# Indice 2 : Pensez à la casse et par quels caractères splitter`
# Exemple : repetitions("Oui bip bop bip blop. Oui, je suis un robot, oui robot.") => 4
def repetitions(s)

  tableau_mots = words(s)
  tableau_mots.each do |mot|
    mot.downcase!
    mot.delete_prefix(".")
    mot.delete_prefix(",")
  end

  tab = []
  compteur = compte_repetitions(tableau_mots)
  compteur.each_value{|val| tab.push(val) }

  return sum(tab)
end


# Signature: dictionnary(s)
# Retourne un hash qui contient les mots pour clés et
# leur définitions comme valeur.
# Exemple: dictionnary('Ours: Mammifère carnivore (ursidé)|Lapin: Mammifère rongeur très prolifique') =>
# { 'Ours' => 'Mammifère carnivore (ursidé)', 'Lapin' => 'Mammifère rongeur très prolifique' }
