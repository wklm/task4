import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by wojte_000 on 5/25/2015.
 */
@ViewScoped
@ManagedBean(name="news")
public class News {

    String title = new String();
    String content = new String();
    ArrayList<String> tags = new ArrayList<String>();
    Boolean read = false;
    Date date = new Date();
    String topic = new String();

    public News(String title, String content, String topic) {
        this.title = title;
        this.content = content;
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }



    public News() {}
}
