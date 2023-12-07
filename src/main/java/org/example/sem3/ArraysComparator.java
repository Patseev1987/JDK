package org.example.sem3;

public class ArraysComparator {
    private ArraysComparator() {
    }

    public static <T extends Object, T2 extends Object> boolean compareArrays(T[] array1, T2[] array2){
        if ((array2 == null || array1 == null) || (array1.length != array2.length) ||
                !(array1[0].getClass().equals(array2[0].getClass()))){
            return false;
        }else{
            for (int i = 0; i < array1.length; i++) {
                if( array1[i]!= array2[i]){
                    return false;
                }
            }
        }
        return true;
    }


}
