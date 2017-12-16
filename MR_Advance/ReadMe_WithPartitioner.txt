1.Create a Java Project and inside that create a file WithPartitioner.java
2. Add the external jars from below locations
    /usr/lib/hadoop-2.2.0/share/hadoop/common/hadoop-common-2.2.0.jar
    /usr/lib/hadoop-2.2.0/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.2.0.jar
3.Export the jar to location /home/edureka/workspace/MR_WordCount/MR_Advance_Part.jar

RUNNING THIS JAR !!!!!!

hadoop fs -mkdir input

vi wordcounttest.txt

Add  some sample test in this file and save it. 
hadoop fs -put wordcounttest.txt /input/

//Make sure output directory do not exist yet. If it already exists then remove it with below command, 
//otherwise JAR will throw an error that directory already exist.

hadoop fs -rm -r /output

//Now we can run JAR file with command as below. 
//Please note you may need to adjust path of jar file depending on where you exported it.

hadoop jar /home/edureka/workspace/MR_Advance/MR_Advance.jar in.edureka.mapreduce.WithPartitioner /input /output

//Please note that this program will read all text files from input folder on HDFS and count total number of words in each file. 
//Output is stored under output folder on HDFS.

Once run is successful, you should see below 2 files in output folder.

hadoop fs -ls /output
