package forma2;

public class Nodo {
    private int dato;
    private int fila;
    private int columna;
    private Nodo ligaFila;
    private Nodo ligaColumna;

    public Nodo(int fila, int columna, int dato){
        this.dato = dato;
        this.fila = fila;
        this.columna = columna;
        this.ligaFila = null;
        this.ligaColumna = null;
    }

    public Nodo(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.ligaFila = null;
        this.ligaColumna = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }


    public Nodo getLigaFila() {
        return ligaFila;
    }

    public void setLigaFila(Nodo ligaFila) {
        this.ligaFila = ligaFila;
    }

    public Nodo getLigaColumna() {
        return ligaColumna;
    }

    public void setLigaColumna(Nodo ligaColumna) {
        this.ligaColumna = ligaColumna;
    }
}
