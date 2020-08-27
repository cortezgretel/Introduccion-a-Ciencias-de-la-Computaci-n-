/**
 * PROYECTO 4 ICC
 * Clase Fabrica
 * @author Gretel Penelope Cruz Macias.
 * @author Valeria Fernanda Manjarrez Angeles
 * @version 1.0 
 */
import java.io.*;
import java.util.Scanner; 
public class Fabrica{

	/** Catalogo que es una lista. */
	public Lista catalogo= new Lista();

	/** Nombre de la fabrica. */
	public String nombreDeFabrica;

	/** Alebrije global. */
	public Alebrije global = null;

	/** Arreglo de colores disponibles. */
	public final String[] color = {"Rojo", "Amarillo", "Azul", "Verde", "Naranja", "Morado", "Rosa" , "Negro" , "Blanco"};
	
	/** 
	 * Metodo que muestra la paleta de colores.
	*/
	public static void paleta(String[] paleta){

		System.out.println("~~~~~~~~~~~~PALETA DE COLORES~~~~~~~~~~~~");
		int i;
		for(i = 0; i < paleta.length; i++){
			System.out.println("Color " + i + ": " + paleta[i]);
		}
	}

   	/**
  	 * Metodo que permite leer las lineas de un catalogo en un archivo. 
   	 * @param archivo Una cadena con el nombre del archivo
   	*/
   	public void lecturaCatalogo(String archivo){

   		try{
   			catalogo = new Lista();
      		Reader fr = new FileReader(archivo); //Creamos el archivo de lectura
      		BufferedReader bfr = new BufferedReader(fr); //Creamos el buffer de lectura
      		String linea, cad[];
      		linea = bfr.readLine(); //Leemos la primera linea
      		while(linea != null){ //Mientras no lleguemos al EOF
        		cad = linea.split(","); //Separamos la cadena
        		if(cad.length == 4){
         			catalogo.agregar(new Animal(cad[0], //animal
               		Integer.parseInt(cad[1]), //patas
                    Boolean.parseBoolean(cad[2]), //cola (boolean)
                    cad[3]));//color
        		}
        		if(cad.length == 7){
        			catalogo.agregar(new Animal(cad[0], //animal
               		Integer.parseInt(cad[1]), //patas
                	Boolean.parseBoolean(cad[2]), //cola (boolean)
                	cad[3],//color cabeza
                	cad[4],// color cuerpo
                	cad[5],// color pata
                	cad[6]));//color cola 
        		}
        		linea = bfr.readLine(); //Leemos la siguiente lÌnea
      		}
      }catch(FileNotFoundException n){
      	System.out.println("\n"+"No se encontro el archivo");
      }catch(Exception e){
      	System.out.println("\n"+"Ocurrio un problema en la lectura");
      }
   	}
  
  	/**
   	 * Metodo que permite almacenar el catalogo en un archivo de texto.
   	 * @param archivo el nombre del archivo a almacenar.
   	*/
   	public void guardarCatalogo(String archivo){

   		try{
      		Writer fw = new FileWriter(archivo); //Creamos el archivo de escritura
      		BufferedWriter bfw = new BufferedWriter(fw); //Creamos el buffer de escritura
      		String linea = "";
      		for(int i = 0; i < catalogo.tamanio ; i++){
            	Animal animal = catalogo.obten(i); 
            	if(animal != null){
            	linea += animal.getNombre() + "," + animal.getNumeroDePatas() + "," + animal.getTieneCola() + "," + animal.getColorCabeza()  + "," + animal.getColorCuerpo()  + "," + animal.getColorPata()  + "," + animal.getColorCola();
            	}
            	linea += "\n";
        	}
      		fw.write(linea); //Imprimimos la linea actual
      		fw.close(); //Cerramos el flujo de escritura
    	}catch(Exception e){
    		System.out.println("\n"+"Ocurrió un problema en la escritura");
    	}
   	}	

