1.Create a Java Project and inside that create a file MyDC.java
2. Add the external jars from below locations
    /usr/lib/hadoop-2.2.0/share/hadoop/common/hadoop-common-2.2.0.jar
    /usr/lib/hadoop-2.2.0/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.2.0.jar
3.Export the jar to location /home/edureka/workspace/MR_Distributed_Cache/MR_Distributed_Cache.jar

RUNNING THIS JAR !!!!!!

hadoop fs -mkdir /inputForDC


//Make sure output directory do not exist yet. If it already exists then remove it with below command, 
//otherwise JAR will throw an error that directory already exist.

hadoop fs -rm -r /output

//Now we can run JAR file with command as below. 
//Please note you may need to adjust path of jar file depending on where you exported it.

//copy abc.dat file on Hdfs

hadoop fs -copyFromLocal /home/edureka/workspace/MR_Distributed_Cache/src/in/edureka/mapreduce/abc.dat /abc.dat
hadoop fs -copyFromLocal /home/edureka/workspace/MR_Distributed_Cache/src/in/edureka/mapreduce/dcinput /inputForDC

hadoop fs -rm -r /output
hadoop jar /home/edureka/workspace/MR_Distributed_Cache/MR_Distributed_Cache.jar in.edureka.mapreduce.MyDC /inputForDC/dcinput /output


hadoop fs -ls /output
