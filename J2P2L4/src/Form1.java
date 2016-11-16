import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Andrey Sevastyanov on 15.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework
 */
class Form1 extends JFrame {

    Form1() throws IOException {
        setTitle ( "Test Window" );
        setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        setLayout (null);
        setBounds ( 300 , 300 , 400 , 400 );
        JPanel jp = new JPanel();
        jp.setLayout ( new BorderLayout());
        add(jp);
        JTextArea jta = new JTextArea ();
        add(jta);
       // JScrollPane jsp = new JScrollPane (jta );
       // jp.add ( jsp );
        JTextField field = new JTextField ();
        add(field);
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\master\\Documents\\Обучение\\Java 2\\Lesson 4\\1.txt"));
        field.addActionListener ( new ActionListener() {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                //System . out. println ( "Your message: " + field . getText ());
                //ввод после нажатия ENTER
                jta.setText(field.getText());
                pw.println(field.getText());
                pw.close();
            }
        });
        JButton button = new JButton ( "Send" );
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ввод после клика по кнопке SEND
                jta.setText(field.getText());
                pw.println(field.getText());
                pw.close();
            }
        });
        jta.setBounds(20,50,300,50);
        field.setBounds(20,200,350,20);
        button.setBounds(150,250,100,50);
        setVisible ( true );



    }
}

