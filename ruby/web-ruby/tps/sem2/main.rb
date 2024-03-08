require_relative 'creature'
require_relative 'troll'
require_relative 'gobelin'

puts()
puts("=-=-=-= Test Creature =-=-=-=-=")
c1 = Creature.new("Senu", 100)
puts(c1)

puts()
puts("=-=-=-= Test Troll =-=-=-=-=-=-=")
c2 = Troll.new("Synin", 89)
puts(c2)

puts()
puts("=-=-=-= Test prise dégats =-=-=-=-=")
c1.encaisser(20)
c2.encaisser(34)
puts(c1)
puts(c2)

puts()
puts("=-=-=-=-= Test du Gobelin =-=-=-=-=")
g1 = Gobelin.new("Soleh", 100)

# puts(" ", g1)

puts("Avant prise de 20 degats : ", g1)
g1.encaisser(20)
puts("Après prise de 20 de degats : ", g1)

puts()
puts("=-=-=-=-=-= Test de Soignable =-=-=-=-=")
c3 = Creature.new("Drac", 100)
c3.soigner(20)
puts(c3)