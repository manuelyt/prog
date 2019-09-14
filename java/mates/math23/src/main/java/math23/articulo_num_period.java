package math23;

import java.math.BigDecimal;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.primes.Primes;

import ch.obermuhlner.math.big.BigDecimalMath;
import java.math.MathContext;

//import java.math.RoundingMode;  
//import com.google.common.math.IntMath;  
//import org.apache.commons.math3.util.BigReal;

/*
me lei este articulito
https://www.freecodecamp.org/news/interview-questions/
y me gusto, pero me chirrio un poco, asi que me puse a rascar un poco, y mira por donde me encontre con esto
el colega en el articulo hace una rutitina para devolver esto :
1) 1/3 = 0.(3)
2) 1/4 = 0.25
3) 1/5 = 0.2
4) 1/6 = 0.1(6)
5) 1/7 = 0.(142857)
6) 1/8 = 0.125
pero creo que esta mal, falla para numeros grandes
 1 / 59 = 0.0(1694915254237288135593220338983050847457627118644067796610)

### solucion
para verlo probe a dividir 1 entre primos un poco mas grandes, 
y parece que lo que decia el articulo esta mal
para ver las divisiones con mucha precision tuve que usar la clase bigfraction de la api de apache de mates
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-math3</artifactId>
bye
por el camino estuvi mirando tambien la api de google de guava
https://guava.dev/
pero la de apache parece bastante mas completa y potente, tiene muchos sub paquetes : analysis, geometry, neuralnet, optimization, stat
https://commons.apache.org/proper/commons-math/javadocs/api-3.4/org/apache/commons/math3/package-use.html
 */

class articulo_num_period {

	public static void main(String args[]) {

//		esto usa la libreria de apache
		int kk22 = 7566474;
		kk22 = 55;
		int c = Primes.nextPrime(kk22);
		BigFraction a = new BigFraction(1, c);
		System.out.print(" \n \n  ");
		System.out.print(1 + " / " + c + " = " + a.bigDecimalValue(80, BigDecimal.ROUND_HALF_UP));
		System.out.print(" \n \n  ");

		MathContext mc = new MathContext(100);
//		esto usa : obermuhlner ( via maven ) ( https://github.com/eobermuhlner/big-math )
		System.out.println(BigDecimalMath.pi(mc));

//		BigReal a = new BigReal(1); 
//		int kk22 = 7566474;
////		kk22 = 7;
//		int c = Primes.nextPrime(kk22) ;
//		BigReal d = new BigReal(c); 
//		BigReal e = a.divide(d); 
//		
//		System.out.print(" \n \n  " + a.doubleValue() + " / " + d.doubleValue() + " = " + e.doubleValue() + "\n \n ");
//		
//		
//		
//		
//		

//		int kk22 = 99999999;
//		kk22 = 7566474;
//		int c = Primes.nextPrime(kk22) ;
//		System.out.print(
//				" \n \n  El siguiente primo mayor que :   " + kk22 + " es  " + c + "\n \n ");
//
//		
//		
//		
//
//	double a = 1;
//	double b = 7;
//	
//	System.out.print(" \n \n  " + a + " / " + c + " = " + a/c + "\n \n ");
//	

//        int a1 = 63; 
//          
//        // Using isPrime(int n)  
//        // method of Guava's IntMath class 
//        if(IntMath.isPrime(a1)) 
//        System.out.println(a1 + " is a prime number"); 
//        else
//        System.out.println(a1 + " is not a prime number"); 
//          
//        int a2 = 17; 
//          
//        // Using isPrime(int n)  
//        // method of Guava's IntMath class 
//        if(IntMath.isPrime(a2)) 
//        System.out.println(a2 + " is a prime number"); 
//        else
//        System.out.println(a2 + " is not a prime number"); 
	}
}

//
//package aaa ;
//
//public class kk23 {
//
//	public static void main(String[] args) {
//
////		double a = 1;
////		double b = 7;
////		
////		
////		System.out.print(" \n \n  " + a + " / " + b + " = " + a/b + "\n \n ");
////
//////		System.out.print(" \n \n  hola mundo \n \n ");
//
//		double a = 1;
//		double b = 7;
//		
//		
//		System.out.print(" \n \n  " + a + " / " + b + " = " + a/b + "\n \n ");
//
////		System.out.print(" \n \n  hola mundo \n \n ");
//		
//	}
//
//}
