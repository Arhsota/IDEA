/**
 * Created by DNS PC on 03.11.2016.
 */
public class OCross extends Obstacle {
    public OCross(float size) {
        this.size = size;
    }
    @Override
    public void doIt(Animal a) {
        a.cross(size);
    }
}
