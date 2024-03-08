package tp2.demo.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LivreException extends RuntimeException{
    public LivreException(String exception){
        super(exception);
    }
}
