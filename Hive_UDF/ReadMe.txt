Copy myqueries.q at location /home/edureka
Copy healthcare_Sample_dataset1.csv at location /home/edureka
You can use gedit command and copy the files from Hive_UDF Project.

Modify the location of Hive_UDF.jar
//ADD JAR /home/edureka/workspace/Hive_UDF/Hive_UDF.jar;
// Use the Jar location where you have created the workspace.

Go to Linux shell (not Hive Shell), Run below command
hive -f myqueries.q

Run Below command to export output from healthCareSampleDSDeidentified table into a file to check output
INSERT OVERWRITE DIRECTORY '/user/OutputForHiveUdf' select * from healthCareSampleDSDeidentified;


// OR use hive shell to run below queries

USE healthDB;
select * from healthCareSampleDSDeidentified;


