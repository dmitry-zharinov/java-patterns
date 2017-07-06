package dw.patterns;

public class ProxyApp {
    public static void main(String... args){
        Image image = new RealImage("C:/Users/zhari_000/Pictures/yTJb3SGQCL48.jpg");
        image.display();
    }

}

interface Image{
    void display( );
}

class RealImage implements Image{
    String file;

    public RealImage(String file){
        super();
        this.file = file;
        load();
    }

    void load(){
        System.out.println("Загрузка файл" + file);
    }

    @Override
    public void display(){
        System.out.println("Просмотр файла" + file);
    }
}

class ProxyImage implements Image{
    String file;
    RealImage image;

    public ProxyImage(String file){
        super();
        this.file = file;
    }

    void load(){
        System.out.println("Загрузка файл" + file);
    }

    @Override
    public void display(){
        if (image == null){
            image = new RealImage(file);
        }
        System.out.println("Просмотр файла" + file);
    }

}