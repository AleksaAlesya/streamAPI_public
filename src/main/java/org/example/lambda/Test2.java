package org.example.lambda;

public class Test2 {
    public static void main(String[] args) {
        def(str -> str.length()+10);
        //
        foo (()->System.out.println("ничего не выводит их этого соута, выводит из метода"));

    }

    static void anyCode() {
        System.out.println("gfjfk");
    }

    static void def(I i){
        System.out.println(i.abc("hello"));
    }

    static void foo(O o){
        System.out.println("no hello");
    }


    private static class MyO implements O {
        @Override
        public void nnn() {
            System.out.println("gfjfk");
        }
    }
}
interface  I{
    int  abc (String str);
}

interface  O{
    void   nnn ();
}