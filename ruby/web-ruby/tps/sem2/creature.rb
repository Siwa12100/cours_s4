class Creature
    def initialize(nom, pv)
        @nom, @pv = nom, pv
    end

    def nom
        @nom
    end 

    def pv
        @pv
    end 

    def nom=(nom)
        @nom = nom
    end

    def pv=(pv)
        @pv = pv
    end

    def encaisser(degats)
        @pv = @pv - degats  
    end

    def to_s
        "Creature #{@nom} : #{@pv}pv"
    end
end