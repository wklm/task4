import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wojte_000 on 6/15/2015.
 */
@ManagedBean
@SessionScoped
@Stateful
public class NewsBean {

    NewsRepo newsMap;
    String toppic;
    String content;
    String tags;

    public String getToppic() {
        return toppic;
    }

    public void setToppic(String toppic) {
        this.toppic = toppic;
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
}
