import java.util.ArrayList;
import java.util.List;

public class Snäkiautomaat implements Müügiautomaat{

    List<Toode> pakutavadSnäkid;

    public Snäkiautomaat(List<Toode> pakutavadSnäkid) {
        this.pakutavadSnäkid = new ArrayList<>();
    }

    @Override
    public void väljastaToodeteHinnad() {
        for (Toode elem : pakutavadSnäkid){
            System.out.println(elem.getNimi() + " - " + elem.getHind());
        }
    }
}
