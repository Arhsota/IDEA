/**
 * Created by DNS PC on 03.11.2016.
 * add on by Andrey Sevastyanov on 6.11.2016
 * @author Andrey Sevastyanov
 *
 *
 *
 */
public class MainClass {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Cat("Barsik");
        animals[1] = new Dog("Bobic");
        animals[2] = new Duck("Donald");
        animals[3] = new Horse("Mary");

        Team[] teamarr = new Team[4];
        teamarr[0] = new Team("Ком1","Команда",20,1000f);
        teamarr[1] = new Team("Ком2","Команда",30,1500f);
        teamarr[2] = new Team("Ком3","Команда",40,2000f);
        teamarr[3] = new Team("Ком4","Команда",25,1000f);

        Course[] crs = new Course [3];
        crs[0] = new CWater(30);
        crs[1] = new CJump(600);
        crs[2] = new CCross(600f);

        Obstacle[] obs = new Obstacle[3];
        obs[0] = new OWater(30);
        obs[1] = new OCross(500);
        obs[2] = new OJump(0.8f);


        for(Animal a : animals){
            for(Obstacle o : obs){
                o.doIt(a);
                if(!a.isOnDistance()) break;
            }
        }

        for (int i = 0; i < animals.length; i++) {
            if(animals[i].isOnDistance()){
                System.out.println(animals[i].getName()+" WIN");
            }
        }

        //Инфо о членах команды
        System.out.println("Инфа о членах команды: ");
         for (int j = 0; j < teamarr.length; j++) {
             System.out.println(teamarr[j].getName()+" "+teamarr[j].getAnimalType()+" возраст "+teamarr[j].getAge());

         }

        for(Team b : teamarr){
            for(Course c : crs){
                c.doThat(b);
                if(!b.isOnDistance()) break;
            }
        }


    }
}
