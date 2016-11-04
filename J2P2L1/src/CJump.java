/**
 * Created by master on 04.11.2016.
 */
public class CJump extends Course {
    public CJump(float size) {
        this.size = size;
    }

    @Override
    public void doThat(Team a) {
        if(a instanceof Jumpable){
            ((Jumpable)a).jump(size);
        }else{
            a.getOutOfDistance("jump");
        }
    }
}

