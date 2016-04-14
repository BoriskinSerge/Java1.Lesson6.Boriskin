import java.io.IOException;
import java.net.Socket;

public class MainClass {


    public static void main(String[] args) throws IOException {

        Socket s = new Socket("localhost", 8189);
        MyWindow w = new MyWindow(s); // Создаем окно
        ServerListener sl = new ServerListener(w, s);
        sl.run();



    }

}
