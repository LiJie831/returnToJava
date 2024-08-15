package lijie.learning.myannotation.simplejpa;

import java.lang.reflect.ParameterizedType;

public class A<T> {
    public A(){
        System.out.println(this.getClass());
        System.out.println(((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public static void main(String[] args) {
        B b = new B();

//        A<String> a = new A();
//        System.out.println(a.getClass());
    }
}
class B extends A<String>{
    public B(){
        super();
    }
}
