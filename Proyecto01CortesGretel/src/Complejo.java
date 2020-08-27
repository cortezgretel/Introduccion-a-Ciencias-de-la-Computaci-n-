/**Clase que crea un numero Complejo y además implementa la interfaz ServiciosComplejos
*@author Cortés Macias Gretel Penélope */

/**Importamos el paquete java.lang.Math para poder hace una raiz cuadrada */
import java.lang.Math;

public class Complejo implements ServiciosComplejos{

	/**Atributos de la clase 
	*private double imaginario
	*private double real
	*public final char I= 'i' (este es un valor constante ya que no necesitamos que cambie)
	*/

	private double imaginario;
	private double real;
	public final char I = 'i'; 



	/**Método constructor del numero complejo 
	que recibe 
	@param double imaginario
	@param double real 
	@param char i
	*/

	public Complejo (double real, double imaginario,char I ){
		this.real=real;
		this.imaginario=imaginario;			
	}

	/**Método constructor vacio*/

	public Complejo(){
		this.real=0.0;
		this.imaginario=0.0;
	}



	/**Métodos de Acceso */

	public double getImaginario(){
		return this.imaginario;
	}
	public double getReal(){
		return this.real;
	}
	public char getI(){
		return this.I;
	}


	/**Métodos Mutantes */

	public void setImaginario(double imaginario){
		this.imaginario=imaginario;
	}
	public void setReal(double real){
		this.real=real;
	}

	/**Método toString 
	*@return String 
	*Este nos ayudara a darle formato de String a los instancias que se creen
	*/

	public String toString(){
		String complejo;
		complejo= this.real + " + " + this.imaginario  + this.I ;
		return complejo;
	}

	/**Métodos de la interfaz ServiciosComplejos que se implementaron */


	public Complejo sumaComplejos(Complejo b){
		this.real += b.real;
		this.imaginario += b.imaginario;

		return this;
	}


	/**Método restaAuxiliar 
	*@param Complejo a
	*@param Complejo b 
	*@return double
	*Este método nos ayudara para el método multiplicaComplejo de la interfaz en realizar la resta
	*para representar el numero real del nuevo Complejo
	*/

	public double restaAuxiliar(Complejo a, Complejo b){
		return (a.real*b.real)-(a.imaginario*b.imaginario);
	}


	/**Método sumaAuxiliar 
	*@param Complejo a
	*@param Complejo b 
	*@return double
	*Este método nos ayudara para el metodo multiplicaComplejo de la interfaz en realizar la suma
	*para representar el numero imaginario del nuevo Complejo
	*/

	public double sumaAuxiliar(Complejo a, Complejo b){
		return (a.real*b.imaginario)+(a.imaginario*b.real);
	}

	public Complejo multiplicaComplejo(Complejo b){

		Complejo resultadoMultiplica= new Complejo();

		resultadoMultiplica.real = restaAuxiliar(this, b);
		resultadoMultiplica.imaginario = sumaAuxiliar(this, b );

		return resultadoMultiplica; 
	}


	public Complejo complejoCuadrado(){
		return this.multiplicaComplejo(this);
	}

	
	public 	Complejo complejoCubo(){
		return this.complejoCuadrado().multiplicaComplejo(this);
	}


	public Complejo complejoConjugado(){
		this.imaginario=-this.imaginario;
		return this;
	}

	/**Método auxiliarInverso
	*@param Complejo auxiliar
	*@return Complejo 
	*Este método nos ayudara para realizar el proceso de complejo Inverso, en el cual haremos las operaciones y 
	*crearemos un nuevo Complejo con los nuevos ajustes
	*/

	public Complejo auxiliarInverso (Complejo auxiliar){
        double denominador=(auxiliar.real*auxiliar.real) + (auxiliar.imaginario*auxiliar.imaginario);  
        return new Complejo( auxiliar.real/denominador, - auxiliar.imaginario/denominador, 'i');
    }


	public Complejo complejoInverso(){
		return auxiliarInverso(this);
	}

	/**Método auxiliarDivide
	*@param Complejo a
	*@param Complejo b
	*@return Complejo 
	*Este método ayuda el proceso de complejoDivide, en este método utilizamos el método multiplicaComplejo
	*para multiplicar dos complejos y el volver uno de estos números a su inverso asi que tambien usamos el 
	*método complejoInverso*/

	public Complejo auxiliarDivide(Complejo a, Complejo b){
		return a.multiplicaComplejo(b.complejoInverso());
	}


	public Complejo complejoDivide(Complejo b){
		return auxiliarDivide(this,b);
	}


	public double complejoModulo(){
		return Math.sqrt((this.real*this.real)+(this.imaginario*this.imaginario));
	}


	public boolean complejoEsIgual(Complejo b){
		if(this.real == b.real && this.imaginario==b.imaginario ){
			return true; }else{
				return false;
			}
	}


	public String complejoMuestra(){
		String complejo;
		complejo= this.real + " + " + this.imaginario  + this.I ;
		return complejo;
	}


	/**Método Main= es el método ejecutable del programa
	*En este método iran las pruebas de la Clase Complejo con el fin de probar que esten correctos las implementaciones
	*de los métodos*/

	public static void main (String [] args){
		//Creación de las instacias de la clase Complejo
		Complejo a = new Complejo(4.0 , 7.0, 'i');
		Complejo b= new Complejo(2.0 , 8.0, 'i');
		Complejo c= new Complejo(4.0 , 7.0, 'i');
		Complejo d= new Complejo(2.0 , 8.0, 'i');
		Complejo e= new Complejo(2.0 , 4.0, 'i');
		Complejo f = new Complejo(1.0, 2.0 ,'i');
		Complejo g= new Complejo(3.0, 4.0, 'i');
		Complejo h = new Complejo(5.0, 4.0,'i');
		Complejo i = new Complejo(4.0,2.0, 'i');
		Complejo j = new Complejo(6.0,16.0,'i');
		Complejo k = new Complejo (4.0, 3.0,'i');
		Complejo l = new Complejo(4.0,3.0,'i');
		Complejo m = new Complejo(4.0,2.0,'i');
		Complejo n = new Complejo (8.0, 5.0, 'i');

		System.out.println("Estos son los números complejos a utilizar : ");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		System.out.println(m);
		System.out.println(n);

		System.out.println("Después de utilizar los métodos");

		//Prueba de sumaComplejos
		System.out.println(a.sumaComplejos(b));

		//Prueba de multiplicaComplejo
		System.out.println(c.multiplicaComplejo(d));

		//Prueba de complejoCuadrado
		System.out.println(e.complejoCuadrado());

		//Prueba de complejoCubo
		System.out.println(f.complejoCubo());

		//Prueba de complejoConjugado		
		System.out.println(g.complejoConjugado());

		//Prueba de complejoInverso
		System.out.println(h.complejoInverso());

		//Prueba de complejoDivide
		System.out.println(i.complejoDivide(j));

		//Prueba de complejoModulo
		System.out.println(k.complejoModulo());

		//Prueba de complejoEsIgual
		System.out.println(l.complejoEsIgual(m));

		//Prueba de complejoMuestra
		System.out.println(k.complejoMuestra());
		

	}	

}






























