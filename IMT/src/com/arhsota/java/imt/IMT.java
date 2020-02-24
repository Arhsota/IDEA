package com.arhsota.java.imt;

import javafx.scene.control.ProgressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*******************************************************************************
 *
 *  * Created by Andrey Sevastianov on 02.02.2020, 22:14
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 24.02.2020
 *  * Arkhangelsk, Sabetta
 *
 ******************************************************************************/

class MyFrame
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel weight;
    private JComboBox inputweight;
    private JLabel length;
    private JComboBox inputlength;
    private JLabel age;
    private JComboBox inputage;
    private JLabel lminp;
    private JLabel lmaxp;
    private JTextField tminp;
    private JTextField tmaxp;
    private JLabel mno;
    private JTextField timt;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    private JProgressBar bar;
    private double myResult;

    private String weights[]
            = { "50", "51", "52", "53", "54","55","56","57","58","59","60","61","61","63","64","65","66","67","68",
            "69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89",
            "90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108",
            "109","110","111","112","113","114","115","116","117","118","119"};
    private String lengths[]
            = { "100", "110", "120", "130",
            "140", "150","151", "152","153","154","155", "156","157", "158","159","160",
            "161", "162","163", "164","165","166","167", "168","169", "170","171","172",
            "173", "174","175", "176","177","178","179", "180","181", "182","183","184",
            "185", "186", "187", "188","189", "190","191", "192","193","194","195", "196","197", "198","199","200"};
    private String ages[]
            = { "18", "19", "20", "21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36",
            "37","38","39","40","41","42","43","44","45","46","47","48","49","50", "51", "52","53","54","55","56",
            "57","58","59","60","61","62","63","64","65","66"};

    private final int num19 = 19;
    private final int num20 = 20;
    private final int num21 = 21;
    private final int num22 = 22;
    private final int num23 = 23;
    private final int num24 = 24;
    private final int num25 = 25;
    private final int num26 = 26;
    private final int num27 = 27;
    private final int num28 = 28;
    private final int num29 = 59;
    private final int num34 = 34;
    private final int num44 = 44;
    private final int num54 = 54;
    private final int num64 = 64;

    private final String text_table ="При таких параметрах Ваш Индекс Массы Тела (ИМТ) должен быть в диапазоне: ";

    // constructor, to initialize the components
    // with default values.
    public MyFrame()
    {
        setTitle("Index");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);
//  only text
        title = new JLabel("Индекс Массы Тела");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

//  the main output of IMT

        timt = new JTextField();
        timt.setFont(new Font("Arial", Font.PLAIN, 30));
        timt.setSize(100, 35);
        timt.setLocation(400, 75);
        timt.setEditable(false);
        c.add(timt);

        weight = new JLabel("Вес");
        weight.setFont(new Font("Arial", Font.PLAIN, 20));
        weight.setSize(100, 20);
        weight.setLocation(100, 150);
        c.add(weight);

        inputweight = new JComboBox(weights);
        inputweight.setFont(new Font("Arial", Font.PLAIN, 15));
        inputweight.setSize(50, 20);
        inputweight.setLocation(200, 150);
        c.add(inputweight);

        length = new JLabel("Рост");
        length.setFont(new Font("Arial", Font.PLAIN, 20));
        length.setSize(100, 20);
        length.setLocation(100, 200);
        c.add(length);

        inputlength = new JComboBox(lengths);
        inputlength.setFont(new Font("Arial", Font.PLAIN, 15));
        inputlength.setSize(50, 20);
        inputlength.setLocation(200, 200);
        c.add(inputlength);

        age = new JLabel("Возраст");
        age.setFont(new Font("Arial", Font.PLAIN, 20));
        age.setSize(100, 20);
        age.setLocation(100, 250);
        c.add(age);

        inputage = new JComboBox(ages);
        inputage.setFont(new Font("Arial", Font.PLAIN, 15));
        inputage.setSize(50, 20);
        inputage.setLocation(200, 250);
        c.add(inputage);

//       min of progress bar

        tminp = new JTextField();
        tminp.setFont(new Font("Arial", Font.PLAIN, 30));
        tminp.setSize(40, 35);
        tminp.setLocation(110, 350);
        tminp.setEditable(false);
        c.add(tminp);


//       max of progress bar

        tmaxp = new JTextField();
        tmaxp.setFont(new Font("Arial", Font.PLAIN, 30));
        tmaxp.setSize(40, 35);
        tmaxp.setLocation(750, 350);
        tmaxp.setEditable(false);
        c.add(tmaxp);

          bar = new JProgressBar();
