import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;

/**
 * Created by wojte_000 on 6/7/2015.
 */

@Startup
@Singleton
public class NewsRepo {

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    int index = 0;

    public HashMap<Integer, News> getNewsMap() {
        return newsMap;
    }

    public void setNewsMap(HashMap<Integer, News> newsMap) {
        this.newsMap = newsMap;
    }

    HashMap<Integer, News> newsMap = new HashMap<>();




}
