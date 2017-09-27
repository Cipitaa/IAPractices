/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecuencialIndexado;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author ValleRo
 */
public class Libro {
   int a_Llave;
   char a_Origen;
   char a_Destino;
   double a_Peso;
   
   public void m_escribeArchivoMaestro(){
       int v_Bandera=1;
       long v_Direccion;
       try{
           RandomAccessFile v_Maestro = new RandomAccessFile("Maestro.dat","rw");
           RandomAccessFile v_Indice = new RandomAccessFile("Indice.dat","rw");
           Scanner v_Entrada = new Scanner(System.in);
           do{
               v_Direccion=v_Maestro.getFilePointer();
               
               System.out.print("Llave: ");
               a_Llave=v_Entrada.nextInt();
               v_Maestro.writeInt(a_Llave);
               
               System.out.print("Origen: ");
               a_Origen= v_Entrada.next().charAt(0);
               v_Maestro.writeChar(a_Origen);
               
               System.out.print("Destino: ");
               a_Destino= v_Entrada.next().charAt(0);
               v_Maestro.writeChar(a_Destino);
               
               System.out.print("Peso: ");
               a_Peso=v_Entrada.nextDouble();
               v_Maestro.writeDouble(a_Peso);
               
               System.out.println("Agregar otra nodo Si=1/No=0");
               v_Bandera=v_Entrada.nextInt();

               v_Indice.writeInt(a_Llave);
               v_Indice.writeLong(v_Direccion);
           }while(v_Bandera==1);
           v_Maestro.close();
           v_Indice.close(); 
       }catch(Exception e){
           System.out.println(e.toString());
       }
   }
   
//   public void m_leeSecuencial(){
//       long v_apActual,v_apFinal;
//       char v_Nombre[] = new char[10],v_Temporal;
//       
//       System.out.println("\t\t\tDatos del Archivo Maestro\n\n");
//       try{
//           RandomAccessFile v_Archivo = new RandomAccessFile("Datos.dat","r");
//           v_apActual=v_Archivo.getFilePointer();
//           v_apFinal=v_Archivo.length();
//           while(v_apActual!=v_apFinal){
//               
//               a_Llave=v_Archivo.readInt();
//               System.out.print(a_Llave+"\t");
//               
//               for(int i=0; i<v_Nombre.length; i++){
//                   v_Nombre[i]=v_Archivo.readChar();
//               }
//               a_Nombre=new String(v_Nombre);
//               System.out.print(a_Nombre+"\t");
//               
//               a_Estatura=v_Archivo.readDouble();
//               System.out.println(a_Estatura);
//           }
//           v_Archivo.close();
//       }catch(Exception e){
//           System.out.println(e.toString());
//       }
//    }
//   
//    public void m_leeAleatorio(){
//        int v_Bandera=1, v_direccionLogica;
//        long v_longuitudRegistro, v_desplaza;
//       
//        System.out.println("\t\t\tDatos del Archivo Maestro Aleatorio\n\n");
//        try{
//            RandomAccessFile v_Archivo = new RandomAccessFile("Datos.dat","r");
//            Scanner v_Entrada= new Scanner(System.in);
//       
//            a_Llave=v_Archivo.readInt();
//            char v_Nombre[] = new char[10];
//            for(int i=0; i<v_Nombre.length; i++){
//                v_Nombre[i]=v_Archivo.readChar();
//            }   
//            v_Archivo.readDouble();
//            v_longuitudRegistro=v_Archivo.getFilePointer();
//            
//            do{
//                System.out.print("Numero de Registro: ");
//                v_direccionLogica=v_Entrada.nextInt();
//                v_desplaza=(v_direccionLogica-1)*v_longuitudRegistro;
//                v_Archivo.seek(v_desplaza);
//                
//                a_Llave=v_Archivo.readInt();
//                System.out.print(a_Llave+"\t");
//               
//                for(int i=0; i<v_Nombre.length; i++){
//                    v_Nombre[i]=v_Archivo.readChar();
//                }
//                a_Nombre=new String(v_Nombre);
//                System.out.print(a_Nombre+"\t");
//               
//                a_Estatura=v_Archivo.readDouble();
//                System.out.println(a_Estatura);
//                
//                System.out.println("Leer otro registro Si=1/No=0");
//               v_Bandera=v_Entrada.nextInt();
//                
//            }while(v_Bandera==1);
//           
//            v_Archivo.close();
//        }catch(Exception e){
//           System.out.println(e.toString());
//        }
//   }
//    
//    public void m_Modifica(){
//        int v_Bandera=1, v_direccionLogica;
//        long v_longuitudRegistro, v_desplaza;
//        StringBuffer v_Buffer= null;
//       
//        System.out.println("\t\t\tModifica Registro\n\n");
//        try{
//            RandomAccessFile v_Archivo = new RandomAccessFile("Datos.dat","rw");
//            Scanner v_Entrada= new Scanner(System.in);
//       
//            a_Llave=v_Archivo.readInt();
//            char v_Nombre[] = new char[10];
//            for(int i=0; i<v_Nombre.length; i++){
//                v_Nombre[i]=v_Archivo.readChar();
//            }   
//            v_Archivo.readDouble();
//            v_longuitudRegistro=v_Archivo.getFilePointer();
//            
//            do{
//                System.out.print("Numero de Registro: ");
//                v_direccionLogica=v_Entrada.nextInt();
//                v_desplaza=(v_direccionLogica-1)*v_longuitudRegistro;
//                v_Archivo.seek(v_desplaza);
//                
//                System.out.print("ID Persona: ");
//                a_Llave=v_Entrada.nextInt();
//                v_Archivo.writeInt(a_Llave);
//               
//                System.out.print("Nombre de la Persona: ");
//                a_Nombre=v_Entrada.next();
//                v_Buffer= new StringBuffer(a_Nombre);
//                v_Buffer.setLength(10);
//                v_Archivo.writeChars(v_Buffer.toString());
//               
//                System.out.print("Estatura: ");
//                a_Estatura=v_Entrada.nextDouble();
//                v_Archivo.writeDouble(a_Estatura);
//                
//                System.out.println("Modificar otro registro Si=1/No=0");
//                v_Bandera=v_Entrada.nextInt();
//                
//            }while(v_Bandera==1);
//            v_Archivo.close();
//            m_leeSecuencial();
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
//   }
}
