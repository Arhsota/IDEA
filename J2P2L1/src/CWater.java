/**
 * Created by master on 04.11.2016.
 */
public  class CWater extends Course {
    public CWater(float size) {
        this.size = size;
    }

    @Override
    public void doThat(Team b) {
        if (b instanceof Swimable) {
            ((Swimable) b).swim(size);
        } else {
            b.getOutOfDistance("swim");
        }
    }
}