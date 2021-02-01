package Utilidades;

import Tienda.*;
import Animales.*;
import java.util.*;

public class Busqueda{
	public static int buscarCliente(List <Cliente> clientes, String nombre){
		int index = 0;
		for(Cliente cl : clientes){
			if(cl.getNombreUsuario().compareTo(nombre) == 0){
				return index;
			}
			index ++;
		}
		return -1;
	}

	public static Mascota buscarMascota(List <Mascota> mascotas, String nombre){
		Mascota ult = null;
		for(Mascota msc : mascotas)
			if(msc.getNombre().compareTo(nombre) == 0){
				return msc;
			}
		return ult;
	}

	public static void mostrarMascotas(List <Mascota> mascotas){
		System.out.println("Actualmente existen estas mascotas, recuerda que solo puedes adoptar las que posean un estado de adopcion falso.");
		for(Mascota msc : mascotas){
				if(msc instanceof Perro){
					Perro p = (Perro)msc;
					System.out.println(p.toString());
				} else if(msc instanceof Gato){
					Gato g = (Gato)msc;
					System.out.println(g.toString());
				} else {
					Pez pz = (Pez)msc;
					System.out.println(pz.toString());
				}
		}
	}

	public static void mostrarUsuarios(List <Cliente> clientes){
		System.out.println("Nombres de usuario:");
		for(Cliente cl : clientes)
			System.out.println("|" + cl.getNombreUsuario() + "|");
	}
}