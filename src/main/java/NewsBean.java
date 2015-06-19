import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 * Created by wojte_000 on 6/18/2015.
 */

@Named
@SessionScoped
public class NewsBean {
    @EJB
    private UserRepo users;
    @Inject
    NewsRepo newsMap;

    private String title;
    private String topic;
    private String content;
    public String newsString;

    public void addNews(){
        if (this.content!=null && this.topic!=null && this.title!=null) {
            users.publish(new News(this.title, this.content, this.topic));
        }
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsRepo getNewsMap() {
        return newsMap;
    }

    public void setNewsMap(NewsRepo newsMap) {
        this.newsMap = newsMap;
    }

    public String getNewsString() {
        return newsMap.getNewsMap().toString();
    }

    public void setNewsString(String newsString) {
        this.newsString = newsString;
    }



}
