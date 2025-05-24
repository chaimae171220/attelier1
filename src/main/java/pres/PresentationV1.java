package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
// 5- a= injection des dépandances par instanciation statique avec new
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(d); //a-methode1:injection (setter)
        System.out.println("RES="+metier.calcul());

    }
}
