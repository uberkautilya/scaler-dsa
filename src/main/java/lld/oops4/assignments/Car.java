package lld.oops4.assignments;

public class Car implements Comparable<Car>{
    int Price;
    int Speed;

    @Override
    public int compareTo(Car c){
        return this.Price - c.Price;
    }
}
