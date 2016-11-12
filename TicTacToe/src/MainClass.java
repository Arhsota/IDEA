/**
 * Created by Andrey Sevastyanov on 29.10.2016.
 * main code taken from GeekBrain's notebook and improved:
 * @author Andrey Sevastyanov
 * @version 0.1 dated November 12, 2016
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainClass extends JFrame {
    Map jpMap;                               // Основное игровое поле
    Font btnFont = new Font("Times New Roman", Font.PLAIN, 16); // Шрифт для кнопок
    public static void main(String args[]) {
        new MainClass();
    }
    public MainClass() {                   // Конструктор окна
        setSize(505, 587);                // Настройка размера окна
        setResizable(false);              // Блокировка возможности изменения размер окна
        setLocation(700, 100);         // Положение
        setTitle("Tic-Tac-Toe");        // Заголовок
// Закрытие программы по закрытию окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpMap = new Map();            // Создаем игровое поле
        jpMap.startNewGame(3);    // Устанавливаем размер 3х3
// Добавляем панель с полем в центр формы
        add(jpMap, BorderLayout.CENTER);
// Основная нижняя панель
        JPanel jpBottom = new JPanel(new CardLayout());
        jpBottom.setPreferredSize(new Dimension(1, 60));
        add(jpBottom, BorderLayout.SOUTH);

// Панель с кнопками Старт/Выход
        JPanel jpStartExit = new JPanel(new GridLayout());
        JButton jbStart = new JButton("Начать новую игру");
        jbStart.setFont(btnFont);
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpSelectPlayers");
            }
        });
        jpStartExit.add(jbStart);
        JButton jbExit = new JButton("Выйти из игры");
        jbExit.setFont(btnFont);
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            });
        jpStartExit.add(jbExit);
        jpBottom.add(jpStartExit, "jpStartExit");
            // Создание панели выбора игроков
            JPanel jpSelectPlayers = new JPanel(new GridLayout());
            JButton jbHumanVsHuman = new JButton("Человек vs. Человек");
        jbHumanVsHuman.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpSelectMap");
                }
            });
            JButton jbHumanVsAI = new JButton("Человек vs. AI");
        jbHumanVsAI.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpSelectMap");
                }
            });
        jpSelectPlayers.add(jbHumanVsHuman);
        jpSelectPlayers.add(jbHumanVsAI);
        jpBottom.add(jpSelectPlayers, "jpSelectPlayers");
            // Создание панели выбора поля
            JPanel jpSelectMap = new JPanel(new GridLayout());
            JButton jbSM3x3l3 = new JButton("Поле: 3x3 Серия: 3");
            JButton jbSM5x5l4 = new JButton("Поле: 5x5 Серия: 4");
            JButton jbSM10x10l5 = new JButton("Поле: 10x10 Серия: 5");
        jpSelectMap.add(jbSM3x3l3);
        jbSM3x3l3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpStartExit");
                    createMap(3);
                }
            });
        jpSelectMap.add(jbSM5x5l4);
        jbSM5x5l4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpStartExit");
                    createMap(5);
                }
            });
        jpSelectMap.add(jbSM10x10l5);
        jbSM10x10l5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpStartExit");
                    createMap(10);
                }
            });
        jpBottom.add(jpSelectMap, "jpSelectMap");
((CardLayout) jpBottom.getLayout()).show(jpBottom, "jpStartExit");
            setVisible(true);
        }
    public void createMap(int size) { // Метод предназначен для старта новой игры, с заданным размером поля
        jpMap.startNewGame(size);
    }
}

