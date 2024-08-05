package lijie.learning.myannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    City hometown();
    String name() default "zhangsan";
    int[] howmuch() default {1,3,9};

}
