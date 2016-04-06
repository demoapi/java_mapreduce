package com.highill.practice.mapreduce.data;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class PrepareData {

	static final String MAP_REDUCE_PATH = "hdfs://hadoop1:9000/test/java_program/map_reduce/input/";

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		try
		{
			FileSystem fileSystem = FileSystem.get(config);

			Path dataPath = new Path(MAP_REDUCE_PATH);
			if (fileSystem.exists(dataPath))
			{
				fileSystem.delete(dataPath, true);
			}
			fileSystem.mkdirs(dataPath);

			// java_word1.txt
			byte[] word1Bytes = "Hello World! Map Reduce Test".getBytes();
			Path word1 = new Path(MAP_REDUCE_PATH + "java_word1.txt");
			FSDataOutputStream word1FS = fileSystem.create(word1);
			word1FS.write(word1Bytes, 0, word1Bytes.length);
			word1FS.close();

			// java_word2.txt
			byte[] word2Bytes = "Map Reduce Demo, Java Program".getBytes();
			Path word2 = new Path(MAP_REDUCE_PATH + "java_word2.txt");
			FSDataOutputStream word2FS = fileSystem.create(word2);
			word2FS.write(word2Bytes, 0, word2Bytes.length);
			word2FS.close();

			// java_word3.txt
			byte[] word3Bytes = "This is a HDFS file!".getBytes();
			Path word3 = new Path(MAP_REDUCE_PATH + "java_word3.txt");
			FSDataOutputStream word3FS = fileSystem.create(word3);
			word3FS.write(word3Bytes, 0, word3Bytes.length);
			word3FS.close();

			fileSystem.close();

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
