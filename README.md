# java map reduce README.md


Map Reduce file  

```  
$ sudo /usr/local/hadoop-2.7.2/bin/hadoop jar /soft/java_mapreduce-0.0.0.1.jar com.highill.practice.mapreduce.data.PrepareData

$ sudo /usr/local/hadoop-2.7.2/bin/hdfs dfs -cat /test/java_program/map_reduce/input/java_word1.txt

```  

执行mapreduce  
```  
$ sudo /usr/local/hadoop-2.7.2/bin/hadoop jar /soft/java_mapreduce-0.0.0.1.jar com.highill.practice.mapreduce.wordcount.WordCountMain /test/java_program/map_reduce/input /test/java_program/map_reduce/output_wordcount1


$ sudo /usr/local/hadoop-2.7.2/bin/hdfs dfs -cat /test/java_program/map_reduce/output_wordcount1/part-r-00000
Demo,   1
HDFS    1
Hello   1
Java    1
Map     2
Program 1
Reduce  2
Test    1
This    1
World!  1
a       1
file!   1
is      1



$ sudo /usr/local/hadoop-2.7.2/bin/hdfs dfs -cat /test/java_program/map_reduce/output_wordcount1/_SUCCESS



$ sudo /usr/local/hadoop-2.7.2/bin/hadoop jar /soft/java_mapreduce-0.0.0.1.jar com.highill.practice.mapreduce.wordcount.WordCountMain hdfs://hadoop1:9000/test/java_program/map_reduce/input hdfs://hadoop1:9000/test/java_program/map_reduce/output_wordcount2

$ sudo /usr/local/hadoop-2.7.2/bin/hdfs dfs -cat /test/java_program/map_reduce/output_wordcount2/part-r-00000


```  

清除map reduce结果目录  

```  
$ sudo /usr/local/hadoop-2.7.2/bin/hdfs dfs -rm -r /test/java_program/map_reduce/output_*

```  

