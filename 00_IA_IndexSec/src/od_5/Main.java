/*Coded By: M.C. María de Jesús Hernández Morales*/
/*Subject: Inteligencia Artificial*/
/*Instituto Tecnológico de Celaya (Tecnológico Nacional de México en Celaya)*/
/*Clase Main*/

package od_5;
/*import com.sun.org.apache.xpath.internal.SourceTree;*/
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        Libro lib=new Libro();

        //lib.escribir_Arch_Maestro();
        System.out.println("LECTURA DEL ARCHIVO MAESTRO\n");
        lib.leer_secuencial_maestro();
        lib.leer_aleatorio_maestro();
    }
}
