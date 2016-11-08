/**
 * Created by Andrey Sevastyanov on 08.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework Java 2, Lesson 2
 */
public class MainClass {


    public static void main(String[] args) {
         String myStr = "1 3 1 2 2 3 2 2 5 6 7 1 3 3 1 0";
         int a;
         String[]  myArr = myStr.split(" "); // убираем пробелы

         int [] myArr1 = new int [16];   // одномерный массив из символов из строки
         for (int i = 0; i < myArr1.length; i++) {
            myArr1[i]= Integer.parseInt (myArr[i]); // преобразуем в int из string
          //  System.out.println(myArr[i]);
         }
          int[][] myArr2 = new int[8][8]; // двумерный массив из одномерного массива

        for (int i = 0; i < 8; i++) {
              myArr2[i][0] = myArr1[i];
            System.out.print(myArr2[i][0]);
        }
        for (int i = 0; i < 8; i++) {
            myArr2[0][i] = myArr1[i+8];
            System.out.print(myArr2[0][i]);
        }

    }



 }
