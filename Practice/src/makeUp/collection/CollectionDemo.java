package makeUp.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Computer implements Comparable {
    int serial;
    String owner;

    public Computer(int serial, String owner) {
        this.serial = serial;
        this.owner = owner;
    }

    public int compareTo(Object o) {
        return this.serial-((Computer)o).serial;
    }

    @Override
    public String toString() {
        return serial +"  " + owner;
    }

}
public class CollectionDemo {
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(1200, "graphittie"));

        Iterator ir=  computers.iterator();
        while (ir.hasNext()) {
            System.out.println(ir.next());
        }

        //Collections : static method 보유
        Collections.sort(computers); //sort의 argument로 computer를 보냄
        System.out.println("\nafter");
        ir=computers.iterator();
        while (ir.hasNext()) {
            System.out.println(ir.next());
        }
    }
}
