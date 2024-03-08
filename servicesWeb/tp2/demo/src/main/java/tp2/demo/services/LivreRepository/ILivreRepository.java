package tp2.demo.services.LivreRepository;

import org.springframework.data.repository.CrudRepository;
import tp2.demo.Model.Livre;

import java.util.List;


public interface ILivreRepository extends CrudRepository<Livre, Integer> {

    List<Livre> findByTitre(String titre);
}
