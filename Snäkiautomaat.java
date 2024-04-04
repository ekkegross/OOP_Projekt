import java.util.ArrayList;
import java.util.List;

/**
 * Snäkiautomaadi klass, mis implementeerib müügiautomaadi liidest.
 */

public class Snäkiautomaat implements Müügiautomaat {
    List<Toode> pakutavadSnäkid;
    private boolean kasMasinOnRikkis; //true-masin on rikkis, false-masin on terve
    private int mituKordaKasutatud;
    private int mituKordaRaputatud;

    // Konstruktor
    public Snäkiautomaat() {
        this.mituKordaKasutatud = 0;
        this.mituKordaRaputatud = 0;
        this.pakutavadSnäkid = new ArrayList<>();
        this.kasMasinOnRikkis = false;
    }

    // Lisame toote masinasse
    public void lisaToode(Toode toode) {
        pakutavadSnäkid.add(toode);
    }

    // Get ja set meetodid
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

    private void masinaOlek() {  //Määrab ära kas masin on rikkis või mitte
        if (getMituKordaRaputatud() > 5) {  //Kui masinat on üle 5 korra raputatud, siis määratakse, et masin on rikkis
            setKasMasinOnRikkis(true);
        } else if (getMituKordaKasutatud() > 3 && Math.random() > 0.9) setKasMasinOnRikkis(true); //Kui masinat on üle 3 korra kastatud, siis kui Math.Random on suurem kui 0.9(võiks olla 10% tõenäosus) määratakse, et masin on rikkis.
    }

    // Raputab masinat ja määrab ära, kas masinast tuleb midagi välja või mitte
    public boolean raputa() {
        if (Math.random() < 0.3) {
            setMituKordaRaputatud(getMituKordaRaputatud() + 1);
            masinaOlek();
            return true;
        }
        setMituKordaRaputatud(getMituKordaRaputatud() + 1);
        masinaOlek();
        return false;
    }

    // Määrab ära, milline toode saadi pärast raputamist
    public String misTooteSaid() {
        Toode milline = pakutavadSnäkid.get((int) Math.round(pakutavadSnäkid.size() * Math.random()));
        milline.setKogus(milline.getKogus() - 1);
        return milline.getNimi();
    }

    // Väljastab toodete hinnad
    @Override
    public void väljastaToodeteHinnad() {
        if (getKasMasinOnRikkis()) { // Kontrollib, kas masin on rikkis
            System.out.println("Vabandame, masin on rikkis!");
            return;
        }
        int number = 1;
        // Väljastab toodete nimed ja hinnad
        for (Toode elem : pakutavadSnäkid) {
            System.out.println(number + ". " + elem.getNimi() + " - " + elem.getHind() + "€ - " + elem.getKogus());
            number++;
        }
    }

    // Sooritab ostu
    @Override
    public double sooritaOst(int tooteNumber, double raha) {
        if (getKasMasinOnRikkis()) { // Kontrollib, kas masin on rikkis
            System.out.println("Vabandame, masin on rikkis!");
            return raha;
        }

        if (tooteNumber < 1 || tooteNumber > pakutavadSnäkid.size()) { // Kontrollib, kas toode on olemas
            System.out.println("Sellist toodet ei ole olemas!");
            return raha;
        } else {
            Toode valitudToode = pakutavadSnäkid.get(tooteNumber - 1);
            if (valitudToode.getKogus() == 0) { // Kontrollib, kas toode on otsas
                System.out.println("Toode on otsas! Vabandame");
                return raha;
            } else if (raha < valitudToode.getHind()) { // Kontrollib, kas raha on piisavalt
                System.out.println("Raha ei ole piisavalt!");
                return raha;
            } else { // Kui kõik on korras, siis ostetakse toode
                valitudToode.setKogus(valitudToode.getKogus() - 1);
                System.out.println("Toode ostetud!");
                System.out.println("Raha tagasi: " + (raha - valitudToode.getHind()));
                setMituKordaKasutatud(getMituKordaKasutatud() + 1);
                masinaOlek();
                return raha - valitudToode.getHind();
            }
        }
    }

    // Kontrollib, kas kasutajal on piisavalt raha
    @Override
    public boolean kontroll(double raha) {
        for (Toode elem : pakutavadSnäkid) {
            if (raha > elem.getHind()) return false;
        }
        return true;
    }
}
