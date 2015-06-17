import javax.ejb.Singleton;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;

/**
 * Created by wojte_000 on 6/7/2015.
 */

@Singleton
public class NewsRepo {

    HashMap<String, ArrayList<News>> newsMap = new HashMap<>();

    // tags:
    ArrayList<News> politics = new ArrayList<>();
    ArrayList<News> sport = new ArrayList<>();
    ArrayList<News> film = new ArrayList<>();
    ArrayList<News> music = new ArrayList<>();
    ArrayList<News> automotive = new ArrayList<>();

    NewsRepo() {
        newsMap.put("politics", politics);
        newsMap.put("sport", sport);
        newsMap.put("film", film);
        newsMap.put("music", music);
        newsMap.put("automotive", automotive);
    }

    public void addNews(String topic, String content, ArrayList<String> tags) {

        if (newsMap.get(topic) != null && content != null && tags != null){
            News news = new News();
            news.setContent(content);
            news.setTopic(topic);
            news.setTags(tags);
            newsMap.get(topic).add(news);
        }
        else FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ooops :(", "wrong input"));

    }

    public HashMap<String, ArrayList<News>> getNewsMap() {
        return newsMap;
    }

    public void setNewsMap(HashMap<String, ArrayList<News>> newsMap) {
        this.newsMap = newsMap;
    }

    public ArrayList<News> getPolitics() {
        return politics;
    }

    public void setPolitics(ArrayList<News> politics) {
        this.politics = politics;
    }

    public ArrayList<News> getSport() {
        return sport;
    }

    public void setSport(ArrayList<News> sport) {
        this.sport = sport;
    }

    public ArrayList<News> getFilm() {
        return film;
    }

    public void setFilm(ArrayList<News> film) {
        this.film = film;
    }

    public ArrayList<News> getMusic() {
        return music;
    }

    public void setMusic(ArrayList<News> music) {
        this.music = music;
    }

    public ArrayList<News> getAutomotive() {
        return automotive;
    }

    public void setAutomotive(ArrayList<News> automotive) {
        this.automotive = automotive;
    }


}
