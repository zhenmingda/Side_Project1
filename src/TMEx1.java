import java.util.Map;
import java.util.TreeMap;


public class TMEx1 {
    public static void main(String[] args){
        TreeMap<String,Double> students = new TreeMap<String,Double>();
        
        students.put("Franksson,Frank",3.85);
        students.put("Mattsson,Matt",3.95);
        students.put("Hanksson,Hank",4.00);
        students.put("Jamesson,James",3.85);
        
        System.out.println(students);
        
        for(Map.Entry<String,Double> entry : students.entrySet()){
            if(entry.getValue()>3.9){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
        
        //What will the output be?
        System.out.println(students.remove("Robertsson,Robert"));
        System.out.println(students.remove("Jamesson,James"));
        System.out.println(students.containsKey("Hank Hanksson"));
        System.out.println(students.containsKey("Hanksson,Hank"));
        System.out.println(students.containsValue(3.85));
    }
}