   	/**
   	* Metodo que permite leer las lineas de un alebrije en un archivo 
   	* @param archivo Una cadena con el nombre del archivo.
   	* @throws FileNotFoundException En caso de que el archivo no se encuentre.
   	* @throws IOException En caso de que hubiera problemas con el flujo.
   	*/
   	public Alebrije lecturaAlebrije(String archivo){

   		Alebrije lecturaAlebrije = null;
   		try{
   			Reader fr = new FileReader(archivo); //Creamos el archivo de lectura
      		BufferedReader bfr = new BufferedReader(fr); //Creamos el buffer de lectura
      		String linea;
      		linea = bfr.readLine(); //Leemos la primera linea
      		while(linea != null){ //Mientras no lleguemos al EOF
      			//tipo de cabeza
      			int cabezaIn = linea.indexOf(":");
      			int cabezaFin = linea.indexOf(",");
      			String tipoCabezaS = linea.substring(cabezaIn+1, cabezaFin);
      			Animal tipoCabeza = new Animal(tipoCabezaS); 
      			//color cabeza
      			int colorCabezaIn = linea.indexOf(":",cabezaFin+1);
      			int colorCabezaFin = linea.indexOf(",",cabezaFin+1); 
      			String colorCabeza = linea.substring(colorCabezaIn+1,colorCabezaFin);
      			//tipo de cola
      			int colaIn = linea.indexOf(":", colorCabezaFin+1);
      			int colaFin = linea.indexOf(",", colorCabezaFin+1);
      			String tipoColaS = linea.substring(colaIn+1,colaFin);
      			Animal tipoCola = new Animal(tipoColaS);
      			//color cola
      			int colorColaIn = linea.indexOf(":" , colaFin +1);
      			int colorColaFin = linea.indexOf("," , colaFin +1);
      			String colorCola = linea.substring(colorColaIn+1,colorColaFin);
      			//tipo de pata 
      			int pataIn = linea.indexOf(":", colorColaFin+1);
      			int pataFin = linea.indexOf(",", colorColaFin +1);
      			String tipoPataS = linea.substring(pataIn+1, pataFin);
      			Animal tipoPata = new Animal(tipoPataS);
      			//color pata 
      			int colorPataIn = linea.indexOf(":", pataFin+1);
      			int colorPataFin = linea.indexOf(",", pataFin+1);
      			String colorPata = linea.substring(colorPataIn+1,colorPataFin);
      			//tipo cuerpo 
      			int cuerpoIn = linea.indexOf(":", colorPataFin+1);
      			int cuerpoFin = linea.indexOf(",", colorPataFin+1);
      			String tipoCuerpoS = linea.substring(cuerpoIn+1,cuerpoFin);
      			Animal tipoCuerpo = new Animal(tipoCuerpoS);
      			//color cuerpo
      			int colorCuerpoIn = linea.indexOf(":",cuerpoFin+1);
      			int colorCuerpoFin = linea.indexOf(",",cuerpoFin+1);
      			String colorCuerpo = linea.substring(colorCuerpoIn+1,colorCuerpoFin);
      			lecturaAlebrije = new Alebrije(tipoCabeza, colorCabeza, tipoCola, colorCola, tipoPata, colorPata , tipoCuerpo, colorCuerpo);
         		linea = bfr.readLine(); //Leemos la siguiente lÌnea
			}
      	}catch(FileNotFoundException n){
      		System.out.println("\n"+"No se encontro el archivo");
      	}catch(Exception e){
      		System.out.println("\n"+"Ocurrio un problema en la lectura");
      	}
      	return lecturaAlebrije;
   	}

   	/**
   	 * Metodo que permite almacenar el alebrije en un archivo de texto.
   	 * @param archivo el nombre del archivo a almacenar.
   	*/
   	public void guardarAlebrije(String archivo, Alebrije modificado ){

   		try{
      		Writer fw = new FileWriter(archivo); //Creamos el archivo de escritura
      		BufferedWriter bfw = new BufferedWriter(fw); //Creamos el buffer de escritura
      		String linea = ""; 
        	linea += "CABEZA DE: "+ modificado.getCabeza() + "," +"COLOR CABEZA: " + modificado.getColorCabeza() + "," + "COLA DE: " + modificado.getCola() + "," + "COLOR COLA: "  + modificado.getColorCola()  + "," 
        			 + "PATAS DE: " + modificado.getPata()  + "," + "COLOR PATAS: " + modificado.getColorPata() + "," + "CUERPO DE: " + modificado.getCuerpo() + ","+"COLOR CUERPO: " + modificado.getColorCuerpo() +"," ;
      		fw.write(linea); //Imprimimos la linea actual
      		fw.close(); //Cerramos el flujo de escritura
    	}catch(Exception e){
    		System.out.println("\n"+"Ocurrió un problema en la escritura");
    	}
   	}
	
