/*Coded By: M.C. María de Jesús Hernández Morales*/
/*Subject: Inteligencia Artificial*/
/*Instituto Tecnológico de Celaya (Tecnológico Nacional de México en Celaya)*/

/*Clase Libro.java*/

package od_5;

import java.io.*;
import java.util.*;

public class Libro {
    int llave;
    String nomb;
    double clasifica;

    /* Métodos de la clase Libro.java */

    //Método de escritura del archivo maestro
    public void escribir_Arch_Maestro()throws IOException{
        int n;
        StringBuffer buffer=null;

        System.out.println("Archivo Maestro");
        RandomAccessFile archi=new RandomAccessFile("biblioteca", "rw");
        Scanner entrada=new Scanner(System.in);

        do{
            System.out.println("Clave del libro");
            llave=entrada.nextInt();
            archi.writeInt(llave);

            System.out.println("Nombre del libro");
            nomb=entrada.next();
            buffer=new StringBuffer(nomb);
            buffer.setLength(15);
            archi.writeChars(buffer.toString());

            System.out.println("Clasificación del libro");
            clasifica=entrada.nextDouble();
            archi.writeDouble(clasifica);

            System.out.println("¿Otro Libro?: Si=1, No=0 ");
            n=entrada.nextInt();
        }while (n==1);
        archi.close();
    }

    //Método de lectura secuencial del archivo maestro
    public void leer_secuencial_maestro()throws IOException{
        long ap_actual, ap_final;
        RandomAccessFile leer_archi=new RandomAccessFile("biblioteca", "r");

        while((ap_actual=leer_archi.getFilePointer())!=(ap_final=leer_archi.length())){
            //Hue
            llave=leer_archi.readInt();

            System.out.println(llave);
            char nombre[]=new char[15],temp;

            for (int c = 0; c < nombre.length ; c++) {
                temp=leer_archi.readChar();
                nombre[c]=temp;
            }

            new String(nombre).replace('\0',' ');

            System.out.println(nombre);
            clasifica=leer_archi.readDouble();

            System.out.println(clasifica);
        }//Fin ciclo while
        leer_archi.close();
    }

    //Método de lectura aleatoria del archivo maestro
    public void leer_aleatorio_maestro()throws IOException{
        int n, dl;
        long lreg, desplaza;

        RandomAccessFile archi=new RandomAccessFile("biblioteca","r");
        Scanner entrada=new Scanner(System.in);
        archi.readInt();
        char nomb[]=new char[15];

        for (int c = 0; c < nomb.length; c++)
            nomb[c]=archi.readChar();

        archi.readDouble();
        lreg=archi.getFilePointer();

        do{
            System.out.println("\nIntroduce la dirección lógica del registro: ");
            dl=entrada.nextInt();
            desplaza=(dl-1)*lreg;
            archi.seek(desplaza);
            llave=archi.readInt();

            System.out.println("\nLos datos del registro son: ");
            System.out.println(llave);
            char nombre[]=new char[15],temp;

            for (int c = 0; c < nombre.length; c++) {
                temp=archi.readChar();
                nombre[c]=temp;
            }

            new String(nombre).replace('\0', ' ');

            System.out.println(nombre);
            clasifica=archi.readDouble();

            System.out.println(clasifica);
            System.out.println("¿Otro libro?: Si=1, No=0 ");
            n=entrada.nextInt();
        }while(n==1);
        archi.close();
    }
}
