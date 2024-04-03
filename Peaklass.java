import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sisestage palju teil raha on: ");
        double raha = scanner.nextDouble();

        Toode snickers = new Toode("Snickers", 1.99, 10);
        Toode chips = new Toode("Potato Chips", 1.49, 20);
        Toode coca = new Toode("Coca-Cola", 1.29, 15);

        Snäkiautomaat snäkiautomaat = new Snäkiautomaat();
        snäkiautomaat.lisaToode(snickers);
        snäkiautomaat.lisaToode(chips);
        snäkiautomaat.lisaToode(coca);

        System.out.println("Olemasolevad tooted: ");
        snäkiautomaat.väljastaToodeteHinnad();

        System.out.println("Sisestage toote number, mida soovite osta: ");
        int tooteNumber = scanner.nextInt();
        snäkiautomaat.sooritaOst(tooteNumber, raha);
        scanner.close();

    }

}
