import java.util.*;

public class Solution {

    public List<Interval> addInterval(List<Interval> intervals, Interval interval){

        intervals.add(interval);
        intervals.sort((i1, i2)-> Integer.compare(i1.start, i2.start));
        int n = intervals.size();
        List<Interval> res = new ArrayList<>();

        int s = intervals.get(0).start;
        int e = intervals.get(0).end;

        //merge and add intervals into res
        for(int i = 1; i < n; i++){
            Interval in = intervals.get(i);
            
            if(in.start > e){ // if current interval's start is larger than the new end, add this interval
                res.add(new Interval(s, e));
                s = in.start;
                e = in.end;
            } else {
                e = Math.max(e, in.end); //track the end
            }
        }
        res.add(new Interval(s, e));//add the last interval
        return res;
    }

    public List<Interval> removeInterval(List<Interval> intervals, Interval interval){

        int n = intervals.size();
        List<Interval> res = new ArrayList<>();

        int rms = interval.start;
        int rme = interval.end;

        for(int i = 0; i < n; i++){
            Interval in = intervals.get(i);
            
            if(rme <= in.start || rms >= in.end || rms == rme){
                // res.add(new Interval(in.start, rms));
                // res.add(new Interval(rme, in.end));
                res.add(new Interval(in.start, in.end));//no removing
            } 
            else if(rms <= in.start && rme > in.start && rme < in.end) {
                res.add(new Interval(rme, in.end));//remove the front part of interval
            }
            else if(rms > in.start && rms < in.end && in.end <= rme) {
                res.add(new Interval(in.start, rms));//remove the rear part of interval
            } 
            else if(in.start < rms && in.end > rme){
                // continue; 
                res.add(new Interval(in.start, rms));//interval is split apart
                res.add(new Interval(rme, in.end));
            } 
            else {
                // res.add(new Interval(in.start, in.end));
                continue; //remove the entire interval
            }
            
            
            
        }
        return res;
    }
}
