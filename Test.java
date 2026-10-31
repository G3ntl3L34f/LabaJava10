import java.lang.reflect.Method;

public class Test {

    @MyAnnotation("Привет из аннотации")
    public void myMethod() {
        System.out.println("Метод myMethod выполнен");
    }

    public static void main(String[] args) throws Exception {
        // Чтение своей аннотации через рефлексию
        Method method = Test.class.getDeclaredMethod("myMethod");
        MyAnnotation ann = method.getAnnotation(MyAnnotation.class);

        if (ann != null) {
            System.out.println("Значение аннотации: " + ann.value());
        } else {
            System.out.println("Аннотация не найдена");
        }

        // Вызов @Deprecated
        Example ex = new Example();
        ex.oldMethod();
    }
}
