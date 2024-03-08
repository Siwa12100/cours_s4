package tp2.demo.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Entity
public class Livre {
    private String titre;
    private String contenu;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Livre(){
        this.titre="Titre inconnu";
        this.contenu="Contenu inconnu";
    }
    public Livre(String titre, String contenu){
        this.titre=titre;
        this.contenu=contenu;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}
