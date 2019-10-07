package PRAC1_ex1;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NullPointerException;
import java.io.IOException;

/**
* Class that allows to check that the Team class has been created right!!
* This class has several comments that we think that they will be useful for our students. Please, read all the comments (they are in Spanish).
* @author David García Solórzano
* @version 1.0
*/
public class TeamCheck{

	public static void main(String[] args){
		Team team = null;
		boolean exit = false;
		int operation = 0;
						
		do{
			System.out.println("\n*********Team test***********");
			System.out.println("\n\t1. Create a default team.");
			System.out.println("\n\n\t2. Get team's shortName.");
			System.out.println("\n\n\t3. Set team's shortName.");
			System.out.println("\n\n\t4. Current getter.");
			System.out.println("\n\n\t5. Set team's members.");
			System.out.println("\n\n\t6. Exit.");
			System.out.println("*****************************");
			Scanner in = new Scanner(System.in);
			try{//Como se van a capturar errores, necesitamos poner el código que puede lanzar excepciones dentro de "try" y gestionar los posibles errores dentro de "catch"
				operation = in.nextInt();
			
				switch(operation){
					case 1:
							//Crear team con los valores por defecto
							team = new Team();
							System.out.println(team+" has been created!");
							break;
					case 2:
							//Obtener el valor del nombre corto
							System.out.println("Team's short name is "+team.getShortName());
							break;
					case 3:
							//Asignar el nombre corto del equipo
							System.out.println("Please, type the team's new short name:");	
							in.nextLine(); //bug: to capture the "extra enter"							
							String shortName = in.nextLine();;
							team.setShortName(shortName);						
							break;
					case 4:
							//Cambia getBudget por getLongName, getImageSrc, getPresident, getSponsor, getMembers y getFounded para probar los diferentes getters 
							//System.out.println("team's budget is  "+team.getBudget());
							break;
					case 5:
							//Asignar el numero de socios del equipo
							/*System.out.println("Type the members of the team");
							int value = in.nextInt();
							if(team.setMembers(value)) {
								System.out.println("The team's members is "+team.getMembers());
							}else {
								in.close();
								throw new Exception("Members cannot be a negative value!!");
							}*/
							//////////////team.members = 50;
							break;					
					case 6: 
							//Salir del programa.
							exit = true;
							in.close();
							break;
				}
			}catch(InputMismatchException e1){//Error que se lanza si el valor, en este caso introducido por teclado, no es un número.
				System.err.println("[ERROR] You have to enter a number!!");
			}catch(NullPointerException e2){//Error que se lanza cuando se intenta acceder a un objeto que no ha sido instanciado (i.e. no se ha hecho previamente "new").
				System.err.println("[ERROR] You have to create a team first!!");
			}catch(Exception e3){ //Gestión del error lanzado por el constructor de la clase Team que usa los diferentes setters setShortName, setMembers, setBudget y setFounded, los cuales pueden lanzar una excepción (Ejercicio 2)
				System.err.println("[ERROR] "+e3.getMessage());
			}
			
			if(operation!=6){				
				System.out.println("\nPress Enter to continue...");
				try{
					/*
						Como el método "read" puede lanzar una excepción (su implementación tiene un "throws IOException" (IOException es un caso particular de Exception), ponemos la línea dentro de try
						y gestionamos el error dentro del catch. Si en el catch, en vez de IOException ponemos Exception, también funcionará por el concepto de herencia (lo veremos más adelante en los apuntes).
					*/
					System.in.read();
				}catch(IOException enterError){
					System.err.println("[ERROR] Keyboard input throwed an exception!!");
				}			
			}			
			
		}while(!exit);
		System.out.println("Bye!!");
	}	
}