import java.util.Scanner; 
public class Fabrica {

	public Lista catalogo= new Lista();
	public Lista animales;
	public final String[] color = {"rojo", "amarillo", "azul", "verde", "anaranjado", "violeta", "rosa" , "negro" , "blanco"};

	public static void paleta(String[] paleta){
		System.out.println("Paletas de colores");
		int i;
		for(i = 0; i < paleta.length; i++){
			System.out.println("Indice : "+ i + " color: " + paleta[i]);
		}
	}



	public static void main(String[] args) {
		Fabrica fabrica1 = new Fabrica();
		Fabrica fabrica2 = new Fabrica ();
		Scanner usuario = new Scanner(System.in);


		System.out.println("							Bienvenido  					");
		System.out.println("Escoja su fabrica");
		System.out.println("Fabrica Artesanal de Alebrijes Mexicanos ------>  M ");
		System.out.println("Fabrica Artesanal de Alebrijes Chinos ------> C  ");
		String fabrica = usuario.nextLine().toUpperCase();
		while (!fabrica.equals("M") && !fabrica.equals("C")){
				System.out.println("Opcion no valida, solo es 'M' o 'C' ");
				fabrica = usuario.next();
			}

		if (fabrica.equals("M")){
					
		
		Animal elefante = new Animal("elefante", 4, true , fabrica1.color[0]);
		Animal serpiente = new Animal ("serpiente" , 0,true,fabrica1.color[2] );
		Animal pinguino = new Animal ("pinguino" , 2 , true, fabrica1.color[8]);
		Animal puerco  = new Animal ("puerco " , 4 , true,fabrica1.color[4]);
		int opcion;


		//Lista catalogo1 = fabrica1.catalogo;
		fabrica1.catalogo.agregar(elefante);
		fabrica1.catalogo.agregar(serpiente);
		fabrica1.catalogo.agregar(pinguino);
		fabrica1.catalogo.agregar(puerco);


		System.out.println("Bienvenido a la Fabrica Artesanal de Alebrijes Mexicanos ");
		System.out.println("Como bienvenida nos gustaría enseñarte el Catalogo que ya tenemos definido pero que podrás modificar " + "\n");
		fabrica1.catalogo.muestra();
		paleta(fabrica1.color);
		do{
		System.out.println("¿Te gustaría agregar, eliminar, modificar algun animal o crear un Alebrije?" + "\n");
		System.out.println("Para agregar introduce 1");
		System.out.println("Para eliminar introduce 2");
		System.out.println("Para modificar introduce 3");
		System.out.println("Para crear un Alebrije introduce 4");
		System.out.println("Para salir de la fabrica introduce 5");
		
		
		while (true){
			if (!usuario.hasNextInt()){
				System.out.println("La opcion debe ser un NUMERO");
				usuario.nextLine();
				continue;
			}		
			opcion = usuario.nextInt();
			//usuario.nextLine(); //robustez
			if (1 > opcion || opcion > 5){
				System.out.println("Las opciones son del 1-5");
				usuario.nextLine();
				continue;
			}
			break;	 
			
		}

		
		switch(opcion){
			case 1 :
				Animal usuarioAnimal = null;
				System.out.println("Usted escogio la opcion 1 ----> AGREGAR ");
				System.out.println("Introduzca el animal que desea agregar");
				String animal = usuario.nextLine();
				paleta(fabrica1.color);
				System.out.println("Introduzca el indice del color para el animal");
				while (!usuario.hasNextInt()){
				System.out.println("Indice no valido  ");
				usuario.next();
				}
				int colorAgrega = usuario.nextInt();
				while (0 > colorAgrega || colorAgrega > 8 ){
					System.out.println(" Indice no valido  ");
					colorAgrega=usuario.nextInt();
				} 
				System.out.println("¿Cuantas patas tiene el animal?  ");

				while (!usuario.hasNextInt()){
				System.out.println("Numero de patas no valido ");
				usuario.next();
				}
				int pata = usuario.nextInt();
				usuario.nextLine();

				while (0 > pata || pata > 800 ){
					System.out.println("Numero de patas no valido ");
					pata=usuario.nextInt();
				}

				System.out.println("¿El animal tiene cola? 's' = si , 'n' = no ");
				String cola = usuario.next();

				while (!cola.equals("s") && !cola.equals("n")){
				System.out.println("Opcion no valida, solo es 's' o 'n' ");
				cola = usuario.next();
				}

				if (cola.equals("s")){
					Animal usuarioAnimal1 = new Animal (animal,pata,true,fabrica1.color[colorAgrega]);
					usuarioAnimal=usuarioAnimal1;
				}

				if (cola.equals("n")){
					Animal usuarioAnimal4 = new Animal(animal, pata ,false,fabrica1.color[colorAgrega]);
					usuarioAnimal=usuarioAnimal4;
				}

				System.out.println("El animal " + animal + " ha sido agregado al catalogo.");
				fabrica1.catalogo.agregar(usuarioAnimal);
				fabrica1.catalogo.muestra();

			break;

			case 2 :
				System.out.println("Usted escogio la opcion 2 ----> ELIMINAR ");
				System.out.println("Introduzca el indice del animal que desea eliminar ");


				while(!usuario.hasNextInt()){
				System.out.println("El indice debe ser un NUMERO");
				usuario.next();
					}
				int indice = usuario.nextInt();
				usuario.nextLine();
				while(indice>fabrica1.catalogo.tamanio || indice<0){
					System.out.println("Indice no valido ");
					indice = usuario.nextInt();
					usuario.nextLine();
				}

				fabrica1.catalogo.elimina(indice);

				System.out.println("El animal ha sido eliminado satisfactoriamente ");
				fabrica1.catalogo.muestra();

			break;


			case 3 : 
				System.out.println("Usted escogio la opcion 3 ----> MODIFICAR ");
				System.out.println("Introduzca el indice del animal que desea modificar ");
				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indiceModifica = usuario.nextInt();
				usuario.nextLine();
				while(indiceModifica>fabrica1.catalogo.tamanio && indiceModifica<0){
					System.out.println("Indice no valido ");
					indiceModifica = usuario.nextInt();
					usuario.nextLine();
				}

				Animal modificado = null;
				System.out.println("¿Deseas modificar al animal o una parte? a = animal , p = parte");
				String modificaAnimal  = usuario.next();
				usuario.nextLine();

				while (!modificaAnimal.equals("a") && !modificaAnimal.equals("p")){
					System.out.println("Opcion no valida, solo es 'a' o 'p' ");
					modificaAnimal = usuario.next();
					usuario.nextLine();
				}

				if (modificaAnimal.equals("a")){
					System.out.println("Escogiste modificar al animal, introduce el nombre del nuevo animal");
					String nuevoAnimal = usuario.nextLine();
					fabrica1.catalogo.elimina(indiceModifica);
					paleta(fabrica1.color);

					System.out.println("Introduzca el indice del color para el animal");
					while (!usuario.hasNextInt()){
						System.out.println("Indice no valido  ");
						usuario.next();
					}
					int colorModifica = usuario.nextInt();
					while (0 > colorModifica || colorModifica > 8 ){
						System.out.println(" Indice no valido  ");
						colorAgrega=usuario.nextInt();
					} 

					System.out.println("¿Cuantas patas tiene el animal?  ");

					while (!usuario.hasNextInt()){
					System.out.println("Numero de patas no valido ");
					usuario.next();
					}
					int pataMod = usuario.nextInt();
					usuario.nextLine();

					while (0 > pataMod || pataMod > 800 ){
					System.out.println("Numero de patas no valido ");
					pataMod=usuario.nextInt();
					}

					System.out.println("¿El animal tiene cola? 's' = si , 'n' = no ");
					String colaMod = usuario.next();

					while (!colaMod.equals("s") && !colaMod.equals("n")){
					System.out.println("Opcion no valida, solo es 's' o 'n' ");
					colaMod = usuario.next();
					}

					if (colaMod.equals("s")){
						Animal usuarioAnimalMod = new Animal (nuevoAnimal,pataMod,true,fabrica1.color[colorModifica]);
						modificado = usuarioAnimalMod ;
					}

					if (colaMod.equals("n")){
						Animal usuarioAnimalMod2 = new Animal(nuevoAnimal, pataMod ,false,fabrica1.color[colorModifica]);
						modificado = usuarioAnimalMod2;
					}

					fabrica1.catalogo.inserta(modificado,indiceModifica);

				}


				if (modificaAnimal.equals("p")){
					fabrica1.catalogo.obten(indiceModifica);

					System.out.println("Introduzca la parte del animal que desea modificar ");
					System.out.println("1. Cabeza " + "\n" + "2. Cuerpo " + "\n" + "3. Patas " + "\n" + "4. Cola ");
					while(!usuario.hasNextInt()){
						System.out.println("La opcion debe ser un NUMERO");
						usuario.next();
					}
					int parte = usuario.nextInt();
					usuario.nextLine();

					while(parte>4 && parte<1){
						System.out.println(" Opcion no valida ");
						parte = usuario.nextInt();
						usuario.nextLine();
					}

					switch(parte){
						case 1 : 
							System.out.println("Modificar Cabeza ");
							paleta(fabrica1.color);
							System.out.println("Introduzca el indice del color para la cabeza");
						while (!usuario.hasNextInt()){
							System.out.println("Indice no valido  ");
							usuario.next();
						}	
						int colorCabezaMod = usuario.nextInt();
						while (0 > colorCabezaMod || colorCabezaMod > 8 ){
							System.out.println(" Indice no valido  ");
							colorCabezaMod=usuario.nextInt();
						} 
							fabrica1.catalogo.obten(indiceModifica).setColorCabeza(fabrica1.color[colorCabezaMod]);
						break;

						case 2:
							System.out.println("Modificar Cuerpo ");
							paleta(fabrica1.color);
							System.out.println("Introduzca el indice del color para el cuerpo");
						while (!usuario.hasNextInt()){
							System.out.println("Indice no valido  ");
							usuario.next();
						}	
						int colorCuerpoMod = usuario.nextInt();
						while (0 > colorCuerpoMod || colorCuerpoMod > 8 ){
							System.out.println(" Indice no valido  ");
							colorCuerpoMod=usuario.nextInt();
						} 
							fabrica1.catalogo.obten(indiceModifica).setColorCuerpo(fabrica1.color[colorCuerpoMod]);
						break;

						case 3:
							System.out.println("Modificar Patas ");
							System.out.println("¿Quiere cambiar el número de patas o el color de las patas? numero = n , color = c ");
							String pataModifica = usuario.next();
							usuario.nextLine();

						while (!pataModifica.equals("n") && !pataModifica.equals("c")){
							System.out.println("Opcion no valida, solo es 'n' o 'c' ");
							pataModifica = usuario.next();
							usuario.nextLine();
						}

						if (pataModifica.equals("c")){

							paleta(fabrica1.color);
							System.out.println("Introduzca el indice del color para las patas");
							while (!usuario.hasNextInt()){
								System.out.println("Indice no valido  ");
								usuario.next();
							}	
							int colorPataMod = usuario.nextInt();
							while (0 > colorPataMod || colorPataMod > 8 ){
								System.out.println(" Indice no valido  ");
								colorPataMod=usuario.nextInt();
							} 

							fabrica1.catalogo.obten(indiceModifica).setColorCuerpo(fabrica1.color[colorPataMod]);
						}



						if (pataModifica.equals("n")){
							System.out.println("¿Cuantas patas tiene el animal?  ");

							while (!usuario.hasNextInt()){
								System.out.println("Numero de patas no valido ");
								usuario.next();
							}
							int pataNumeroModifica = usuario.nextInt();
							usuario.nextLine();

							while (0 > pataNumeroModifica || pataNumeroModifica > 800 ){
								System.out.println("Numero de patas no valido ");
								pataNumeroModifica=usuario.nextInt();
							}	

							fabrica1.catalogo.obten(indiceModifica).setNumeroDePatas(pataNumeroModifica);
						}
						break;

						case 4 : 	
							System.out.println("Modificar Cola ");
							paleta(fabrica1.color);
							System.out.println();
							System.out.println("Introduzca el indice del color para la cola");
						while (!usuario.hasNextInt()){
							System.out.println("Indice no valido  ");
							usuario.next();
						}	
						int colorColaMod = usuario.nextInt();
						while (0 > colorColaMod || colorColaMod > 8 ){
							System.out.println(" Indice no valido  ");
							colorColaMod=usuario.nextInt();
						} 
							fabrica1.catalogo.obten(indiceModifica).setColorCola(fabrica1.color[colorColaMod]);
						break;
					}
				}	

				fabrica1.catalogo.muestra();
				break;

			case 4: 
			System.out.println ("Opcion Crear un Alebrije");
			System.out.println ("Te presentamos el catalogo de animales y la paleta de colores  ");
			paleta(fabrica1.color);
			fabrica1.catalogo.muestra();
			System.out.println ("¿De que animal quieres la cabeza del alebrije? Introduce el indice ");

				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indiceCabeza = usuario.nextInt();
				usuario.nextLine();
				while(indiceCabeza>fabrica1.catalogo.tamanio && indiceCabeza<0){
					System.out.println("Indice no valido ");
					indiceCabeza = usuario.nextInt();
					usuario.nextLine();
				}
			System.out.println("¿De que animal quieres el cuerpo? introduce el indice");
				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indiceCuerpo = usuario.nextInt();
				usuario.nextLine();
				while(indiceCuerpo>fabrica1.catalogo.tamanio && indiceCuerpo<0){
					System.out.println("Indice no valido ");
					indiceCuerpo = usuario.nextInt();
					usuario.nextLine();
				}
			System.out.println("¿De que animal quieres la cola? Introduce el indice");
				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indiceCola = usuario.nextInt();
				usuario.nextLine();
				while(indiceCola>fabrica1.catalogo.tamanio && indiceCola<0){
					System.out.println("Indice no valido ");
					indiceCola = usuario.nextInt();
					usuario.nextLine();
				}
			System.out.println("¿De que animal quieres las patas? Introduce el indice");
				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indicePata = usuario.nextInt();
				usuario.nextLine();
				while(indicePata>fabrica1.catalogo.tamanio && indicePata<0){
					System.out.println("Indice no valido ");
					indicePata = usuario.nextInt();
					usuario.nextLine();
				}

			Alebrije usuarioAlebrije = new Alebrije (fabrica1.catalogo.obten(indiceCabeza),fabrica1.catalogo.obten(indiceCabeza).getColorCabeza() ,fabrica1.catalogo.obten(indiceCola),fabrica1.catalogo.obten(indiceCola).getColorCola(),fabrica1.catalogo.obten(indicePata),fabrica1.catalogo.obten(indicePata).getColorPata(),fabrica1.catalogo.obten(indiceCuerpo),fabrica1.catalogo.obten(indiceCuerpo).getColorCuerpo());
			System.out.println("El alebrije ha sido creado satisfactoriamente");
			System.out.println("El alebrije ha sido agregado al catalogo de modelos excelente trabajo");
			usuarioAlebrije.muestra();


			default: //opcion no valida 



			}



			if (opcion == 5) System.out.println("Fabrica fuera."); 
		}while(opcion !=5);

		}




		if (fabrica.equals("C")){

		Animal rinoceronte = new Animal("rinoceronte", 4, true , fabrica1.color[3]);
		Animal gusano = new Animal ("gusano" , 0,true,fabrica1.color[5] );
		Animal pollo =new Animal ("pollo" , 2 , true, fabrica1.color[4]);
		Animal vaca  =new Animal ("vaca " , 4 , true,fabrica1.color[2]);
		int opcion;

		fabrica2.catalogo.agregar(rinoceronte);
		fabrica2.catalogo.agregar(gusano);
		fabrica2.catalogo.agregar(pollo);
		fabrica2.catalogo.agregar(vaca);


		System.out.println("Bienvenido a la Fabrica Artesanal de Alebrijes Mexicanos ");
		System.out.println("Como bienvenida nos gustaría enseñarte el Catalogo que ya tenemos definido pero que podrás modificar " + "\n");
		fabrica2.catalogo.muestra();
		paleta(fabrica2.color);
		do{
		System.out.println("¿Te gustaría agregar, eliminar, modificar algun animal o crear un Alebrije?" + "\n");
		System.out.println("Para agregar introduce 1");
		System.out.println("Para eliminar introduce 2");
		System.out.println("Para modificar introduce 3");
		System.out.println("Para crear un Alebrije introduce 4");
		System.out.println("Para salir de la fabrica introduce 5");
		
		
		while (!usuario.hasNextInt()){
			System.out.println("La opcion debe ser un NUMERO");
			usuario.next();
		}
		opcion = usuario.nextInt();
		usuario.nextLine(); //robustez


		while( 1 > opcion || opcion > 5){
			System.out.println("Las opciones son del 1-5");
			opcion = usuario.nextInt();
			usuario.nextLine(); 
			
				while (!usuario.hasNextInt()){
			System.out.println("La opcion debe ser un NUMERO");
			usuario.next();
		}
		}
		
		switch(opcion){
			case 1 :
				Animal usuarioAnimal = null;
				System.out.println("Usted escogio la opcion 1 ----> AGREGAR ");
				System.out.println("Introduzca el animal que desea agregar");
				String animal = usuario.nextLine();
				paleta(fabrica2.color);
				System.out.println("Introduzca el indice del color para el animal");
				while (!usuario.hasNextInt()){
				System.out.println("Indice no valido  ");
				usuario.next();
				}
				int colorAgrega = usuario.nextInt();
				while (0 > colorAgrega || colorAgrega > 8 ){
					System.out.println(" Indice no valido  ");
					colorAgrega=usuario.nextInt();
				} 
				System.out.println("¿Cuantas patas tiene el animal?  ");

				while (!usuario.hasNextInt()){
				System.out.println("Numero de patas no valido ");
				usuario.next();
				}
				int pata = usuario.nextInt();
				usuario.nextLine();

				while (0 > pata || pata > 800 ){
					System.out.println("Numero de patas no valido ");
					pata=usuario.nextInt();
				}

				System.out.println("¿El animal tiene cola? 's' = si , 'n' = no ");
				String cola = usuario.next();

				while (!cola.equals("s") && !cola.equals("n")){
				System.out.println("Opcion no valida, solo es 's' o 'n' ");
				cola = usuario.next();
				}

				if (cola.equals("s")){
					Animal usuarioAnimal1 = new Animal (animal,pata,true,fabrica2.color[colorAgrega]);
					usuarioAnimal=usuarioAnimal1;
				}

				if (cola.equals("n")){
					Animal usuarioAnimal4 = new Animal(animal, pata ,false,fabrica2.color[colorAgrega]);
					usuarioAnimal=usuarioAnimal4;
				}

				System.out.println("El animal " + animal + " ha sido agregado al catalogo.");
				fabrica2.catalogo.agregar(usuarioAnimal);
				fabrica2.catalogo.muestra();

			break;

			case 2 :
				System.out.println("Usted escogio la opcion 2 ----> ELIMINAR ");
				System.out.println("Introduzca el indice del animal que desea eliminar ");
				while(!usuario.hasNextInt()){
				System.out.println("El indice debe ser un NUMERO");
				usuario.next();
					}
				int indice = usuario.nextInt();
				usuario.nextLine();
				while(indice>fabrica2.catalogo.tamanio || indice<0){
					System.out.println("Indice no valido ");
					indice = usuario.nextInt();
					usuario.nextLine();
				}

				fabrica2.catalogo.elimina(indice);

				System.out.println("El animal ha sido eliminado satisfactoriamente ");
				fabrica2.catalogo.muestra();

			break;


			case 3 : 
				System.out.println("Usted escogio la opcion 3 ----> MODIFICAR ");
				System.out.println("Introduzca el indice del animal que desea modificar ");
				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indiceModifica = usuario.nextInt();
				usuario.nextLine();
				while(indiceModifica>fabrica2.catalogo.tamanio && indiceModifica<0){
					System.out.println("Indice no valido ");
					indiceModifica = usuario.nextInt();
					usuario.nextLine();
				}

				Animal modificado = null;
				System.out.println("¿Deseas modificar al animal o una parte? a = animal , p = parte");
				String modificaAnimal  = usuario.next();
				usuario.nextLine();

				while (!modificaAnimal.equals("a") && !modificaAnimal.equals("p")){
					System.out.println("Opcion no valida, solo es 'a' o 'p' ");
					modificaAnimal = usuario.next();
					usuario.nextLine();
				}

				if (modificaAnimal.equals("a")){
					System.out.println("Escogiste modificar al animal, introduce el nombre del nuevo animal");
					String nuevoAnimal = usuario.nextLine();
					fabrica2.catalogo.elimina(indiceModifica);
					paleta(fabrica2.color);

					System.out.println("Introduzca el indice del color para el animal");
					while (!usuario.hasNextInt()){
						System.out.println("Indice no valido  ");
						usuario.next();
					}
					int colorModifica = usuario.nextInt();
					while (0 > colorModifica || colorModifica > 8 ){
						System.out.println(" Indice no valido  ");
						colorAgrega=usuario.nextInt();
					} 

					System.out.println("¿Cuantas patas tiene el animal?  ");

					while (!usuario.hasNextInt()){
					System.out.println("Numero de patas no valido ");
					usuario.next();
					}
					int pataMod = usuario.nextInt();
					usuario.nextLine();

					while (0 > pataMod || pataMod > 800 ){
					System.out.println("Numero de patas no valido ");
					pataMod=usuario.nextInt();
					}

					System.out.println("¿El animal tiene cola? 's' = si , 'n' = no ");
					String colaMod = usuario.next();

					while (!colaMod.equals("s") && !colaMod.equals("n")){
					System.out.println("Opcion no valida, solo es 's' o 'n' ");
					colaMod = usuario.next();
					}

					if (colaMod.equals("s")){
						Animal usuarioAnimalMod = new Animal (nuevoAnimal,pataMod,true,fabrica2.color[colorModifica]);
						modificado = usuarioAnimalMod ;
					}

					if (colaMod.equals("n")){
						Animal usuarioAnimalMod2 = new Animal(nuevoAnimal, pataMod ,false,fabrica2.color[colorModifica]);
						modificado = usuarioAnimalMod2;
					}

					fabrica2.catalogo.inserta(modificado,indiceModifica);

				}


				if (modificaAnimal.equals("p")){
					fabrica2.catalogo.obten(indiceModifica);

					System.out.println("Introduzca la parte del animal que desea modificar ");
					System.out.println("1. Cabeza " + "\n" + "2. Cuerpo " + "\n" + "3. Patas " + "\n" + "4. Cola ");
					while(!usuario.hasNextInt()){
						System.out.println("La opcion debe ser un NUMERO");
						usuario.next();
					}
					int parte = usuario.nextInt();
					usuario.nextLine();

					while(parte>4 && parte<1){
						System.out.println(" Opcion no valida ");
						parte = usuario.nextInt();
						usuario.nextLine();
					}

					switch(parte){
						case 1 : 
							System.out.println("Modificar Cabeza ");
							paleta(fabrica2.color);
							System.out.println("Introduzca el indice del color para la cabeza");
						while (!usuario.hasNextInt()){
							System.out.println("Indice no valido  ");
							usuario.next();
						}	
						int colorCabezaMod = usuario.nextInt();
						while (0 > colorCabezaMod || colorCabezaMod > 8 ){
							System.out.println(" Indice no valido  ");
							colorCabezaMod=usuario.nextInt();
						} 
							fabrica2.catalogo.obten(indiceModifica).setColorCabeza(fabrica2.color[colorCabezaMod]);
						break;

						case 2:
							System.out.println("Modificar Cuerpo ");
							paleta(fabrica2.color);
							System.out.println("Introduzca el indice del color para el cuerpo");
						while (!usuario.hasNextInt()){
							System.out.println("Indice no valido  ");
							usuario.next();
						}	
						int colorCuerpoMod = usuario.nextInt();
						while (0 > colorCuerpoMod || colorCuerpoMod > 8 ){
							System.out.println(" Indice no valido  ");
							colorCuerpoMod=usuario.nextInt();
						} 
							fabrica2.catalogo.obten(indiceModifica).setColorCuerpo(fabrica2.color[colorCuerpoMod]);
						break;

						case 3:
							System.out.println("Modificar Cuerpo ");
							System.out.println("¿Quiere cambiar el número de patas o el color de las patas? numero = n , color = c ");
							String pataModifica = usuario.next();
							usuario.nextLine();

						while (!pataModifica.equals("n") && !pataModifica.equals("c")){
							System.out.println("Opcion no valida, solo es 'n' o 'c' ");
							pataModifica = usuario.next();
							usuario.nextLine();
						}

						if (pataModifica.equals("c")){

							paleta(fabrica2.color);
							System.out.println("Introduzca el indice del color para las patas");
							while (!usuario.hasNextInt()){
								System.out.println("Indice no valido  ");
								usuario.next();
							}	
							int colorPataMod = usuario.nextInt();
							while (0 > colorPataMod || colorPataMod > 8 ){
								System.out.println(" Indice no valido  ");
								colorPataMod=usuario.nextInt();
							} 

							fabrica2.catalogo.obten(indiceModifica).setColorCuerpo(fabrica2.color[colorPataMod]);
						}



						if (pataModifica.equals("n")){
							System.out.println("¿Cuantas patas tiene el animal?  ");

							while (!usuario.hasNextInt()){
								System.out.println("Numero de patas no valido ");
								usuario.next();
							}
							int pataNumeroModifica = usuario.nextInt();
							usuario.nextLine();

							while (0 > pataNumeroModifica || pataNumeroModifica > 800 ){
								System.out.println("Numero de patas no valido ");
								pataNumeroModifica=usuario.nextInt();
							}	

							fabrica2.catalogo.obten(indiceModifica).setNumeroDePatas(pataNumeroModifica);
						}
						break;

						case 4 : 	
							System.out.println("Modificar Cola ");
							paleta(fabrica2.color);
							System.out.println();
							System.out.println("Introduzca el indice del color para la cola");
						while (!usuario.hasNextInt()){
							System.out.println("Indice no valido  ");
							usuario.next();
						}	
						int colorColaMod = usuario.nextInt();
						while (0 > colorColaMod || colorColaMod > 8 ){
							System.out.println(" Indice no valido  ");
							colorColaMod=usuario.nextInt();
						} 
							fabrica2.catalogo.obten(indiceModifica).setColorCola(fabrica2.color[colorColaMod]);
						break;
					}
				}	

				fabrica2.catalogo.muestra();
				break;

			case 4: 
			System.out.println ("Opcion Crear un Alebrije");
			System.out.println ("Te presentamos el catalogo de animales y la paleta de colores  ");
			paleta(fabrica2.color);
			fabrica2.catalogo.muestra();
			System.out.println ("¿De que animal quieres la cabeza del alebrije? Introduce el indice ");

				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indiceCabeza = usuario.nextInt();
				usuario.nextLine();
				while(indiceCabeza>fabrica2.catalogo.tamanio && indiceCabeza<0){
					System.out.println("Indice no valido ");
					indiceCabeza = usuario.nextInt();
					usuario.nextLine();
				}
			System.out.println("¿De que animal quieres el cuerpo? introduce el indice");
				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indiceCuerpo = usuario.nextInt();
				usuario.nextLine();
				while(indiceCuerpo>fabrica2.catalogo.tamanio && indiceCuerpo<0){
					System.out.println("Indice no valido ");
					indiceCuerpo = usuario.nextInt();
					usuario.nextLine();
				}
			System.out.println("¿De que animal quieres la cola? Introduce el indice");
				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indiceCola = usuario.nextInt();
				usuario.nextLine();
				while(indiceCola>fabrica2.catalogo.tamanio && indiceCola<0){
					System.out.println("Indice no valido ");
					indiceCola = usuario.nextInt();
					usuario.nextLine();
				}
			System.out.println("¿De que animal quieres las patas? Introduce el indice");
				while(!usuario.hasNextInt()){
					System.out.println("El indice debe ser un NUMERO");
					usuario.next();
				}
				int indicePata = usuario.nextInt();
				usuario.nextLine();
				while(indicePata>fabrica2.catalogo.tamanio && indicePata<0){
					System.out.println("Indice no valido ");
					indicePata = usuario.nextInt();
					usuario.nextLine();
				}

			Alebrije usuarioAlebrije = new Alebrije (fabrica2.catalogo.obten(indiceCabeza),fabrica2.catalogo.obten(indiceCabeza).getColorCabeza() ,fabrica2.catalogo.obten(indiceCola),fabrica2.catalogo.obten(indiceCola).getColorCola(),fabrica2.catalogo.obten(indicePata),fabrica2.catalogo.obten(indicePata).getColorPata(),fabrica2.catalogo.obten(indiceCuerpo),fabrica2.catalogo.obten(indiceCuerpo).getColorCuerpo());
			System.out.println("El alebrije ha sido creado satisfactoriamente");
			System.out.println("El alebrije ha sido agregado al catalogo de modelos excelente trabajo");
			usuarioAlebrije.muestra();


			default: //opcion no valida 



			}



			if (opcion == 5) System.out.println("Fabrica fuera."); 
		}while(opcion !=5);
						
		}
	}

}