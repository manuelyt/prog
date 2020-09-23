package util.java.funct;

import java.util.ArrayList;



/*

tal y como explica fenomenalmente aqui :

https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value

en java los parametros se pasan por valor
osea, cuando se pasa un numero entero a una funcion aunque se modifique el entero, el entero no se modifica

pero si se le pasa un objeto a una funcion, y dentro de la funcion se modifica el objeto si que se modifica

aqui he puesto algunos ejemplos

 */


public class RefVal {

    public static void main(String[] args) {

        System.out.println(" _____________ ");

        RefVal.Dog aDog = new Dog("Max");
        RefVal.Dog oldDog = aDog;

        // we pass the object to foo
        foo(aDog);
        // aDog variable is still pointing to the "Max" dog when foo(...) returns
        System.out.println(" max - " + aDog.getName().equals("Max")); // true
        System.out.println(" fifi - " + aDog.getName().equals("Fifi")); // false
        if (aDog == oldDog) {
            System.out.println(" aDog == oldDog : " + true);
        }

        System.out.println(" _____________ ");


        Dog aDog2 = new Dog("Max");
        Dog oldDog2 = aDog;

        foo2(aDog2);
        // when foo(...) returns, the name of the dog has been changed to "Fifi"
        System.out.println(" fifi 2 " + aDog2.getName().equals("Fifi")); // true
        // but it is still the same dog:
//        aDog2 == oldDog2; // true


        System.out.println(" _____________ ");

        ArrayList foo23 = new ArrayList();
        foo23.add("1");
        foo23.add("2");
        System.out.println(" " + foo23.size());
        ArrayList foo24 = new ArrayList();
        foo24 = (ArrayList) foo23.clone();
        funct1(foo23);
        System.out.println(" " + foo23.size());
        System.out.println(" " + foo24.size());

        System.out.println(" _____________ ");

        int foo25 = 22;
        System.out.println(" " + foo25);
        funct2(foo25);
        System.out.println(" " + foo25);

        System.out.println(" _____________ ");

    }


    public static void foo(Dog d) {
        System.out.println(" max " + d.getName().equals("Max")); // true
        // change d inside of foo() to point to a new Dog instance "Fifi"
        d = new Dog("Fifi");
        System.out.println(" fifi " + d.getName().equals("Fifi")); // true
    }

    public static void foo2(Dog d) {
        d.getName().equals("Max"); // true
        // this changes the name of d to be "Fifi"
        d.setName("Fifi");
    }

    static void funct1(ArrayList foo22) {
        foo22.add("4");
    }

    static void funct2(int foo22) {
        foo22 = 44;
    }

    static public class Dog {
        String name;


        public Dog() {
        }

        public Dog(String foo) {
            setName(foo);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}
