puts("Coucou ceci est le test ! ")

def testAddition(val1, val2=6)

    val1 + val2
end

puts("test addition : ", testAddition(3))

monMot = "coucou"
puts("Mon mot est : #{monMot} ! ")

puts("Mon mot en majuscule sans modif : #{monMot.capitalize} ! ")
puts("Mon mot en majuscule avec modif : #{monMot.capitalize!} ! ")
puts("Mon mot modifié  : #{monMot} ! ")

puts("Mon mot coupé en fonction des c : #{monMot.split("c")}")

premierTableau = []

monString = "test"
monString = monString + 1.to_s
# puts("Mon String : #{monString}")


for cpt in 1..5

    premierTableau.push("Test : " + cpt.to_s)
end


premierTableau.each do |val|
    msg = " - " + val
    puts(msg)
end

puts("Taille du tableau = " + (premierTableau.size).to_s)
