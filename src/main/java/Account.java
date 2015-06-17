/**
 * Created by wojte_000 on 6/3/2015.
 */
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ViewScoped
@ManagedBean(name="account")
public class Account {
    String login = null;
    String password = null;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Account(){}

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (getPassword().equals(oldPassword)) {
            setPassword(newPassword);
            return true;
        }
        return false;
    }
}
