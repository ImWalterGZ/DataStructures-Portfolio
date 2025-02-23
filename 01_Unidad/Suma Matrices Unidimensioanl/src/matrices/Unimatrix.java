package matrices;

import java.util.Arrays;

public class Unimatrix {

    private double [] matrix;
    public int seed;

    public Unimatrix(){
        this.seed = 3;
        matrix = new double[this.seed *this.seed];
        }

    public Unimatrix(int seed){
        this.seed = seed;
        matrix = new double[this.seed *this.seed];
        }

    public Unimatrix(Unimatrix matriz){
        this.seed = matriz.seed;
        this.matrix = matriz.matrix;

        }


    public void set(int i, int j, double valor){
        this.matrix[seed * i + j] = valor;
    }

    public double[] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[] matrix) {
        this.matrix = matrix;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public void sumar(Unimatrix matrizB) {
        for (int i = 0; i < seed*seed; i++){
            this.matrix[i] += matrizB.matrix[i];

        }

    }

//    public Unimatrix suma(Unimatrix matrizB){
//
//        if (this.seed == matrizB.seed) {
//            Unimatrix newUnimatrix = new Unimatrix(this);
//
//            for (int i = 0; i < this.getSeed() * this.getSeed(); i++) {
//                newUnimatrix.matrix[i] = this.matrix[i] = matrizB.matrix[i];
//            }
//
//            return newUnimatrix;
//        } else {
//            return null;
//        }
//    }

    public Unimatrix suma(Unimatrix matrizB){
        if (this.seed == matrizB.seed) {
            Unimatrix newUnimatrix = new Unimatrix(this);

            for (int i = 0; i < this.seed; i++) {
                for (int j = 0; j < this.seed ; j++){
                    newUnimatrix.set(i,j,this.matrix[this.seed * i + j]+ matrizB.matrix[matrizB.seed * i + j]);

                }
            }
            return newUnimatrix;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuffer cadena = new StringBuffer();
        for (int i = 0; i < this.seed; i++) {
            for (int j = 0; j < this.seed ; j++){
                cadena.append(this.matrix[(this.seed * i + j)]);
                cadena.append(' ');
            }
            cadena.append('\n');
        }
        return cadena.toString();
    }
}


