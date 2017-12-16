1.Create a Java Project and inside that create a file WordCount.java
2. Add the external jars from below locations
    /usr/lib/hadoop-2.2.0/share/hadoop/common/hadoop-common-2.2.0.jar
    /usr/lib/hadoop-2.2.0/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.2.0.jar
3.Export the jar to location /home/edureka/workspace/MR_WordCount/MR_WordCount.jar

RUNNING THIS JAR !!!!!!

hadoop fs -rm -r /inputWordCount


hadoop fs -mkdir /inputWordCount   ---- /inputWordCount

hadoop fs -mkdir inputWordCount    --- /home/edureka/inputWordCount
    

gedit wordcounttest.txt

Add  some sample text in this file and save it. 
hadoop fs -put wordcounttest.txt /inputWordCount

hadoop fs -ls

//Make sure outputWordCount directory do not exist yet. If it already exists then remove it with below command, 
//otherwise JAR will throw an error that directory already exist.

hadoop fs -rm -r /outputWordCount

//Now we can run JAR file with command as below. 
//Please note you may need to adjust path of jar file depending on where you exported it.

hadoop jar /home/edureka/workspace/MR_WordCount/MR_WordCount.jar in.edureka.mapreduce.WordCount /inputWordCount /outputWordCount

//Please note that this program will read all text files from inputWordCount folder on HDFS and count total number of words in each file. 
//outputWordCount is stored under outputWordCount folder on HDFS.

Once run is successful, you should see below 2 files in outputWordCount folder.

hadoop fs -ls /outputWordCount

-rw-r--r--   1 hduser supergroup          0 2016-07-15 13:54 outputWordCount/_SUCCESS

-rw-r--r--   1 hduser supergroup         73 2016-07-15 13:54 outputWordCount/part-r-00000

_SUCCESS file is an empty file indicating RUN was successful. To see outputWordCount of run, view part-r-00000 file.

hadoop fs -cat /outputWordCount/part-r-00000