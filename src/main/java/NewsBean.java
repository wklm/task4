import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 * Created by wojte_000 on 6/15/2015.
 */
@ManagedBean
@SessionScoped
@Stateful
public class NewsBean {

    @Inject
    NewsRepo newsMap;
    String title;
    String topic;
    String content;
    @Inject
    TopicRepo topics;


    public void addNews() {
        News news = new News(getTitle(),getContent(),getTopic());
        this.newsMap.getNewsMap().put(getTitle(),news);
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TopicRepo getTopics() {
        return topics;
    }

    public void setTopics(TopicRepo topics) {
        this.topics = topics;
    }
}
