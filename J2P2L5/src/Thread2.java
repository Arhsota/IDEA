/**
 * Created by Andrey Sevastyanov on 18.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework
 */
public class Thread2 extends Thread {
    private float[] a2;
    private int h;

    public Thread2(int h, float[] a2){
        this.a2=a2;
        this.h=h;
    }
        public void run() {

        for (int i = 0; i < h; i++) a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5)
                * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
