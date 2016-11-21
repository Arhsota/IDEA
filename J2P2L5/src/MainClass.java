import java.util.Arrays;

/**
 * Created by Andrey Sevastyanov on 18.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework Java 2, Lesson 5, Threads
 */
public class MainClass {
    static final int size = 10000000;
    static final int h = size/2;
    static float[] arr = new float[size];
    static long result;
    static float[] a1 = new float[h];
    static float[] a2 = new float[h];
    public static void main(String[] args) {
    arrFull(); // without threads
    arrDev();  // with threads
    }

    private static void arrDev() {
        Arrays.fill(arr,1f);                            // filling array with 1.0
        long a = System.currentTimeMillis();            // mark start time
        System.arraycopy(arr,0,a1,0,h);                 // dividing array arr to two arrays: ar1 and ar2, part 1
        System.arraycopy(arr,h,a2,0,h);                 // dividing array arr to two arrays: ar1 and ar2, part 2
        Thread1 t1 = new Thread1(h,a1);                     // working in the first thread
        t1.start();
        Thread2 t2 = new Thread2(h,a2);                     // working in the second thread
        t2.start();
        System.arraycopy(a1,0,arr,0,h);                 // concating the results in arrays ar1 and ar2 to arr
        System.arraycopy(a2,0,arr,h,h);
        long b = System.currentTimeMillis();            // mark end time
        result = b - a;
        System.out.println("Время работы с разделением по потокам: "+ result);
    }

    private static void arrFull() {
        Arrays.fill(arr,1f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++){arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));}
        long b = System.currentTimeMillis();
        result = b - a;
        System.out.println("Время работы без разделения по потокам: " + result);
    }
}
