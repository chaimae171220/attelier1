package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args, String daoClassname) {


        try {
            Scanner scanner = new Scanner(new File("config.txt"));

            // ces trois lignes equivalent de         DaoImpl d = new DaoImpl();
            String daoClassName = scanner.nextLine(); //donner le nom de la calsse
            Class cDao = Class.forName(daoClassname);// chercher si la classe existe et la charger en mémoire
            IDao dao=(IDao)  cDao.getConstructor().newInstance(); // créer un objet de cette clase



            // MetierImpl metier = new MetierImpl();
            String metierClassName = scanner.nextLine();
            Class cMetierClass = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetierClass.getConstructor().newInstance();


            //        metier.setDao(d); //a-methode1:injection (setter)
            Method setDao = cMetierClass.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier,dao); // executer setdao sur objet metier en lui tranmettant dao

        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }
}

