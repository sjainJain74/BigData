1.Create a Java Project and inside that create a file BinaryFilesToHadoopSequenceFile.java,ImageDriver.java
2. Add the external jars from below locations
    /usr/lib/hadoop-2.2.0/share/hadoop/common/hadoop-common-2.2.0.jar
    /usr/lib/hadoop-2.2.0/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.2.0.jar
3.Export the jar to location /home/edureka/workspace/MR_SequenceFile/MR_Sequenece_File.jar

//RUNNING THIS JAR !!!!!!

// Create a folder input on HDFS using below command
hadoop fs -mkdir /inputForSeq


//Make sure output directory do not exist yet. If it already exists then remove it with below command, 
//otherwise JAR will throw an error that directory already exist. If doing first time you need not remove this folder

hadoop fs -rm -r /outputForSeqFile
hadoop fs -rm -r /outputForDuplicateImages

//Now we can run JAR file with command as below. 
//Please note you may need to adjust path of jar file depending on where you exported it.

//Download the images from  browser and copy them to HDFS at location using below command

hadoop fs -copyFromLocal /home/edureka/Downloads/SequenceFile/images /images

//Should show all images.
// Check these files on url http://localhost:50070/dfshealth.jsp

hadoop fs -ls /image


//Copy the seqinput.txt on the input folder on HDFS
hadoop fs -copyFromLocal /home/edureka/workspace/MR_SequenceFile/src/in/edureka/mapreduce/seqinput.txt /inputForSeq


// Run Below command to convert all images into single Sequence File
hadoop jar /home/edureka/workspace/MR_SequenceFile/MR_Sequenece_File.jar in.edureka.mapreduce.BinaryFilesToHadoopSequenceFile /inputForSeq/seqinput.txt /outputForSeqFile


//Use this URL to see this sequence file, at path /outputForSeqFile/part-r-00000
//In First line you will see	SEQ -->Its a Sequence File  ,Key ---> org.apache.hadoop.io.Text , value -->org.apache.hadoop.io.BytesWritable 
//http://localhost:50070/dfshealth.jsp

// Run Below Map Reduce to find Non Duplicates Images List 

hadoop jar /home/edureka/workspace/MR_SequenceFile/MR_Sequenece_File.jar in.edureka.mapreduce.ImageDriver  /outputForSeqFile/part-r-00000  /outputForDuplicateImages

// When JOb is triggered  you can see the progress using link shown in logs
// http://localhost:8088/cluster/

// Below command with show only list of images which are not duplicate
hadoop fs -ls /outputForDuplicateImages
hadoop fs -cat /outputForDuplicateImages/part-r-00000

