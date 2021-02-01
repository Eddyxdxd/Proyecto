package Animales;

import java.io.*;

public class Mascota implements Serializable{
    String nombre;
    String animal;
    int edad;
    boolean adoptado;

    Mascota(String nombre, String animal, int edad, boolean adoptado){
        this.nombre = nombre;
    	this.animal = animal;
    	this.edad = edad;
    	this.adoptado = adoptado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public String toString() {
        return "| Nombre: " + nombre + ", Mascota: " + animal + ", Edad: " + edad + ", Adoptado: " + Boolean.toString(adoptado);
    }

    public void comer(){
    	System.out.println("Nam Nam Nam\t");
    }

}