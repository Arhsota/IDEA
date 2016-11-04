/**
 * Created by DNS PC on 03.11.2016.
 */
public class Cat extends Animal implements Jumpable{

    public Cat(String name) {
        this.name = name;
        this.animalType = "Кошка";
        this.onDistance = true;
        this.maxRunDist = 500;
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
