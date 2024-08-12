package lijie.learning.myannotation.my_jpa;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class A<T> {
    public static void main(String[] args) {
        C b = new C();
        ParameterizedType type = (ParameterizedType)b.getClass().getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        Class actualTypeArgument = (Class)types[0];
        System.out.println(actualTypeArgument);
//        System.out.println(type.getClass());
    }
    public A(){
//        Class clz = this.getClass();
//        Type t = clz.getGenericSuperclass();
//        System.out.println(t);
    }
}
class B extends A<String>{

}
class C extends A<Integer>{

}