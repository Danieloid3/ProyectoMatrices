package forma1;

import forma2.Forma2;

public class Forma1 {

    public Nodo punta;



    public Forma1() {
       this.punta = null;
    }
    public Nodo getPunta() {
        return punta;
    }

    public void Construir (int [][] Mat){
        Paso1(Mat.length, Mat[0].length);
        Paso2(Mat);
        Paso3();
        System.out.println("--Forma 1--");
        Mostrar();
    }

    public void InsertarFinal(int mayor)
    {
        Nodo x = new Nodo(mayor, mayor);
        x.setLigaFila(x);
        Nodo P = punta;

        if(punta== null){
            punta = x;
            punta.setLiga(punta);
        }else{
            while(P.getLiga()!=punta){
                P = P.getLiga();
            }
            P.setLiga(x);
            x.setLiga(punta);
        }
    }

    public void InsertarFinalF(int filas, int columnas, int dato, Nodo P)
    {
        Nodo x = new Nodo(filas, columnas, dato);
        Nodo q = P;
        if(P.getLigaFila() == null){
            P = x;
            P.setLigaFila(P);
            P.setLigaColumna(P);
        }else{
            while(q.getLigaFila()!=P){
                q = q.getLigaFila();
            }
        }
        q.setLigaFila(x);
        x.setLigaFila(P);
    }


    public void Paso1(int f, int c){
        int May = 0;
        if (f>c)
            May = f;
        else
            May = c;

        InsertarFinal(May);
        for(int i=0; i<May; i++){
            InsertarFinal(i);
        }

        punta.setFila(f);
        punta.setColumna(c);
    }

