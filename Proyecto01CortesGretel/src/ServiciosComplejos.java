

/**Interfaz servicios complejos
*@author Pedro Ulises Cervantes Gónzalez   */

public interface ServiciosComplejos{

	/**Suma dos números complejos y entrega el resultado .
	*@param otro El segundo complejo (El primero es el objeto con que se invoca ).
	* @return El complejo que corresponde a:
			(a+bi) + (c+di) = (a+c) + (b+d) i
	*/
	public Complejo sumaComplejos(Complejo b );


	/**Multiplica dos números complejos y entrega el resultado .
	* @param otro El segundo complejo (El primero es el
	* objeto con que se invoca ).
	* @return El complejo que corresponde a:
		    (a+bi) * (c+di) = (ac-bd)+(ad+bc)i

	*/
	public Complejo multiplicaComplejo(Complejo b);

	/**Calcula el cuadrado del complejo con que se invoca .
	* @return El complejo que corresponde a:
			 (a+bi)²
	*/

	public Complejo complejoCuadrado();

	/*** Calcula el cubo del complejo con que se invoca .
	* @return El complejo que corresponde a:
			(a+bi)³
	*/

	public Complejo complejoCubo();

	/**Calcula el conjugado del complejo con que se invoca .
	* @return (a-bi)
	*/

	public Complejo complejoConjugado();

	/**Calcula el inverso multiplicativo del complejo con que se invoca .
	* @return El complejo que corresponde a:
	*/
	
	public Complejo complejoInverso();

	/**Divide dos números complejos y entrega el resultado .
	* @param otro El segundo complejo (El primero es el objeto con que se invoca ).
	* @return (a+bi)*(c+di)-¹ 

	*/

	public Complejo complejoDivide(Complejo b);
	
	/**Calcula el módulo del complejo con que se invoca .
	* @return raiz cuadrada(a²+b²)

	*/

	public double complejoModulo();

	/**Compara dos números complejos para saber si son iguales .
	 @param otro El segundo complejo (El primero es el objeto con que se invoca ).
	* @return true si son iguales , false en otro caso .*/
	
	public boolean complejoEsIgual(Complejo b);

	/** Devuelve una cadena en formato adecuado que representa al complejo que invoca el m ́e todo .
	* @return Una cadena con formato adecuado .
	*/
	
	public String complejoMuestra();
}