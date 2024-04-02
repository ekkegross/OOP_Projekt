public class Kohv {
    String kohviNimi;

    double kohviHind;

    public Kohv(String kohviNimi, double kohviHing) {
        this.kohviNimi = kohviNimi;
        this.kohviHind = kohviHing;
    }

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
}
