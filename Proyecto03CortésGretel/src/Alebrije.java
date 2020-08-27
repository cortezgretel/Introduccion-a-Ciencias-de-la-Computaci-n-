public class Alebrije{

  /**Atributos de la clase Alebrije*/
  
  public String[] alebrije = new String [4];
  private String cabeza = alebrije[0];
  private String cuerpo = alebrije[1] ;
  private String pata = alebrije[2];
  private String cola = alebrije[3];
  private String colorCabeza;
  private String colorCuerpo;
  private String colorPata;
  private String colorCola;



  public Alebrije(Animal tipoCabeza,String colorCabeza, Animal tipoCola, String colorCola, Animal tipoPata, String colorPata, Animal tipoCuerpo, String colorCuerpo){
    
  alebrije[0]= tipoCabeza.getCabeza();
  alebrije[1]= tipoCuerpo.getCuerpo();
  alebrije[2]= tipoPata.getPata();
  alebrije[3]= tipoCola.getCola();
  this.setColorCabeza(colorCabeza);
  this.setColorCola(colorCola);
  this.setColorPata(colorPata);
  this.setColorCuerpo(colorCuerpo);

  }

  public String getCabeza(){
    return this.cabeza;
  }
  public String getCola(){
    return this.cola;
  }
  public String getPata(){
    return this.pata;
  }
  public String getCuerpo(){
    return this.cuerpo;
  }

  public void setCabeza(String cabeza){
    this.cabeza=cabeza;
  }
  public void setCola(String cola){
    this.cola=cola;
  }
  public void setPata(String pata){
    this.pata=pata;
  }
  public void setCuerpo(String cuerpo){
    this.cuerpo=cuerpo;
  }


  public void setColorCabeza(String color){
    this.colorCabeza=color;
  }

  public void setColorCuerpo(String color){
    this.colorCuerpo=color;
  }

  public void setColorPata(String color){
    this.colorPata=color;
  }

  public void setColorCola(String color ){
    this.colorCola=color;   
  }

  public void muestra(){
    String patas = this.alebrije[2] == null ? "No tiene patas" : "patas de  : " + this.alebrije[2] + " de color " + this.colorPata;
    String alebrije = "El alebrije tiene :" + "\n" +
    "cabeza de : "+ this.alebrije[0] + " de color " + this.colorCabeza + "\n" + 
    "cuerpo de : " + this.alebrije[1] + " de color " + this.colorCuerpo +"\n"+
     patas + "\n"+
    "cola de : " + this.alebrije[3] + " de color " + this.colorCola + "\n" ;
    
    System.out.println(alebrije);
    
  
  }

}