//        add.setFont(new Font("Arial", Font.PLAIN, 20));
          bar.setLocation(100,400);
          bar.setSize(700,20);
//          bar.setValue(1);
          c.add(bar);


        sub = new JButton("Вычислить");
        sub.setFont(new Font("Arial", Font.PLAIN, 30));
        sub.setSize(300, 50);
        sub.setLocation(100, 450);
        sub.addActionListener(this);
        c.add(sub);

        res = new JLabel("Информация");
        res.setFont(new Font("Arial", Font.PLAIN, 15));
        res.setSize(100, 25);
        res.setLocation(700, 120);
        c.add(res);

// output info with recomendations

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 150);
        tout.setLocation(500, 150);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);


        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)

    {
        String i,l,a,str_IMT;
        Double i1,l1;
        int a1;
        i = (String) inputweight.getSelectedItem();
        l = (String) inputlength.getSelectedItem();
        a = (String) inputage.getSelectedItem();
        i1 = Double.parseDouble(i);
        l1 = (Double.parseDouble(l))/100;
        a1 = Integer.parseInt(a);
        myResult = i1/(l1*l1);
        str_IMT =  String.format("%.2f",myResult); // making string format
//        bar.setValue((int) myResult);


//  Output to main
        if (myResult < num19) {
            timt.setForeground(Color.RED);
        }
        if ((myResult >= num19) && (myResult <=num24)) {
            timt.setForeground(Color.BLACK);
        }
        if ((myResult > num25) && (myResult <= num28)) {
            timt.setForeground(Color.BLUE);
        }
        if ((myResult > num28) && (myResult <= 30)) {
            timt.setForeground(Color.MAGENTA);
        }
        if ((myResult > 30)) {
            timt.setForeground(Color.RED);
        }

        timt.setText(str_IMT);

//  Output to info window
        if (a1 < num19) {
            tout.setText("Вы слишком молоды, чтобы беспокоится...");
            bar.setMinimum(num19);
            bar.setMaximum(30);
//            bar.setValue((int) myResult);
//            c.add(tout);

        }
        if ((a1 >= num19) && (a1 <= num24)){
            tout.setText(text_table + " от " +num19 +" до "+ num24);
            bar.setMinimum(num19);
            bar.setMaximum(num24);
            tminp.setText(String.valueOf(num19));
            tmaxp.setText(String.valueOf(num24));
            bar.setValue((int) myResult);
        }
        if ((a1 > num24) && (a1 <= num34)){
            tout.setText(text_table + " от "+num20 +" до  "+ num25);
            bar.setMinimum(num20);
            bar.setMaximum(num25);
            tminp.setText(String.valueOf(num20));
            tmaxp.setText(String.valueOf(num25));
            bar.setValue((int) myResult);
        }
        if ((a1 > num34) && (a1 <= num44)){
            tout.setText(text_table + " от " + num21 +" до  "+ num26);
            bar.setMinimum(num21);
            bar.setMaximum(num26);
            tminp.setText(String.valueOf(num21));
            tmaxp.setText(String.valueOf(num26));
            bar.setValue((int) myResult);

        }
        if ((a1 > num44) && (a1 <= num54)){
            tout.setText(text_table + " от " + num22 +" до "+ num27);
            bar.setMinimum(num22);
            bar.setMaximum(num27);
            tminp.setText(String.valueOf(num22));
            tmaxp.setText(String.valueOf(num27));
            bar.setValue((int) myResult);

        }
        if ((a1 > num54) && (a1 <= num64)){
            tout.setText(text_table + " от " + num23 +" до "+ num28);
            bar.setMinimum(num23);
            bar.setMaximum(num28);
            tminp.setText(String.valueOf(num23));
            tmaxp.setText(String.valueOf(num28));
            bar.setValue((int) myResult);
        }

        if (a1 > num64) {
            tout.setText(text_table + " от " + num24 +" до  "+ num29);
            bar.setMinimum(num24);
            bar.setMaximum(num29);
            tminp.setText(String.valueOf(num24));
            tmaxp.setText(String.valueOf(num29));
            bar.setValue((int) myResult);

        }
    }
}

// Driver Code
class IMT {

    public static void main(String[] args) throws Exception
    {
        MyFrame f = new MyFrame();
    }
}