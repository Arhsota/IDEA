import java.util.TreeSet;
/**
 * Created by Andrey Sevastyanov on 12.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework
 */
public class MainClass {
     public static void main (String[] args){
         // filling data
         TreeSet < String > al1 = new TreeSet< String >();
         al1.add("папа");al1.add("яма");al1.add("мама");
         al1.add("папа");al1.add("яма");al1.add("мама");
         al1.add("рама");al1.add("вама");al1.add("мама");
         al1.add("кама");al1.add("сама");al1.add("мама");
         al1.add("рама");al1.add("сама");al1.add("мама");
         al1.add("кама");al1.add("тама");al1.add("мама");
         al1.add("дама");al1.add("тама");al1.add("мама");

         System.out.println("Всего  неповторяющихся слов: " + al1.size());
         System.out.println(al1);

         PhoneRec.Rec();
         System.out.println();
         PhoneRec.getEmail();



     }
 }
