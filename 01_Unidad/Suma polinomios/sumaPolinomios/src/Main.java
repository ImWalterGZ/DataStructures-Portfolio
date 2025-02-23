import polinomios.Polinomio;

public class Main {
    public static void main(String[] args) {
        Polinomio poli,poli1, poli2, poli3;


        poli = new Polinomio(3);
        poli1 = new Polinomio(5);

        poli.capturar();
        poli1.capturar();


        poli2 = poli.suma(poli1);

        System.out.println(poli.toString());
        System.out.println(poli1.toString());
        System.out.println(poli2.toString());

    }
}