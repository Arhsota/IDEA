/**
 * Created by master on 05.11.2016.
 */
public class Team extends Animal implements Swimable, Jumpable {

    public Team(String name,String animalType,int age,float maxRunDist) {
        this.name = name;
        this.animalType = animalType;
        this.age = age;
        this.onDistance = true;
        this.maxRunDist = maxRunDist;

        }

    public String getAnimalType() { return animalType; }
    public int getAge() {return age;}


    @Override
    public void swim(float dist) {
        if(dist < 500){
            System.out.println(name+" swim ok");
        }else{
            getOutOfDistance("swim");
        }
    }

    @Override
    public void jump(float height) {
        if(height < 1.5f){
            System.out.println(name+" jump ok");
        }else{
            getOutOfDistance("jump");
        }
    }
}
