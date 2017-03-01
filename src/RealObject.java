/**
 * Created by oubin on 17-2-23.
 */
public class RealObject implements Interface{

    @Override
    public String getName() {
        System.out.println("my name is oubin");
        return "oubin";
    }

    @Override
    public int getId(int id) {
        System.out.println("my id is "+ id);
        return id + 1;
    }

    private String testPrivate(){
        System.out.println("testPrivate");
        return "test private";
    }
}