	/**
   	 * Metodo que muestra y realiza las acciones de una fabrica.
   	*/
	public void menu(){

		Scanner usuario = new Scanner(System.in);
		int opcion;
		do{
			System.out.println("\n"+"Selecciona la opcion que quieres realizar:" + "\n");
			System.out.println("Introduce 1 para agregar un animal.");
			System.out.println("Introduce 2 para eliminar un animal.");
			System.out.println("Introduce 3 para modificar un animal.");
			System.out.println("Introduce 4 para crear un alebrije."); // quieres cargar un pedido o hacer uno nuevo 
			System.out.println("Introduce 5 para guardar el catalogo existente.");
			System.out.println("Introduce 6 para modificar un Alebrije.");//cargar el archivo  
			System.out.println("Introduce 7 para cerrar y salir de la fabrica.");
			while(true){
				if(!usuario.hasNextInt()){
					System.out.println("\n" + "La opcion debe ser un NUMERO");
					usuario.nextLine();
					continue;
				}
				opcion = usuario.nextInt();
				if(opcion > 8 || opcion < 1){
					System.out.println("\n" + "Elige una opcion del 1 al 5");
					usuario.nextLine();
					continue;
				}	
				break;
			}
			usuario.nextLine();
			switch(opcion){

				case 1 :

					Animal usuarioAnimal = null;
					System.out.println("\n" + "**** Usted escogio la opcion 1 ----> AGREGAR UN ANIMAL ****");
					System.out.println("\n" +"Introduzca el animal que desea agregar");
					String animal = usuario.nextLine();
					System.out.println("\n" +"Los colores disponibles son:" + "\n");
					paleta(this.color);
					System.out.println("\n" +"Introduzca el indice del color para el animal");
					int colorAgrega;
					while(true){
						if(!usuario.hasNextInt()){
							System.out.println("\n" + "La opcion debe ser un NUMERO");
							usuario.nextLine();
							continue;
						}
						colorAgrega = usuario.nextInt();
						if(colorAgrega > 8 || colorAgrega < 0){
							System.out.println("\n" + "Elige una opcion del 0 al 8");
							usuario.nextLine();
							continue;
						}	
						break;
					}
					usuario.nextLine();
					System.out.println("\n" +"¿Cuantas patas tiene el animal?  ");
					int pata;
					while(true){
						if(!usuario.hasNextInt()){
							System.out.println("\n" + "La opcion debe ser un NUMERO");
							usuario.nextLine();
							continue;
						}
						pata = usuario.nextInt();
						if(pata > 800 || opcion < 0){
							System.out.println("\n" + "Elige una opcion del 0 al 800");
							usuario.nextLine();
							continue;
						}	
						break;
					}
					usuario.nextLine();
					System.out.println("\n" + "¿El animal tiene cola? si = s , no = n");
					String cola = usuario.next();
					while (!cola.equals("s") && !cola.equals("n")){
						System.out.println("\n" + "Opcion no valida, solo es 's' o 'n' ");
						cola = usuario.next();
					}
					if (cola.equals("s")){
						Animal usuarioAnimal1 = new Animal(animal,pata,true,this.color[colorAgrega]);
						usuarioAnimal=usuarioAnimal1;
					}
					if (cola.equals("n")){
						Animal usuarioAnimal4 = new Animal(animal,pata ,false,this.color[colorAgrega]);
						usuarioAnimal=usuarioAnimal4;
					}
					System.out.println("\n" + "El animal " + animal + " ha sido agregado al catalogo" + "\n");
					this.catalogo.agregar(usuarioAnimal);
					this.catalogo.muestra();
				break;

				case 2 :

					System.out.println("\n" + "**** Usted escogio la opcion 2 ----> ELIMINAR UN ANIMAL ****");
					System.out.println("\n" + "Introduzca el indice del animal que desea eliminar ");
					int indice;
					while(true){
						if(!usuario.hasNextInt()){
							System.out.println("\n" + "La opcion debe ser un NUMERO");
							usuario.nextLine();
							continue;
						}
						indice = usuario.nextInt();
						if(indice < 0 || indice > this.catalogo.tamanio-1){
							System.out.println("\n" + "Elige un indice valido");
							usuario.nextLine();
							continue;
						}	
						break;
					}
					usuario.nextLine();
					this.catalogo.elimina(indice);
					System.out.println("\n" + "El animal ha sido eliminado satisfactoriamente" + "\n");
					this.catalogo.muestra();
				break;

				case 3 : 

					System.out.println("\n" + "**** Usted escogio la opcion 3 ----> MODIFICAR UN ANIMAL ****");
					System.out.println("\n" + "Introduzca el indice del animal que desea modificar");
					int indiceModifica;
					while(true){
						if(!usuario.hasNextInt()){
							System.out.println("\n" + "La opcion debe ser un NUMERO");
							usuario.nextLine();
							continue;
						}
						indiceModifica = usuario.nextInt();
						if(indiceModifica < 0 || indiceModifica > this.catalogo.tamanio-1){
							System.out.println("\n" + "Elige un indice valido");
							usuario.nextLine();
							continue;
						}	
						break;
					}
					usuario.nextLine();
					Animal modificado = null;
					System.out.println("\n" + "¿Deseas modificar al animal o una parte? a = animal , p = parte");
					String modificaAnimal  = usuario.next();
					usuario.nextLine();
					while (!modificaAnimal.equals("a") && !modificaAnimal.equals("p")){
						System.out.println("\n" + "Opcion no valida, solo es 'a' o 'p' ");
						modificaAnimal = usuario.next();
						usuario.nextLine();
					}
					if (modificaAnimal.equals("a")){
						System.out.println("\n" + "----Escogiste modificar al animal, introduzca el nombre del nuevo animal----");
						String nuevoAnimal = usuario.nextLine();
						this.catalogo.elimina(indiceModifica);
						System.out.println("\n" +"Los colores disponibles son:" + "\n");
						paleta(this.color);
						System.out.println("\n" + "Introduzca el indice del color para el animal");
						int colorModifica;
						while(true){
							if(!usuario.hasNextInt()){
							System.out.println("\n" + "La opcion debe ser un NUMERO");
							usuario.nextLine();
							continue;
							}
							colorModifica= usuario.nextInt();
							if(colorModifica < 0 || colorModifica > 8){
								System.out.println("\n" + "Elige una opcion del 1 al 8");
								usuario.nextLine();
								continue;
							}	
							break;
						}
						usuario.nextLine();
						System.out.println("\n" + "¿Cuantas patas tiene el animal? ");
						int pataMod;
						while(true){
							if(!usuario.hasNextInt()){
								System.out.println("\n" + "La opcion debe ser un NUMERO");
								usuario.nextLine();
								continue;
							}
							pataMod = usuario.nextInt();
							if(pataMod < 0 || pataMod > 800){
								System.out.println("\n" + "Elige una opcion del 1 al 800");
								usuario.nextLine();
								continue;
							}	
							break;
						}
						usuario.nextLine();
						System.out.println("\n" + "¿El animal tiene cola? si = s , no = n");
						String colaMod = usuario.next().toLowerCase();
						while (!colaMod.equals("s") && !colaMod.equals("n")){
							System.out.println("\n" + "Opcion no valida, solo es 's' o 'n' ");
							colaMod = usuario.next();
						}
						if (colaMod.equals("s")){
							Animal usuarioAnimalMod = new Animal (nuevoAnimal,pataMod,true,this.color[colorModifica]);
							modificado = usuarioAnimalMod ;
						}
						if (colaMod.equals("n")){
							Animal usuarioAnimalMod2 = new Animal(nuevoAnimal, pataMod ,false,this.color[colorModifica]);
							modificado = usuarioAnimalMod2;
						}
						this.catalogo.inserta(modificado,indiceModifica);
					}
					if (modificaAnimal.equals("p")){
						this.catalogo.obten(indiceModifica);
						System.out.println("\n" + "----Introduzca la parte del animal que desea modificar----" + "\n");
						System.out.println("1. Cabeza " + "\n" + "2. Cuerpo " + "\n" + "3. Patas " + "\n" + "4. Cola ");
						int parte;
						while(true){
							if(!usuario.hasNextInt()){
								System.out.println("\n" + "La opcion debe ser un NUMERO");
								usuario.nextLine();
								continue;
							}
							parte = usuario.nextInt();
							if(parte < 0 || parte > 4){
								System.out.println("\n" + "Elige una opcion del 1 al 4");
								usuario.nextLine();
								continue;
							}	
							break;
						}
						usuario.nextLine();
						switch(parte){

							case 1 : 

								System.out.println("\n" + "<<<Modificar Cabeza>>>");
								System.out.println("\n" +"Los colores disponibles son:" + "\n");
								paleta(this.color);
								System.out.println("\n" + "Introduzca el indice del color para la cabeza");
								int colorCabezaMod;
								while(true){
									if(!usuario.hasNextInt()){
										System.out.println("\n" + "La opcion debe ser un NUMERO");
										usuario.nextLine();
										continue;
									}
									colorCabezaMod= usuario.nextInt();
									if(colorCabezaMod < 0 || colorCabezaMod > 8){
										System.out.println("\n" + "Elige una opcion del 1 al 8");
										usuario.nextLine();
										continue;
									}	
									break;
								}
								usuario.nextLine();
								this.catalogo.obten(indiceModifica).setColorCabeza(this.color[colorCabezaMod]);
							break;

							case 2:

								System.out.println("\n" + "<<<Modificar Cuerpo>>>");
								System.out.println("\n" +"Los colores disponibles son:" + "\n");
								paleta(this.color);
								System.out.println("\n" +"Introduzca el indice del color para el cuerpo");
								int colorCuerpoMod;
								while(true){
									if(!usuario.hasNextInt()){
										System.out.println("\n" + "La opcion debe ser un NUMERO");
										usuario.nextLine();
										continue;
									}
									colorCuerpoMod= usuario.nextInt();
									if(colorCuerpoMod < 0 || colorCuerpoMod> 8){
										System.out.println("\n" + "Elige una opcion del 1 al 8");
										usuario.nextLine();
										continue;
									}	
									break;
								}
								usuario.nextLine();
								this.catalogo.obten(indiceModifica).setColorCuerpo(this.color[colorCuerpoMod]);
							break;

							case 3:

								System.out.println("\n" + "<<<Modificar Patas>>>");
								System.out.println("\n" +"¿Quiere cambiar el número de patas o el color de las patas? numero = n , color = c ");
								String pataModifica = usuario.next().toLowerCase();
								usuario.nextLine();
								while (!pataModifica.equals("n") && !pataModifica.equals("c")){
									System.out.println("\n" + "Opcion no valida, solo es 'n' o 'c'");
									pataModifica = usuario.next();
									usuario.nextLine();
								}
								if (pataModifica.equals("c")){
									System.out.println("\n" +"Los colores disponibles son:" + "\n");
									paleta(this.color);
									System.out.println("\n" + "Introduzca el indice del color para las patas");
									int colorPataMod;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										colorPataMod= usuario.nextInt();
										if(colorPataMod < 0 || colorPataMod > 8){
											System.out.println("\n" + "Elige una opcion del 1 al 8");
											usuario.nextLine();
											continue;
										}	
										break;
									}
									usuario.nextLine(); 
									this.catalogo.obten(indiceModifica).setColorPata(this.color[colorPataMod]);
								}
								if (pataModifica.equals("n")){
									System.out.println("\n" + "¿Cuantas patas tiene el animal?");
									int pataNumeroModifica;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										pataNumeroModifica = usuario.nextInt();
										if(pataNumeroModifica < 0 || pataNumeroModifica > 800){
											System.out.println("\n" + "Elige una opcion del 1 al 800");
											usuario.nextLine();
											continue;
										}		
										break;
									}
									usuario.nextLine();
									this.catalogo.obten(indiceModifica).setNumeroDePatas(pataNumeroModifica);
								}
							break;

							case 4 : 	

								System.out.println("\n" +"<<<Modificar Cola>>>");
								System.out.println("\n" +"Los colores disponibles son:" + "\n");
								paleta(this.color);
								System.out.println("\n" + "Introduzca el indice del color para la cola");
								int colorColaMod;
								while(true){
									if(!usuario.hasNextInt()){
										System.out.println("\n" + "La opcion debe ser un NUMERO");
										usuario.nextLine();
										continue;
									}
									colorColaMod = usuario.nextInt();
									if(colorColaMod < 0 || colorColaMod > 8){
										System.out.println("\n" + "Elige una opcion del 1 al 8");
										usuario.nextLine();
										continue;
									}	
									break;
								}
								usuario.nextLine(); 
								this.catalogo.obten(indiceModifica).setColorCola(this.color[colorColaMod]);
							break;
						}
					}
					this.catalogo.muestra();
				break;

				case 4: 

					System.out.println ("\n" +"**** Usted escogio la opcion 4 ----> CREAR UN ALEBRIJE ****");
					System.out.println ("\n" + "¿Quieres cargar un pedido de un alebrije desde un archivo o crearlo desde la consola?" + "\n");
					System.out.println ("1. Cargar un pedido de un archivo");
					System.out.println ("2. Crearlo");
					int opcionAlebrije;
					while(true){
						if(!usuario.hasNextInt()){
							System.out.println("\n" + "La opcion debe ser un NUMERO");
							usuario.nextLine();
							continue;
						}
						opcionAlebrije = usuario.nextInt();
						if(opcionAlebrije!= 1 && opcionAlebrije!= 2){
							System.out.println("\n" + "Elige una opcion valida");
							usuario.nextLine();
							continue;
						}	
						break;
					}
					usuario.nextLine();
					if(opcionAlebrije==2){
						System.out.println ("\n" +"Te presentamos el catalogo de animales y la paleta de colores"+ "\n");
						this.catalogo.muestra();
						paleta(this.color);
						System.out.println ("\n" + "¿De que animal quieres la cabeza del alebrije? Introduzca el indice");
						int indiceCabeza;
						while(true){
							if(!usuario.hasNextInt()){
								System.out.println("\n" + "La opcion debe ser un NUMERO");
								usuario.nextLine();
								continue;
							}
							indiceCabeza = usuario.nextInt();
							if(indiceCabeza < 0 || indiceCabeza > this.catalogo.tamanio-1){
								System.out.println("\n" + "Elige un indice valido");
								usuario.nextLine();
								continue;
							}	
							break;
						}
						usuario.nextLine(); 
						System.out.println("\n" + "¿De que animal quieres el cuerpo del alebrije? Introduzca el indice");
						int indiceCuerpo;
						while(true){
							if(!usuario.hasNextInt()){
								System.out.println("\n" + "La opcion debe ser un NUMERO");
								usuario.nextLine();
								continue;
							}
							indiceCuerpo = usuario.nextInt();
							if(indiceCuerpo< 0 || indiceCuerpo > this.catalogo.tamanio-1){
								System.out.println("\n" + "Elige un indice valido");
								usuario.nextLine();
								continue;
							}	
							break;
						}
						usuario.nextLine();
						System.out.println("\n" + "¿De que animal quieres la cola del alebrije? Introduzca el indice");
						int indiceCola;
						while(true){
							if(!usuario.hasNextInt()){
								System.out.println("\n" + "La opcion debe ser un NUMERO");
								usuario.nextLine();
								continue;
							}
							indiceCola = usuario.nextInt();
							if(indiceCola < 0 || indiceCola > this.catalogo.tamanio-1){
								System.out.println("\n" + "Elige un indice valido");
								usuario.nextLine();
								continue;
							}	
							break;
						}
						usuario.nextLine();
						System.out.println("\n" + "¿De que animal quieres las patas del alebrije? Introduzca el indice");
						int indicePata;
						while(true){
							if(!usuario.hasNextInt()){
								System.out.println("\n" + "La opcion debe ser un NUMERO");
								usuario.nextLine();
								continue;
							}
							indicePata = usuario.nextInt();
							if(indicePata < 0 || indicePata > this.catalogo.tamanio-1){
								System.out.println("\n" + "Elige un indice valido");
								usuario.nextLine();
								continue;
							}	
							break;
						}
						usuario.nextLine();
						Alebrije usuarioAlebrije = new Alebrije (this.catalogo.obten(indiceCabeza),this.catalogo.obten(indiceCabeza).getColorCabeza() ,this.catalogo.obten(indiceCola),this.catalogo.obten(indiceCola).getColorCola(),this.catalogo.obten(indicePata),this.catalogo.obten(indicePata).getColorPata(),this.catalogo.obten(indiceCuerpo),this.catalogo.obten(indiceCuerpo).getColorCuerpo());
						System.out.println("\n" + "El alebrije ha sido creado satisfactoriamente" + "\n");
						usuarioAlebrije.muestra();
						System.out.println("Ingrese el nombre del archivo donde guardar su alebrije. Ejemplo: Nombre.txt ");
						String nombreArchivo = usuario.next();
						global = usuarioAlebrije;
						this.guardarAlebrije(nombreArchivo, global);
						System.out.println("\n" + "El alebrije ha sido guardado exitosamente en su archivo." + "\n");
					}
					if(opcionAlebrije==1){
						System.out.println("\n" + "Ingrese el nombre del archivo desde donde esta realizando su pedido. Ejemplo: Nombre.txt");
						String archivoPedido = usuario.next();
						Alebrije usuarioAlebrije = this.lecturaAlebrije(archivoPedido);
						if(usuarioAlebrije != null) {
							System.out.println("\n" + "El alebrije ha sido creado satisfactoriamente." + "\n");
							usuarioAlebrije.muestra();
							global = usuarioAlebrije;
							this.guardarAlebrije(archivoPedido, global);
							System.out.println("El alebrije ha sido guardado exitosamente en su archivo de origen.");
						}
					}
				break;

				case 5:

					System.out.println ("\n" +"**** Usted escogio la opcion 5 ----> GUARDAR EL CATALOGO EXISTENTE ****");
					System.out.println("\n" + "El catalogo se esta guardando ...");
					System.out.println("\n" + "Cargando ...");
					if(this.nombreDeFabrica.equals("Mexicana")){
						this.guardarCatalogo("CatalogoMexicano.txt");
					}
					if(this.nombreDeFabrica.equals("China")){
						this.guardarCatalogo("CatalogoChino.txt");
					}
					System.out.println("\n" + "El catalogo ha sido guardado exitosamente");
				break;

				case 6: //alebrije que se reciba se modifica y se guarda en una variable global 
				
					System.out.println("\n" + "**** Usted escogio la opcion 6 ----> MODIFICAR UN ALEBRIJE ****");
					System.out.println("\n" + "Ingrese el nombre del archivo donde se encuentra el alebrije a modificar. Ejemplo: Nombre.txt");
					String archivoAlebrije = usuario.next();
					Alebrije actualizado= this.lecturaAlebrije(archivoAlebrije);
					if(actualizado != null){
						System.out.println();
						actualizado.muestra();
						System.out.println("¿Qué parte del alebrije deseas modificar?");
						System.out.println("1. Cabeza" + "\n" + "2. Cuerpo" + "\n" + "3. Patas" + "\n" + "4. Cola");
						int parteModAlebrije;
						while(true){
							if(!usuario.hasNextInt()){
								System.out.println("\n" + "La opcion debe ser un NUMERO");
								usuario.nextLine();
								continue;
							}
							parteModAlebrije = usuario.nextInt();
							if(parteModAlebrije < 0 || parteModAlebrije > 4){
								System.out.println("\n" + "Elige una opcion del 1 al 4");
								usuario.nextLine();
								continue;
							}	
							break;
						}
						usuario.nextLine();
						switch(parteModAlebrije){

							case 1: 

								System.out.println("\n" + "<<<Modificar Cabeza>>>");
								System.out.println("\n" + "¿Deseas modificar el animal de la cabeza o el color de la cabeza? animal = a , color = c");
								String cabezaOpcion = usuario.next().toLowerCase();
								while (!cabezaOpcion.equals("a") && !cabezaOpcion.equals("c")){
									System.out.println("\n" + "Opcion no valida, solo es 'a' o 'c' ");
									cabezaOpcion = usuario.next().toLowerCase();
								}
								if(cabezaOpcion.equals("a")){
									this.catalogo.muestra();
									System.out.println("Introduzca el indice del animal del que quieres la cabeza");
									int indiceCabezaA;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										indiceCabezaA = usuario.nextInt();
										if(indiceCabezaA < 0 || indiceCabezaA > this.catalogo.tamanio-1){
											System.out.println("\n" + "Elige un indice valido");
											usuario.nextLine();
											continue;
										}
										break;
									}
									usuario.nextLine();
									String nuevaCabeza = this.catalogo.obten(indiceCabezaA).getNombre();
									actualizado.setCabeza(nuevaCabeza);
								}
								if(cabezaOpcion.equals("c")){
									paleta(this.color);
									System.out.println("Introduzca el indice del color para la cabeza");
									int indiceColorCabezaA;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										indiceColorCabezaA = usuario.nextInt();
										if(indiceColorCabezaA < 0 || indiceColorCabezaA > 8){
											System.out.println("\n" + "Elige una opcion del 1 al 8");
											usuario.nextLine();
											continue;
										}
									break;
									}
									usuario.nextLine();
									actualizado.setColorCabeza(this.color[indiceColorCabezaA]);
								}
							break;

							case 2:

								System.out.println("\n" + "<<<Modificar Cuerpo>>>");
								System.out.println("\n" + "¿Deseas modificar el animal del cuerpo o el color del cuerpo? animal = a , color = c");
								String cuerpoOpcion = usuario.next().toLowerCase();
								while (!cuerpoOpcion.equals("a") && !cuerpoOpcion.equals("c")){
									System.out.println("\n" + "Opcion no valida, solo es 'a' o 'c' ");
									cuerpoOpcion = usuario.next().toLowerCase();
								}
								if(cuerpoOpcion.equals("a")){
									this.catalogo.muestra();
									System.out.println("Introduzca el indice del animal del que quieres el cuerpo");
									int indiceCuerpoA;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										indiceCuerpoA = usuario.nextInt();
										if(indiceCuerpoA < 0 || indiceCuerpoA > this.catalogo.tamanio-1){
											System.out.println("\n" + "Elige un indice valido");
											usuario.nextLine();
											continue;
										}
										break;
									}
									usuario.nextLine();
									String nuevoCuerpo = this.catalogo.obten(indiceCuerpoA).getNombre();
									actualizado.setCuerpo(nuevoCuerpo);
								}
								if(cuerpoOpcion.equals("c")){
									paleta(this.color);
									System.out.println("Introduzca el indice del color para el cuerpo");
									int indiceColorCuerpoA;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										indiceColorCuerpoA = usuario.nextInt();
										if(indiceColorCuerpoA < 0 || indiceColorCuerpoA > 8){
											System.out.println("\n" + "Elige una opcion del 1 al 8");
											usuario.nextLine();
											continue;
										}
									break;
									}
									usuario.nextLine();
									actualizado.setColorCuerpo(this.color[indiceColorCuerpoA]);
								}
							break;

							case 3:

								System.out.println("\n" + "<<<Modificar Patas>>>");
								System.out.println("\n" + "¿Deseas modificar el animal de las patas o el color de las patas? animal = a , color = c");
								String patasOpcion = usuario.next().toLowerCase();
								while (!patasOpcion.equals("a") && !patasOpcion.equals("c")){
									System.out.println("\n" + "Opcion no valida, solo es 'a' o 'c' ");
									patasOpcion = usuario.next().toLowerCase();
								}
								if(patasOpcion.equals("a")){
									this.catalogo.muestra();
									System.out.println("Introduzca el indice del animal del que quieres las patas");
									int indicePatasA;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										indicePatasA = usuario.nextInt();
										if(indicePatasA < 0 || indicePatasA > this.catalogo.tamanio-1){
											System.out.println("\n" + "Elige un indice valido");
											usuario.nextLine();
											continue;
										}
										break;
									}
									usuario.nextLine();
									String nuevaPata = this.catalogo.obten(indicePatasA).getNombre();
									actualizado.setPata(nuevaPata);
								}
								if(patasOpcion.equals("c")){
									paleta(this.color);
									System.out.println("Introduzca el indice del color para las patas");
									int indiceColorPatasA;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										indiceColorPatasA = usuario.nextInt();
										if(indiceColorPatasA < 0 || indiceColorPatasA > 8){
											System.out.println("\n" + "Elige una opcion del 1 al 8");
											usuario.nextLine();
											continue;
										}
									break;
									}
									usuario.nextLine();
									actualizado.setColorPata(this.color[indiceColorPatasA]);
								}
							break;

							case 4:

								System.out.println("\n" + "<<<Modificar Cola>>>");
								System.out.println("\n" + "¿Deseas modificar el animal de la cola o el color de la cola? animal = a , color = c");
								String colaOpcion = usuario.next().toLowerCase();
								while (!colaOpcion.equals("a") && !colaOpcion.equals("c")){
									System.out.println("\n" + "Opcion no valida, solo es 'a' o 'c' ");
									colaOpcion = usuario.next().toLowerCase();
								}
								if(colaOpcion.equals("a")){
									this.catalogo.muestra();
									System.out.println("Introduzca el indice del animal del que quieres la cola");
									int indiceColaA;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										indiceColaA = usuario.nextInt();
										if(indiceColaA < 0 || indiceColaA > this.catalogo.tamanio-1){
											System.out.println("\n" + "Elige un indice valido");
											usuario.nextLine();
											continue;
										}
										break;
									}
									usuario.nextLine();
									String nuevaCola = this.catalogo.obten(indiceColaA).getNombre();
									actualizado.setCola(nuevaCola);
								}
								if(colaOpcion.equals("c")){
									paleta(this.color);
									System.out.println("Introduzca el indice del color para la cola");
									int indiceColorColaA;
									while(true){
										if(!usuario.hasNextInt()){
											System.out.println("\n" + "La opcion debe ser un NUMERO");
											usuario.nextLine();
											continue;
										}
										indiceColorColaA = usuario.nextInt();
										if(indiceColorColaA < 0 || indiceColorColaA > 8){
											System.out.println("\n" + "Elige una opcion del 1 al 8");
											usuario.nextLine();
											continue;
										}
									break;
									}
									usuario.nextLine();
									actualizado.setColorCola(this.color[indiceColorColaA]);
								}
							break;
						}
						System.out.println();
						global = actualizado;
						this.guardarAlebrije(archivoAlebrije, global);
						System.out.println("El alebrije ha sido modificado exitosamente");
					}	
				break;
			}
			if (opcion == 7) System.out.println("\n" + "Fabrica de alebrijes fuera");	
		} while(opcion != 7); 
	}

	public static void main(String[] args) {
		
		Fabrica fabrica1 = new Fabrica();
		Fabrica fabrica2 = new Fabrica();
		Scanner menu = new Scanner(System.in);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~BIENVENIDO A LA FABRICA DE ALEBRIJES~~~~~~~~~~~~~~~~~~~~~" + "\n");
		System.out.println("****Escoja su fabrica****" + "\n");
		System.out.println("Fabrica Artesanal de Alebrijes Mexicanos ------>  M ");
		System.out.println("Fabrica Artesanal de Alebrijes Chinos ------> C  ");
		String fabrica = menu.nextLine().toUpperCase();
		while (!fabrica.equals("M") && !fabrica.equals("C")){
			System.out.println("Opcion no valida, eliga 'M' o 'C'");
			fabrica = menu.next().toUpperCase();
		}
		if (fabrica.equals("M")){
			System.out.println("\n" + "****Bienvenido a la Fabrica Artesanal de Alebrijes Mexicanos****");
			System.out.println("\n" + "Como bienvenida mostraremos el catalogo ya existente y que puedes modificar " + "\n");
			fabrica1.nombreDeFabrica = "Mexicana";
			fabrica1.lecturaCatalogo("CatalogoMexicano.txt");
			fabrica1.catalogo.muestra();
			paleta(fabrica1.color);
			fabrica1.menu();
		} else if (fabrica.equals("C")){
			System.out.println("\n" + "****Bienvenido a la Fabrica Artesanal de Alebrijes Chinos****");
			System.out.println("\n" + "Como bienvenida mostraremos el catalogo ya existente y que puedes modificar " + "\n");
			fabrica2.nombreDeFabrica = "China";
			fabrica2.lecturaCatalogo("CatalogoChino.txt");
			fabrica2.catalogo.muestra();
			paleta(fabrica2.color);
			fabrica2.menu();
		}
	}
}