/**
 * PROYECTO 4 ICC
 * Clase Animal
 * @author Gretel Penelope Cruz Macias.
 * @author Valeria Fernanda Manjarrez Angeles
 * @version 1.0 
 */
public class Animal{

	/** Nombre del animal */
	private String nombre;

	/** Cabeza del animal */
	private String cabeza;

	/** Cuerpo del animal */
	private String cuerpo;
	
	/** Patas del animal */
	private String pata;

	/** Cola del animal */
	private String cola;

	/** Color de la cabeza del animal */
	private String colorCabeza = "blanco" ;

	/** Color del cuerpo del animal */
	private String colorCuerpo = "blanco" ;

	/** Color de las patas del animal */
	private String colorPata= "blanco";

	/** Color de la cola del animal */
	private String colorCola="blanco" ;
	
	/** El animal tiene cola o no */
	private boolean tieneCola;

	/** Numero de patas del animal */
	private int numeroDePatas;

	/**
     * Constructor de un animal.
     * @param animal nombre del animal. 
    */
	public Animal (String animal){

		this.setNombre(animal);
		this.setCabeza(animal);
		this.setCuerpo(animal);
		this.setPata(animal);
		this.setCola(animal);
	}

	/**
     * Constructor de un animal.
     * @param animal nombre del animal.
     * @param patas numero de patas del animal.
     * @param cola si el animal tiene cola.
     * @param color color del animal. 
    */
	public Animal (String animal, int patas , boolean cola, String color ){

		if (patas == 0){
			this.setPata(null);
		}
		if (cola == false){
			this.setTieneCola(false);
			this.setCola(null);
		}
		if (patas > 0){
			this.setPata(animal);
			this.setColorPata(color);
		}
		if (cola == true){
			this.setTieneCola(true);
			this.setCola(animal);
			this.setColorCola(color);
		}
		this.setNombre(animal);
		this.setCabeza(animal);
		this.setCuerpo(animal);
		this.setNumeroDePatas(patas);
		this.setColorCabeza(color);
		this.setColorCuerpo(color);	
	}

	/**
     * Constructor de un animal.
     * @param animal nombre del animal.
     * @param patas numero de patas del animal.
     * @param cola si el animal tiene cola.
     * @param colorCabeza color de la cabeza.
     * @param colorCuerpo color del cuerpo.
     * @param colorPata color de las patas.
     * @param colorCola color de la cola.
    */
	public Animal (String animal, int patas , boolean cola, String colorCabeza, String colorCuerpo, String colorPata, String colorCola){

		if (patas == 0){
			this.setPata(null);
		}
		if (cola == false){
			this.setTieneCola(false);
			this.setCola(null);
		}
		if (patas > 0){
			this.setPata(animal);
			this.setColorPata(colorPata);
		}
		if (cola == true){
			this.setTieneCola(true);
			this.setCola(animal);
			this.setColorCola(colorCola);
		}
		this.setNombre(animal);
		this.setCabeza(animal);
		this.setCuerpo(animal);
		this.setNumeroDePatas(patas);
		this.setColorCabeza(colorCabeza);
		this.setColorCuerpo(colorCuerpo);	
	}

	/**
     * Permite accesar al nombre del animal.
     * @return el nombre del animal.
    */
	public String getNombre(){

		return this.nombre;
	}

	/**
     * Permite accesar a la cabeza del animal.
     * @return la cabeza del animal.
     */
	public String getCabeza(){

		return this.cabeza;
	}

	/**
     * Permite accesar al cuerpo del animal.
     * @return el cuerpo del animal.
     */
	public String getCuerpo(){

		return this.cuerpo;
	}

	/**
     * Permite accesar a las patas del animal.
     * @return las patas del animal.
    */
	public String getPata(){

		return this.pata;
	}

	/**
     * Permite accesar a la cola del animal.
     * @return la cola del animal.
    */
	public String getCola(){

		return this.cola;
	}

	/**
     * Permite accesar al numero de patas del animal.
     * @return el numero de patas.
    */
	public int getNumeroDePatas(){

		return this.numeroDePatas;
	}

	/**
     * Permite accesar a si el animal tiene cola o no.
     * @return si el animal tiene cola o no.
    */
	public boolean getTieneCola(){

		return this.tieneCola;
	}

	/**
     * Permite accesar al color de la cabeza del animal.
     * @return el color de la cabeza.
    */
	public String getColorCabeza (){

		return this.colorCabeza; 
	}

	/**
     * Permite accesar al color del cuerpo del animal.
     * @return el color del cuerpo.
    */
	public String getColorCuerpo (){

		return this.colorCuerpo;
	}

	/**
     * Permite accesar al color de las patas del animal.
     * @return el color de las patas.
    */
	public String getColorPata (){

		return this.colorPata;
	}

	/**
     * Permite accesar al color de la cola del animal.
     * @return el color de la cola.
    */
	public String getColorCola (){

		return this.colorCola;
	}

	/**
     * Modifica el nomnre del animal.
     * @param nombre nombre del animal.
    */
	public void setNombre(String nombre){

		this.nombre = nombre;
	}

	/**
     * Modifica la cabeza del animal.
     * @param tipoDeCabeza cabeza del animal.
    */
	public void setCabeza(String tipoDeCabeza){

		this.cabeza = tipoDeCabeza;
	}

	/**
     * Modifica el cuerpo del animal.
     * @param tipoDeCuerpo cuerpo del animal.
    */
	public void setCuerpo(String tipoDeCuerpo){

		this.cuerpo=tipoDeCuerpo;
	}

	/**
     * Modifica las patas del animal.
     * @param tipoDePata patas del animal.
    */
	public void setPata(String tipoDePata){

		this.pata = tipoDePata;
	}

	/**
     * Modifica la cola del animal.
     * @param tipoDeCola cola del animal.
    */
	public void setCola(String tipoDeCola){

		this.cola=tipoDeCola;
	}

	/**
     * Modifica el numero de patas del animal.
     * @param numeroDePatas numero de patas del animal.
    */
	public void setNumeroDePatas(int numeroDePatas){

		this.numeroDePatas=numeroDePatas;
	}

	/**
     * Modifica la existecia de cola del animal.
     * @param cola cola del animal.
    */
	public void setTieneCola(boolean cola){

		this.tieneCola = cola;
	}

	/**
     * Modifica el color de la cabeza del animal.
     * @param color color de la cabeza.
    */
	public void setColorCabeza(String color){

		this.colorCabeza = color;
	}

	/**
     * Modifica el color del cuerpo del animal.
     * @param color color del cuerpo.
    */
	public void setColorCuerpo(String color){

		this.colorCuerpo = color;
	}

	/**
     * Modifica el color de las patas del animal.
     * @param color color de las patas.
    */
	public void setColorPata(String color){

		this.colorPata = color;
	}	

	/**
     * Modifica el color de la cola del animal.
     * @param color color de la cola.
    */	
	public void setColorCola(String color){

		this.colorCola	 = color;
	}

	@Override 
	public String toString(){

		String animal = "El animal es " + this.getNombre() + " tiene " + this.getNumeroDePatas() + " patas " ;
		return animal;
	}	
}