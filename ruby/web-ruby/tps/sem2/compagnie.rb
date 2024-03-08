class Compagnie

    def initialize(nom)
        @aventuriers = []
        @nom = nom
    end

    def ajouter(aventurier)
        @aventuriers.push(aventurier)
        
    end

    def find(aventurier)
        @aventuriers.index {
            |elmt | elmt.nom == aventurier.nom
        }
    end
end
