import java.util.ArrayList;
import java.util.List;

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
}
