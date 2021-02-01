package Revisiones;

import java.util.*;

public class RazaNotFound extends Exception{

    public RazaNotFound(){
        List<String> razas = new ArrayList<>();
        razas.add("Snauzer");
        razas.add("Basenji");
        razas.add("Bull Dog");
        razas.add("Labrador");
        razas.add("Pastor Aleman");
        razas.add("Salchicha");
        System.out.println("No podemos permitir esa raza, no contamos con los especialistas para ello");
    	System.out.println("Se pueden registrar las siguientes razas: ");
        for(String rz: razas)
            System.out.print("|" + rz + "|");
        System.out.println("");
    }
    
}