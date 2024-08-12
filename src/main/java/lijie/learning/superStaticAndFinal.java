package lijie.learning;

public class superStaticAndFinal {
    public static void main(String[] args){
        Zi zi=new Zi();
        Zi1 z1 = new Zi1();
        // 静态内部类的好处是，外部调用者在new的时候无需实例化外部类------静态内部类当做类属性来看
        superStaticAndFinal.Department ud = new superStaticAndFinal.Department();

        // 如果 Department类前不加static则需要先实例化外部类,再实例化内部类------无static就当做实例属性来看,当然就要new
        //ssf = new superStaticAndFinal().new Department();

    }
    static class Fu<T>{
        public final static String FU_STATIC_AA="FUAA";
        static {
            System.out.println("FU's static block.");
        }
        int a=10;
        public Fu(){
            printA();
        }
        public void printA(){
            System.out.println("FU's a="+a);
            System.out.println("method in FU. and 'this' = " + this.getClass().getName());
        }
    }

    static class Zi extends Fu{
        static String ZI_STATIC_AA="ZIAA";
        static {
            System.out.println("Zi's static block.");
        }
        int a=20;
        public Zi(){
            // 为了方便观察，显式调用super(),不写也这么调用,只不过是隐式调用
            super();
            printA();
        }
        @Override
        public void printA(){
            System.out.println("Zi's a="+a);
        }
    }

    //静态内部类
    static class Department{
        private String dpName;
    }
    static class Zi1 extends Fu{

    }
}

