import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class MyWindow extends JFrame {

    private JTextArea jta;
    private Socket s;

    public MyWindow(Socket _s) throws IOException {
        this.s = _s;
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        setTitle("My First Window"); // Устанавливаем заголовок окна
        setSize(400, 400); // Размер окна
        setLocation(1200, 200); // Положение
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Включаем завершение работы программы по зарытию окна
        jta = new JTextArea(); // Создаем большое текстовое поле
        jta.setBackground(Color.lightGray); // Красим его в серый цвет
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

            }
        });
        setVisible(true); // Переключаем видимость формы в true

    }

    public void addTextToJta(String s) {
        jta.append(s+"\n");
    }
}
