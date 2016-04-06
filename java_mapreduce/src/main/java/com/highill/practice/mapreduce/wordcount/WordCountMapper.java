package com.highill.practice.mapreduce.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

	private static final IntWritable ONE = new IntWritable(1);

	private Text word = new Text();

	@Override
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException
	{
		System.out.println("----- ----- map data: key=" + key + ",  value=" + value + ",  context=" + context);
		StringTokenizer stringToken = new StringTokenizer(value.toString());
		for (; stringToken.hasMoreTokens();)
		{
			word.set(stringToken.nextToken());
			context.write(word, ONE);
		}
	}

}
