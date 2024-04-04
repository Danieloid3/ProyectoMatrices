package forma2;

import forma1.Forma1;

public class Forma2 {
    private Nodo punta;

    public Forma2() {
        this.punta=null;

    }
    public Nodo getPunta() {
        return punta;
    }


    public void Construir(int Mat[][]){
        Nodo x = new Nodo(Mat.length, Mat[0].length, 0);
        punta = x;
        punta.setLigaFila(punta);
        for(int i = 0; i < Mat.length;i++){
            for(int j = 0; j< Mat[0].length; j++){
                if(Mat[i][j] != 0){
                    this.InsertarFinal(i,j,Mat[i][j]);
                }
            }
        }
        construirColumnas();
        System.out.println("--Forma 2--");
        Mostrar();
    }

    public void InsertarFinal(int filas, int columnas, int dato)
    {
        Nodo x = new Nodo(filas, columnas, dato);
        x.setLigaFila(x);
        Nodo P = punta;
        if(punta == null){
            punta = x;
            punta.setLigaFila(punta);
        }else{
            while(P.getLigaFila()!=punta){
                P = P.getLigaFila();
            }
        }
        P.setLigaFila(x);
        x.setLigaFila(punta);
    }



    public void construirColumnas(){
        Nodo A = punta.getLigaFila();
        Nodo P = this.punta;
        for(int i = 0; i < punta.getColumna(); i++){
            P = punta.getLigaFila();
            while(P!=punta){
                if(P.getColumna()==i){
                    A.setLigaColumna(P);
                    A=P;
                }
                P=P.getLigaFila();
            }
        }
    }


    public void multiplicar(Forma2 forma2) {

        Forma2 multiplicacion = new Forma2();
        multiplicacion.getPunta().setFila(getPunta().getFila());
        multiplicacion.getPunta().setFila(forma2.getPunta().getColumna());
        Nodo P = multiplicacion.getPunta().getLigaFila();
        int resultado = 0;
        for (int i = 0; i < getPunta().getFila(); i++){
            for (int j = 0; j < forma2.getPunta().getColumna(); j++){
                for (int k = 0; k < getPunta().getColumna(); k++){
                    resultado += Buscar(i, k) * forma2.Buscar(k, j);
                }
                if (resultado != 0){
                    while (P.getFila() != i){
                        P = P.getLigaFila();
                    }
                    multiplicacion.InsertarFinal(i, j, resultado);
                    P = multiplicacion.getPunta().getLigaFila();
                }
                resultado= 0;
            }
        }

        multiplicacion.construirColumnas();
        System.out.println("---Multiplicacion Forma 2:");
        multiplicacion.Mostrar();
    }



    public void sumaFilasColumnas(){
        Nodo P = this.punta.getLigaFila();
        int [] Fila= new int[this.punta.getFila()];
        int [] Columna= new int[this.punta.getColumna()];

            while (P!=punta) {
                Fila[P.getFila()] += P.getDato();
                Columna[P.getColumna()] += P.getDato();
                P = P.getLigaFila();
            }

        for(int i = 0; i < Fila.length;i++){
            System.out.println("La suma de la fila "+ i + " es: "+ Fila[i]);
        }
        for (int i = 0; i < Columna.length; i++) {
            System.out.println("La suma de la columna "+ i + " es: "+ Columna[i]);
        }
    }


    public void Mostrar(){
        Nodo P = punta.getLigaFila();
        System.out.println("|"+ punta.getFila()+"."+punta.getColumna()+"."+punta.getDato()+"|--->");
        while (P != punta)
        {
            System.out.print("|"+ P.getFila()+ "." +P.getColumna()+"."+P.getDato() + "|--->");
            P = P.getLigaFila();
        }
        System.out.println(" ");
    }
    public int Buscar(int fila, int columna){
        Nodo P = this.punta.getLigaFila();
        Nodo Q = P.getLigaFila();
        while (P != punta){
            while (Q != P){
                if (Q.getFila() == fila && Q.getColumna() == columna){
                    return Q.getDato();
                }
                Q = Q.getLigaFila();
            }
            P = P.getLigaFila();
            Q = P.getLigaFila();
        }
        return 0;
    }
}
