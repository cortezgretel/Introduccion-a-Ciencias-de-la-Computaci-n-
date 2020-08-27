public class Nodo{
	
	/**Variable del valor del nodo*/

	private Animal elemento;

	/**Variable del Nodo siguiente*/
	private Nodo siguiente;

	/**Metodo constructor 
	* @param valor 
	*/
	public Nodo (Animal valor){
		this.elemento=valor;
		siguiente= null;
	}

	/**Metodo de acceso
	*que nos servira para poder acceder al elemento 
	*@return  elemento
	*/

	public Animal getElemento(){
		return this.elemento;
	}

	/**Metodo de acceso
	*que nos servira para poder acceder a siguiente
	*@return Nodo siguiente 
	*/
	public Nodo getSiguiente(){
		return this.siguiente;
	}


	/**Metodo mutante 
	*que nos ayudara para cambiar la referencia del nodo
	*@param  nuevo 
	*/
	public void setSiguiente(Nodo nuevo){
		this.siguiente= nuevo;
	}

	@Override
	public String toString(){
		return "" + this.elemento;
	}

}