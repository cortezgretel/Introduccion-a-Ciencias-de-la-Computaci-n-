public class Lista{
	  /**Atributo Cabeza: es la cabeza del catalogo*/
  public Nodo cabeza;
  public int tamanio=0;

  /**Metodo muestra que no recibe parametros y tampoco tiene un regreso
  * que nos ayudara para mostrar lista */
  public void muestra(){
      System.out.println("CATALOGO DE ANIMALES");
      Nodo iterador=cabeza;
  	  int contador = 0;
  	  if (iterador== null){
      System.out.println("NO HAY ANIMALES EN El CATALOGO");
      return;
    }
    while(iterador!=null){
      	System.out.println(contador + " "+ iterador.getElemento().getCabeza()) ;
      	contador++;
      	iterador=iterador.getSiguiente();
    }

    System.out.println("CATALOGO CABEZAS DE ANIMALES");
    Nodo iterador0=cabeza;
    while(iterador0!=null){
      	System.out.println("Cabeza de  "+ iterador0.getElemento().getCabeza()  + " color de la cabeza : " +  iterador0.getElemento().getColorCabeza()) ;
      	iterador0=iterador0.getSiguiente();
    }
    System.out.println("CATALOGO CUERPOS DE ANIMALES");
    Nodo iterador1=cabeza;
     while(iterador1!=null){
      	System.out.println("Cuerpo de " + iterador1.getElemento().getCuerpo()  + " color del cuerpo: : " + iterador1.getElemento().getColorCuerpo()) ;
      	iterador1=iterador1.getSiguiente();
      
    }
    
    System.out.println("CATALOGO PATAS DE ANIMALES");
    Nodo iterador2=cabeza;
      while(iterador2!=null){
      	System.out.print(iterador2.getElemento().getPata() == null? "" : "Patas de " + iterador2.getElemento().getPata() + " y tiene " + iterador2.getElemento().getNumeroDePatas()+  " patas y de color : "+ iterador2.getElemento().getColorPata()+"\n") ;
      	iterador2=iterador2.getSiguiente();
    }
    
    System.out.println("CATALOGO COLAS DE ANIMALES");
    Nodo iterador3=cabeza;
      while(iterador3!=null){
      	System.out.print(iterador3.getElemento().getCola() == null? " " : "Cola de " + iterador3.getElemento().getCola() + " color de la cola : " + iterador3.getElemento().getColorCola()+ "\n") ;
      	iterador3=iterador3.getSiguiente();
    }
    System.out.println("\n");
  }

  
  private void insertaPrimero(Animal objeto){
    Nodo nuevo = new Nodo(objeto);
    nuevo.setSiguiente(cabeza);
    cabeza = nuevo;
    this.tamanio++;
 
  }

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
		for(iterador = cabeza; iterador != null; iterador = iterador.getSiguiente() ) {
			contador++;

			if (contador == indice){
				nuevo.setSiguiente(iterador.getSiguiente());
				iterador.setSiguiente(nuevo);
				iterador = nuevo;
				verifica = true;
				tamanio++;
			}

		}
		if (contador < indice) verifica = false ;


		return verifica;

	}


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

  public Animal obten(int indice){
  Nodo regreso = new Nodo (null);
  Nodo iterador;
  int contador = -1;

    for(iterador = cabeza; iterador != null; iterador = iterador.getSiguiente() ) {
      contador++;
      if (contador == indice){
        regreso=iterador;
      }
    }

    if (contador < indice || indice<0) {
    	regreso=null;
    	return regreso.getElemento();
    }

    return regreso.getElemento();
  }
  
  

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