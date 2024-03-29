import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import forma1.Forma1;

import forma2.Forma2;
import tripleta.Tripleta;


public class Main {

    public static void main(String[] args) {

        int opc;
        Forma2 forma2 = new Forma2();
        Scanner scanner = new Scanner(System.in);
        int h = 1;
        List<Tripleta> tripletas = new ArrayList<>();
        do {
            System.out.println("----Menu de opciones----");
            System.out.println("1. Tripleta");
            System.out.println("2. Forma 1");
            System.out.println("3. Forma 2");
            System.out.println("Ingrese una opcion: ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("---Tripleta---");
                    System.out.println("1. Crear Tripleta");
                    System.out.println("2. Sumar filas y columnas");
                    System.out.println("3. Multiplicar");
                    System.out.println("4. Suma de tripletas");
                    System.out.println("5. Eliminar dato");
                    System.out.println("6. Ingresar dato");
                    System.out.println("7. Salir");
                    System.out.println("Ingrese una opcion: ");
                    int opc2 = scanner.nextInt();
                    switch (opc2) {
                        case 1:
                            int matriz[][];
                            int datos = 0;

                            matriz = LeerArchivo(h);
                            for (int i = 0; i < matriz.length; i++) {
                                for (int j = 0; j < matriz[i].length; j++) {
                                    System.out.print(matriz[i][j]);
                                    System.out.print(" ");
                                    if (matriz[i][j] != 0) {
                                        datos++;
                                    }
                                }
                                System.out.println(" ");
                            }
                            Tripleta tripleta = new Tripleta(datos, matriz.length, matriz[0].length);
                            tripleta.crearTripletas(matriz);
                            tripletas.add(tripleta);
                            h++;
                            if (h > 10){
                                h = 1;
                            }
                            break;
                        case 2:
                            //Sumar filas y columnas
                            break;
                        case 3:
                            //Multiplicar
                            break;
                        case 4:
                            //Suma de tripletas
                            break;
                        case 5:
                            //Eliminar dato
                            break;
                        case 6:
                            //Ingresar dato
                            break;
                    }
                    break;
                case 2:
                    System.out.println("---Forma 1---");
                    System.out.println("1. Crear Forma 1");
                    System.out.println("2. Sumar filas y columnas");
                    System.out.println("3. Multiplicar");
                    System.out.println("4. Suma de tripletas");
                    System.out.println("5. Eliminar dato");
                    System.out.println("6. Ingresar dato");
                    System.out.println("7. Salir");
                    System.out.println("Ingrese una opcion: ");
                    int opc3 = scanner.nextInt();
                    switch (opc3) {
                        case 1:
                            int matriz[][];
                            int datos = 0;

                            matriz = LeerArchivo(h);
                            for (int i = 0; i < matriz.length; i++) {
                                for (int j = 0; j < matriz[i].length; j++) {
                                    //System.out.print(matriz[i][j]);
                                    //System.out.print(" ");
                                    if (matriz[i][j] != 0) {
                                        datos++;
                                    }
                                }
                                System.out.println(" ");
                            }
                            Forma1 forma1 = new Forma1(datos, matriz.length, matriz[0].length);
                            forma1.Construir(matriz);
                            break;
                        case 2:
                            break;
                        case 3:
                            //Multiplicar
                            break;
                        case 4:
                            //Suma de tripletas
                            break;
                        case 5:
                            //Eliminar dato
                            break;
                        case 6:
                            //Ingresar dato
                            break;
                    }
                    break;
                case 3:
                    System.out.println("---Forma 2---");
                    System.out.println("1. Crear Forma 2");
                    System.out.println("2. Sumar filas y columnas");
                    System.out.println("3. Multiplicar");
                    System.out.println("4. Suma de tripletas");
                    System.out.println("5. Eliminar dato");
                    System.out.println("6. Ingresar dato");
                    System.out.println("7. Salir");
                    System.out.println("Ingrese una opcion: ");
                    int opc4 = scanner.nextInt();
                    switch (opc4) {
                        case 1:
                            //Crear forma 2
                            break;
                        case 2:
                            //Sumar filas y columnas
                            break;
                        case 3:
                            //Multiplicar
                            break;
                        case 4:
                            //Suma de tripletas
                            break;
                        case 5:
                            //Eliminar dato
                            break;
                        case 6:
                            //Ingresar dato
                            break;
                    }
                    break;
            }
        } while (opc != 7);
        scanner.close();
    }

    public static int[][] LeerArchivo(int h) {
        String archivo = "C:\\Users\\123\\IdeaProjects\\Matrices\\Matrices\\src\\Matriz" + h + ".txt";
        String linea;
        int[][] matriz;
        int i=0;
        int j=0;
        int contador=0;
        char aux;
        String num="";
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                while (contador < linea.length()) {
                    aux = linea.charAt(contador);
                    if (Character.isDigit(aux)) {
                        num += aux;
                        contador++;


                    }else{
                        num = "";
                        j++;
                        contador++;
                    }

                }
                System.out.println(linea);
                i ++;
            }
            matriz = new int[i][j+1];
            //llenar la matriz nueva con los datos del archivo
            i=0;
            j=0;
            contador=0;
            num="";
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                while (contador < linea.length()) {
                    aux = linea.charAt(contador);
                    if (Character.isDigit(aux)) {
                        num += aux;
                        contador++;
                    }else{
                        matriz[i][j] = Integer.parseInt(num);
                        num = "";
                        j++;
                        contador++;
                    }
                    if (contador == linea.length()) {
                        matriz[i][j] = Integer.parseInt(num);
                        num= "";
                    }
                }
                i++;
                contador=0;
                j=0;
            }
            br.close();
            return matriz;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}