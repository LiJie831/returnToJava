package lijie.learning.mygeneric;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyGeneric {
    public static void main(String[] args) throws Exception{
//        bypassGenericCheck();

        List<String> l = new ArrayList<>();
        l.add("2332");
        l.add("dacs");
        print(l);
    }
    public static void bypassGenericCheck() throws Exception{
        //绕过泛型检查,使得List<String>可以存入1
        ArrayList<String> list = new ArrayList<>();
        list.add("we");
        list.add("are the");
        Method method = list.getClass().getDeclaredMethod("add",Object.class);
        method.invoke(list,1);
        for(Object o:list) {
            System.out.println(o);
        }
    }
    public static <T> void print(List<T> lst){
        for(T o:lst){
            System.out.println(o);
        }
    }

    public static <E> List<E> reverseList(List<E> list){
        List<E> tmp = new ArrayList<>();
        for (int i=list.size()-1;i>0;i--){
            tmp.add(list.get(i));
        }
        return tmp;
    }
}
class MyGenerator1<T>{
    private T key;

    public T foo(T obj){
        System.out.println("使用了泛型的成员方法并不是泛型方法");
        return key;
    }

    public <E> void foo1(E obj){
        System.out.println("使用了<T>的方法才是泛型方法");
    }
    public <E> E foo2(E obj){
        System.out.println("使用了<T>的方法才是泛型方法,这个T和MyGenerator1<T>的T毫无关系");
        return (E) this.key; // why cast to T ???
    }
    public <T,K> K foo3(K obj){
        return obj;
    }
    public <T extends Number> T foo5(T obj){
        return obj;
    }

    static <E> E foo4(E obj){
        System.out.println("静态方法只能写成泛型方法,静态泛型方法应该使用其他类型区分:");
        return obj;
    }
}
