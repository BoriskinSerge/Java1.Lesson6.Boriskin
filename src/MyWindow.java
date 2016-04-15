import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class MyWindow extends JFrame {

    private JTextArea jta;
    private Socket s;
    private PrintWriter out;

    public MyWindow(Socket _s) throws IOException {
        this.s = _s;
        out = new PrintWriter(s.getOutputStream(), true);
        setTitle("Chat Client"); // Устанавливаем заголовок окна
        setSize(400, 400); // Размер окна
        setLocation(1200, 200); // Положение
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // Включаем завершение работы программы по зарытию окна
        jta = new JTextArea(); // Создаем большое текстовое поле
//        jta.setBackground(Color.lightGray); // Красим его в серый цвет
        add(jta); // добавляем его на форму
        JPanel southPanel = new JPanel(); // Создаем южную(нижнюю) панель
        southPanel.setLayout(new BorderLayout()); // Задаем для нее мспособ компоновки элементов
        add(southPanel, BorderLayout.SOUTH); // Добавляем панель на форму
        JButton jb = new JButton("Send"); // Создаем кнопку
        JTextField jtf = new JTextField(); // И однострочное текстовое поле
        southPanel.add(jb, BorderLayout.EAST); // Кнопки ставим на восток нижней панели
        southPanel.add(jtf, BorderLayout.CENTER); // Текстовое пле в центр панели


//        jta.setText(getAllDb());
        jb.addActionListener(new ActionListener() { // вешаем на кнопку прослушивальщик действий
            @Override
            public void actionPerformed(ActionEvent e) {
                addTextToJta(jtf.getText());
                out.println(jtf.getText());
                jtf.setText(""); // Нижнее текстовое поле очищается
                jtf.grabFocus();

            }
        });
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                out.close();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
//        setVisible(true); // Переключаем видимость формы в true


    }

    public void addTextToJta(String s) {
        jta.append(s+"\n");
    }
}