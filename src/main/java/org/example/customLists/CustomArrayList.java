package org.example.customLists;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public CustomArrayList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void resize(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(Object element) {
        if(size == elements.length){
            resize();
        }
        elements[size] = element;
        size++;
    }

    public T get(int i){
        if (i >= size || size <0){
            throw new IndexOutOfBoundsException("Index: " + i + ", sizeL " + size);
        }
        return (T) elements[i];
    }

    @Override
    public void print(){
        for (Object element: elements){
            if(element != null) {
                System.out.print(element + ", ");
            }
        }
        System.out.println();
    }

    @Override
    public void set(int i, Object element) {
        elements[i]=element;
    }

    @Override
    public int length(){
        return size;
    }

    @Override
    public void addAll(CustomList o) {
        if(size == elements.length) {
            resize();
        }
        for(int i =0; i<o.length();i++){
            add(o.get(i));
        }

    }

    @Override
    public void add(int i, Object element) {
        // TODO: Implement this
        CustomArrayList<T> temp = new CustomArrayList<>();
        if(size == elements.length) {
            resize();
        }
        for(int j = i; j<elements.length;j++){
            temp.add(elements[j]);
        }
        elements[i]=element;

        for(int j = i+1; j<elements.length;j++){
            elements[j]=temp.get(j-(i+1));
        }
    }

}
