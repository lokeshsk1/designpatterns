import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java");
        YouTubeChannel channel = new YouTubeChannel("Loki Tech");

        Subscriber subscriber1 = new Subscriber("Lokesh");
        Subscriber subscriber2 = new Subscriber("Akash");
        Subscriber subscriber3 = new Subscriber("Vijay");

        channel.attach(subscriber1);
        channel.attach(subscriber2);
        channel.uploadVideo("1.React bits - Intro");

        channel.attach(subscriber3);
        channel.uploadVideo("2.React bits - Landing Pages");

        channel.detach(subscriber2);
        channel.uploadVideo("3.React bits - Alerts");
    }
}

interface Observer{
    void update(String message);
}

interface Subject{
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyAllObservers(String message);
}

class Subscriber implements Observer{

    String name;

    Subscriber(String name){
        this.name = name;
    }

    @Override
    public void update(String message){
        System.out.println("Hey " + name  + ", " + message);
    }
}

class YouTubeChannel implements Subject{

    private String channelName;
    private List<Observer> subscribers = new ArrayList<>();

    YouTubeChannel(String channelName){
        this.channelName = channelName;
    }

    @Override
    public void attach(Observer subscriber){
        subscribers.add(subscriber);
    }

    @Override
    public void detach(Observer subscriber){
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAllObservers(String message){
        for(Observer subscriber : subscribers){
            subscriber.update(message);
        }
    }

    public void uploadVideo(String videoTitle){
        notifyAllObservers("Video Uploaded - " + videoTitle);
    }
}
