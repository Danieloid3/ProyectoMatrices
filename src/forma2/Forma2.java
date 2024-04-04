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


    public void Construir(int [][] Mat){
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
        punta.setFila(Mat.length);
        punta.setColumna(Mat[0].length);
        construirColumnas();
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
        int [][] resultado = new int[getPunta().getFila()][forma2.getPunta().getColumna()];

        for (int i = 0; i < getPunta().getFila(); i++) {
            for (int j = 0; j < forma2.getPunta().getColumna(); j++) {
                for (int k = 0; k < getPunta().getColumna(); k++) {
                    resultado[i][j] += Buscar(i, k) * forma2.Buscar(k, j);
                }
            }
        }

        multiplicacion.Construir(resultado);
        System.out.println("---Multiplicacion Forma 2---");
        multiplicacion.Mostrar();
    }

    public void Sumar(Forma2 forma2) {
        Forma2 Suma = new Forma2();
        int [][] resultado = new int[getPunta().getFila()][getPunta().getColumna()];
        for (int i = 0; i < getPunta().getFila(); i++){
            for (int j = 0; j <getPunta().getColumna(); j++){
                resultado[i][j] = Buscar(i,j) + forma2.Buscar(i, j);

            }
        }
        Suma.Construir(resultado);
        System.out.println("---Suma Forma 2---");
        Suma.Mostrar();
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

    public void Eliminar(int fila, int columna, int dato){
        Nodo P = this.punta.getLigaFila();
        Nodo aux = P;
        Nodo Q = P.getLigaFila();
        if (Buscar(fila, columna) == dato){
            while (P!=punta){
                while (Q!=P){
                    if (Q.getFila() == fila && Q.getColumna() == columna){
                        Q = Q.getLigaFila();
                        aux.setLigaFila(Q);
                        Q = P;
                    }else{
                        aux = aux.getLigaFila();
                        Q = Q.getLigaFila();
                    }
                }
                P = P.getLigaFila();
                Q = P.getLigaFila();
                aux = P;
            }

        }else{
            System.out.println("El dato no existe");
        }
        Mostrar();
    }

    //insertar un dato en forma 2
    public void Insertar(int fila, int columna, int dato){
        Nodo P = this.punta.getLigaFila();
        Nodo Q = P.getLigaFila();
        Nodo x = new Nodo(fila, columna, dato);
        Nodo aux = BuscarNodo(fila, columna);

        if(aux != null){
            aux.setDato(aux.getDato()+dato);
        }else{
            while (P.getFila() < fila){
                P = P.getLigaFila();
            }
            while  (P.getColumna() < columna && P.getFila()== fila){
                Q = P;
                P = P.getLigaFila();
            }
            Q.setLigaFila(x);
            x.setLigaFila(P);
        }

        Mostrar();
    }
    public Nodo BuscarNodo(int fila, int columna){
        Nodo P = this.punta.getLigaFila();
        Nodo Q;
        while (P != punta){
            Q = P.getLigaFila();
            while (Q != P){
                if (Q.getFila() == fila && Q.getColumna() == columna){
                    return Q;
                }
                Q = Q.getLigaFila();
            }
            P = P.getLigaFila();
        }
        return null;
    }



}
