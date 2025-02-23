import Utilis.Sets;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        Sets<Integer> Frances = new Sets<>();
        Sets<Integer> Aleman = new Sets<>();
        Sets<Integer> Espanol = new Sets<>();

        Frances.add(30);
        Frances.add(7);
        Frances.add(2);
        Frances.add(3);

        Aleman.add(20);
        Aleman.add(5);
        Aleman.add(3);
        Aleman.add(2);

        Espanol.add(13);
        Espanol.add(5);
        Espanol.add(3);
        Espanol.add(7);

        Sets<Integer> EspAle = Espanol.union(Aleman);

        Sets<Integer>EspAleFra = Frances.union(EspAle);

        Sets<Integer> soloFrances = Frances.difference(Aleman.union(Espanol));

        System.out.println("Hay " + (100 - EspAleFra.sumaConjunto() ) + " alumnos que no estudian idiomas");

        System.out.println("Hay" + (soloFrances.toString()) + "alumnos que solo estudian frances");


    }
}
