/**
 * Andrey Sevastyanov, author 25/10/2016 homework  for lesson7, Java 1. Created by master on 25.10.2016.
 * NOT Working !!!!
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI extends JFrame {
    // coordinates of our window
    int size1 = 100;    //left corner x
    int size2 = 100;    //left corner y
    int size3 = 400;    //right corner x
    int size4 = 350;    //right corner y

    Main main;

    GUI() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(size1, size2, size3, size4);

        JButton btn1 = new JButton("New Game");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("First");
            }
        });
        JButton btn2 = new JButton("Exit");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
               // System.out.println("Exit");
            }
        });
       // JButton btn3 = new JButton("Third");
        JPanel bp = new JPanel();
        paintSym ps = new paintSym();


        main = new Main();
        main.setBackground(Color.blue);
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int x = e.getX();
                int y = e.getY();
                if ((x > 5) && (x <130) || (y > 77) && (y < 128)) {

//                   ps.add (new paintSym());
                    System.out.println("O");

                  // paintO();
               }
                System.out.println(x + ":" + y);
            }
        });

        bp.setLayout(new GridLayout());
        bp.add(btn1);
        bp.add(btn2);
      //  bp.add(btn3);

        setLayout(new BorderLayout());
        add(bp, BorderLayout.SOUTH);
        add(main, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String args[]) {
        new GUI();
    }

    class Main extends JPanel { // for painting
                @Override
                public void paint(Graphics g) {
                    super.paint(g);

                    g.drawLine(130,5,130,280);
                    g.drawLine(260,5,260,280);
                    g.drawLine(5,80,385,80);
                    g.drawLine(5,180,385,180);

                }
    }

    class paintSym extends JPanel { // for painting symbols
        @Override
        public void paint(Graphics d) {
            super.paint(d);

            d.drawOval(40,30,30,30);
        }

    }
}
