require_relative 'creature'

class Troll < Creature

    def to_s
        "Troll ->  #{@nom.upcase} : #{@pv}pv"
    end
end