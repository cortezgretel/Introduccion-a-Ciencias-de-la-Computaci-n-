/**
*@author Gretel Penélope Cortés Macias
*Clase Cifrado que nos ayudara a programar tres distintos tipos de cifrado
*/


/**Se importan las bibliotecas Scanner para recibir las cadenas y la interacción con el usuario
y Random para crear numéros random 
*/
import java.util.Scanner; 
import java.util.Random;

public class Cifrado{



	/**Variable constante "ABECEDARIO" que nos serviria para iterar en el cifrado de Cesar*/
	public final String ABECEDARIO= "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	/**Variable privada que almacenará la cadena recibida de obtenCadena(Scanner sc) */
	private String entrada;
	/**Variable privada que almacenará la cadena cifrada de cifradoDeCesar(int k)*/
	private String cifradaCesar;
	/**Variable privada que alamacenará la cadena descifrada de descifradoDeCesar(int k)*/
	private String descifradaCesar;
	/**Variable privada que almacenará la cadena cifrada de cifraRieles()*/
	private String cifradaRieles;
	/**Variable privada que almacenará la cadena descifrada de descifraRieles()*/
	private String descifradaRieles;
	/**Variable que almacena el abecedario revuelto*/
	public String abecedarioRevuelto;
	/**Variable que almacena la cadena cifrada por el cifrado Kama-Sutra*/
	private String cifradaKamaSutra;
	/**Variable que almacena la cadena descifrada por el descifrado Kama-Sutra*/
	private String descifradaKamaSutra;


	//Metodos de acceso a los atributos

	/**Metodo de acceso que nos ayuda a acceder a la cadena de entrada
	*@return la cadena de entrada*/

	public String getEntrada(){
		return this.entrada;
	}

	/**Metodo de acceso que nos ayuda a acceder a la cadena cifrada por el cifrado de cesar
	*@return la cadena cifrada de Cesar*/

	public String getCifradaCesar(){
		return this.cifradaCesar;
	}

	/**Metodo de acceso que nos ayuda a acceder a la cadena descifrada por el descifrado de cesar
	*@return la cadena descifrada de Cesar*/

	public String getDescifradaCesar(){
		return this.descifradaCesar;
	}

	/**Metodo de acceso que nos ayuda a acceder a la cadena cifrada por el cifrado de Rieles
	*@return la cadena cifrada de Rieles*/

	public String getCifradaRieles(){
		return this.cifradaRieles;
	}

	/**Metodo de acceso que nos ayuda a acceder a la cadena descifrada por el cifrado de Rieles
	*@return la cadena descifrada de Rieles*/

	public String getDescifradaRieles(){
		return this.descifradaRieles;
	}

	/**Metodo de acceso que nos ayuda a acceder a la cadena cifrada por el cifrado de Kama-Sutra
	*@return la cadena cifrada de Kama.Sutra*/

	public String getCifradaKamaSutra(){
		return this.cifradaKamaSutra;
	}

	/**Metodo de acceso que nos ayuda a acceder a la cadena descifrada por el cifrado de Kama-Sutra
	*@return la cadena descifrada de Kama-Sutra*/

	public String getDescifradaKamaSutra(){
		return this.descifradaKamaSutra;
	}

	/**Metodo de acceso que nos ayuda a acceder al abecedario revuelto
	*@return abecedario revuelto*/
	public String getAbecedarioRevuelto(){
		return this.abecedarioRevuelto;
	}



	/**Metodo que lee la cadena de entrada y la modifica (le quita espacios, digitos y caracteres especiales),
	además la convierta en mayusculas y despues la almacena en la variable entrada
	*@param Scanner sc
	*@return String this.entrada
	*/
	public String obtenCadena(Scanner sc){
		//Mensaje al usuario para que pueda introducir la cadena a cifrar 
		System.out.println("\n\n"+ "--------------------------------ADVERTENCIA--------------------------------"+
		"\n\n"+ "Es IMPORTANTE que sepa que si escribe una cadena con CARACTERES ESPECIALES con DIGITOS NUMERICOS y ESPACIOS estos se ELIMINARAN"
		+ "\n\n" + "Introduce una cadena: ");
		//Mensaje de aclaración que sera la cadena original 
		String cadenaEntrada = sc.nextLine();
		//se le quitan los espacios a la cadena
		String sinEspacios = cadenaEntrada.replaceAll(" ","");
		// no se aceptan caracteres especiales y numeros en la cadena 
		String sinCaracter= sinEspacios.replaceAll("[^a-zA-Z]+","");
		//La cadena se guarda en un atributo de la clase para poder acceder facilmente a el 
		this.entrada = sinCaracter.toUpperCase();
		System.out.println("\nEsta será su cadena original");
		return  "                 " + getEntrada() + "\n" ;

	}





	/** Trabaja con un atributo de la clase como cadena de origen
	* y regresa la cadena cifrada.
	*@param k el desplazamiento que desea dar.
	*@return la cadena cifrada.
	*/

