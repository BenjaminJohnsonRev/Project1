package org.example.customLists;

public interface CustomList<T>{
    public void add(T element);
    public T get(int i);
    public void print();
    public void add(int i, T element);
    public int length();
    public void addAll(CustomList<T> o);
    public void set(int i, T element);
}
