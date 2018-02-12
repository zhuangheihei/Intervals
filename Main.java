import java.util.*;
import java.io.*;

public class Main {
    
    private static final String cvsSplitBy = ",";
    
    public static void main(String[] args) throws IOException{
        List<Interval> intervals = new ArrayList<>();
        Solution sol = new Solution();
        
        
        //create file for output
        PrintWriter printWriter = new PrintWriter (args[1]);
        
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] s = line.split(cvsSplitBy);
                
                //check if input is valid
                if(Integer.valueOf(s[1]) > Integer.valueOf(s[2])){
                    printWriter.print("Input is invalid: Interval start time is larger than end time!");
                    break;
                } else {
                    
                    printWriter.print("[");
                    if(s[0].equals("add")){
                        //System.out.println(s[0]+", "+ s[1]+", "+s[2]);
                    
                        //do adding intervals
                        intervals = sol.addInterval(intervals, new Interval(Integer.valueOf(s[1]), Integer.valueOf(s[2])));
                        for(Interval i : intervals) {
                            printWriter.print("["+i.start+ ", "+ i.end + "]");
                        }
                    } else if(s[0].equals("remove")) {
                       //System.out.println(s[0]+", "+ s[1]+", "+s[2]);
                     
                       //do removing intervals
                       intervals = sol.removeInterval(intervals, new Interval(Integer.valueOf(s[1]), Integer.valueOf(s[2])));
                       for(Interval i : intervals) {
                            printWriter.print("["+i.start+ ", "+ i.end + "]");
                        }
                    }
                }
                
                printWriter.print("]");
                printWriter.println ("");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        printWriter.close (); 
        
    }
}
