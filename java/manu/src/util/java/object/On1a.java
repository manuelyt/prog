package util.java.object;

/*
 * en tour diez hoy he tenido un problema con un null pointer en un objeto que me cree
 * asi que hoy en casa me he intentado reproducir el problema para ver si asi podia 
 * entenderlo, y asi arreglarlo
 * pero no, aqui en casa, en mi ejemplito funciona, no casca como en el curro
 */
public class On1a {
	int x;
	On2a in2a;

	public void run() {
		On1a in1a = new On1a();
		On2a in2b = new On2a();
		On3a in3b = new On3a();
		String in4b[] = { "aaa" };
		in3b.setY(in4b);
		in2b.setIn3a(in3b);
		in2a = in2b;
	}
}
