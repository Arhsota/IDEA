/**
 * Created by DNS PC on 03.11.2016.
 */
public class Animal {
    protected String name;
    protected String animalType;
    protected boolean onDistance;
    protected float maxRunDist;
    protected int age;

    public boolean isOnDistance() {
        return onDistance;
    }

    public void cross(float dist){
        if(dist < maxRunDist){
            System.out.println(animalType+" cross ok");
        }else{
            getOutOfDistance("cross");
        }
    }

    public void getOutOfDistance(String reason){
        onDistance= false;
        System.out.println("name "+name+" reason"+reason+" fail");
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Animal(){

    }



    public void printInfo(){
        System.out.println("name "+name);
    }



}
