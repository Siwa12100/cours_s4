require_relative 'creature'

class Gobelin < Creature

    def encaisser(degats)
        @pv = @pv - (degats / 2)
    end

    def to_s
        "Gobelin -> #{@nom} : #{@pv}pv"
    end
end