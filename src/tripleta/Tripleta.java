package tripleta;


import forma1.Forma1;
import forma2.Forma2;
import forma1.Nodo;


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

    }

    //Sumar los datos de cada fila y los datos de cada columna de una tripleta
    public void sumarFilasColumnas() {
        int sumaFila = 0;
        int sumaColumna = 0;
        for (int i = 0; i < matriz[0][0]; i++) {
            for (int j = 0; j < matriz[0][1]; j++) {
                sumaFila += buscarDato(i, j);
                sumaColumna += buscarDato(j, i);
            }
            System.out.println("La suma de la fila " + i + " es: " + sumaFila);
            System.out.println("La suma de la columna " + i + " es: " + sumaColumna);
            sumaFila = 0;
            sumaColumna = 0;
        }

    }

    //Multiplicar dos tripletas
    public void multiplicarTripletas(Tripleta tripleta1, Tripleta tripleta2) {
        Tripleta tripletaMultiplicacion = new Tripleta(tripleta1.getMatriz(0, 0) + tripleta2.getMatriz(0, 1), tripleta1.getMatriz(0, 0), tripleta2.getMatriz(0, 1));
        int k = 1;
        for (int i = 0; i < tripleta1.getMatriz(0, 0); i++) {
            for (int j = 0; j < tripleta2.getMatriz(0, 1); j++) {
                int multipicacion = 0;
                for (int l = 0; l < tripleta1.getMatriz(0, 1); l++) {
                    multipicacion += tripleta1.buscarDato(i, l) * tripleta2.buscarDato(l, j);
                }
                if (multipicacion != 0) {
                    tripletaMultiplicacion.setMatriz(i, k, 0);
                    tripletaMultiplicacion.setMatriz(j, k, 1);
                    tripletaMultiplicacion.setMatriz(multipicacion, k, 2);
                    k++;
                    multipicacion = 0;
                }
            }
        }
        tripletaMultiplicacion.mostrarTripleta();

    }


    //Sumar dos tripletas de la lista tripletas
    public void sumarTripletas(Tripleta tripleta1, Tripleta tripleta2) {
        Tripleta tripletaSuma = new Tripleta(tripleta1.getMatriz(0, 2) + tripleta2.getMatriz(0, 2), tripleta1.getMatriz(0, 0), tripleta1.getMatriz(0, 1));
        int k = 1;
        for (int i = 0; i < tripletaSuma.getMatriz(0, 0); i++) {
            for (int j = 0; j < tripletaSuma.getMatriz(0, 1); j++) {
                int suma = tripleta1.buscarDato(i, j) + tripleta2.buscarDato(i, j);
                if (suma != 0) {
                    tripletaSuma.setMatriz(i, k, 0);
                    tripletaSuma.setMatriz(j, k, 1);
                    tripletaSuma.setMatriz(suma, k, 2);
                    k++;
                    suma = 0;
                }
            }


        }
        tripletaSuma.setMatriz(k - 1, 0, 2);
        tripletaSuma.mostrarTripleta();
    }
    //Buscar un dato en una la tripleta

    public int buscarDato(int fila, int columna) {
        for (int i = 1; i < matriz.length; i++) {
            if (matriz[i][0] == fila && matriz[i][1] == columna) {
                return matriz[i][2];
            }
        }
        return 0;
    }

    //mostrar tripleta
    public void mostrarTripleta() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (0 == matriz[i][2]) {
                    break;
                }
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println();

        }
    }

    //Eliminar un dato de la tripleta
    public Tripleta eliminarDato(int fila, int columna) {
        for (int i = 1; i < matriz.length; i++) {
            if (matriz[i][0] == fila && matriz[i][1] == columna) {
                matriz[i][2] = 0;
            }
        }
        Tripleta nuevaTripleta = new Tripleta(matriz[0][2] - 1, matriz[0][0], matriz[0][1]);
        int k = 1;
        for (int i = 0; i < matriz[0][0]; i++) {
            for (int j = 0; j < matriz[0][1]; j++) {
                if (buscarDato(i, j) != 0) {
                    nuevaTripleta.setMatriz(i, k, 0);
                    nuevaTripleta.setMatriz(j, k, 1);
                    nuevaTripleta.setMatriz(buscarDato(i, j), k, 2);
                    k++;
                }
            }

        }
        nuevaTripleta.mostrarTripleta();
        return nuevaTripleta;
    }

    //ingresar un dato en la tripleta o adicionar en una posicion existente de forma ordenada
    public Tripleta ingresarDato(int fila, int columna, int dato) {
        Tripleta nuevaTripleta = new Tripleta(matriz[0][2] +1 , matriz[0][0], matriz[0][1]);
        int k = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (buscarDato(i, j) != 0) {
                    if (i == fila && j == columna) {
                        nuevaTripleta.setMatriz(matriz[0][2],0,2);
                        nuevaTripleta.setMatriz(fila, k, 0);
                        nuevaTripleta.setMatriz(columna, k, 1);
                        nuevaTripleta.setMatriz(dato + buscarDato(i,j), k, 2);
                        k++;
                    } else {
                        nuevaTripleta.setMatriz(i, k, 0);
                        nuevaTripleta.setMatriz(j, k, 1);
                        nuevaTripleta.setMatriz(buscarDato(i, j), k, 2);
                        k++;
                    }
                }else {
                    if(i == fila && j == columna) {
                        nuevaTripleta.setMatriz(fila, k, 0);
                        nuevaTripleta.setMatriz(columna, k, 1);
                        nuevaTripleta.setMatriz(dato, k, 2);
                        k++;
                    }
                }
            }
        }
        nuevaTripleta.mostrarTripleta();
        return nuevaTripleta;
    }
    //Sumar tripleta con forma 2 y resultado forma 1
    public void sumarTripletaForma2(Tripleta tripleta1, Forma2 forma2) {
        Forma1 forma1Suma = new Forma1();
        forma1Suma.Paso1(tripleta1.getMatriz(0, 0), tripleta1.getMatriz(0, 1));
        Nodo x = forma1Suma.getPunta().getLiga();
        int k = 1;
        for (int i = 0; i < tripleta1.getMatriz(0, 0); i++) {
            for (int j = 0; j < tripleta1.getMatriz(0, 1); j++) {
                int suma = tripleta1.buscarDato(i, j) + forma2.Buscar(i, j);
                if (suma != 0) {
                    while (x.getFila() != i) {
                        x = x.getLiga();
                    }
                    forma1Suma.InsertarFinalF(i, j, suma, x);
                    x = forma1Suma.getPunta().getLiga();
                    k++;
                    suma = 0;
                }
            }
        }
        forma1Suma.Paso3();
        System.out.println("---Suma de Formas :");
        forma1Suma.Mostrar();
    }
}