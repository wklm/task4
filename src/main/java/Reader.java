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

public class Reader implements Serializable, User {
    Account account;
    Reader(String login, String password) {
        this.account = new Account(login, password);
    }
    ArrayList<News> newsList = new ArrayList<>();
    ArrayList<String> topics = new ArrayList<String>();
    Integer paging;

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

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public Integer getPaging() {
        return paging;
    }

    public void setPaging(Integer paging) {
        this.paging = paging;
    }
}