package Animales;

public class Perro extends Mascota{
    String raza;

    public Perro(String nombre, int edad, boolean adoptado,String raza){
    	super(nombre,"perro",edad,adoptado);
    	this.raza = raza;
    }

    public void jugar(){
    	System.out.println("Guaf Guaf! \t");
    }

    public String getRaza(){
        return raza;
    }

    public String toString(){
        String sp = super.toString();
        return sp + ", Raza: " + raza + "|";
    }
}
