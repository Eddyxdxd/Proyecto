package Revisiones;

import java.util.*;

public class Revisar{
	
	public void revisaRaza(String raza) throws RazaNotFound{
		List<String> razas = new ArrayList<>();
    	razas.add("Snauzer");
    	razas.add("Basenji");
    	razas.add("Bull Dog");
    	razas.add("Labrador");
    	razas.add("Pastor Aleman");
    	razas.add("Salchicha");

		Boolean correcto = razas.contains(raza);
		if(!correcto)
			throw new RazaNotFound();
	}
}
