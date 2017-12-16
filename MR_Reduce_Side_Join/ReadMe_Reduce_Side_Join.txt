1.Create a Java Project and inside that create a file ReduceJoin.java
2. Add the external jars from below locations (And Many more as we are running this project in debug)
    /usr/lib/hadoop-2.2.0/share/hadoop/common/hadoop-common-2.2.0.jar
    /usr/lib/hadoop-2.2.0/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.2.0.jar
3.Export the jar to location /home/edureka/workspace/MR_Reduce_Side_Join/MR_Reduce_Side_Join.jar


/////////////////////////////////////////////////RUNNING THIS USING DEBUG  /////////////////////////////////////////////////////////////////////

Keep the input file custs and txns at location

/home/edureka/input/custs
/home/edureka/input/txns

/// Delete Output file as this would be created when MR is executed 

rm -r  /home/edureka/output

//Give below arguments while running MR in Debug mode
/home/edureka/input/custs /home/edureka/input/txns /home/edureka/output

//Run in debug mode to get the output at 

/home/edureka/output


///////////////////////////////////////////  RUNNING THIS JAR /////////////////////////////////////////////////////////////////////////////////////////////

hadoop fs -mkdir /inputForReduceSideJoin


//Make sure output directory do not exist yet. If it already exists then remove it with below command, 
//otherwise JAR will throw an error that directory already exist.

hadoop fs -rm -r /output

//Now we can run JAR file with command as below. 
//Please note you may need to adjust path of jar file depending on where you exported it.

//copy abc.dat file on Hdfs

hadoop fs -rm -r /output

hadoop fs -mkdir /inputForReduceSideJoin


hadoop fs -copyFromLocal /home/edureka/workspace/MR_Reduce_Side_Join/src/in/edureka/mapreduce/custs /inputForReduceSideJoin
hadoop fs -copyFromLocal /home/edureka/workspace/MR_Reduce_Side_Join/src/in/edureka/mapreduce/txns /inputForReduceSideJoin

hadoop jar /home/edureka/workspace/MR_Reduce_Side_Join/MR_Reduce_Side_Join.jar in.edureka.mapreduce.ReduceJoin /inputForReduceSideJoin/custs /inputForReduceSideJoin/txns /output

//To view the Output

hadoop fs -ls /output

hadoop fs -cat /output/part-r-00000


Kristina	8	651.049999
Paige	6	706.970007
Sherri	3	527.589996
Gretchen	5	337.060005
Karen	5	325.150005
Patrick	5	539.380010
Elsie	6	699.550003
Hazel	10	859.419990
Malcolm	6	457.829996
Dolores	6	447.090004



