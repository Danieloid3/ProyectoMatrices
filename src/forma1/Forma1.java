package forma1;

public class Forma1 {
    private int dato;
    private int fila;
    private int columna;
    private Nodo punta;


    public Forma1(int dato, int fila, int columna){
        this.dato=dato;
        this.fila=fila;
        this.columna=columna;
        this.punta = null;
    }

    public void Construir (int [][] Mat){
        punta = new Nodo(Mat.length, Mat[0].length, 0);
        Paso1(Mat.length, Mat[0].length);
        Paso2(Mat);
        Paso3();
    }

    public void InsertarFinal(int i)
    {
        Nodo x = new Nodo(i, i);
        Nodo P = punta;

        while (P.getLiga() != punta && P.getLiga() != null)
        {
            P = P.getLiga();
        }
        x.setLiga(punta);
        P.setLiga(x);
    }

    public void InsertarFinal(int filas, int columnas, int dato, Nodo P)
    {
        Nodo x = new Nodo(filas, columnas, dato);
        while (P.getLigaFila() != punta && P.getLigaFila() != null)
        {
            P = P.getLigaFila();
        }

        x.setLigaFila(punta);
        P.setLigaFila(x);
    }


    public void Paso1(int f, int c){
        int May = 0, i = 0;
        if (f<c)
            May = c;
        else
            May = f;

        while (i<May){
            InsertarFinal(i);
            i++;
        }
    }

    public void Paso2 (int [][] mat){
        Nodo P = punta;
        for (int i = 0; i < mat.length; i++) {
            P = P.getLiga();
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    InsertarFinal(i, j, mat[i][j], P);
                }
            }
        }
    }

    public void Paso3() {
        Nodo A = punta.getLiga();
        Nodo RegistroCabeza = A;
        Nodo P = A.getLigaFila();

        while (RegistroCabeza != punta) {
            while (A != punta && P != punta) {
                if (P.getColumna() == RegistroCabeza.getColumna()) {
                    A = P;
                    P.setLigaColumna(RegistroCabeza);
                    P = RegistroCabeza;
                } else {
                    P = P.getLigaFila();
                }
                P = P.getLiga();
                RegistroCabeza = RegistroCabeza.getLiga();
            }
        }
    }

    public void sumaFilasColumnas(int filas, int columnas){
        Nodo P = punta.getLiga();
        int i = 0;
        int [] Fila= new int[P.getFila()];
        int [] Columna= new int[P.getColumna()];
        int mayor = 0;
        if (filas < columnas) {
            mayor = columnas;
        }else {
            mayor = filas;
        }

        while (i < mayor)
        {
            while (P.getLigaFila() != punta)
            {
                Fila[P.getFila()] += P.getDato();
                Columna[P.getColumna()] += P.getDato();
                P = P.getLigaFila();
            }
            P=P.getLiga();
            i++;
        }
    }


}
