package Tienda;

import java.util.*;
import ManejoArchivos.*;
import Animales.*;
import Utilidades.*;
import Revisiones.*;

public class Tienda {

    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
    	List <Cliente> clientes = new LinkedList<>();
    	clientes = Manejador.cargarClientes("./Archivos/Usrs/usuarios.txt");
    	List <Mascota> mascotas = new LinkedList<>();
    	mascotas = Manejador.cargarMascotas();
    	String usuario;
    	Cliente clienteActual;
		char opc;

		do{
			Menus.principal();
	    	opc = scanner.next().charAt(0);
	    	if(opc == 'S' || opc == 's'){
	    		System.out.print("\nIngresa tu nombre de usuario: ");
	    		scanner.nextLine();
	    		usuario = scanner.nextLine();
	    		int id = Busqueda.buscarCliente(clientes,usuario); 
	    		if(id != -1){
	    			do{
	    				Menus.menuCliente();
	    				opc = scanner.next().charAt(0);
	    				if(opc == 'A' || opc == 'a'){
	    					if(clientes.get(id).getInfoMasc().compareTo("0") == 0){
	    						if(!mascotas.isEmpty()){
		    						String miMasc = Registro.adoptar(mascotas);
		    						if(miMasc.compareTo("No disponible para su adopcion") != 0){
		    							clientes.get(id).setInfoMasc(miMasc);
		    							Manejador.registroC(clientes);
		    							Manejador.registro(mascotas);
		    							System.out.println("Recuerda ser un buen dueno o podremos eliminar tu usuario.");
		    						}
	    						} else {
	    							System.out.println("Aun no tenemos mascotas para adopcion. Regresa pronto.");
	    						}
	    					} else {
	    						System.out.println("Unicamente puedes tener una mascota.");
	    					}
	    				} else if(opc == 'J' || opc == 'j'){
	    					if(clientes.get(id).getInfoMasc().compareTo("0") != 0){
	    						String msc = clientes.get(id).getInfoMasc();
	    						Mascota msco = Busqueda.buscarMascota(mascotas,msc);
	    						Menus.jugar(msco);
	    					} else {
	    						System.out.println("Primero necesitas adoptar una mascota.");
	    					}
	    					
	    				} else if(opc == 'V' || opc == 'v'){
	    					Busqueda.mostrarMascotas(mascotas);
	    					System.out.print("Nombre de la mascota que deseas ver: ");
	    					scanner.nextLine();
	    					String msc = scanner.nextLine();
	    					Mascota msco = Busqueda.buscarMascota(mascotas,msc);
	    					if(msco != null){
	    						Menus.jugar(msco);
	    					}
	    					else
	    						System.out.println("Nombre de la mascota incorrecto.");
	    				} else if(opc != 'E' && opc != 'e'){
	    					System.out.println("Opcion invalida.");
	    				}
	    			}while(opc != 'E' && opc != 'e');
	    			opc = 'D';
	    		}
	    		else
	    			System.out.println("No se ha encontrado el usuario. Intentelo de nuevo.");
	    	} else if(opc == 'N' || opc == 'n'){
	    		System.out.print("Debes realizar tu registro para poder entrar a la tienda. \n");
	    		Registro.registrarUsuario(clientes);
	    		Manejador.registroC(clientes);
	    		System.out.println("Tu usuario se ha registrado correctamente. Responde (S) en el siguiente menu.");
	    	} else if(opc == 'A' || opc == 'a'){	
	    		do{
	    			Menus.menuAdministrador();
	    			opc = scanner.next().charAt(0);
	    			if(opc == 'R' || opc == 'r'){
	    				Registro.registrar(mascotas);
	    				Manejador.registro(mascotas);
	    				System.out.println("Tu mascota se ha registrado correctamente.");
	    			} else if(opc == 'L' || opc == 'l') {
	    				Busqueda.mostrarUsuarios(clientes);
	    				Registro.eliminarUsuario(clientes);
	    				Manejador.registroC(clientes);
	    			} else if(opc != 'E' && opc != 'e'){
	    				System.out.println("Opcion invalida.");
	    			}
	    		}while(opc != 'E' && opc != 'e');
	    		opc = 'D';
	    	} else if(opc != 'E' && opc != 'e'){
	    		System.out.println("Opcion invalida.");
	    	}   
	    }while(opc != 'E' && opc != 'e');
    }
}
