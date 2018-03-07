import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Concordance {

    public static void main(String[] args) {
        //Timing variable.
        long start=System.currentTimeMillis();
        BufferedReader br;  //An uninitialized file reader.
        //A TreeMap to hold the concordance.
        //The key will be the words in the text.
        //The value will be a list of lines those words appear on.
        TreeMap<String,String> tm = new TreeMap<String,String>(); 
        
        
        try {
            //Initialize the file reader to read from the text file.
            br = new BufferedReader(new FileReader("TreeMapsTreeSets\\ulysses.txt"));
            String line = "";   //Will hold each line read from the file.
            String value="";    //Will hold the value we input for each word key.
            int lineNumber=1;   //Start reading from line 1.
            //Read the first line.
            line = br.readLine();
            
            //So long as we have not reached the end of the file,
            while (line != null) {
                //Do some cleaning for each line with a regular expression,
                //Then turn the line lower case,
                //Then split the line into individual words based on spaces.
                String[] words = line.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split(" ");
                //Regular expression (regex) here is a "character class", a custom defined set of characters.
                //Brackets [] in regex denote a character class.
                //Carat ^ denotes "not".
                //Therefore, the character class is defined as "not lowercase letters, uppercase letters, numerics, or spaces".
                //The method replaceAll looks at a string, finds everything in that character class, removes it, and in this case replaces it with nothing.
                
                
                //Insert each word into the TreeMap and update the line numbers associated with it.
                for(int i=0;i<words.length;i++){
                    //Insert word and value.
                    //Handle case where current word is an empty string.
                    //We want to exclude these so tell the loop to move forward.
                    if(words[i].equals("")){continue;}

                    //Case where current word is not an empty string.
                    //First, get the current value for the word in the tree.
                    //If it is not in the tree yet, this returns null.
                    value=tm.get(words[i]); 
                    if(value==null){value="";}  //Handle the case where the string variable is set to null.
                    //Then append the current line number plus a comma and space.
                    value+=Integer.toString(lineNumber)+", ";
                    //Then put the key word into the treemap with the updated value.
                    //If the key word already exists in the map, it is overwritten with the new value.
                    tm.put(words[i], value);
                }   //Words from this line have now been added to the treemap.
                lineNumber++;   //Increment the line number.
                //Read the next line.
                line = br.readLine();
            }   //All lines have been read.
            br.close(); //Close the reader.        
            
            //Print out the treemap with keys and values on one line each.
            Set keys = tm.keySet(); //Extract the keys from the treemap as a set.
            Iterator i = keys.iterator();   //Get an iterator for that key set.
            
            //Iterate through the key set.
            while(i.hasNext()){
                //Store the current key.
                String k=(String)i.next();
                //Get and store the value for that current key.
                String v=tm.get(k);
                //Print them out with formatting.
                System.out.println(k+": "+v);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //Print elapsed time.
        System.out.println("Elapsed time: "+(System.currentTimeMillis()-start)+"ms");
    }
}
