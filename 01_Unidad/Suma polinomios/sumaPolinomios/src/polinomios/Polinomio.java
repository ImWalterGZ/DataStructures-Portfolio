package polinomios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Polinomio {

    int grado;
    double [] valores;

    public Polinomio(int grado){
        this.grado = grado;
        this.valores = new double[grado+1];
    }

    public Polinomio(){


    }

    public Polinomio(Polinomio copia){
        this.grado = copia.grado;
        this.valores = new double[grado];
    }


    public Polinomio suma(Polinomio binomioB){

        Polinomio temp;
        temp = this.grado >= binomioB.getGrado() ?
                new Polinomio(this.grado):
                new Polinomio(binomioB.getGrado());

        temp.valores[0] = this.valores[0] = binomioB.valores[0];


        for(int i = 1; i < temp.grado ; i++){

            if (i <= this.grado && i <= binomioB.grado){
                temp.valores[i] = this.valores[i] + binomioB.valores[i];
            } else {
                if (this.grado < i){
                    temp.valores[i] = binomioB.valores[i];
                } else {
                    temp.valores[i] = this.valores[i];
                }
            }

        }


        return temp;
    }


    public void capturar(){
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader leer = new BufferedReader(in);

        try{
            for (int i = this.grado; i >= 0; i--){
                System.out.printf("Ingrese el valor de X^:%d ",i);
                this.valores[i] = Double.parseDouble(leer.readLine());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append(this.valores[grado] + "x^" + grado + ' ');

        for (int i = this.grado - 1; i >=0 ; i--) {
            if (this.valores[i] != 0){
                if (this.valores[i] > 0 ) {
                    cadena.append("+ " + this.valores[i] + "x^" + i + ' ');
                } else{
                    cadena.append(this.valores[i] + "x^" + i + ' ');
                }

            }
        }
        return cadena.toString();
    }
}
