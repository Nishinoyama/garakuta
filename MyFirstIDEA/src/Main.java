import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        RacingDog ht1 = new RacingDog("A",stdIn.nextDouble(), stdIn.nextInt());
        RacingDog ht2 = new RacingDog("B",stdIn.nextDouble(), stdIn.nextInt());
        RacingDog ht3 = new RacingDog("C",stdIn.nextDouble(), stdIn.nextInt());
        stdIn.close();

        System.out.println("Start threads.");
        ht1.start();
        ht2.start();
        ht3.start();
        System.out.println("Done.");

    }
}