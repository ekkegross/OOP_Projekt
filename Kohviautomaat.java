import java.util.ArrayList;
import java.util.List;

public class Kohviautomaat implements Müügiautomaat{
    List<Kohv> pakutavadKohvid;

    public Kohviautomaat(List<Kohv> pakutavadKohvid) {
        this.pakutavadKohvid = new ArrayList<>();
    }

    @Override
    public void väljastaToodeteHinnad() {
        for (Kohv elem : pakutavadKohvid){
            System.out.println(elem.getKohviNimi() + " - " + elem.getKohviHind());
        }
    }
}
