import javax.faces.bean.ManagedBean;
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
    ArrayList<News> newsList = new ArrayList<>();
    ChooseTopics topics;
    ArrayList<Topic> subscribedTopics;

    @Override
    public void update(Observable o, Object news) {
        News n = (News)news;
        for (Topic t : getSubscribedTopics())
            if (t.equals(n.getTopic()))
                newsList.add(n);
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public ArrayList<News> getNewsList() {
        return newsList;
    }
    public void setNewsList(ArrayList<News> newsList) {
        this.newsList = newsList;
    }
    public ChooseTopics getTopics() {
        return topics;
    }

    public void setTopics(ChooseTopics topics) {
        this.topics = topics;
    }


    public ArrayList<Topic> getSubscribedTopics() {
        return subscribedTopics;
    }

    public void setSubscribedTopics(ArrayList<Topic> subscribedTopics) {
        this.subscribedTopics = subscribedTopics;
    }

    public Integer getPaging() {
        return paging;
    }

    public void setPaging(Integer paging) {
        this.paging = paging;
    }

    Integer paging;


}