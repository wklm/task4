import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by wojte_000 on 6/14/2015.
 */
@ViewScoped
@ManagedBean(name="topic")
public class Topic extends Observable {

    String name;
    public Topic(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
