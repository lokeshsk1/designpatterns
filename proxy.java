class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java"); 
        ProxyImage image1 = new ProxyImage("image1.jpg");
        ProxyImage image2 = new ProxyImage("image2.jpg");
        ProxyImage image3 = new ProxyImage("image3.jpg");
        //image2 is not loading during initialization, but only during displaying
        image2.display();
        image2.display();
    }
}

interface Image{
    void display();
}

class RealImage implements Image{

    public String filename;

    RealImage(String filename){
        this.filename = filename;
        loadFromDisk();
    }

    public void loadFromDisk(){
        System.out.println("Loading " + filename); 
    }

    @Override
    public void display(){
        System.out.println("Displaying " + filename); 
    }
}

class ProxyImage implements Image{

    public String filename;
    public RealImage realImage;

    ProxyImage(String filename){
        this.filename = filename;
    }

    @Override
    public void display(){
        if(realImage == null){
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

