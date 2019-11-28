package util.java.lambda;

@FunctionalInterface
public interface Foo {

    String method(String string);

    default void defaultMethod() {
    }
}