package exercise.generics;

import java.util.ArrayList;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack<String> stackStr = new MyStack<>();

        System.out.println(stackStr.isEmpty());
        stackStr.push("a");
        stackStr.push("b");
        stackStr.push("c");

        System.out.println(stackStr.pop());
        System.out.println(stackStr.peek());

        System.out.println(stackStr.isEmpty());

        stackStr.printElements();
    }
}

class MyStack<T>{
    ArrayList<T> arrayList = new ArrayList<T>();

    public void push(T item){
        arrayList.add(item);
    }

    public T pop(){
        T item = arrayList.get(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);

        return item;
    }

    public T peek(){
        return arrayList.get(arrayList.size()-1);
    }

    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    public void printElements(){
        for(int i = 0 ; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }
}