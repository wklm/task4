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



    ArrayList<String> topics = new ArrayList<String>();

    public News(String title, String content, ArrayList<String> topics) {
        this.title = title;
        this.content = content;
        this.topics = topics;
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

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }
}
