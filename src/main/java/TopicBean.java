import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Created by wojte_000 on 6/17/2015.
 */
@ManagedBean
public class TopicBean {
    @Inject
    TopicRepo topics;
    Topic topic;

    private boolean sport;
    private boolean automotive;
    private boolean politics;
    private boolean music;
    private boolean film;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    public boolean getSport() {
        return sport;
    }
    public void setSport(boolean value) {
        this.sport = value;
    }
    public boolean getAutomotive() {
        return automotive;
    }
    public void setAutomotive(boolean value) {
        this.automotive = value;
    }
    public boolean getPolitics() {
        return politics;
    }
    public void setPolitics(boolean value) {
        this.politics = value;
    }
    public boolean getMusic() {
        return music;
    }
    public void setMusic(boolean value) {
        this.music = value;
    }
    public boolean getFilm() {
        return film;
    }
    public void setFilm(boolean value) {
        this.film = value;
    }


    public void addMessage() {
        String sportSummary = sport ? "Checked" : "Unchecked";
        String automotiveSummary = automotive ? "Checked" : "Unchecked";
        String politicsSummary = politics ? "Checked" : "Unchecked";
        String musicSummary = music ? "Checked" : "Unchecked";
        String filmSummary = film ? "Checked" : "Unchecked";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(sportSummary));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(automotiveSummary));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(politicsSummary));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(musicSummary));
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(filmSummary));
    }
}
