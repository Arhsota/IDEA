import java.util.HashMap;
/**
 * Created by Andrey Sevastyanov on 12.11.2016.
 *
 * @author Andrey Sevastyanov
 * @version 0.1
 *          Homework Java 2, Lesson 3, point 2
 */
public class PhoneRec {
    // Filling data
    static HashMap<Integer, PhoneBook> record = new HashMap<Integer, PhoneBook>();
    static PhoneBook a = new PhoneBook("Иванов", "79021234567879", "ivanov@mail.ru");
    static PhoneBook b = new PhoneBook("Петров", "79031234567879", "petrov@mail.ru");
    static PhoneBook c = new PhoneBook("Сидоров", "79041234567879", "sidorov@mail.ru");
    static PhoneBook d = new PhoneBook("Петров", "79051234567879", "petr@mail.ru");

    // Getting and printing name and phone number
    public static void Rec() {
        record.put(1, a);
        record.put(2, b);
        record.put(3, c);
        record.put(4, d);
        for (int i = 1; i <=4; i++){System.out.println(record.get(i).Name + " " + record.get(i).PhoneNumber);}
    }
     // Getting and printing name and Email
    // not using FOR
    public static void getEmail(){
        record.put(1, a);
        record.put(2, b);
        record.put(3, c);
        record.put(4, d);
        System.out.println(record.get(1).Name + " " + record.get(1).Email);
        System.out.println(record.get(2).Name + " " + record.get(2).Email);
        System.out.println(record.get(3).Name + " " + record.get(3).Email);
        System.out.println(record.get(4).Name + " " + record.get(4).Email);
    }
}
