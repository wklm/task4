import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Created by wojte_000 on 6/18/2015.
 */

@ManagedBean
@SessionScoped
public class NewsBean {
    @EJB
    private UserRepo users;

    private String title;
    private ArrayList<String> topics;
    private String content;

    public void addNews(){
        News news = new News(this.title, this.content, this.topics);
        users.publish(news);
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getTopics() {
        return this.topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
