package ManejoArchivos;

import java.io.*;
import java.util.*;
import Tienda.*;
import Utilidades.*;
import Animales.*;

/**
 * @author Team4
 */
public class Manejador {

    /**
     *
     * @param nombre
     * Imprime el archivo especificado.
     */
    public static void imprimir(String ruta) {
        File fl = new File(ruta);
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader(fl));
            String lectura = br.readLine();
            while (lectura != null) {
                System.out.println(lectura);
                lectura = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static List<Mascota> cargarMascotas(){
    	List <Mascota> mascotas = new LinkedList<>();
    	File fl = new File("./Archivos/Pet/pets.txt");

    	try {
            FileInputStream fis = new FileInputStream(fl);
    		ObjectInputStream ois = new ObjectInputStream(fis);
            if(fis.available()>0){
                Mascota pet = (Mascota)ois.readObject();
                while(pet != null){
                    mascotas.add(pet);
                    pet = (Mascota)ois.readObject();
                }
                ois.close();
            }
    		else
                System.out.println("No hay animales registrados. Porfavor ingresa alguno.");
        } catch (EOFException ex) {
            System.out.println("-Todos los animales-");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace(System.out);
        } 
    	return mascotas;
    }

    public static List<Cliente> cargarClientes(String ruta){
    	List <Cliente> clientes = new LinkedList<>();
    	File fl = new File(ruta);
        try {
            FileInputStream fis = new FileInputStream(fl);
            ObjectInputStream ois = new ObjectInputStream(fis);
            if(fis.available()>0){
                Cliente cln = (Cliente)ois.readObject();
                while(cln != null){
                    clientes.add(cln);
                    cln = (Cliente)ois.readObject();
                }
                ois.close();
            }
            else
                System.out.println("No hay clientes registrados. Porfavor ingresa alguno.");
        } catch (EOFException ex) {
            System.out.println("-Todos los clientes-");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } 
        return clientes;
    }

    public static void registro(List<Mascota> mascotas){
        File fl = new File("./Archivos/Pet/pets.txt");
        try {
            FileOutputStream fos = new FileOutputStream(fl, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                for(Mascota msc : mascotas)
                    oos.writeObject(msc);
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
    }

    public static void registroC(List<Cliente> clientes){
        File fl = new File("./Archivos/Usrs/usuarios.txt");
        try {
            FileOutputStream fos = new FileOutputStream(fl, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Cliente cl : clientes){
                String info = cl.toString();
                oos.writeObject(cl);
            }
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    /**
     * Crea un nuevo archivo con el nombre especificado.
     * @param nombre Nombre del archivo que se va a crear.
     */
    public static void crear(String ruta) {
        File fileC = new File(ruta);
        try {
            PrintWriter exit = new PrintWriter(fileC);
            exit.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
