package com.eds;

import javassist.bytecode.stackmap.BasicBlock;

import java.awt.*;
import java.util.PriorityQueue;

public class ExampleTest
{
    String str1 = "a";
    void A(){
        try{
            str1+="b";
            D();
        }catch (Exception e){
            str1+="c";
        }
        finally {
            str1+="M";
        }
        str1+="N";
    }
    void D() throws  Exception{
        try{
            str1+="d";
            c();
        }catch (Exception e){
            throw  new Exception();
        }
        finally {
            str1+="e";
        }
        str1+="f";
    }
    void c()throws Exception{
        throw new Exception();
    }
    void  display(){
        System.out.println(str1);
    }

    void M2(){
        try{
            int a=0;
            System.out.println("a = "+a);
            int b = 20/a;
            System.out.println("b = "+b);
        }catch (ArithmeticException e){
            System.out.println("Airth metic excaption"+e);
        }
        catch (Exception e){
            System.out.println("Main metic excaption"+e);
        }
    }
    int count=0;
    void M1(){
        try{
            count++;
            try{
                count++;
                throw new Exception();
            }catch (Exception e){
                count++;
                throw new Exception();
            }
        }catch (Exception e){
            count++;
        }
    }
    void display1(){
        System.out.println(count);
    }
    void  M3(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(111);
        queue.add(100);
        queue.add(103);
        queue.add(99);
        queue.add(89);
        queue.add(10);

        while (queue.isEmpty() == false){
            System.out.printf("%d",queue.remove());
            System.out.println("\n");
        }
    }
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.str+b.a+b.size);
        ExampleTest test = new ExampleTest();
        test.A();
        test.display();
        test.M1();
        test.display1();
        test.M2();
        test.M3();
        int[] arr = {1,2,3,4,5};
        System.out.println(arr);
        char ch = 59;
        System.out.println(ch);

        new MyThread().start();
        new MyThread(new RunnableDemo()).start();
        ThreadDemo obj = new ThreadDemo();
        (new Thread(obj)).start();
        (new Thread(obj)).start();

        ThreadDemo t1 = new ThreadDemo(){
            public void run(){
                System.out.println("foo");
            }
        };

       System.out.println("1");
       synchronized (args){
           System.out.println("2");
           try{
               args.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.print("3 ");
       }


    }



}
class A{
    int a;
    int size;
}
class  B extends A{
    String str="ABC";
    B(){
        this.str = str;
        super.a = 12;
        super.size = 20;
    }
}
class Base extends  Exception{}
class Derived extends Base{}

class MyThread extends Thread
{
    MyThread() {}
    MyThread(Runnable r) {super(r); }
    public void run()
    {
        System.out.print("Inside Thread ");
    }
}
class RunnableDemo implements Runnable
{
    public void run()
    {
        System.out.print(" Inside Runnable");
    }
}

class ThreadDemo implements Runnable{
    int x=0;
    int y=0;
    ThreadDemo(){
        System.out.println("Handle class");
    }
    @Override
    public synchronized void run() {
        System.out.println("\n");
        System.out.println(" baz11");
        for(int i=0;i<10;i++){
            x++;
            y++;

            System.out.println("x = "+x+" ; Y = "+y);
        }
    }
    public void run(String s)
    {
        System.out.println(" baz");
    }

}