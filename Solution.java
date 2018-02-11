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
            if(in.start > e){
                res.add(new Interval(s, e));
                s = in.start;
                e = in.end;
            } else {
                e = Math.max(e, in.end);
            }
        }
        res.add(new Interval(s, e));
        return res;
    }

    public List<Interval> removeInterval(List<Interval> intervals, Interval interval){

        int n = intervals.size();
        List<Interval> res = new ArrayList<>();

        int rms = interval.start;
        int rme = interval.end;

        for(int i = 0; i < n; i++){
            Interval in = intervals.get(i);
            if(in.start < rms && in.end > rme){
                res.add(new Interval(in.start, rms));
                res.add(new Interval(rme, in.end));
            } else if(rms < in.start && rme > in.start && rme < in.end) {
                res.add(new Interval(rme, in.end));//删了前半部分
            } else if(rms >= in.start && rms < in.end && in.end < rme) {
                res.add(new Interval(in.start, rms));//删了后半部分
            } else if(rms <= in.start && rme >= in.end){
                continue; //全删了
            } else {
                res.add(new Interval(in.start, in.end));//没删这个interval
            }
        }
        return res;
    }
}
