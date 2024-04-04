import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kohviautomaat implements Müügiautomaat{
    List<Kohv> pakutavadKohvid;

    public Kohviautomaat() {
        this.pakutavadKohvid = new ArrayList<>();
    }
    public void lisaToode(Kohv kohv){
        pakutavadKohvid.add(kohv);
    }

    @Override
    public void väljastaToodeteHinnad() {
        for (Kohv elem : pakutavadKohvid){
            System.out.println(elem.getKohviNimi() + " - " + elem.getKohviHind());
        }
    }

    @Override
    public void sooritaOst(int tooteNumber, double raha) {
        if(masinKatki()) {
            System.out.println("Masin on katki, proovige hiljem uuesti!");
            System.out.println("Raha tagasi: " + raha);
            return;
        }
        if (tooteNumber < 1 || tooteNumber > pakutavadKohvid.size()) {
            System.out.println("Sellist toodet ei ole olemas!");
        } else {
            Kohv valitudKohv = pakutavadKohvid.get(tooteNumber - 1);
            if (raha < valitudKohv.getKohviHind()) {
                System.out.println("Raha ei ole piisavalt!");
            } else {
                System.out.println("Kohv valmistatud!");
                System.out.println("Raha tagasi: " + (raha - valitudKohv.getKohviHind()));
            }
        }
    }

    @Override
    public boolean masinKatki() {
        Random random = new Random();
        int rand_int = random.nextInt(5);
        return rand_int == 1;
    }
}
