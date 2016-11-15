import javax.swing.*;
import java.awt.*;

/**
 * Created by Andrey Sevastyanov on 15.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework
 */
class Form1 extends JFrame {
    Form1() {
        setTitle ( "Test Window" );
        setDefaultCloseOperation ( WindowConstants . EXIT_ON_CLOSE );
        setLayout ( new GridLayout (2,1));
        setBounds ( 300 , 300 , 400 , 400 );
        JPanel jp = new JPanel();
        jp.setLayout ( new BorderLayout());
        add(jp);
        JTextArea jta = new JTextArea ();
        add(jta);
        JScrollPane jsp = new JScrollPane (jta );
        jp.add ( jsp );
        JButton button = new JButton ( "Send" );
        add(button);
        setVisible ( true );
    }
}

