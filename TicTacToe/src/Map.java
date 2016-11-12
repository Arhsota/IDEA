import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Random;

/**
 * Created by Andrey Sevastyanov on 12.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework
 */
    class Map extends JPanel {
        private int linesCount;
        private int dotsToWin;  // expanding size of screen 5 or 10, depends upon lineCount
        private final int PANEL_SIZE = 500;
        private int CELL_SIZE;
        private boolean gameOver;
        private String gameOverMsg;
        Random rand = new Random();
        private int[][] field;
        private final int PLAYER1_DOT = 1;
        private final int PLAYER2_DOT = 2;
        // конструктор поля
        public Map() {
            startNewGame(3);
            setBackground(Color.white);
            dotsToWin = linesCount;
// отлавливаем клики мыши по карте
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    int cmx, cmy;
// рассчитываем координаты из пикселей в ячейки по Х и У
                    cmx = e.getX() / CELL_SIZE;
                    cmy = e.getY() / CELL_SIZE;
                    if (!gameOver) {                                            // если игра все еще идет
                        if (setDot(cmx, cmy, PLAYER1_DOT)) { // пробуем поставить фишку
                            checkFieldFull();                                  // проверяем занятость
                            checkWin(PLAYER1_DOT);               // проверяем победу первого игрока
                            repaint();                                             // перерисовываем поле
                            aiTurn();                                              // запускаем ход компьютера
                        }
                    }
                }
            });
        }
        // ход компьютера
        public void aiTurn() {
            if (gameOver) return;
            int x, y;
            do {
                x = rand.nextInt(linesCount);
                y = rand.nextInt(linesCount);
            } while (!setDot(x, y, PLAYER2_DOT));
            checkFieldFull();
            checkWin(PLAYER2_DOT);
            repaint();
        }
        public void startNewGame(int linesCount) {               // метод старта новой игры
            this.linesCount = linesCount;
            this.dotsToWin = linesCount;
            CELL_SIZE = PANEL_SIZE / linesCount;
            gameOver = false;
            field = new int[linesCount][linesCount];
            repaint();
        }
        public void checkFieldFull() {                     // проверка поля на занятость
            boolean b = true;
            for (int i = 0; i < linesCount; i++) {
                for (int j = 0; j < linesCount; j++) {
                    if (field[i][j] == 0) b = false;        // если нашли хоть одно свободное поле – b = false
                }
            }
            if (b) {                                               // если не нашли свободного поля
                gameOver = true;                        // завершаем игры
                gameOverMsg = "DRAW";         // пишем сообщение
            }
        }

        public boolean checkWin(int ox) {      // проверка победы одного из игроков
            for (int i = 0; i < linesCount; i++) {  // во всех ячейках запускаем проверяем все возможные линии
                for (int j = 0; j < linesCount; j++) {
                    if (checkLine(i, j, 1, 0, dotsToWin, ox) || checkLine(i, j, 0, 1, dotsToWin, ox) || checkLine(i, j, 1, 1, dotsToWin, ox) || checkLine(i, j, 1, -1, dotsToWin, ox)) {                                 // если хоть одна нашлась
                        gameOver = true;                                                                        // завершаем игры
                        if (PLAYER1_DOT == ox) gameOverMsg = "PLAYER 1 WIN"; // пишем сообщение
                        if (PLAYER2_DOT == ox) gameOverMsg = "PLAYER 2 WIN"; // пишем сообщение
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean checkLine(int cx, int cy, int vx, int vy, int l, int ox) {                  // проверка линии
            if (cx + l * vx > linesCount || cy + l * vy > linesCount || cy + l * vy < -1) return false;
            for (int i = 0; i < l; i++) {
                if (field[cx + i * vx][cy + i * vy] != ox) return false;
            }
            return true;
        }
        public boolean setDot(int x, int y, int dot) { // Метод для установки фишки на поле
            if (field[x][y] == 0) {                             // Фишка ставится только если поле свободно
                field[x][y] = dot;
                return true;
            }
            return false;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black);                                                                  // устанавливаем цвет кисти
            for (int i = 0; i <= linesCount; i++) {                                                 // рисуем сетку
                g.drawLine(0, i * CELL_SIZE, PANEL_SIZE, i * CELL_SIZE); // горизонтальные линии
                g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, PANEL_SIZE); // вертикальные линии
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
//g2d.drawLine(0, 0, 10, 0);
            for (int y = 0; y < linesCount; y++) { // бежим двойным циклом по всему полю
                for (int x = 0; x < linesCount; x++) {
                    if (field[x][y] > 0) {                    // если на поле стоит какая-то фишка
// для первого игрока ставим красный цвет
                        // if (field[i][j] == PLAYER1_DOT) g.setColor(Color.red);
                        if (field[x][y] == PLAYER1_DOT) {
                            g.setColor(Color.red);
                            //                     g.drawLine(0,0,100,100);
                            g2.draw(new Line2D.Float(x * CELL_SIZE + CELL_SIZE / 4, y * CELL_SIZE + CELL_SIZE / 4, (x + 1) * CELL_SIZE - CELL_SIZE / 4, (y + 1) * CELL_SIZE - CELL_SIZE / 4));
                            g2.draw(new Line2D.Float(x * CELL_SIZE + CELL_SIZE / 4, (y + 1) * CELL_SIZE - CELL_SIZE / 4, (x + 1) * CELL_SIZE - CELL_SIZE / 4, y * CELL_SIZE + CELL_SIZE / 4));
                        }
// для второго - синий
                        if (field[x][y] == PLAYER2_DOT) {
                            g.setColor(Color.blue);
// рисуем овал
                            //g.fillOval(x * CELL_SIZE + 2, y * CELL_SIZE + 2, CELL_SIZE - 4, CELL_SIZE - 4);
                            //  g.drawLine(0,0,100,100);
                            g2.draw(new Ellipse2D.Float(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, CELL_SIZE/2, CELL_SIZE/2));
                        }
                    }
                }
            }
// если игра по какой-то причине закончилась, рисуем сообщение о завершении игры
            if (gameOver) {
                g.setFont(new Font("Arial", Font.BOLD, 64));
                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 220, 500, 70);
                g.setColor(Color.black);
                g.drawString(gameOverMsg, 12, 277);
                g.setColor(Color.yellow);
                g.drawString(gameOverMsg, 10, 275);

            }
        }
    }
