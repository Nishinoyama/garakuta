import java.util.Random;

public class RacingDog {

    private String name;
    private double step;
    private int interval;

    private double position;
    private int check;
    private int goal;

    private int zekkocho;

    public RacingDog( String name, double step, int interval ){
        this.name = name;
        this.step = step;
        this.interval = interval;
        goal = 600;
    }

    public void start(){
        while(true){
            try {
                Thread.sleep(interval); //処理を(約)1000ms止める．例外の可能性あり
                run();
            } catch (InterruptedException e) { /*略*/ }
            System.out.println(name + ":" + i);
        }
    }

    public void run(){
        double step = this.step;
        if( zekkocho > 0 ) {
            step *= 2;
            zekkocho--;
            if( zekkocho == 0 ) {
                System.out.println( name + "");
            }
        }

        position += step;

        Random rnd = new Random()
        if( zekkocho == 0 && rnd.nextInt(100)==1 ){
            zekkocho += 10;
        }

    }

}
