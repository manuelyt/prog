package manu.java.lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Buena {

	interface FuncInterface {
		// An abstract function
		Iterator<StackTraceElement> abstractFun(Stream<StackTraceElement> x);

		// A non-abstract (or default) function
		default void normalFun() {
			System.out.println("Hello");
		}
	}

	public static String getTrazaPilaHiloStringV2(Thread hilo) {
		String ret = "\n\t";
		try {
			if (hilo != null) {
				FuncInterface fobj = (Stream<StackTraceElement> x) -> x.iterator();
				Iterator<StackTraceElement> kkll23 = fobj.abstractFun(Arrays.asList(hilo.getStackTrace()).stream());
				while (kkll23.hasNext()) {
					StackTraceElement kkll24 = kkll23.next();
					ret += kkll24.getClassName() + "\n\t";
				}

				ret += "\n ---------- \n \n";

				List<StackTraceElement> lh = Arrays.asList(hilo.getStackTrace());
				for (StackTraceElement olh : lh) {
					ret += olh.getClassName() + "\n\t";
				}

				if (ret.length() < 3)
					ret = "";

				return Arrays.asList(hilo.getStackTrace()).stream().map(s -> s.toString())
				.collect(Collectors.joining("\n\t"));

			}
		} catch (Exception e) {
			System.out.println("error - excep");
			e.printStackTrace();
//			logger.error("No se puede sacar la traza del hilo");
		}
		return ret;
	}

	public static void main(String[] args) {
		Thread t22 = Thread.currentThread();
		String kktp22 = getTrazaPilaHiloStringV2(t22);
		System.out.println(kktp22);
	}
}
