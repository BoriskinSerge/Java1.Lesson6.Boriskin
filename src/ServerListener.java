import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Sergey on 14.04.16.
 */
public class ServerListener implements Runnable {

    private MyWindow w;
    private Socket s;
    private Scanner in;

    public ServerListener(MyWindow w, Socket s) {
        this.w = w;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            in = new Scanner(s.getInputStream());
            w.addTextToJta("Подключились к серверу.");
            while (!Thread.currentThread().isInterrupted()) {
                w.addTextToJta(in.nextLine());
                Thread.sleep(10);

            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
