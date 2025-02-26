package Tree;

import java.util.*;

public class Main {
    public static void main(String[] args){
        MyTree tree = new MyTree();
        Scanner sc = new Scanner(System.in);
        tree.insertroot(sc);
        tree.display();
    }
}
