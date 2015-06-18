import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;

/**
 * Created by wojte_000 on 6/7/2015.
 */

@Singleton
@Startup
public class NewsRepo {

    public HashMap<String, News> getNewsMap() {
        return newsMap;
    }

    public void setNewsMap(HashMap<String, News> newsMap) {
        this.newsMap = newsMap;
    }

    HashMap<String, News> newsMap = new HashMap<>();

}
