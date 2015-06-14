import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wojte_000 on 6/6/2015.
 */
public class TagManager {

    HashMap<String, ArrayList<News>> tags = new HashMap<>();

    public HashMap<String, ArrayList<News>> getTags() {
        return tags;
    }

    public void setTags(HashMap<String, ArrayList<News>> tags) {
        this.tags = tags;
    }

}
