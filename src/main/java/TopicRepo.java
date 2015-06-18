import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wojte_000 on 6/14/2015.
 */
@Startup
@Singleton
public class TopicRepo {
    public Topic getSport() {
        return sport;
    }

    public void setSport(Topic sport) {
        this.sport = sport;
    }

    public Topic getAutomotive() {
        return automotive;
    }

    public void setAutomotive(Topic automotive) {
        this.automotive = automotive;
    }

    public Topic getPolitics() {
        return politics;
    }

    public void setPolitics(Topic politics) {
        this.politics = politics;
    }

    public Topic getMusic() {
        return music;
    }

    public void setMusic(Topic music) {
        this.music = music;
    }

    public Topic getFilm() {
        return film;
    }

    public void setFilm(Topic film) {
        this.film = film;
    }

    public HashMap<String, Topic> getTopics() {
        return topics;
    }

    Topic sport = new Topic("sport");
    Topic automotive = new Topic("automotive");
    Topic politics = new Topic("politics");
    Topic music = new Topic("music");
    Topic film = new Topic("film");

    public void setTopics(HashMap<String, Topic> topics) {
        this.topics = topics;
    }

    HashMap<String, Topic> topics= new HashMap<>();


}
