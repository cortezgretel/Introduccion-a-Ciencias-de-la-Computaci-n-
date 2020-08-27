public class Animal{

	private String cabeza;
	private String cola;
	private String pata;
	private String cuerpo;
	private String colorCabeza = "blanco" ;
	private String colorCuerpo = "blanco" ;
	private String colorPata= "blanco";
	private String colorCola="blanco" ;
	private String nombre;
	private boolean tieneCola;
	private int numeroDePatas;


	public Animal (String animal, int patas , boolean cola, String color ){

		if (patas == 0){
			this.setPata(null);
		}
		if (cola == false){
			this.setCola(null);
		}

		if (patas > 0){
			this.setPata(animal);
			this.setColorPata(color);
		}

		if (cola == true){
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



	public String getNombre(){
		return this.nombre;
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
	public int getNumeroDePatas(){
		return this.numeroDePatas;
	}
	public boolean getTieneCola(){
		return this.tieneCola;
	}

	public String getColorCabeza (){
		return this.colorCabeza; 
	}
	public String getColorCuerpo (){
		return this.colorCuerpo;
	}
	public String getColorPata (){
		return this.colorPata;
	}
	public String getColorCola (){
		return this.colorCola;
	}


	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setCabeza(String tipoDeCabeza){
		this.cabeza = tipoDeCabeza;
	}

	public void setCola(String tipoDeCola){
		this.cola=tipoDeCola;
	}

	public void setPata(String tipoDePata){
		this.pata = tipoDePata;
	}

	public void setCuerpo(String tipoDeCuerpo){
		this.cuerpo=tipoDeCuerpo;
	}

	public void setNumeroDePatas(int numeroDePatas){
		this.numeroDePatas=numeroDePatas;
	}

	public void setTieneCola(boolean cola){
		this.tieneCola = cola;
	}
	public void setColorCabeza(String color){
		this.colorCabeza = color;
	}
	public void setColorCuerpo(String color){
		this.colorCuerpo = color;
	}
	public void setColorPata(String color){
		this.colorPata = color;
	}	
	public void setColorCola(String color){
		this.colorCola	 = color;
	}

	@Override 
	public String toString(){
		String animal = "El animal es " + this.getNombre() + " tiene " + this.getNumeroDePatas() + " patas " ;
		return animal;
	}






	
}