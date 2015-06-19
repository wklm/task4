import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 * Created by wojte_000 on 6/17/2015.
 */
@ManagedBean
@ViewScoped
public class TopicBean {
    private static SelectItem[] newstopics = {
            new SelectItem("sports"),
            new SelectItem("technology"),
            new SelectItem("innovation"),
            new SelectItem("health")
    };

    public SelectItem[] getNewstopics() {
        return newstopics;
    }
}
