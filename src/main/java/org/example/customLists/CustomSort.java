package org.example.customLists;


import org.example.entity.Ticket;

public class CustomSort {
    public static void sort(CustomList<Ticket> k){
        for (int i = 0; i < k.length(); i++) {
            for (int j = k.length() - 1; j > i; j--) {
                if ((k.get(i).compareTo(k.get(j)))>0) {
                    Ticket tmp = k.get(i);
                    k.set(i,k.get(j));
                    k.set(j,tmp);
                }
            }
        }
    }
}
