class Parent{
    public void display(){
        System.out.println("I am Parent");
    }
}
class Child extends Parent{
    public void show(){
        System.out.println("I am Child");
    }
}

public class Main{
    public static void main(String[] args) {
        Child obj = new Child();
        obj.show();
    }
}