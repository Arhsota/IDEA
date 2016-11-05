/**
 * Created by master on 05.11.2016.
 */
public class Team extends Animal implements Swimable, Jumpable {

    public Team(String name,String animalType,int swim_metres,float jump_metres,float maxRunDist) {
        this.name = name;
        this.animalType = animalType;
        this.swim_metres = swim_metres;
        this.jump_metres = jump_metres;
        this.onDistance = true;
        this.maxRunDist = maxRunDist;

        }

    public String getAnimalType() { return animalType; }
    public int getSwim() {return swim_metres;}
    public float getJump() {return jump_metres;}


    @Override
    public void swim(float dist) {
        if(dist < swim_metres){
            System.out.println(name+" swim ok");
        }else{
            getOutOfDistance("swim");
        }
    }

    @Override
    public void jump(float height) {
        if(height < jump_metres){
            System.out.println(name+" jump ok");
        }else{
            getOutOfDistance("jump");
        }
    }
}
