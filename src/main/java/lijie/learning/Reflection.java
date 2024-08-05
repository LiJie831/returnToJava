package lijie.learning;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

// 反射被广泛地用于那些需要在运行时(也就是未来时)检测或修改程序行为的程序中
public class Reflection {
    public static void main(String[] args) throws Exception{
//        warnUp1();
        warnUp2();
    }

    public static void warnUp1(){
        Class clz = String.class;
        Field[] fields = clz.getDeclaredFields();
        System.out.println(fields.length);
        for(Field f:fields){
            System.out.println(f.getName());
        }
    }

    public static void warnUp2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Reflection r1=new Reflection();
        Reflection r2=new Reflection();
        Class<Reflection> clz = Reflection.class;
        Method method1 =clz.getDeclaredMethod("foo",int.class);
        method1.invoke(r1,5);
        Method method2 =clz.getDeclaredMethod("foo",Integer.class);
        method2.invoke(r2,55);
        Method method3 =clz.getDeclaredMethod("foo",String.class);
        method3.invoke(r1,"QD发");
        Method method4=clz.getDeclaredMethod("foo",Long.class);
        method4.invoke(null,1000l);
    }
    public void foo(String s){
        System.out.println("foo's parameter's type is String "+s);
    }
    public void foo(int i){
        System.out.println("foo's parameter's type is int "+i);
    }
    public void foo(Integer k){
        System.out.println("foo's parameter's type is Integer "+k);
    }
    public static void foo(Long l){
        System.out.println("This foo is static method! "+l);
    }
}
