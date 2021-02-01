package Animales;

public class Gato extends Mascota{
    String color;
    
    public Gato(String nombre, int edad, boolean adoptado, String color){
    	super(nombre,"gato",edad,adoptado);
        this.color = color;
    }

    public void jugar(){
    	System.out.println("Miauuuu! \t");
    }

    public String toString(){
    	String sp = super.toString();
        return sp + ", Color: " + color + "|";
    }
}
