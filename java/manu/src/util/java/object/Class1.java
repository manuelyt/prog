package util.java.object;


public class Class1 {

/*
 * ayer en una entrevista, en un test me hicieron esta pregunta
 * asi que me hice el ejemplito para saber la respuesta
 * 
 * la chicha esta en la otra clase, Class2
 * en el metodo method1
 * lo que se hace es que se van  añadiendo objetos a una lista
 * pero es un ejemplo de un error tipico
 * se supone que se quieren meter valores que van cambiando
 * pero no es asi, porque lo que se mete es un objeto que es el mismo
 * se mete la referencia a ese objeto, no una copia de ese objeto 
 *
 * esta es la salida de este codigo :
 * 
 * [ - id : 3 , name: 3 . ,  - id : 3 , name: 3 . ,  - id : 3 , name: 3 . ]
 */

	public static void main(String[] args) {
		Class2 xxx2 = new Class2();
	}
}
