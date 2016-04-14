import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Sergey on 14.04.16.
 */
public class ServerListener implements Runnable {

    private MyWindow w;
    private Socket s;


    public ServerListener(MyWindow w, Socket s) {
        this.w = w;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(s.getInputStream());
            w.addTextToJta("Подключились к серверу.");
            while (!Thread.currentThread().isInterrupted()) {
                w.addTextToJta(in.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
