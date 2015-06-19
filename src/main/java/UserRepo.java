import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wojte_000 on 6/14/2015.
 */
@Startup
@Singleton
public class UserRepo {

    public HashMap<String, Reader> getReaders() {
        return readers;
    }

    public void setReaders(HashMap<String, Reader> readers) {
        this.readers = readers;
    }

    public HashMap<String, Writer> getWriters() {
        return writers;
    }

    public void setWriters(HashMap<String, Writer> writers) {
        this.writers = writers;
    }

    HashMap<String, Reader> readers = new HashMap<>();
    HashMap<String, Writer> writers = new HashMap<>();
    public void publish(News n) {
        for(Reader r: readers.values()) { 
        //if newsreader contains all the newsreader topics
           //f (r.getTopics().));
            if(r.getTopics().containsAll(n.getTopics())) {
                r.newsList.add(n);
            }
        }
    }
}
