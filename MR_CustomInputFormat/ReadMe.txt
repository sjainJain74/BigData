1.Create a Java Project and inside that create a file WordCount.java
2. Add the external jars from below locations
    /usr/lib/hadoop-2.2.0/share/hadoop/common/hadoop-common-2.2.0.jar
    /usr/lib/hadoop-2.2.0/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.2.0.jar
3.Export the jar to location /home/edureka/workspace/MR_CustomInputFormat/MR_CustomInputFormat.jar


RUNNING THIS JAR !!!!!!

hadoop fs -rm -r /outputCustom

hadoop fs -mkdir /inputCustomFile

hadoop fs -copyFromLocal /home/edureka/workspace/MR_CustomInputFormat/src/in/edureka/mapreduce/inputdata.txt /inputCustomFile

//Execution:

hadoop jar /home/edureka/workspace/MR_CustomInputFormat/MR_CustomInputFormat.jar in.edureka.mapreduce.MyFile /inputCustomFile/inputdata.txt /outputCustom

// To Get the value1 and Value 2 of sensor with SesnsorID starting with a
hadoop fs -cat /outputCustom/part-m-00000
