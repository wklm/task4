import javax.ejb.Singleton;
import java.util.ArrayList;

/**
 * Created by wojte_000 on 6/14/2015.
 */

@Singleton
public class TopicRepo {
    ArrayList<Topic> topics = new ArrayList<>();
}
