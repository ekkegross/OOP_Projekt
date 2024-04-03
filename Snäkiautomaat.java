import java.util.ArrayList;
import java.util.List;

public class Snäkiautomaat implements Müügiautomaat{

    List<Toode> pakutavadSnäkid;

    public Snäkiautomaat() {
        this.pakutavadSnäkid = new ArrayList<>();
    }
    public void lisaToode(Toode toode){
        pakutavadSnäkid.add(toode);
    }

    @Override
    public void väljastaToodeteHinnad() {
        int number = 1;
        for (Toode elem : pakutavadSnäkid){
            System.out.println(number + ". " + elem.getNimi() + " - " + elem.getHind() + "€ - " + elem.getKogus());
            number++;
        }
    }
    @Override
    public void sooritaOst(int tooteNumber, double raha){
        if (tooteNumber < 1 || tooteNumber > pakutavadSnäkid.size()) {
            System.out.println("Sellist toodet ei ole olemas!");
        } else {
            Toode valitudToode = pakutavadSnäkid.get(tooteNumber - 1);
            if (valitudToode.getKogus() == 0) {
                System.out.println("Toodet ei ole piisavalt!");
            } else if (raha < valitudToode.getHind()) {
                System.out.println("Raha ei ole piisavalt!");
            } else {
                valitudToode.setKogus(valitudToode.getKogus() - 1);
                System.out.println("Toode ostetud!");
                System.out.println("Raha tagasi: " + (raha - valitudToode.getHind()));
            }
        }
    }
}
