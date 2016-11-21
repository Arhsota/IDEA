import java.util.Arrays;

/**
 * Created by Andrey Sevastyanov on 18.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework
 */
public class Thread1 extends Thread {

    private float[] a1;
    private int h;

    public Thread1(int h, float[] a1){
        this.a1=a1;
        this.h=h;
    }
    public void run() {

       for (int i = 0; i < h; i++) a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5)
               * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

    }
 }

