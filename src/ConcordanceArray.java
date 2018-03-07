import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;


public class ConcordanceArray {

    public static void main(String[] args) {
        //Timing variable.
        long start=System.currentTimeMillis();
        BufferedReader br;  //An uninitialized file reader.
        //An ArrayList to hold the concordance.
        //Holds Entry objects which are just key-value pairs of Strings.
        //The key will be the words in the text.
        //The value will be a list of lines those words appear on.
        ArrayList<Entry> a = new ArrayList<Entry>(); 
        
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
                
                
                //Insert each word into the ArrayList and update the line numbers associated with it.
                for(int i=0;i<words.length;i++){
                    //Insert word and value.
                    //Handle case where current word is an empty string.
                    //We want to exclude these so tell the loop to move forward.
                    if(words[i].equals("")){continue;}

                    //Case where current word is not an empty string.
                    //First, see if the current word is in the arraylist already.
                    int wordIndex=containsEntry(a,words[i]);
                    //Case where it has not been added yet, set value to empty string.
                    if(wordIndex==-1){
                        value="";
                    }
                    //Case where is has been added already, extract the current value.
                    else{
                        value=((Entry)a.get(wordIndex)).value;
                    }
                    //Then append the current line number plus a comma and space.
                    value+=Integer.toString(lineNumber)+", ";
                    //Then put the key word into the arraylist with the updated value.
                    //Case where key word already exists in the arraylist, it is overwritten with the new value.
                    if(wordIndex!=-1){
                        a.set(wordIndex,new Entry(words[i],value));
                    }
                    //Case where the key word does not exist in the arraylist yet.
                    else{
                        a.add(new Entry(words[i],value));
                    }
                }   //Words from this line have now been added to the treemap.
                lineNumber++;   //Increment the line number.
                //Read the next line.
                line = br.readLine();
            }   //All lines have been read.
            br.close(); //Close the reader.        


            //Sort the arraylist.
            a.sort(new EntryComparator());
            
            //Print out the arraylist with keys and values on one line each.
            for(int i=0;i<a.size();i++){
                System.out.println(a.get(i).key+": "+a.get(i).value);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //Print elapsed time.
        System.out.println("Elapsed time: "+(System.currentTimeMillis()-start)+"ms");
    }
    
    //Searches the array list for an entry with matching key.
    //Returns the index where that entry resides.
    //Returns -1 if no match is found.
    public static int containsEntry(ArrayList a,String k){
        int result=-1;
        for(int i=0;i<a.size();i++){
            if(((Entry)a.get(i)).key.equals(k)){
                result=i;
                break;
            }
        }
        return result;
    }
}

class Entry{
    public String key;
    public String value;
    
    public Entry(String k, String v){
        key=k;
        value=v;
    }
}
class EntryComparator implements Comparator<Entry>{
        public int compare(Entry e1, Entry e2){
            return e1.key.compareTo(e2.key); 
        }
    }
