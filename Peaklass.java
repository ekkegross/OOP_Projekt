import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {


        Toode snickers = new Toode("Snickers", 1.99, 4);
        Toode chips = new Toode("Potato Chips", 1.49, 10);
        Toode coca = new Toode("Coca-Cola", 1.29, 3);

        Snäkiautomaat snäkiautomaat = new Snäkiautomaat();
        snäkiautomaat.lisaToode(snickers);
        snäkiautomaat.lisaToode(chips);
        snäkiautomaat.lisaToode(coca);

        Kohv latte = new Kohv("Latte", 0.15, 0.25, 2.49);
        Kohv espresso = new Kohv("Espresso", 0, 0.2, 0.99);
        Kohv Americano = new Kohv("Americano", 0, 0.4, 1.99);

        Kohviautomaat kohviautomaat = new Kohviautomaat(0.5, 1);
        kohviautomaat.lisaKohv(latte);
        kohviautomaat.lisaKohv(espresso);
        kohviautomaat.lisaKohv(Americano);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisestage palju teil raha on: ");
        double raha = scanner.nextDouble();

        while(true) {
            System.out.println("Sisestage '1' kui soovite kasutada kohviautomaati");
            System.out.println("Sisestage '2' kui soovite kasutada snäkiautomaati");
            System.out.println("Sisestage '3' kui soovite lõpetada");
            int valik = scanner.nextInt();

            if(valik==3) break;

            if(valik==1){
                while(true){
                    if(kohviautomaat.getKasMasinOnRikkis()){
                        System.out.println("Masin on rikkis!");
                        break;
                    }
                    System.out.println("Valik: ");
                    kohviautomaat.väljastaToodeteHinnad();
                    System.out.println();

                    if(kohviautomaat.kontroll(raha)){
                        System.out.println("Teil pole piisavalt raha ühegi kohvi jaoks");
                        break;
                    }

                    System.out.println("Sisestage valiku number, mida soovite osta: ");
                    int kohviNr = scanner.nextInt();
                    raha = kohviautomaat.sooritaOst(kohviNr, raha);
                    System.out.println();
                }
            }

            if(valik==2){
                while(true) {
                    if(snäkiautomaat.getKasMasinOnRikkis()){
                        System.out.println("Masin on rikkis!");
                        break;
                    }
                    System.out.println("Olemasolevad tooted: ");
                    snäkiautomaat.väljastaToodeteHinnad();

                    if(snäkiautomaat.kontroll(raha)){
                        System.out.println("Teil pole raha ühegi toote jaoks, kas soovite oma õnne proovida ja masinat raputada?");
                        System.out.println("Sisesta 1 kui soovid, 0 kui ei soovi.");
                        int soovidEiSoovi = scanner.nextInt();
                        if(soovidEiSoovi==0) break;
                        else{
                            while(!snäkiautomaat.getKasMasinOnRikkis()){
                                if(snäkiautomaat.raputa()){
                                    System.out.println("Vedas. Saite endale ühe " + snäkiautomaat.misTooteSaid());
                                    System.out.println("Soovite korra veel proovida?");
                                    System.out.println("Sisesta 1 kui soovid, 0 kui ei soovi.");
                                    soovidEiSoovi = scanner.nextInt();
                                    if(soovidEiSoovi==0) break;
                                }else{
                                    System.out.println("Seekord ei vedanud, kas soovid veel proovida?");
                                    System.out.println("Sisesta 1 kui soovid, 0 kui ei soovi.");
                                    soovidEiSoovi = scanner.nextInt();
                                    if(soovidEiSoovi==0) break;
                                }
                            }
                            if(snäkiautomaat.getKasMasinOnRikkis()) System.out.println("Raputasite liiga palju masin on rikkis!");;
                            break;
                        }
                    }

                    System.out.println("Sisestage toote number, mida soovite osta: ");
                    int tooteNumber = scanner.nextInt();
                    raha = snäkiautomaat.sooritaOst(tooteNumber, raha);
                }
            }
        }
        scanner.close();

    }

}
