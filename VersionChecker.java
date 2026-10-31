
import java.lang.reflect.Method;
import java.util.Arrays;

public class VersionChecker {

    public static void main(String[] args) {
        Method[] methods = Software.class.getDeclaredMethods();
        Arrays.sort(methods, (a, b) -> a.getName().compareTo(b.getName()));

        int withoutAnnotation = 0;

        for (Method m : methods) {
            Version v = m.getAnnotation(Version.class);
            if (v != null) {
                System.out.println("Method: " + m.getName()
                        + ", Version: " + v.number()
                        + ", Author: " + v.author());
            } else {
                withoutAnnotation++;
            }
        }

        System.out.println("Methods without @Version: " + withoutAnnotation);
    }
}
