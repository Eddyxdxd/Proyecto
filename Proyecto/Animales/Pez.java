package Animales;

public class Pez extends Mascota{
    String sexo;

    public Pez(String nombre, int edad, boolean adoptado, String sexo){
    	super(nombre,"pez",edad,adoptado);
    	this.sexo = sexo;
    }

    public void jugar(){
    	System.out.println("oOo Swoosh oOo");
    }

    public String toString(){
    	String sp = super.toString();
        return sp + ", Sexo: " + sexo + "|";
    }
}