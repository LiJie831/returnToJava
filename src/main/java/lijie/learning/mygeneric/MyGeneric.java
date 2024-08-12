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
}
