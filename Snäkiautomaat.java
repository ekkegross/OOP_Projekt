import java.util.ArrayList;
import java.util.List;

public class Snäkiautomaat implements Müügiautomaat{
    List<Toode> pakutavadSnäkid;
    private boolean kasMasinOnRikkis; //true-masin on rikkis, false-masin on terve
    private int mituKordaKasutatud;
    private int mituKordaRaputatud;

    public Snäkiautomaat() {
        this.mituKordaKasutatud = 0;
        this.mituKordaRaputatud = 0;
        this.pakutavadSnäkid = new ArrayList<>();
        this.kasMasinOnRikkis = false;
    }
    public void lisaToode(Toode toode){
        pakutavadSnäkid.add(toode);
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

    public int getMituKordaRaputatud() {
        return mituKordaRaputatud;
    }

    public void setMituKordaRaputatud(int mituKordaRaputatud) {
        this.mituKordaRaputatud = mituKordaRaputatud;
    }

    private void masinaOlek(){  //Määrab ära kas masin on rikkis või mitte
        if(getMituKordaRaputatud()>5) {
            setKasMasinOnRikkis(true);
        } else if (getMituKordaKasutatud()>3&&Math.random()>0.9) setKasMasinOnRikkis(true);
    }

    public boolean raputa(){
        if(Math.random()<0.3){
            setMituKordaRaputatud(getMituKordaRaputatud()+1);
            masinaOlek();
            return true;
        }
        setMituKordaRaputatud(getMituKordaRaputatud()+1);
        masinaOlek();
        return false;
    }
    public String misTooteSaid(){
        Toode milline = pakutavadSnäkid.get((int) Math.round(pakutavadSnäkid.size()*Math.random()));
        milline.setKogus(milline.getKogus()-1);
        return milline.getNimi();
    }

    @Override
    public void väljastaToodeteHinnad() {
        if(getKasMasinOnRikkis()) {
            System.out.println("Vabandame, masin on rikkis!");
            return;
        }
        int number = 1;
        for (Toode elem : pakutavadSnäkid){
            System.out.println(number + ". " + elem.getNimi() + " - " + elem.getHind() + "€ - " + elem.getKogus());
            number++;
        }
    }
    @Override
    public double sooritaOst(int tooteNumber, double raha){
        if(getKasMasinOnRikkis()) {
            System.out.println("Vabandame, masin on rikkis!");
            return raha;
        }

        if (tooteNumber < 1 || tooteNumber > pakutavadSnäkid.size()) {
            System.out.println("Sellist toodet ei ole olemas!");
            return raha;
        } else {
            Toode valitudToode = pakutavadSnäkid.get(tooteNumber - 1);
            if (valitudToode.getKogus() == 0) {
                System.out.println("Toode on otsas! Vabandame");
                return raha;
            } else if (raha < valitudToode.getHind()) {
                System.out.println("Raha ei ole piisavalt!");
                return raha;
            } else {
                valitudToode.setKogus(valitudToode.getKogus() - 1);
                System.out.println("Toode ostetud!");
                System.out.println("Raha tagasi: " + (raha - valitudToode.getHind()));
                setMituKordaKasutatud(getMituKordaKasutatud()+1);
                masinaOlek();
                return raha-valitudToode.getHind();
            }
        }
    }

    @Override
    public boolean kontroll(double raha) {
        for(Toode elem:pakutavadSnäkid){
            if(raha>elem.getHind()) return false;
        }
        return true;
    }
}
