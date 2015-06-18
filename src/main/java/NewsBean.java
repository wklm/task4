import javax.annotation.ManagedBean;
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

    @Inject
    NewsRepo newsMap;

    @NotNull String title;
    @NotNull String topic;
    @NotNull String content;
    public String newsString;
    News news = new News();

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public void addNews(){

        newsMap.getNewsMap().put(newsMap.getIndex(), news);
        newsMap.setIndex(newsMap.getIndex()+1);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getNewsString() {
        return newsMap.getNewsMap().toString();
    }

    public void setNewsString(String newsString) {
        this.newsString = newsString;
    }



}
