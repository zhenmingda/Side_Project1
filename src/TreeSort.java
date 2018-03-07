import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class TreeSort {
    public static void main(String[] args){
        
        //Create an int arraylist, fill it with random ints, and print the unsorted arraylist.
        ArrayList<Integer> aList = new ArrayList();
        System.out.print("Unsorted list :");
        for(int i=0;i<10;i++){
            int x=(int)(Math.random() * 10);
            aList.add(x);
            System.out.print(x+", ");
        }
        
        //Call TreeSort.
        treeSort(aList);
        
        //Print the sorted arraylist.
        System.out.print("\nSorted list :");
        for(int i=0;i<aList.size();i++){
            System.out.print(aList.get(i)+", ");
        }
    }
    
    public static <E> void treeSort(List<E> aList){
        //Create an empty treemap object with generic key and integer value.
        TreeMap<E,Integer> aMap = new TreeMap<E,Integer>();
        //Generic element to hold the current key element in the list.
        //E element;
        //Integer to hold current value for a key.
        //Integer value;
        
        //For each element in the list,
        for(E element: aList){
            //Get the value for that element in the tree.
            Integer value=aMap.get(element);
            //If there is no key in the tree matching that element,
            if(value==null){
                //Add the element to the tree with value 1.
                aMap.put(element, 1);
            }
            //If there is matching key in the tree already,
            else{
                //Overwrite the current value for that key with an incremented value.
                aMap.put(element, value+1);
            }
        }
        
        //Then clear the list.
        aList.clear();
        
        //Last, iterate across the tree and insert each key into the list value number of times.
        
        //For each Entry in the map's Entry Set,
        for(Map.Entry<E,Integer> entry : aMap.entrySet()){
            //Loop value times.
            for(int i=0;i<entry.getValue();i++){
                //Insert the key each time.
                aList.add(entry.getKey());
            }
        }
    }
}
