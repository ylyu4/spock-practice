import java.util.ArrayList;
import java.util.List;

public class Publisher {

    List<Subscriber> subscriberList = new ArrayList<>();


    public void add(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void fire(String string) {
        subscriberList.forEach(subscriber -> subscriber.receive(string));
    }
}
