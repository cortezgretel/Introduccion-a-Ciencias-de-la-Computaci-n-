/**
 * PROYECTO 4 ICC
 * Clase Alebrije
 * @author Gretel Penelope Cruz Macias.
 * @author Valeria Fernanda Manjarrez Angeles
 * @version 2.0 
*/
public class Alebrije{

  /** Arreglo que puede ser visto como el cuerpo del alebrije */
  public String[] alebrije = new String [4];

  /** Color de la cabeza del alebrije */
  private String colorCabeza;

  /** Color del cuerpo del alebrije */
  private String colorCuerpo;

  /** Color de las patas del alebrije */
  private String colorPata;

  /** Color de la cola del alebrije */
  private String colorCola;

  /**
   * Constructor de un alebrije.
   * @param tipoCabeza cabeza del alebrije.
   * @param colorCabeza color de la cabeza del alebrije.
   * @param tipoCola cola del alebrije.
   * @param colorCola color de la cola del alebrije. 
   * @param tipoPata patas del alebrije.
   * @param colorPata color de las patas del alebrije.
   * @param tipoCuerpo cuerpo del alebrije.
   * @param colorCuerpo color del cuerpo del alebrije.
  */
  public Alebrije(Animal tipoCabeza,String colorCabeza, Animal tipoCola, String colorCola, 
                  Animal tipoPata, String colorPata, Animal tipoCuerpo, String colorCuerpo){
    
    alebrije[0]= tipoCabeza.getCabeza();
    alebrije[1]= tipoCuerpo.getCuerpo();
    alebrije[2]= tipoPata.getPata();
    alebrije[3]= tipoCola.getCola();
    this.setColorCabeza(colorCabeza);
    this.setColorCola(colorCola);
    this.setColorPata(colorPata);
    this.setColorCuerpo(colorCuerpo);
  }

  /**
   * Permite accesar a la cabeza del alebrije.
   * @return la cabeza del alebrije.
  */
  public String getCabeza(){

    return alebrije[0];
  }

  /**
   * Permite accesar a la cola del alebrije.
   * @return la cola del alebrije.
  */
  public String getCola(){

    return alebrije[3];
  }

  /**
   * Permite accesar a las patas del alebrije.
   * @return las patas del alebrije.
  */
  public String getPata(){

    return alebrije[2];
  }

  /**
   * Permite accesar al cuerpo del alebrije.
   * @return el cuerpo del alebrije.
  */
  public String getCuerpo(){

    return alebrije[1];
  }

  /**
   * Modifica la cabeza del alebrije.
   * @param cabeza cabeza del alebrije.
  */
  public void setCabeza(String cabeza){

    this.alebrije[0] = cabeza;
  }

  /**
   * Modifica la cola del alebrije.
   * @param cola cola del alebrije.
  */
  public void setCola(String cola){
    
    this.alebrije[3]=cola;
  }

  /**
   * Modifica las patas del alebrije.
   * @param pata patas del alebrije.
  */
  public void setPata(String pata){
    
    this.alebrije[2]=pata;
  }

  /**
   * Modifica el cuerpo del alebrije.
   * @param cuerpo cuerpo del alebrije.
  */
  public void setCuerpo(String cuerpo){

    this.alebrije[1]=cuerpo;
  }

  /**
   * Permite accesar al color de la cabeza del alebrije.
   * @return el color de la cabeza.
  */
  public String getColorCabeza(){

    return this.colorCabeza;
  }

  /**
   * Permite accesar al color del cuerpo del alebrije.
   * @return el color del cuerpo.
  */
  public String getColorCuerpo(){

    return this.colorCuerpo;
  }

  /**
   * Permite accesar al color de las patas del alebrije.
   * @return el color de las patas.
  */
  public String getColorPata(){

    return this.colorPata;
  }

  /**
   * Permite accesar al color de la cola del alebrije.
   * @return el color de la cola.
  */
  public String getColorCola(){

    return this.colorCola;
  }

  /**
   * Modifica el color de la cabeza del alebrije.
   * @param color color de la cabeza.
   */
  public void setColorCabeza(String color){

    this.colorCabeza=color;
  }

  /**
   * Modifica el color del cuerpo del alebrije.
   * @param color color del cuerpo.
  */
  public void setColorCuerpo(String color){

    this.colorCuerpo=color;
  }

  /**
   * Modifica el color de las patas del alebrije.
   * @param color color de las patas.
  */
  public void setColorPata(String color){

    this.colorPata=color;
  }

   /**
   * Modifica el color de la cola del alebrije.
   * @param color color de la cola.
  */
  public void setColorCola(String color){

    this.colorCola=color;   
  }

  /**
   * Metodo muestra para representar una alebrije.
  */
  public void muestra(){

    String patas = this.alebrije[2] == null ? "No tiene patas" : "Patas de: " + this.alebrije[2] + " de color: " + this.colorPata;
    String alebrije = "El alebrije tiene:" + "\n" +
    "Cabeza de: "+ this.alebrije[0] + " de color: " + this.colorCabeza + "\n" + 
    "Cuerpo de: " + this.alebrije[1] + " de color: " + this.colorCuerpo +"\n"+
    patas + "\n"+
    "Cola de: " + this.alebrije[3] + " de color: " + this.colorCola + "\n" ;
    System.out.println(alebrije);
  }
}