    public void Paso2 (int [][] mat){
        Nodo P = punta.getLiga();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    InsertarFinalF(i, j, mat[i][j], P);
                }
            }
            P = P.getLiga();
        }
    }

    public void Paso3() {
        Nodo RegistroCabeza = punta.getLiga();
        Nodo A = RegistroCabeza;
        Nodo P = punta.getLiga();
        Nodo Q = P.getLigaFila();

        while (RegistroCabeza != punta){
            A = RegistroCabeza;
            P = punta.getLiga();
            Q = P.getLigaFila();
            while (P != punta) {
                while (Q != P) {
                    if (A.getColumna() == Q.getColumna()) {
                        A.setLigaColumna(Q);
                        A = Q;
                        Q = P;
                    } else {
                        Q = Q.getLigaFila();
                    }
                }
                P = P.getLiga();
                Q = P.getLigaFila();
            }
            A.setLigaColumna(RegistroCabeza);
            RegistroCabeza = RegistroCabeza.getLiga();
        }
    }

    public void Mostrar(){
        Nodo P = punta;
        System.out.println("|" + P.getFila() + "." + P.getColumna() + "." + P.getDato() + "|");
        P = P.getLiga();
        Nodo Q = P.getLigaFila();
        while (P != punta) {
            System.out.print("|" + P.getFila() + "." + P.getColumna() + "." + P.getDato() + "|---->");
            while (Q != P){
                System.out.print("|" + Q.getFila() + "." + Q.getColumna() + "." + Q.getDato() + "|---->");
                Q = Q.getLigaFila();
            }
            P = P.getLiga();
            Q = P.getLigaFila();
            System.out.println();
        }
    }


    public void sumaFilasColumnasF(){
        Nodo P = this.punta.getLiga();
        Nodo Q = P.getLigaFila();
        int [] Fila= new int[this.punta.getFila()];
        int [] Columna= new int[this.punta.getColumna()];


        while (P != punta)
        {
            while (Q!=P) {
                Fila[Q.getFila()] += Q.getDato();
                Columna[Q.getColumna()] += Q.getDato();
                Q = Q.getLigaFila();
            }
            P = P.getLiga();
            Q = P.getLigaFila();

        }


        for(int i = 0; i < Fila.length;i++){
            System.out.println("La suma de la fila "+ i + " es: "+ Fila[i]);
        }
      for (int i = 0; i < Columna.length; i++) {
            System.out.println("La suma de la columna "+ i + " es: "+ Columna[i]);
        }
    }

    public int Buscar(int fila, int columna){
        Nodo P = this.punta.getLiga();
        Nodo Q = P.getLigaFila();
        while (P != punta){
            while (Q != P){
                if (Q.getFila() == fila && Q.getColumna() == columna){
                    return Q.getDato();
                }
                Q = Q.getLigaFila();
            }
            P = P.getLiga();
            Q = P.getLigaFila();
        }
        return 0;
    }

    public void Eliminar(int fila, int columna, int dato){
        Nodo P = this.punta.getLiga();
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
                P = P.getLiga();
                Q = P.getLigaFila();
                aux = P;
            }

        }
            Mostrar();
    }



    public void multiplicar(Forma1 forma1) {
        Forma1 multiplicacion = new Forma1();
        multiplicacion.Paso1(getPunta().getFila(), forma1.getPunta().getColumna());
        Nodo P = multiplicacion.getPunta().getLiga();
        int resultado = 0;
        for (int i = 0; i < getPunta().getFila(); i++){
            for (int j = 0; j < forma1.getPunta().getColumna(); j++){
                for (int k = 0; k < getPunta().getColumna(); k++){
                    resultado += Buscar(i, k) * forma1.Buscar(k, j);
                }
                if (resultado != 0){
                    while (P.getFila() != i){
                        P = P.getLiga();
                    }
                    multiplicacion.InsertarFinalF(i, j, resultado, P);
                    P = multiplicacion.getPunta().getLiga();
                }
                resultado= 0;
            }
        }

        System.out.println("---Multiplicacion Forma 1:");
        multiplicacion.Mostrar();
    }


    public void Sumar(Forma1 forma1) {
        Forma1 Suma = new Forma1();
        Suma.Paso1(getPunta().getFila(), forma1.getPunta().getColumna());
        Nodo P = Suma.getPunta().getLiga();
        int resultado = 0;
        for (int i = 0; i < getPunta().getFila(); i++){
            for (int j = 0; j <getPunta().getColumna(); j++){
                resultado = Buscar(i,j) + forma1.Buscar(i, j);
                if (resultado != 0){
                    while (P.getFila() != i){
                        P = P.getLiga();
                    }
                    Suma.InsertarFinalF(i, j, resultado, P);
                    P = Suma.getPunta().getLiga();
                }
                resultado= 0;
            }
        }
        Suma.Paso3();
        System.out.println("---Suma Forma 1:");



        Suma.Mostrar();
    }

    //insertar dato en forma 1
    public void insertar(int fila, int columna, int dato){
        Nodo P = this.punta.getLiga();
        Nodo Q = P.getLigaFila();
        //Insertar(fila, columna, dato);
        Paso3();


        Mostrar();
    }

    public void Insertar(int fila, int columna, int dato){
        Nodo P = this.punta.getLiga();
        Nodo Q = P.getLigaFila();
        Nodo aux = BuscarNodo(fila,columna);
        Nodo s = null;

        if(aux.getDato()!=0){
            aux.setDato(dato+aux.getDato());
        }else{
            while (P.getFila() != fila && Q.getColumna()!= columna){
                P = P.getLiga();
                Q = P.getLigaFila();
            }

            while (Q.getColumna() < columna && Q != P){
                s = Q;
                Q = Q.getLigaFila();
            }
            if (Q.getColumna() == columna) {



            }

        }
        Mostrar();

    }



    public Nodo BuscarNodo(int fila, int columna){
        Nodo P = this.punta.getLiga();
        Nodo Q;
        while (P != punta){
            Q = P.getLigaFila();
            while (Q != P){
                if (Q.getFila() == fila && Q.getColumna() == columna){
                    return Q;
                }
                Q = Q.getLigaFila();
            }
            P = P.getLiga();
        }
        return null;
    }

}