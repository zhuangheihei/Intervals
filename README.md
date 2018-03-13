Implement a program that read the inputs from a file and outputs them to another file. 
These files would be specified as command line parameters in the following format:

./executable input_file.csv output_file.txt

The input file would be a CSV in the following format:

action, start of interval, end of interval

Here is an example sequence in an input file:
```
add, 1, 5
remove, 2, 3
add, 6, 8
remove, 4, 7
add, 2, 7
```
The output file would contain the state of the intervals at each step of the sequence. 
Assume that the output array is initially []. 
The following is the expected content of the output file for the above example input sequence.
```
[[1, 5]]
[[1, 2], [3, 5]]
[[1, 2], [3, 5], [6, 8]]
[[1, 2], [3, 4], [7, 8]]
[[1, 8]]
```
---
Usage:
- Type "make" in bash to compile .java files.
- Type "java Main file.csv file.txt" to run this program.
- Type "make clean" to remove all .class files.
---
- Interval.java: define the interval class
- Solution.java: define the solution class, which has two methods: 
    - public List<Interval> addInterval(List<Interval> intervals, Interval interval)
    - public List<Interval> removeInterval(List<Interval> intervals, Interval interval)
- Main.java: main method to execute the code.
- file.csv: input test file 
- file.txt: output file of the program

Hong Zhuang