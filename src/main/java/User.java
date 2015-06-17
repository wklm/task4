import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by wojte_000 on 6/6/2015.
 */
@ViewScoped
public interface User {
    @NotNull
    String username = null;
    @NotNull@Pattern(regexp = "((?=.*\\d)(?=.*[A-Z]).{6,})", message = "{invalid.password}")
    String password = null;
}
