import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by wojte_000 on 5/25/2015.
 */

@ViewScoped
@ManagedBean(name="reader")
public class Reader implements Observer, Serializable, User {
    Account account;
    Reader(String login, String password) {
        this.account = new Account(login, password);
    }
    ArrayList<String> subscribedTopics = new ArrayList<>();
    ArrayList<News> newsList = new ArrayList<>();

    @Override
    public void update(Observable o, Object news) {
        News n = (News)news;
        for (String s : getSubscribedTopics())
            if (s.equals(n.getTopic()))
                newsList.add(n);
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public ArrayList<String> getSubscribedTopics() {
        return subscribedTopics;
    }

    public void setSubscribedTopics(ArrayList<String> subscribedTopics) {
        this.subscribedTopics = subscribedTopics;
    }
    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<News> newsList) {
        this.newsList = newsList;
    }

    public Reader (){}
}