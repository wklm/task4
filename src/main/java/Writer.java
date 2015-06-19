import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by wojte_000 on 5/25/2015.
 */
@ViewScoped
@ManagedBean(name="writer")
public class Writer implements User {
    Account account;
    @Inject
    NewsRepo news;
    String topic;
    String content;


    public Writer(String login, String pass) {
        this.account = new Account(login,pass);
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public NewsRepo getNews() {
        return news;
    }

    public void setNews(NewsRepo news) {
        this.news = news;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Writer() {}


}
