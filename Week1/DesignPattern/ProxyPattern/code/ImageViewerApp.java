
interface Image {
    void display();
}


class RemoteImage implements Image {
    String fileName;

    public RemoteImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}


class CachedImageProxy implements Image {
    private RemoteImage realImage;
    String fileName;

    public CachedImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RemoteImage(fileName);
        } else {
            System.out.println("Fetching from cache: " + fileName);
        }
        realImage.display();
    }
}


public class ImageViewerApp {
    public static void main(String[] args) {
        Image img1 = new CachedImageProxy("scenery.jpg");
        Image img2 = new CachedImageProxy("cityscape.png");

        
        img1.display();
        System.out.println();

        
        img1.display();
        System.out.println();

        
        img2.display();
    }
}
