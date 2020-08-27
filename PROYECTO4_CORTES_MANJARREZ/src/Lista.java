/**
 * PROYECTO 4 ICC
 * Clase Lista
 * @author Gretel Penelope Cruz Macias.
 * @author Valeria Fernanda Manjarrez Angeles
 * @version 1.0 
 */
public class Lista{

	/**Primer elemento de la lista. */
  public Nodo cabeza;

  /**Tamaño de la lista. */
  public int tamanio=0;

  /**Metodo muestra que representa el catalogo lisa. */
  public void muestra(){

    System.out.println("~~~~~~~~~~~~CATALOGO DE ANIMALES~~~~~~~~~~~~");
    Nodo iterador=cabeza;
    int contador = 0;
    if (iterador== null){
      System.out.println("\n" + "~~~~~~~~~~~~NO HAY ANIMALES EN El CATALOGO~~~~~~~~~~~~");
      return;
    }
    while(iterador!=null){
      System.out.println(contador + " " + iterador.getElemento().getCabeza()) ;
      contador++;
      iterador=iterador.getSiguiente();
    }
    System.out.println("\n" + "~~~~~~~~~~~~CATALOGO CABEZAS DE ANIMALES~~~~~~~~~~~~");
    Nodo iterador0=cabeza;
    while(iterador0!=null){
      System.out.println("Cabeza de "+ iterador0.getElemento().getCabeza()  + " color " +  iterador0.getElemento().getColorCabeza()) ;
      iterador0=iterador0.getSiguiente();
    }
    System.out.println("\n" + "~~~~~~~~~~~~CATALOGO CUERPOS DE ANIMALES~~~~~~~~~~~~");
    Nodo iterador1=cabeza;
    while(iterador1!=null){
      System.out.println("Cuerpo de " + iterador1.getElemento().getCuerpo()  + " color " + iterador1.getElemento().getColorCuerpo()) ;
      iterador1=iterador1.getSiguiente();
    }
    System.out.println("\n" + "~~~~~~~~~~~~CATALOGO PATAS DE ANIMALES~~~~~~~~~~~~");
    Nodo iterador2=cabeza;
    while(iterador2!=null){
      System.out.print(iterador2.getElemento().getPata() == null? "" : "Patas de " + iterador2.getElemento().getPata() + " con " + iterador2.getElemento().getNumeroDePatas()+  " patas color "+ iterador2.getElemento().getColorPata()+"\n") ;
      iterador2=iterador2.getSiguiente();
    }
    System.out.println("\n" + "~~~~~~~~~~~~CATALOGO COLAS DE ANIMALES~~~~~~~~~~~~");
    Nodo iterador3=cabeza;
    while(iterador3!=null){
        System.out.print(iterador3.getElemento().getCola() == null? " " : "Cola de " + iterador3.getElemento().getCola() + " color " + iterador3.getElemento().getColorCola()+ "\n") ;
        iterador3=iterador3.getSiguiente();
    }
    System.out.println();
  }

  /**
   * Metdodo auxiliar que inserta un animal al principio del catalogo,
   * desplazando todos los demás animales.
   * @param objeto El animal a insertar.
  */
  private void insertaPrimero(Animal objeto){

    Nodo nuevo = new Nodo(objeto);
    nuevo.setSiguiente(cabeza);
    cabeza = nuevo;
    this.tamanio++;
  }

  /**
   * Inserta un animal en la posición especificada de la catalogo, desplazando 
   * todos los demás animales.
   * @param objeto El animal a insertar.
   * @param indice La posición donde se insertará el animal. La posición debe
   * ser mayor o igual a cero, y menor o igual al tamaño del catalogo.
  */
  public boolean inserta(Animal objeto, int indice){

    Nodo nuevo = new Nodo (objeto);
		boolean verifica = false;
		Nodo iterador;
		int contador = 0;
		if (indice == 0) {
      nuevo.setSiguiente(cabeza);
			cabeza= nuevo;
			tamanio ++;
			verifica= true;
			return verifica;
		}
		for(iterador = cabeza; iterador != null; iterador = iterador.getSiguiente()){
		  contador++;
		  if (contador == indice){
        nuevo.setSiguiente(iterador.getSiguiente());
        iterador.setSiguiente(nuevo);
        iterador = nuevo;
        verifica = true;
        tamanio++;
			}
		}
		if (contador < indice) verifica = false;
		return verifica;
	}

  /**
   * Metodo auxiliar que verifica si el catalogo no tiene animales
   * @return true si el catalogo no tiene animales, false en otro caso.
  */
  private boolean estaVacia(){
    
    boolean vacia = false;
    if (cabeza==null){
      vacia= true;
    }
    if(cabeza!=null){
      vacia = false;
    }
    return vacia;
  }

  /**
   * Agrega un animal al catalogo, si el catalogo no tiene animales
   * se agrega al principio, en otro caso se agrega al final.
   * @param objeto El animal a agregar.
  */
  public void agregar(Animal objeto){
    
    Nodo nuevo = new Nodo(objeto);
    Nodo iterador = cabeza;
    iterador = cabeza;
    if(this.estaVacia()){
      this.insertaPrimero(objeto);
      return;
    }
    while (iterador != null){
      if((iterador.getSiguiente() == null)){
        nuevo.setSiguiente(iterador.getSiguiente());
        iterador.setSiguiente(nuevo);
        iterador= nuevo;
        this.tamanio++;
        return;
      }
      iterador = iterador.getSiguiente();
    } 
  }

  /**
   * Obtiene el animal en la posición especificada del catalogo.
   * @param indice La posición donde se encuentra el animal. La posición debe
   * ser mayor o igual a cero, y menor al tamaño de la lista.
   * @return El animal en la posición especificada. Si la posición es inválida
   * devuelve null.
  */
  public Animal obten(int indice){

    Nodo regreso = new Nodo (null);
    Nodo iterador;
    int contador = -1;
    for(iterador = cabeza; iterador != null; iterador = iterador.getSiguiente()){
      contador++;
      if (contador == indice){
        regreso=iterador;
      }
    }
    if(contador < indice || indice<0){
    	regreso=null;
    	return regreso.getElemento();
    }
    return regreso.getElemento();
  }
  
  /**
   * Elimina un animal en la posición especificada del catalogo, desplazando 
   * todos los demás animales.
   * @param indice La posición donde se eliminará el animal. La posición debe
   * ser mayor o igual a cero, y menor al tamaño del catalogo.
  */
  public void elimina(int indice){

    int contador = 0 ;
    Nodo iterador = cabeza;
    if (indice == 0){
      cabeza = cabeza.getSiguiente();
      return;
    }
    while((contador < (indice-1))&& indice < this.tamanio && indice >= 0 && iterador != null){
      iterador = iterador.getSiguiente();
      contador++;
    }
    iterador.setSiguiente(iterador.getSiguiente().getSiguiente());
    this.tamanio--;      
  }
}