	public String cifradoDeCesar(int k){
		//cadena auxiliar del cifrado de cesar 
		String auxCesar = "";
		int i;
		for (i=0; i<getEntrada().length(); i++){

			auxCesar += "" + ABECEDARIO.charAt((ABECEDARIO.indexOf(getEntrada().charAt(i))+k)%ABECEDARIO.length());

		}
		//mensaje para anunciar la cadena cifrada por el cifrado de Cesar
	System.out.println("Cadena cifrada por el cifrado de Cesar");
	//se guarda en un atributo de la clase para poder acceder a ella 
	this.cifradaCesar = auxCesar;
	return "                 "+ getCifradaCesar()+ "\n" ;

	}




	/**Trabaja con un atributo de la clase el cual sera el mensaje cifrado por el cifrado de Cesar
	* y nos regresa la cadena descifrada
	*@param k el desplazamiento que se dio 
	*@return la cadena descifrada
	*/
	public String descifradoDeCesar(int k){
		//Cadena auxiliar del descifrado de Cesar
		String auxdescifradoCesar ="";
		int i;
		for (i=0; i<getCifradaCesar().length(); i++){
			auxdescifradoCesar += "" + ABECEDARIO.charAt((ABECEDARIO.indexOf(getCifradaCesar().charAt(i))+(ABECEDARIO.length()-k))%ABECEDARIO.length());
		}
		//Mensaje para anunciar la cadena descifrada por el cifrado de Cesar
		System.out.println("Cadena descifrada por el cifrado de Cesar");
		//Se guarda la cadena en un atributo de la clase para poder acceder a ella 
		this.descifradaCesar = auxdescifradoCesar;
		return "                 "+getDescifradaCesar()+ "\n"  ;
	}





	/**Regresa los tres rieles pegados. Trabaja a partir de un atributo donde se encuentra la cadena origen 
	*@return la cadena con los tres rieles pegados sin blancos.
	*/

	public String cifraRieles(){
		//cadenas auxiliares 
		String auxCifraRieles1 = "";
		String auxCifraRieles2 = "";
		String auxCifraRieles3 = "";
		//variable i declarada fuera del for
		int i;
		for (i = 0; i<getEntrada().length(); i++){
			
			switch(i%3){
				case 0 :
				auxCifraRieles1+= "" + getEntrada().charAt(i);
				break; 
				case 1 :
				auxCifraRieles2+= "" + getEntrada().charAt(i);
				break;
				case 2 : 
				auxCifraRieles3+= "" + getEntrada().charAt(i);
				break;

			}

		}

		// cadena que pega los tres rieles sin blancos
		String totalCifraRieles =""+ auxCifraRieles1 + auxCifraRieles2 + auxCifraRieles3;

		//Mensaje para anunciar la cadena cifrada por el cifrado de rieles
		System.out.println("Cadena cifrada por el cifrado de Rieles");

		//Cadena se guarda un atributo de la clase para acceder facilmente a el 
		this.cifradaRieles= totalCifraRieles;

		return "                 " + getCifradaRieles()+ "\n"  ;
	}




	/**Trabaja con un atributo donde se encuentra la cadena cifrada y regresa la cadena original
	*@return la cadena original sin blancos y caracteres especiales
	*/
	public String descifraRieles(){
		//cadena auxiliar que concantena los rieles 
		String descifraRielesTotal= "";

		//caso en el que la longitud de la cadena % 3 sea igual a 0
		if ( getCifradaRieles().length()%3 == 0 ){
			String aux = getCifradaRieles().substring(0, (getCifradaRieles().length()/3));
			String aux2 = getCifradaRieles().substring((getCifradaRieles().length()/3), ((getCifradaRieles().length()/3)*2 ));
			String aux3 = getCifradaRieles().substring(((getCifradaRieles().length()/3)*2 ));
			String aux4 = "";
			int i;
			for (i = 0; i<aux.length()&i<aux2.length()&i<aux.length(); i++  ){
				//concatenamos los rieles 
				aux4 += "" + aux.charAt(i) + aux2.charAt(i) + aux3.charAt(i);
				continue;
			}

			descifraRielesTotal += "" + aux4;
		}



		//caso en el que la longitud de la cadena % 3 sea igual a 1
		if ( getCifradaRieles().length()%3 == 1 ){

			//cadenas auxiliares 
			String aux = getCifradaRieles().substring(0, ((getCifradaRieles().length()/3) + 1));
			String aux2 = getCifradaRieles().substring(((getCifradaRieles().length()/3) + 1), (((getCifradaRieles().length()/3)*2 )+1));
			String aux3 = getCifradaRieles().substring((((getCifradaRieles().length()/3)*2 )+1));
			String aux4 = "";
			int i;
			for (i = 0; i<aux.length()-1&i<aux2.length()&i<aux.length(); i++  ){
				//concatenamos los rieles 
				aux4 += "" + aux.charAt(i) + aux2.charAt(i) + aux3.charAt(i);
				continue;
			}

			descifraRielesTotal += "" + aux4 + aux.charAt(aux.length()-1);
		}


		//caso en el que la longitud de la cadena % 3 sea igual a 2 
		if(getCifradaRieles().length()%3 == 2){

			//cadenas auxiliares 
			String aux = getCifradaRieles().substring(0, ((getCifradaRieles().length()/3) + 1));
			String aux2 = getCifradaRieles().substring(((getCifradaRieles().length()/3) + 1), (((getCifradaRieles().length()/3)*2 )+2));
			String aux3 = getCifradaRieles().substring((((getCifradaRieles().length()/3)*2 )+2));
			String aux4 = "";
			int i;
			for (i = 0; i<aux.length()-1 &i<aux2.length()-1&i<aux.length(); i++  ){
				//concatenamos los rieles 
				aux4 += "" + aux.charAt(i) + aux2.charAt(i) + aux3.charAt(i);
				continue;
			}

			descifraRielesTotal += "" + aux4 + aux.charAt(aux.length()-1)+ aux2.charAt(aux.length()-1);
		}

		//Atributo para almacenar la cadena descifrada
		this.descifradaRieles=descifraRielesTotal;

		//Mensaje para anunciar que la cadena es descifrado por el descifrado de rieles 
		System.out.println("Cadena descifrada por el descifrado de rieles");

		return "                 " + getDescifradaRieles() + "\n" ;
	}






