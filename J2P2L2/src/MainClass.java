/**
 * Created by Andrey Sevastyanov on 08.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework Java 2, Lesson 2
 */
public class MainClass {
 private    String myStr = "1 3 1 2 2 3 2 2 5 6 7 1 3 3 1 0"; // исходная строка
 private    int [] myArr1 = new int [16];   // одномерный массив из символов из строки
 private    int[][] myArr2 = new int[8][8]; // двумерный массив из одномерного массива
 private    int result;

    public static void main(String[] args) {
       new  MainClass().go();
    }

    private void go() {
        System.out.println("Исходная строка: " + myStr);
        try {
            System.out.println("Сумма элементов поделенная на 2: " + workArr() / 2);
        } catch (ArrayIndexOutOfBoundsException e){System.out.println("Выход за пределы массива");}
          catch (ArrayStoreException e1) {System.out.println("Неверный тип элемента массива");}
    }

    // обработка массива. Перевод из строки в int, преобразование в двумерный массив
    // суммирование элементов и деление на 2
    private int workArr(){
        String[]  myArr = myStr.split(" "); // убираем пробелы
        for (int i = 0; i < myArr1.length; i++) {
             myArr1[i]= Integer.parseInt (myArr[i]); // преобразуем в int из string
            }

        for (int i = 0; i < 8; i++) {
            myArr2[i][0] = myArr1[i];
            result += myArr2[i][0];
        }
        for (int i = 0; i < myArr2.length; i++) {
            myArr2[0][i] = myArr1[i+8];
            result += myArr2[0][i];
        }
        return result;
    }
 }
