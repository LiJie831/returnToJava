package lijie.learning.myannotation.simplejunit;

import lijie.learning.myannotation.simplejunit.AnExampleToBeTest;
import lijie.learning.myannotation.simplejunit.MyAfter;
import lijie.learning.myannotation.simplejunit.MyBefore;
import lijie.learning.myannotation.simplejunit.MyTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MySimpleJunitFramework {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = AnExampleToBeTest.class;
        Method[] methods = clazz.getDeclaredMethods();

        List<Method> lstBefore = new ArrayList<>();
        List<Method> lstTest = new ArrayList<>();
        List<Method> lstAfter = new ArrayList<>();

        for (Method m:methods) {
            if(m.isAnnotationPresent(MyBefore.class)){
                lstBefore.add(m);
            }else if(m.isAnnotationPresent(MyTest.class)){
                lstTest.add(m);
            }else if(m.isAnnotationPresent(MyAfter.class)){
                lstAfter.add(m);
            }
        }
        Object o = clazz.newInstance();
        for(Method mt:lstTest){
            for(Method mb :lstBefore){
                mb.invoke(o);
            }
            mt.invoke(o);
            for(Method ma:lstAfter){
                ma.invoke(o);
            }
        }


    }
}
