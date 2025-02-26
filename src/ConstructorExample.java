public class ConstructorExample {
    private int a;
    public int b;
    public String str;

    ConstructorExample(int val){
        this.a = val;
    }

    ConstructorExample(String value){
        this.str = value;
    }

    ConstructorExample(){

    }

    public int getter(){
        return this.a;
    }
    public void setter(int value){
        this.a = value;
    }
}
