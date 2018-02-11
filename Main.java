import java.util.*;
import java.io.*;

public class Main {
    
    private static final String cvsSplitBy = ",";
    
    public static void main(String[] args) throws IOException{
        List<Interval> intervals = new ArrayList<>();
        Solution sol = new Solution();
        
        
        //create file for output
        //File file = new File ("C:/Users/Me/Desktop/directory/file.txt");
        PrintWriter printWriter = new PrintWriter ("file.txt");
        printWriter.println ("hello");
        
        String csvFile = "file.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] s = line.split(cvsSplitBy);
                printWriter.print("[");
                if(s[0].equals("add")){
                    System.out.println(s[0]+", "+ s[1]+", "+s[2]);
                    intervals = sol.addInterval(intervals, new Interval(Integer.valueOf(s[1]), Integer.valueOf(s[2])));
                    for(Interval i : intervals) {
                        printWriter.print("["+i.start+ ", "+ i.end + "]");
                    }
                } else if(s[0].equals("remove")) {
                   System.out.println(s[0]+", "+ s[1]+", "+s[2]);
                   intervals = sol.removeInterval(intervals, new Interval(Integer.valueOf(s[1]), Integer.valueOf(s[2])));
                   for(Interval i : intervals) {
                        printWriter.print("["+i.start+ ", "+ i.end + "]");
                    }
                }
                printWriter.print("]");
                printWriter.println ("");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        //Trial of adding interval
        // intervals = sol.addInterval(intervals, new Interval(3,5));
        // for(Interval i : intervals) {
        //     System.out.print( "["+i.start+ ", "+i.end+"]");
        //     printWriter.print("["+i.start+ ", "+ i.end + "]");
        // }
        // System.out.println("");
        // printWriter.println ("");
        
        // intervals = sol.addInterval(intervals, new Interval(6,8));
        // for(Interval i : intervals) {
        //     System.out.print( "["+i.start+ ", "+i.end+"]");
        //     printWriter.print("["+i.start+ ", "+ i.end + "]");
        // }
        // System.out.println("");
        // printWriter.println ("");
        
        // intervals = sol.addInterval(intervals, new Interval(2,7));
        // for(Interval i : intervals) {
        //     System.out.print( "["+i.start+ ", "+i.end+"]");
        //     printWriter.print("["+i.start+ ", "+ i.end + "]");
        // }
        // System.out.println("");
        // printWriter.println ("");
        
        // intervals = sol.addInterval(intervals, new Interval(11,15));
        // for(Interval i : intervals) {
        //     System.out.print( "["+i.start+ ", "+i.end+"]");
        //     printWriter.print("["+i.start+ ", "+ i.end + "]");
        // }
        // System.out.println("");
        // System.out.println("-----Now Removing Interval-----");
        // printWriter.println ("");
        
        // //Test of removing interval
        // //删前半
        // intervals = sol.removeInterval(intervals, new Interval(1,3));
        // for(Interval i : intervals) {
        //     System.out.print( "["+i.start+ ", "+i.end+"]");
        //     printWriter.print("["+i.start+ ", "+ i.end + "]");
        // }
        // System.out.println("");
        // printWriter.println ("");
        // //删后半
        // intervals = sol.removeInterval(intervals, new Interval(6, 9));
        // for(Interval i : intervals) {
        //     System.out.print( "["+i.start+ ", "+i.end+"]");
        //     printWriter.print("["+i.start+ ", "+ i.end + "]");
        // }
        // System.out.println("");
        // printWriter.println ("");
        // //删中间
        // intervals = sol.removeInterval(intervals, new Interval(4,5));
        // for(Interval i : intervals) {
        //     System.out.print( "["+i.start+ ", "+i.end+"]");
        //     printWriter.print("["+i.start+ ", "+ i.end + "]");
        // }
        // System.out.println("");
        // printWriter.println ("");
        // //删整段
        // intervals = sol.removeInterval(intervals, new Interval(1,6));
        // for(Interval i : intervals) {
        //     System.out.print( "["+i.start+ ", "+i.end+"]");
        //     printWriter.print("["+i.start+ ", "+ i.end + "]");
        // }
        // System.out.println("");
        // printWriter.println ("");
        
        printWriter.close (); 
        
    }
}
