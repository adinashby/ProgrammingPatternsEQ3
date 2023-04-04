/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eq3progpatterns;

/**
 *
 * @author adinashby
 */
import java.util.Arrays;

public class TheArrayList<E> {

    private Object[] myStore;
    private int actSize = 0;

    public TheArrayList() {
        myStore = new Object[10];
    }

    public E get(int index) {
        if (index < actSize) {
            return (E) myStore[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(E e) {
        if (myStore.length - actSize <= 5) {
            increaseListSize();
        }

        myStore[actSize++] = e;
    }

    public E remove(int index) {
        if (index < actSize) {
            E e = (E) myStore[index];
            myStore[index] = null;
            int tmp = index;

            while (tmp < actSize) {
                myStore[tmp] = myStore[tmp + 1];
                myStore[tmp + 1] = null;
                tmp++;
            }

            actSize--;
            return e;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public int size() {
        return actSize;
    }

    private void increaseListSize() {
        myStore = Arrays.copyOf(myStore, myStore.length * 2);
        System.out.println("\nNew length: " + myStore.length);
    }

    public static void main(String a[]) {
        TheArrayList<Integer> mal = new TheArrayList<>();

        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));

        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }

        mal.add(new Integer(29));

        System.out.println("Element at Index 5: " + mal.get(5));
        System.out.println("List size: " + mal.size());
        System.out.println("Removing element at index 2: " + mal.remove(2));

        for (int i = 0; i < mal.size(); i++) {
            System.out.print(mal.get(i) + " ");
        }
    }
}
