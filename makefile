JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        Interval.java \
        Main.java \
        Solution.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class

