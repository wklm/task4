import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by wojte_000 on 6/14/2015.
 */
@ViewScoped
@ManagedBean(name="topic")
public class Topic extends Observable {
    private ArrayList<News> articles = new ArrayList<News>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    String name;

    public void notifyObservers(Observable observable, News news) {
        for (Observer ob : observers) {
            ob.update(observable, news);
        }
    }
    public void publish(News news) {
        articles.add(news);
        notifyObservers(this, news);
    }
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public Topic(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
