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

    def to_s
        texte = "Compagnie : " + @nom + "\n" + " - Membres  : " + "\n"

        @aventuriers.each do | elmt |
            texte = "\t - #{elmt.nom} (#{elmt.pv})."
        end

        return texte
    end
end
