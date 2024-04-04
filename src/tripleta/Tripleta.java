package tripleta;

public class Tripleta {
    // Atributos
    private int[][] matriz;

    public Tripleta(int datos, int filas, int columnas) {
        matriz = new int[datos + 1][3];
        matriz[0][0] = filas;
        matriz[0][1] = columnas;
        matriz[0][2] = datos;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    public int getMatriz(int fila, int columna) {
        return matriz[fila][columna];
    }
    public void setMatriz(int datos, int fila, int columna) {
        matriz[fila][columna] = datos;
    }


    public void crearTripletas(int[][] matriz) {
        int contador = 1;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (contador == this.matriz[0][2] + 1) {
                    break;
                }
                if (matriz[i][j] != 0) {
                    this.matriz[contador][0] = i;
                    this.matriz[contador][1] = j;
                    this.matriz[contador][2] = matriz[i][j];
                    contador++;
                }

            }
        }
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                System.out.print(this.matriz[i][j] + " ");
            }
            System.out.println();
        }

    }








}