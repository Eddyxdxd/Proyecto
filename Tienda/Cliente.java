package Tienda;

import java.util.*;
import Animales.*;
import ManejoArchivos.*;
import java.io.*;

public class Cliente implements Serializable{
	transient Scanner scanner = new Scanner(System.in);
	String nombreUsuario;
	String nombre;
	String infoMasc;

	public Cliente(String nombreUsuario, String nombre){
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
        this.infoMasc = "0";
	}

	public Cliente(){

	}

	public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfoMasc() {
        return infoMasc;
    }

    public void setInfoMasc(String infoMasc) {
        this.infoMasc = infoMasc;
    }

}