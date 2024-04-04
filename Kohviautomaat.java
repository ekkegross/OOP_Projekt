import java.util.ArrayList;
import java.util.List;

public class Kohviautomaat implements Müügiautomaat{
    private List<Kohv> pakutavadKohvid;
    private double piimaKogusLiitrites;
    private double kohviSeguKogusLiitrites;
    private boolean kasMasinOnRikkis; //true-masin on rikkis, false-masin on terve
    private int mituKordaKasutatud;

    public Kohviautomaat(double piimaKogusLiitrites, double kohviSeguKogusLiitrites) {
        this.piimaKogusLiitrites = piimaKogusLiitrites;
        this.kohviSeguKogusLiitrites = kohviSeguKogusLiitrites;
        this.pakutavadKohvid = new ArrayList<>();
        this.kasMasinOnRikkis = false;
        this.mituKordaKasutatud = 0;
    }
    public void lisaKohv(Kohv kohv){
        pakutavadKohvid.add(kohv);
    }

    public double getPiimaKogusLiitrites() {
        return piimaKogusLiitrites;
    }

    public void setPiimaKogusLiitrites(double piimaKogusLiitrites) {
        this.piimaKogusLiitrites = piimaKogusLiitrites;
    }

    public double getKohviSeguKogusLiitrites() {
        return kohviSeguKogusLiitrites;
    }

    public void setKohviSeguKogusLiitrites(double kohviSeguKogusLiitrites) {
        this.kohviSeguKogusLiitrites = kohviSeguKogusLiitrites;
    }

    public boolean getKasMasinOnRikkis() {
        return kasMasinOnRikkis;
    }


    public void setKasMasinOnRikkis(boolean kasMasinOnRikkis) {
        this.kasMasinOnRikkis = kasMasinOnRikkis;
    }

    public int getMituKordaKasutatud() {
        return mituKordaKasutatud;
    }

    public void setMituKordaKasutatud(int mituKordaKasutatud) {
        this.mituKordaKasutatud = mituKordaKasutatud;
    }

    private void masinaOlek(){  //Määrab ära, kas masin on rikkis või mitte tõenäosuse järgi.
        if(getMituKordaKasutatud()>3&&Math.random()>0.9) setKasMasinOnRikkis(true);
    }

    @Override
    public void väljastaToodeteHinnad() {
        if (getKasMasinOnRikkis()){
            System.out.println("Masin on rikkis! Vabandame");
            return;
        }
        for (Kohv elem : pakutavadKohvid){
            if(elem.getPiimaKogusL()>getPiimaKogusLiitrites()) System.out.println(elem.getKohviNimi() + " - " + elem.getKohviHind() + " Vabandame, aga hetkel pole piisavalt piima selle kohvi valmistamiseks.");
            else if (elem.getKohviSeguKogusL()>getKohviSeguKogusLiitrites()) System.out.println(elem.getKohviNimi() + " - " + elem.getKohviHind() + " Vabandame, aga hetkel pole piisavalt segu kohvi valmistamiseks.");
            else System.out.println(elem.getKohviNimi() + " - " + elem.getKohviHind());
        }
    }

    @Override
    public double sooritaOst(int tooteNumber, double raha) {
        if (getKasMasinOnRikkis()){
            System.out.println("Masin on rikkis! Vabandame");
            return raha;
        }

        if (tooteNumber < 1 || tooteNumber > pakutavadKohvid.size()) {
            System.out.println("Sellist toodet ei ole olemas!");
            return raha;
        } else {
            Kohv valitudKohv = pakutavadKohvid.get(tooteNumber - 1);
            if (raha < valitudKohv.getKohviHind()) {
                System.out.println("Raha ei ole piisavalt!");
                return raha;
            } else if (valitudKohv.getKohviSeguKogusL()>getKohviSeguKogusLiitrites()) {
                System.out.println("Pole piisavalt segu kohvi valmistamiseks. Valige mõni muu kohv.");
                return raha;
            } else if (valitudKohv.getPiimaKogusL()>getPiimaKogusLiitrites()) {
                System.out.println("Pole piisavalt piima kohvi valmistamiseks. Valige mõni muu kohv.");
                return raha;
            } else {
                setKohviSeguKogusLiitrites(getKohviSeguKogusLiitrites()-valitudKohv.getKohviSeguKogusL());
                setPiimaKogusLiitrites(getPiimaKogusLiitrites()-valitudKohv.getPiimaKogusL());
                System.out.println("Kohv valmistatud!");
                System.out.println("Raha tagasi: " + (raha - valitudKohv.getKohviHind()));
                setMituKordaKasutatud(getMituKordaKasutatud()+1);
                masinaOlek();
                return raha-valitudKohv.getKohviHind();
            }
        }
    }

    @Override
    public boolean kontroll(double raha) {   //Kas on piisavalt raha, et midagi osta. Kui ei ole tagastab true.
        for(Kohv elem:pakutavadKohvid){
            if(raha>elem.getKohviHind()) return false;
        }
        return true;
    }
}
