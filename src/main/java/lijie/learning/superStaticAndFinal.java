package lijie.learning;

public class superStaticAndFinal {
    public static void main(String[] args){
        Zi zi=new Zi();
    }
    static class Fu{
        int a=10;
        static String FU_STATIC_AA="FUAA";
        public Fu(){
            printA();
        }
        public void printA(){
            System.out.println("FU's a="+a);
        }
    }

    static class Zi extends Fu{
        static String ZI_STATIC_AA="ZIAA";
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
}
