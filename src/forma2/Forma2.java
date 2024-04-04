package forma2;

public class Forma2 {
    private Nodo punta;

    public Forma2() {
        this.punta=null;

    }


    public void Construir(int Mat[][]){
        punta = new Nodo(Mat.length, Mat[0].length, 0);
        Nodo n,ant;
        int i,j;
        ant = punta;
        for(i=0;i<Mat.length;i++){
            for(j=0;j<Mat[0].length;j++){
                if(Mat[i][j]!=0){
                    n = new Nodo(i,j,Mat[i][j]);
                    n.setLigaFila(punta);
                    n.setLigaColumna(punta);
                    ant.setLigaFila(n);
                    ant=n;
                }
            }
        }
        construirColumnas();
        System.out.println("--Forma 2--");
        Mostrar();
    }

    public void construirColumnas(){
        Nodo A = punta, p;
        int colum = punta.getColumna(), i = 0;
        while(i<colum){
            p=punta.getLigaFila();
            while(p!=punta){
                if(p.getColumna()==i){
                    A.setLigaColumna(p);
                    A=p;
                }
                p=p.getLigaFila();
            }
            i++;
        }
    }


    public void InsertarFinal(int filas, int columnas, int dato)
    {
        Nodo x = new Nodo(filas, columnas, dato);
        x.setLigaFila(x);
        Nodo P = null;
        if(this.punta == null){
            this.punta = x;
            this.punta.setLigaFila(punta);
        }else{
            P = this.punta.getLigaFila();
            while(P.getLigaFila()!= punta){
                P = P.getLigaFila();
            }
        }
        P.setLigaFila(x);
        x.setLigaFila(P);
    }




    public void sumaFilaColumnas(int fila, int columna){
        Nodo P = punta.getLigaFila();
        int [] Fila= new int[fila];
        int [] Columna= new int[columna];

        while(P.getLigaFila() != punta && P.getLigaFila() != null)
        {
            Fila[P.getFila()] += P.getDato();
            Columna[P.getColumna()] += P.getDato();
            P = P.getLigaFila();
        }

        System.out.println("Suma de las filas es igual a: "+ Fila);
        System.out.println("Suma de las columnas es igual a: "+ Columna);

    }

    public void Mostrar(){
        Nodo P = punta;
        while (P != punta)
        {
            System.out.print("|"+ P.getFila()+ "." +P.getColumna()+"."+P.getDato() + "|--->");
            P = P.getLigaFila();
        }
        System.out.println(" ");
    }
}
