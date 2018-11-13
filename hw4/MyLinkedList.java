package hw4;

import java.lang.reflect.Array;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E>{
    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    public MyLinkedList() {
    }

    @Override
    public void add(E element) {
        if(size > 1){
            Node<E> newNode = new Node<>(element);
            last.nextNode = newNode;
            last = newNode;
            size++;
        }
        else
            if(size == 1){
                Node<E> newNode = new Node<>(element);
                first.nextNode = newNode;
                last = newNode;
                size = 2;
            }
            else {
                Node<E> newNode = new Node<>(element);
                first = newNode;
                size = 1;
            }
    }

    @Override
    public void add(int index, E element) {
        if(index > 0 && index < size) {
            int i = 0;
            Node<E> prev = null, current = first;
            Node<E> newNode = new Node<>(element);
            while(i < index) {
                prev = current;
                current = current.nextNode;
                i++;
            }
            prev.nextNode = newNode;
            newNode.nextNode = current;
        }
        else
            if (index == 0){
                Node<E> newNode = new Node<>(element);
                newNode.nextNode = first;
                first = newNode;
            }
            else
                System.err.println(index + " is incorrect index");
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if(index >= 0 && index < size){
            int i = 0;
            Node<E> node = first;
            while (i < index){
                node = node.nextNode;
                i++;
            }
            return node.element;
        }
        else {
            System.err.println(index + "is incorrect index");
            return null;
        }
    }

    @Override
    public int indexOf(E element) {
        int i = 0;
        Node<E> node = first;
        while((i < size) && (!node.element.equals(element))) {
            node = node.nextNode;
            i++;
        }
        if (i != size)
            return i;
        else
            return -1;
    }

    @Override
    public E remove(int index) {
        E element = null;
        if(index>= 0 && index < size) {
            int i = 0;
            Node<E> prev = null, removedNode = first;
            while (i < index) {
                prev = removedNode;
                removedNode = removedNode.nextNode;
                i++;
            }
            if(prev != null) {
                if (removedNode.nextNode != null) {
                    prev.nextNode = removedNode.nextNode;
                }
                else {
                    prev.nextNode = null;
                    last = prev;
                }
            }
            else {
                first = removedNode.nextNode;
            }
            size--;
            element = removedNode.element;
        }
        return element;
    }

    @Override
    public E set(int index, E element) {
        E oldElement = null;
        if(index>= 0 && index < size) {
            int i = 0;
            Node<E> current = first;
            while(i < index) {
                current = current.nextNode;
                i++;
            }
            oldElement = current.element;
            current.element = element;
        }
        return oldElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        E[] arr = null;
        if(first != null) {
            arr = (E[]) Array.newInstance(first.element.getClass(), size);
            Node<E> node = first;
            for(int i = 0; i < size; i++) {
                arr[i] = node.element;
                node = node.nextNode;
            }
        }
        return arr;
    }

    @Override
    public String toString() {
        String sList = "[";
        Node<E> current = first;
        while (current != null){
            sList += current.element.toString();
            sList += current.nextNode != null ? ", " : "";
            current = current.nextNode;
        }
        sList += "]";
        return sList;
    }

    public Iterator<E> iterator(){
        return new Iterator<E>() {
            private Node<E> current = first;

            @Override
            public boolean hasNext() {
                return (current != null); // && current.nextNode != null);
            }

            @Override
            public E next() {
                Node<E> returnedNode = current;
                current = current.nextNode;
                return returnedNode.element;
            }
        };
    }

    private class Node<E> {
        E element;
        Node nextNode = null;

        Node(E element) {
            this.element = element;
        }
    }
}
