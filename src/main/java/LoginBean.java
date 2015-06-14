import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;

@ManagedBean
@SessionScoped
@Stateful
public class LoginBean {

    @Inject
    UserRepo users;
    @NotNull
        String username;
    @NotNull@Pattern(regexp = "((?=.*\\d)(?=.*[A-Z]).{6,})", message = "{invalid.password}")
        String password;
    User currentUser = null;
    HashMap<String, Reader> readers = new HashMap<>();
    HashMap<String, Writer> writers = new HashMap<>();
    String readersListString = "readers: ";
    String writersListString = "writers: ";
    String currentUserName;

    public void addReader(String login, String pass) {
        if (users.getReaders().get(login) == null && users.getWriters().get(login) == null) {
            Reader r = new Reader(login, pass);
            users.getReaders().put(login, r);
        } // else exception
    }

    public void addWriter(String login, String pass) {
        if (users.getReaders().get(login) == null && users.getWriters().get(login) == null) {
            Writer w = new Writer(login, pass);
            users.getWriters().put(login, w);
        } // else exception
    }

    public String login() {
        if (users.getWriters().get(username) != null && users.getWriters().get(username).getAccount().getPassword().equals(password)){
            currentUser = users.getWriters().get(username);
            return "writerspanel";
        }
        if (users.getReaders().get(username) != null && users.getReaders().get(username).getAccount().getPassword().equals(password)){
            currentUser = users.getReaders().get(username);
            return "readerspanel";
        }
        else return "failure";
    }

    public String getCurrentUserName() {

        if (currentUser == null)
            return "there's no current user";
        if (currentUser instanceof Reader)
            return ((Reader) currentUser).getAccount().getLogin();
        if (currentUser instanceof Writer)
            return ((Writer) currentUser).getAccount().getLogin();
        else return "error getCurrentUserName" + users.getReaders().toString() + " " + users.getWriters().toString();
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public String getReadersListString() {
        return users.getReaders().toString();
    }

    public void setReadersListString(String readersListString) {
        this.readersListString = readersListString;
    }

    public String getWritersListString() {
        return users.getWriters().toString();
    }

    public void setWritersListString(String writersListString) {
        this.writersListString = writersListString;
    }


    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


   public HashMap<String, Reader> getReaders() {
        return users.getReaders();
    }

    public void setReaders(HashMap<String, Reader> readers) {
        users.setReaders(readers);
    }

    public HashMap<String, Writer> getWriters() {
        return users.getWriters();
    }

    public void setWriters(HashMap<String, Writer> writers) {
        users.setWriters(writers);
    }

    public UserRepo getUsers() {
        return users;
    }

    public void setUsers(UserRepo users) {
        this.users = users;
    }
}