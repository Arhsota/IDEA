import java.io.IOException;

/**
 * Created by Andrey Sevastyanov on 15.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework J2, Lesson 4
 */
public class MainClass {
    public static void main ( String [] args ) {
        try {
            Form1 w = new Form1 ();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
