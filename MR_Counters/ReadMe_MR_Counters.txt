1.Create a Java Project and inside that create a file WordCount.java
2. Add the external jars from below locations
    /usr/lib/hadoop-2.2.0/share/hadoop/common/hadoop-common-2.2.0.jar
    /usr/lib/hadoop-2.2.0/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.2.0.jar
3.Export the jar to location /home/edureka/workspace/MR_Counters/MRCounters.jar

RUNNING THIS JAR !!!!!!

hadoop fs -mkdir /inputCounters
hadoop fs -copyFromLocal /home/edureka/workspace/MR_Counters/src/in/edureka/mapreduce/inputdata.txt /inputCounters
hadoop fs -ls /inputCounters

//Below command should show 
one,1386023259550
two,1389523259550
three,1389523259550
four,1389523259550

hadoop fs -cat /inputCounters/inputdata.txt
hadoop fs -rm -r /outputCounters
hadoop jar /home/edureka/workspace/MR_Counters/MyCounters.jar in.edureka.mapreduce.MyCounter /inputCounters /outputCounters

Output is shown on console.
DEC : 1
JAN : 3
FEB : 0