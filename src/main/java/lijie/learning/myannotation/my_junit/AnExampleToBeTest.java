package lijie.learning.myannotation.my_junit;

//测试类
public class AnExampleToBeTest {
    @MyBefore
    public void init(){
        System.out.println("init...");
    }
    @MyTest
    public void testSout(){
        System.out.println("test sout...");
    }
    @MyTest
    public void testDel(){
        System.out.println("test del...");
    }
    @MyAfter
    public void destory(){
        System.out.println("end...");
    }


}
