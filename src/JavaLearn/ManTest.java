package JavaLearn;

/**
 * Created by oubin on 17-3-11.
 */
public class ManTest {

    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Woman();
        Helper helper = new Helper();
        helper.sp(man);
        helper.sp(women);
    }

}

class Helper{

    public void sp(Human man){
        System.out.println("I am a Human");
    }

    public void sp(Woman man){
        System.out.println("I am a woman");
    }
    public void sp(Man man){
        System.out.println("I am a man");
    }
}


class Man extends Human{

}

class Woman extends Human{

}

class Human{

}
