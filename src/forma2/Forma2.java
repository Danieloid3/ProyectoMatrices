package forma2;

public class Forma2 {
    private Nodo punta;
    public void Construir (int[][] Mat){
        punta = new Nodo(Mat.length, Mat[0].length, 0);
        Paso1(Mat);
        Paso2();

    }

    public void Paso1(int [][]Mat)
    {
        Nodo P = punta.getLigaFila();
        for (int i = 0; i < Mat.length; i++)
        {
            for (int j = 0; j < Mat[0].length; j++)
            {
                if (Mat[i][j] != 0)
                {
                    InsertarFinal(i, j, Mat[i][j], P);
                }
            }
        }


    }

    public void InsertarFinal(int filas, int columnas, int dato,Nodo P)
    {
        Nodo x = new Nodo(filas, columnas, dato);

        while (P.getLigaFila() != punta && P.getLigaFila() != null)
        {
            P = P.getLigaFila();
        }

        x.setLigaFila(punta);
        P.setLigaFila(x);
    }


    public void Paso2()
    {
        Nodo P = punta.getLigaFila();
        Nodo Q = P;

        while (P.getLigaFila() != punta)
        {
            while (Q.getLigaFila() != punta)
            {
                if (P.getColumna() == Q.getColumna())
                {
                    P.setLigaColumna(Q);
                    Q = P;
                    P = P.getLigaFila();
                }
                else
                {
                    P = P.getLigaFila();
                }
            }
            P = punta.getLigaFila();
            Q = P;
        }

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
}
