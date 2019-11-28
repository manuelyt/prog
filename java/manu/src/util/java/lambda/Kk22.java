package util.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.graalvm.compiler.nodes.extended.GetClassNode;

//import es.market.utilidades.UtilidadesString;
//import jdk.jfr.StackTrace;

public class Kk22 {

	@FunctionalInterface
	public interface Foo {
		String method(String string);
	}

	public String add22(String string, Foo foo) {
		return foo.method(string);
	}
	
	// Java program to demonstrate lambda expressions 
	// to implement a user defined functional interface. 
	  
	// A sample functional interface (An interface with 
	// single abstract method 
	interface FuncInterface 
	{ 
	    // An abstract function 
	    void abstractFun(int x); 
	  
	    // A non-abstract (or default) function 
	    default void normalFun() 
	    { 
	       System.out.println("Hello"); 
	    } 
	} 
	
	interface FuncInterface2 
	{ 
	    // An abstract function 
	    Iterator<StackTraceElement> abstractFun(Stream<StackTraceElement> x); 
	  
	    // A non-abstract (or default) function 
	    default void normalFun() 
	    { 
	       System.out.println("Hello"); 
	    } 
	} 
	
	public static String getTrazaPilaHiloString(Thread hilo) {
		try {
			if (hilo != null) {

				Predicate<Object> predicate = new Predicate<Object>() {
					@Override
					public boolean test(Object item) {
						return true;
					}
				};

				Integer num = 0;
				num = 1;
//			    Function<Integer,  List> listSupplier2 = (num) > new  ArrayList(num);

				Function<Integer, List> listSupplier = ArrayList::new;
				List lista = listSupplier.apply(5);

				System.out.println(lista.size());
				if (lista.size() > 0) {

					for (Object ll : lista) {
						System.out.println(ll);

					}
				}

				//
				//
				//

				// lambda expression to implement above
				// functional interface. This interface
				// by default implements abstractFun()
				FuncInterface fobj = (int x) -> System.out.println(2 * x);

				// This calls above lambda expression and prints 10.
				fobj.abstractFun(5);
				fobj.abstractFun(3432);
				System.out.println(" -------------------- ");

				Stream<StackTraceElement> xx = Arrays.asList(hilo.getStackTrace()).stream();
				
				
				
				FuncInterface2 fobj2 = (Stream<StackTraceElement> x) -> x.iterator();
				
//			    Iterator<StackTraceElement> kkll23 = null;
			    Iterator<StackTraceElement> kkll23 = fobj2.abstractFun(Arrays.asList(hilo.getStackTrace()).stream());

//				String kkll22 = fobj2.abstractFun(Arrays.asList(hilo.getStackTrace()).stream());

				
//				FuncInterface2 fobj2 = (Stream<StackTraceElement> x) -> (StackTraceElement[]) x.toArray();
//				StackTraceElement[] kkll22 = fobj2.abstractFun(Arrays.asList(hilo.getStackTrace()).stream());

			    
			    while(kkll23.hasNext()) {
			    	StackTraceElement kkll24 = kkll23.next();
					System.out.println(kkll24.getClassName());
			    }
//			    
//			    for (StackTraceElement kkll24:kkll22) {
//
//					System.out.println(kkll24.getClassName());
//			    }
//			    
//				System.out.println(kkll22);
				
				System.out.println(" -------------------- ");
				
				//
				//
				//

//				Foo useFoo =
//				
//				Function<String, String> fn = 
//						  parameter -> parameter + " from lambda";
//						String result = useFoo.add22("Message ", fn);
//				
//				

				Foo foo = parameter -> parameter + " from Foo";

				String st22 = "xxxx";
//						st22.add22();

//			    Function<StackTrace, String> listSupplier3 = StackTrace.GetClassName::toString; 
//			    
//				return Arrays.asList(hilo.getStackTrace()).stream().map(listSupplier)
//						.collect(Collectors.joining("\n\t"));

//				return Arrays.asList(hilo.getStackTrace()).stream().map(s -> s.toString())
//						.collect(Collectors.joining("\n\t"));
			}
		} catch (Exception e) {

			System.out.println("error - excep");
			e.printStackTrace();

//			logger.log(l22, "No se puede sacar la traza del hilo" + e.getMessage());

		}

		return null;

	}

	


	public static String getTrazaPilaHiloStringV2(Thread hilo) {
		try {
			if (hilo != null) {
//				return Arrays.asList(hilo.getStackTrace()).stream().map(s -> s.toString())
//						.collect(Collectors.joining("\n\t"));
			}
		} catch (Exception e) {
			System.out.println("error - excep");
//			logger.error("No se puede sacar la traza del hilo");
//			logger.log(l22, "No se puede sacar la traza del hilo" + e.getMessage());
		}

		return null;

	}
	
	public static void main(String[] args) {

		Thread t22 = Thread.currentThread();

		String kktp22 = getTrazaPilaHiloStringV2(t22);

		System.out.println(kktp22);

	}

}
