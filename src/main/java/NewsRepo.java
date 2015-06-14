import javax.ejb.Singleton;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wojte_000 on 6/7/2015.
 */

@Singleton
public class NewsRepo {

    HashMap<String, ArrayList<News>> newsMap = new HashMap<>();
    ArrayList<String> topicsToChoose = new ArrayList<>();

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
        topicsToChoose.add("politics");
        topicsToChoose.add("sport");
        topicsToChoose.add("film");
        topicsToChoose.add("music");
        topicsToChoose.add("automotive");
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
