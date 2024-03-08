class Compagnie

    def initialize(nom)
        @aventuriers = []
        @nom = nom
    end

    def ajouter(aventurier)

        if existe?(aventurier)
            raise "L'aventurier #{aventurier.nom} est déjà dans la compagnie !"

        @aventuriers.push(aventurier)
        
    end

    def find(aventurier)
        @aventuriers.index do
            |elmt | elmt.nom == aventurier.nom
        end
    end

    def existe?(aventurier)
        find(aventurier) != nil
    end

    def to_s

        texte = "Compagnie : " + @nom + "\n" + " - Membres  : " + "\n"

        @aventuriers.each do | elmt |
            texte += "\t - #{elmt.nom} (#{elmt.pv}). \n"
        end

        texte
    end
end
