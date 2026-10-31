import java.lang.reflect.Method;

public class Test {

    @MyAnnotation("my annotation")
    public void myMethod() {
        System.out.println("myMethod done");
    }

    public static void main(String[] args) throws Exception {
        // Чтение своей аннотации через рефлексию
        Method method = Test.class.getDeclaredMethod("myMethod");
        MyAnnotation ann = method.getAnnotation(MyAnnotation.class);

        if (ann != null) {
            System.out.println("Annotation value: " + ann.value());
        } else {
            System.out.println("annotation not found");
        }

        // Вызов @Deprecated
        Example ex = new Example();
        ex.oldMethod();
    }
}
