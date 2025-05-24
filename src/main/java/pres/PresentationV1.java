package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class PresentationV1 {
    public static void main(String[] args) {
// 5- a= injection des dépandances par instanciation statique
        DaoImpl d = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(d);
        System.out.println("RES="+metier.calcul());

    }
}
