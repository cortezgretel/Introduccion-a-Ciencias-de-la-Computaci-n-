/**
 * PROYECTO 4 ICC
 * Clase Nodo
 * @author Gretel Penelope Cruz Macias.
 * @author Valeria Fernanda Manjarrez Angeles
 * @version 1.0 
 */
public class Nodo{
	
	/** Variable del valor del nodo. */
	private Animal elemento;

	/** Variable del Nodo siguiente. */
	private Nodo siguiente;

	/**
     * Construye de un nodo con un elemento.
     * @param valor el elemento del nodo.
    */    
	public Nodo(Animal valor){

		this.elemento=valor;
		siguiente= null;
	}

	/**
     * Permite accesar al elemento del nodo.
     * @return el elemento del nodo.
     */
	public Animal getElemento(){

		return this.elemento;
	}

	/**
     * Permite accesar al nodo siguiente.
     * @return el nodo siguiente.
     */
	public Nodo getSiguiente(){

		return this.siguiente;
	}

	/**
     * Modifica la referencia del nodo siguiente.
     * @param nuevo el nuevo nodo siguiente.
     */
	public void setSiguiente(Nodo nuevo){

		this.siguiente= nuevo;
	}

	@Override
	public String toString(){

		return "" + this.elemento;
	}
}