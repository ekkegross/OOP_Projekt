/**
 * Klass Kohv
 */
public class Kohv {
    private String kohviNimi;
    private double piimaKogusL;
    private double kohviSeguKogusL;
    private double kohviHind;

    // Konstruktor
    public Kohv(String kohviNimi, double piimaKogusLiitrites, double kohviSeguKogusLiitrites, double kohviHind) {
        this.kohviNimi = kohviNimi;
        this.piimaKogusL = piimaKogusLiitrites;
        this.kohviSeguKogusL = kohviSeguKogusLiitrites;
        this.kohviHind = kohviHind;
    }

    // Get ja set meetodid
    public String getKohviNimi() {
        return kohviNimi;
    }

    public void setKohviNimi(String kohviNimi) {
        this.kohviNimi = kohviNimi;
    }

    public double getKohviHind() {
        return kohviHind;
    }

    public void setKohviHind(double kohviHind) {
        this.kohviHind = kohviHind;
    }

    public double getPiimaKogusL() {
        return piimaKogusL;
    }

    public void setPiimaKogusL(double piimaKogusL) {
        this.piimaKogusL = piimaKogusL;
    }

    public double getKohviSeguKogusL() {
        return kohviSeguKogusL;
    }

    public void setKohviSeguKogusL(double kohviSeguKogusL) {
        this.kohviSeguKogusL = kohviSeguKogusL;
    }
}
