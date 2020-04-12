import models.Gracz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NajlepszyWynik {

  //  private static Gracz najlepszyGracz;
   // private Gracz najlepszyGracz;
    //    private NajlepszyWynik najlepszyWynik;

    public NajlepszyWynik()  {


    }

    public static void checkAndSave(Gracz gracz){
        Gracz najlepszyGracz = odczytajWynik();
        if (gracz.getstanKonta() > najlepszyGracz.getstanKonta()) najlepszyGracz = gracz;
           zapiszWynik(najlepszyGracz);
  }

    public static void zapiszWynik(Gracz najlepszyGracz)  {
        PrintWriter rekord = null;
        try {
            rekord = new PrintWriter("rekord.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            rekord.close();
        }

        rekord.println(najlepszyGracz.getImie() + "," + najlepszyGracz.getstanKonta());
        rekord.close();
    }


    public static Gracz odczytajWynik() {
        Scanner odczytRekordu = null;
        try {
            odczytRekordu = new Scanner(new File("rekord.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String rekord = odczytRekordu.nextLine();
        String[] gracz = rekord.split(",", 2);
        Integer.parseInt(gracz[1]);
        return  new Gracz(gracz[0],  Integer.parseInt(gracz[1]));
       }
}
