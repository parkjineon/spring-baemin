package exercise.generics;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
        // 3종류의 차가 순서대로 bbang()
        // 배열은 차를 더 추가할 수가 없어요.
        Car[] cars = {new Taxi(), new Bus(), new Truck()};

        for(int i = 0; i < cars.length; i++){
            cars[i].bbang();
        }

        ArrayList<Car> carArrayList = new ArrayList<>();
        carArrayList.add(new Taxi());
        carArrayList.add(new Bus());
        carArrayList.add(new Truck());

        for(int i = 0; i < carArrayList.size(); i++){
            carArrayList.get(i).bbang();
        }

        CarList<Car> carList = new CarList<>();
        carList.add(new Taxi());
        carList.add(new Bus());
        carList.add(new Truck());
        for(int i = 0; i < carList.size(); i++){
            carList.get(i).bbang();
        }
    }
}

class Car{
    void bbang(){
        System.out.println("경적 소리");
    }
}

class Taxi extends Car{
    void bbang(){
        System.out.println("bbang bbang");
    }
}

class Bus extends Car{
    void bbang(){
        System.out.println("bbi bbi");
    }
}

class Truck extends Car{
    void bbang(){
        System.out.println("bwang bwang");
    }
}

class CarList<T>{
    ArrayList<T> arrayList = new ArrayList<>();

    void add(T item){
        arrayList.add(item);
    }

    int size(){
        // bbang
        return arrayList.size();
    }

    T get(int i){
        return arrayList.get(i);
    }
}