import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;

@ManagedBean
@SessionScoped
public class UserBean {

    @Inject
    UserRepo users;

    @NotNull
    String username;
    @NotNull
    @Pattern(regexp = "((?=.*\\d)(?=.*[A-Z]).{6,})", message = "{invalid.password}")
    String password;
    User currentUser = null;
    HashMap<String, Reader> readers = new HashMap<>();
    HashMap<String, Writer> writers = new HashMap<>();
    String readersListString = "readers: ";
    String writersListString = "writers: ";
    String currentUserName;
    String oldPass;
    String newPass;
    Integer currentReaderPaging;
    Integer newPaging;
    boolean loggedIn;
    @Inject
    TopicBean topics;


    public Integer getNewPaging() {
        return newPaging;
    }

    public void setNewPaging(Integer newPaging) {
        this.newPaging = newPaging;
    }



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
        if (users.getWriters().get(username) != null && users.getWriters().get(username).getAccount().getPassword().equals(password)) {
            currentUser = users.getWriters().get(username);
            return "index";
        }
        if (users.getReaders().get(username) != null && users.getReaders().get(username).getAccount().getPassword().equals(password)) {
            currentUser = users.getReaders().get(username);
            return "index";
        } else return "failure";
    }

    public String logout() {
        currentUser = null;
        return "index?faces-redirect=true";
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

    public boolean changePassword() {

        if (currentUser instanceof Reader && ((Reader) currentUser).getAccount().getPassword().equals(getPassword())) {
            ((Reader) currentUser).getAccount().setPassword(newPass);
            return true;
        }
        if (currentUser instanceof Writer && ((Writer) currentUser).getAccount().getPassword().equals(getPassword())) {
            ((Writer) currentUser).getAccount().setPassword(newPass);
            return true;
        }
        return false;
    }

    public boolean isLogedasReader() {
        return currentUser instanceof Reader;
    }
    public boolean isLogedasWriter() {
        return currentUser instanceof Writer;
    }

    public String init() {
        String testReaderName = "testreader";
        String testWriterName = "testwriter";
        String testPass = "A1test";
        // v.1 : reader + topics
        Topic t1 = new Topic("automotive");
        Topic t2 = new Topic("politics");
        Topic t3 = new Topic("music");
        addReader(testReaderName, testPass);
        users.getReaders().get(testReaderName).getSubscribedTopics().add(t1);
        users.getReaders().get(testReaderName).getSubscribedTopics().add(t2);
        users.getReaders().get(testReaderName).getSubscribedTopics().add(t3);
        // v.2 : news provider
        this.addWriter(testWriterName,testPass);
        // v.3 : subscribable items
        News n1 = new News("title1", "topic1", "politics");
        News n2 = new News("title2", "topic2", "automotive");
        users.getWriters().get(testReaderName).write("title1", "topic1");
        users.getWriters().get(testReaderName).write("title2", "topic2");
       // users.getWriters().get(testWriterName).registerObserver(users.getReaders().get(testReaderName));

        return "index";
    }

    public void changePaging(int i) {

    }
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
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

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }


    public Integer getCurrentReaderPaging() {
        if (currentUser instanceof Reader)
            return users.getReaders().get(getCurrentUserName()).getPaging();
        else return Integer.MAX_VALUE;
    }

    public void setCurrentReaderPaging(Integer currentReaderPaging) {
        this.users.getReaders().get(getCurrentUserName()).setPaging(currentReaderPaging);
    }


    public TopicBean getTopics() {
        return topics;
    }

    public void setTopics(TopicBean topics) {
        this.topics = topics;
    }

}