	/** Revuelve el alfabeto . Trabaja a partir del alfabeto , que
	puede ser estático y constante .
	* @return El alfabeto revuelto .
	*/
	public String revuelve(){
		Random numeroRandom = new Random (4);
		String nuevoAbecedario = "";
		int i; 
		for (i=0; i< ABECEDARIO.length();){
			char caracterGenerado = ABECEDARIO.charAt(numeroRandom.nextInt(ABECEDARIO.length()));
			if (nuevoAbecedario.indexOf(caracterGenerado)<0){
				nuevoAbecedario+= ""+caracterGenerado;
				i++;
			}

		}
		//Se almacena el abecedario en una variable 
		this.abecedarioRevuelto = nuevoAbecedario;
		//Mensaje que anuncia el abecedario revuelto

		return "Abecedario revuelto: " + getAbecedarioRevuelto() + "\n" ;
	}	


	/**
	* Trabaja con un atributo de la clase como cadena origen y
	* regresa la cadena cifrada .
	*
	* @param revuelto El alfabeto revuelto .
	* @return La cadena cifrada .
	*/
	public String cifradoKamaSutra ( String revuelto ){
		String auxKamaSutra = ""; 

		int i;
		for (i=0; i<getEntrada().length(); i++){
			auxKamaSutra += revuelto.charAt(ABECEDARIO.indexOf(getEntrada().charAt(i)));

		}
		//Se almacena la cadena en una variable 
		this.cifradaKamaSutra = auxKamaSutra;

		//Mensaje que anuncia que la cadena fue cifrada por el cifrado kama-sutra
		System.out.println("Cadena cifrada por el cifrado Kama-sutra");

		return "                 "+ getCifradaKamaSutra() + "\n";
	}




	/**
	* Trabaja con un atributo donde se encuentra la cadena
	* cifrada yregresa la cadena original .
	*
	* @param revuelto El alfabeto que se us ́o para cifrar .
	* @return La cadena descifrada , aunque sin blancos ni
	* caracteres especiales
	*/
	public String descifraKamaSutra( String revuelto ){
		String auxdescifraKamaSutra = ""; 

		int i;
		for (i=0; i<getCifradaKamaSutra().length(); i++){
			auxdescifraKamaSutra += ABECEDARIO.charAt(revuelto.indexOf(getCifradaKamaSutra().charAt(i)));

		}

		//Se almacena la cadena en una variable
		this.descifradaKamaSutra = auxdescifraKamaSutra;

		//Mensaje que anuncia la cadena descifrada por el metodo descifrado de Kama-sutra
		System.out.println("Cadena descifrada por el descifrado Kama-sutra");

		return "                 "+ getDescifradaKamaSutra() + "\n";

	}
	






	public static void main (String [] args){
		Cifrado prueba = new Cifrado();
		Scanner sc = new Scanner(System.in);
		

		//impresion del metodo obten cadena 
		System.out.println(prueba.obtenCadena(sc));


		//numero de parametro 
		//System.out.println("Introduce un numero k que hará cuanto avanza en tu cifrado de Cesar");
		//int k = sc.nextInt(); 
		//impresion del metodo cifrado de cesar y descifrado de cesar
		System.out.println(prueba.cifradoDeCesar(7));
		System.out.println(prueba.descifradoDeCesar(7));

		//impresion del metodo cifrado de rieles y descifrado de rieles
		System.out.println(prueba.cifraRieles());
		System.out.println(prueba.descifraRieles());

		//impresion del metodo que revuelve el abecedario
		System.out.println(prueba.revuelve());

		//impresion del metodo cifrado y descifrado kama-sutra
		System.out.println(prueba.cifradoKamaSutra(prueba.getAbecedarioRevuelto()));
		System.out.println(prueba.descifraKamaSutra(prueba.getAbecedarioRevuelto()));



	}

	
}