package Utilidades;

import ManejoArchivos.*;
import Animales.*;
import Tienda.*;
import ManejoArchivos.*;

public class Menus{
	private static boolean inicio = true;

	public static void principal(){
		if(inicio == true){
			Manejador.imprimir("./Archivos/Tienda.txt");
			inicio = false;
		}
    	System.out.println("Bienvenido a nuestra tienda de mascotas!");
    	System.out.println("Haz comprado anteriormente con nosotros? (S)Si (N)No (E)Salir (A)Ingresar como administrador");
	}

	public static void menuAdministrador(){
		System.out.println("(R)Registrar mascota.");
		System.out.println("(L)Eliminar cliente.");
		System.out.println("(E)Regresar.");
	}

	public static void menuCliente(){
		System.out.println("Bienvenido, que deseas hacer?");
		System.out.println("(A)Adoptar mascota.");
		System.out.println("(V)Ver mascotas.");
		System.out.println("(J)Jugar con mi mascota.");
		System.out.println("(E)Regresar.");
	}

	public static void jugar(Mascota masc){
		String animal = masc.getAnimal();
		String ruta = "./Archivos/Img/";
		switch(animal){
			case "perro":
				Perro p = (Perro) masc;
				ruta = ruta + p.getRaza() + ".txt";
				Manejador.imprimir(ruta);
				p.jugar();
				break;
			case "gato":
				Gato g = (Gato) masc;
				ruta = ruta + animal + ".txt";
				g.jugar();
			case "pez":
				Pez pz = (Pez) masc;
				ruta = ruta + animal + ".txt";
				pz.jugar();
			default:
				System.out.println("Tu amigo no se encuentra.");
		}
	}
}