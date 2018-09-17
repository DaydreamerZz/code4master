package imp.designpattern.observer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new HexaObserver(subject);

        subject.setState(10);
        subject.setState(2);

        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            list.add(1);
        }

//        System.gc();
    }
}
/*
Binary:1010
Hexa:a
Binary:10
Hexa:2
 */
