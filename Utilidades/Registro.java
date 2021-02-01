package Utilidades;

import java.util.*;
import Animales.*;
import Tienda.*;
import Revisiones.*;

public class Registro{
	static Scanner scanner = new Scanner(System.in);
    
	public static void registrar(List<Mascota> mascotas){
		String raza;
		int edad;
		String nombre;
        String sexo;
        String color;
        Boolean permitido = false;
        System.out.print("Ingresa la especie de tu animal: ");
        String animal = scanner.nextLine();
        switch(animal){
        	case "perro":
                System.out.print("Ingresa el nombre de tu mascota: ");
                nombre = scanner.nextLine();
                do{
                    System.out.print("Ingresa la raza de tu mascota: ");
                    raza = scanner.nextLine();
                    try{
                        Revisar.revisaRaza(raza);
                        permitido = true;
                    }
                    catch(RazaNotFound rz){
                        permitido = false;
                    }
                }while(!permitido);
        		System.out.print("Ingresa la edad de tu mascota: ");
        		edad = scanner.nextInt();
        		scanner.nextLine();
        		Perro perro = new Perro(nombre,edad,false,raza);
        		mascotas.add(perro);
        		break;
        	case "gato":
        		System.out.print("Ingresa el nombre de tu mascota: ");
                nombre = scanner.nextLine();
                System.out.print("Ingresa la edad de tu mascota: ");
                edad = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingresa el color de tu mascota: ");
                color = scanner.nextLine();
                Gato gato = new Gato(nombre, edad, false, color);
                mascotas.add(gato);
                break;
        	case "pez":
        		System.out.print("Ingresa el nombre de tu mascota: ");
        		nombre = scanner.nextLine();
                System.out.print("Ingresa la edad de tu mascota: ");
                edad = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingresa el sexo de tu mascota (Masculino o Femenino): ");
                sexo = scanner.nextLine();
                Pez pez = new Pez(nombre, edad, false, sexo);
                mascotas.add(pez);
                break;
        	default:
        		System.out.println("Raza no existente.");
        }
    }

    public static void registrarUsuario(List<Cliente> clientes){
        Cliente nuevo;
        System.out.print("Cual es tu nombre? ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa un nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        nuevo = new Cliente(nombreUsuario, nombre);
        clientes.add(nuevo);
    }

    public static void eliminarUsuario(List<Cliente> clientes){
        int id;
        if(!clientes.isEmpty()){
           do{
                System.out.print("Ingresa el nombre de usuario: ");
                String nombre = scanner.nextLine();
                id = Busqueda.buscarCliente(clientes,nombre);
                if(id == -1)
                    System.out.println("Nombre de usuario incorrecto.");
            }while(id == -1);
            clientes.remove(id); 
            System.out.println("El usuario se ha eliminado correctamente.");
            System.out.println("No podremos contactar con el usuario para poder poner en adopcion su mascota.");
        } else
            System.out.println("Aun no hay usuarios.");
    }

    public static String adoptar(List<Mascota> mascotas){
        Busqueda.mostrarMascotas(mascotas);
        System.out.println("Ingresa el nombre de la mascota que deseas adoptar:");
        String nombre = scanner.nextLine();
        try{
            Boolean disponible = Busqueda.buscarMascota(mascotas, nombre).isAdoptado();
            if(!disponible){
                Busqueda.buscarMascota(mascotas, nombre).setAdoptado(true);
                System.out.println("Felicidades. Cuida mucho de tu nuevo amigo.");
            } else{
                System.out.println("No disponible para su adopcion");
                nombre = "No disponible para su adopcion";
            } 
        } catch(Exception ex) {
            nombre = "0";
            System.out.println("Mascota no encontrada.");
        }
        return nombre;
    }
}