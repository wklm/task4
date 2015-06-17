import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by wojte_000 on 5/25/2015.
 */
@ViewScoped
@ManagedBean(name="writer")
public class Writer extends Observable implements User {
    Account account;

    private ArrayList<News> publications = new ArrayList<News>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public Writer(String login, String pass) {
        this.account = new Account(login,pass);
    }


    public void publish(News news) {
        publications.add(news);
        notifyObservers(this, news);
    }

    public void notifyObservers(Observable observable, News news) {
        for (Observer ob : observers) {
            ob.update(observable, news);
        }
    }
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public ArrayList<News> getNewses() {
        return publications;
    }
    public void setNewses(ArrayList<News> newses) {
        this.publications = newses;
    }
    public ArrayList<Observer> getObservers() {
        return observers;
    }
    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public Writer() {}


}
