package tp2.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tp2.demo.Exception.LivreException;
import tp2.demo.Model.Livre;
import tp2.demo.services.LivreRepository.ILivreRepository;
//import tp2.demo.services.LivreRepository.LivreRepository;

import java.util.ArrayList;
import java.util.List;
//PathVariable


@RestController
public class LivreController {
    List<Livre> livres;
    protected ILivreRepository repository;

    public LivreController(ILivreRepository repository){

        this.livres  = new ArrayList<Livre>();
        this.chargerStubLivres();

        this.repository = repository;
    }

    @GetMapping(value="/getalllivres", produces="application/json")
    public @ResponseBody List<Livre> getAllLivres(){
        return livres;
    }

    @PostMapping(value="/addlivre")
    public Livre addLivres(@RequestBody Livre livre){
        this.livres.add(livre);
        return livre;
    }

    @GetMapping(value="/getError")
    public void getError(){
        throw new LivreException("Erreur marchée !");
    }

    protected void chargerStubLivres() {

        for (int i = 0; i < 8; i++) {
            String titre = "Titre - " + (i+1);
            String contenu = "Contenu - " + (i+1) + "....";
            this.livres.add(new Livre(titre, contenu));
        }
    }
}
