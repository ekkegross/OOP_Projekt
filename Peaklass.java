import java.util.ArrayList;
import java.util.List;

public class Peaklass {
    public static void main(String[] args) {
        Toode snickers = new Toode("Snickers", 1.99, 10);
        Toode chips = new Toode("Potato Chips", 1.49, 20);
        Toode coke = new Toode("Coca-Cola", 1.29, 15);

        List<Toode> tooted = new ArrayList<>();
        tooted.add(snickers);
        tooted.add(chips);
        tooted.add(coke);
        Snäkiautomaat snäkiautomaat = new Snäkiautomaat(tooted);
        snäkiautomaat.väljastaToodeteHinnad();
    }

}
