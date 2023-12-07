package org.example.sem3;

public class Pair <F extends Object,S extends Object> {
    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }


    @Override
    public String toString() {
        return "Pair [" +first.toString()+"; "+
                second.toString()+"]";
    }
}
