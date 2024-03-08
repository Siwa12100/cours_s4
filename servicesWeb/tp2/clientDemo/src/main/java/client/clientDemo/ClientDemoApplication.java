package client.clientDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

//il faut créer la classe livre (c/c)
// on relance (clean install) + run

@SpringBootApplication
public class ClientDemoApplication {

	public static void main(String[] args) {

		RestTemplate restTemplate= new RestTemplate();
		Livre l = new Livre("Titre Client", "Contenu Client");

		restTemplate.postForObject("http://localhost:8080/addlivre", l, Livre.class);

		ArrayList<Livre> liste = restTemplate.getForObject("http://localhost:8080/addlivre", ArrayList.class);
		System.out.println(liste.toString());

	}

}
