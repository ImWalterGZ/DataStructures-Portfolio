import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Estudio {
    int cantEstudiantes;
    int cantMaterias;
    int calificacion;

    int[][][] matriz;

    public Estudio(int cantEstudiantes, int cantMaterias, int calificacion) {
        this.calificacion = calificacion;
        this.cantEstudiantes = cantEstudiantes;
        this.cantMaterias = cantMaterias;

        this.matriz = new int[cantEstudiantes][cantMaterias][calificacion];
    }

    public void llenar() {
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader leer = new BufferedReader(in);

            for (int i = 0; i < cantEstudiantes; i++) {
                matriz[i] = leer.readLine();
                for (int j = 0; j < cantMaterias; j++) {
                    for (int k = 0; k < calificacion; k++) {
                        matriz[i][j][k] =
                    }
                }
            }
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }

    }
}
