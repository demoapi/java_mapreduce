package com.highill.practice.mapreduce.wordcount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountMain {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		if (args.length != 2)
		{
			System.err.println("Must use two args. like <input path> <output path>. ");
			System.exit(-1);
		}

		System.out.println("----- Start use map reduce ");
		System.out.println("----- input path: " + args[0]);
		System.out.println("----- output path: " + args[1]);
		Configuration config = new Configuration();
		try
		{
			Job job = Job.getInstance(config, "Word Count");
			job.setJarByClass(WordCountMain.class);
			job.setMapperClass(WordCountMapper.class);
			job.setCombinerClass(WordCountReducer.class);
			job.setReducerClass(WordCountReducer.class);

			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);

			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));

			System.exit(job.waitForCompletion(true) ? 0 : 1);
			System.out.println("----- Finish word count by map reduce!");

		} catch (IOException | ClassNotFoundException | InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("----- ----- ----- ----- Exception: \n" + e.getMessage());
		}

	}

}
