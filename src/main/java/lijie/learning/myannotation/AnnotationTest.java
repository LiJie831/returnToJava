package lijie.learning.myannotation;

import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        // 获取类上的注解
        Class<Demo> clazz = Demo.class;
        MyAnnotation annotationOnClass = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass.hometown().name());
        System.out.println(annotationOnClass.name());
        System.out.println(Arrays.toString(annotationOnClass.howmuch()));

        // 获取成员变量上的注解
        Field name = clazz.getField("name");
        MyAnnotation annotationOnField = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnField.hometown().name());
        System.out.println(annotationOnField.name());

//        // 获取hello方法上的注解
//        Method hello = clazz.getMethod("hello", (Class<?>[]) null);
//        MyAnnotation annotationOnMethod = hello.getAnnotation(MyAnnotation.class);
//        System.out.println(annotationOnMethod.hometown());
//
//        // 获取defaultMethod方法上的注解
//        Method defaultMethod = clazz.getMethod("defaultMethod", (Class<?>[]) null);
//        MyAnnotation annotationOnDefaultMethod = defaultMethod.getAnnotation(MyAnnotation.class);
//        System.out.println(annotationOnDefaultMethod.hometown());

    }
}
@MyAnnotation(hometown = City.HANGZHOU,howmuch = {2,3,4})
class Demo{
    @MyAnnotation(hometown = City.BEIJING, name = "lisi")
    public int name=10;
}


