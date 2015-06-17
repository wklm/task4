import java.util.ArrayList;

/**
 * Created by wojte_000 on 6/1/2015.
 */
public class Main {

    public static void main(String[] args) {



//        Reader r1 = new Reader("login", "password");
//        Reader r2 = new Reader("login", "password");
//
//        Writer w = new Writer();
//        w.registerObserver(r1);
//        w.registerObserver(r2);
//
//
//       // r1.getSubscribedTopics().add("sport");
//
//
//        News n = new News("jeden", "dwa", "sport");
//        w.publish(n);
//        for (News news : r1.getNewsList())
//            System.out.println(news.getContent());
    ArrayList<String> tags = new ArrayList<>();
        tags.add("efwef");

        NewsRepo nr = new NewsRepo();
        nr.addNews("blblb", "politics", tags);

        System.out.print(nr.getNewsMap().toString());

        /*
        ArrayList<String> topics = new ArrayList<>();
        topics.add("elelele");
        topics.add("lalalalala");
        News n = new News("title1", "content1", topics);
        w.publish(n);
        n = new News("blblbl", "wefwef", topics);
        w.publish(new News("blblbl", "wefwef", topics));
        n.setContent("iejfoeijfoeijfoewijf");
        w.publish(n);

        for (News news : r1.getSubscribedTopics())
            System.out.println(news.getContent()); */
    }

}