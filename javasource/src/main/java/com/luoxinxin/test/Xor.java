package com.luoxinxin.test;

//public class StringTest{
//    public static void main(String[] a){
//        String s1 = "test string";
//        String s2 = "test string";
//        if(s1 == s2){
//            System.out.println("same");
//        }else{
//            System.out.println("different");
//        }
//    }
//}

//public class Question1{
//    static class Decrementer{
//        public void decrement(double decMe){
//            decMe = decMe - 1.0;
//        }
//    }
//    public static void main(String args[]){
//        double d = 12.3;
//        Decrementer dec = new Decrementer();
//        dec.decrement(d);
//        System.out.println(d);
//    }
//}

public class Xor{
    public static void main(String args[]){
//        byte b = 10; // 00001010 binary
//        byte c = 15; // 00001111 binary
//
//        b = (byte) (b ^ c);
//        System.out.println("b contains " + b);
//        Object ob = new Object();
//        String stringarr[] = new String[50];
//        Float aFloat = new Float(3.14f);
//        ob = stringarr;
//        ob = stringarr[5];
//        aFloat = ob;
        Xor or = new Xor();
        or.method(4);
    }

    public int a = 1;
    private int b = 2;
    public void method(final int c){
        int d = 3;
        class Inner{
            private void iMethod(int e){
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(d);
                System.out.println(e);
            }
        }
        Inner ox = new Inner();
        ox.iMethod(5);
    }



}
