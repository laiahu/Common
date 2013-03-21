package com.mycompany.common.bloomfilter.test;

import org.junit.Test;
import static org.junit.Assert.*;
public class MyTest {

	@Test
	public void test(){
	
		System.out.println(Math.log(2.0)*11);
	}
	
	@Test
	public void example(){
//		double falsePositiveProbability = 0.1;
//		int expectedSize = 100;

		double falsePositiveProbability = 0.0001;
		int expectedSize = 100*100;//100*100*100*100;
		
		BloomFilter<String> bloomFilter = new BloomFilter<String>(falsePositiveProbability, expectedSize);

		bloomFilter.add("foo");

		if (bloomFilter.contains("foo")) { // Always returns true
		    System.out.println("BloomFilter contains foo!"); 
		    System.out.println("Probability of a false positive: " + bloomFilter.expectedFalsePositiveProbability());
		}

		if (bloomFilter.contains("bar")) { // Should return false, but could return true
		    System.out.println("There was a false positive.");
		}
	}
	
	@Test
	public void testBloomFilter(){
		
		/*
		 * BloomFilter 添加对象时，可以用
		 */
		double falsePositiveProbability = 0.0001;
		int expectedSize = 100*100;//100*100*100*100;
		
		BloomFilter<String> bloomFilter = new BloomFilter<String>(falsePositiveProbability, expectedSize);
		bloomFilter.add("foo");

		if (bloomFilter.contains("foo")) { // Always returns true
		    System.out.println("BloomFilter contains foo!"); 
		    System.out.println("Probability of a false positive: " + bloomFilter.expectedFalsePositiveProbability());
		}
		bloomFilter.add("bar");
		bloomFilter.add("mytest");
		bloomFilter.add("aaa");
		bloomFilter.add("bbb");
		
		
		//double c = bloomFilter.getBitsPerElement();  //实际的位数
		
		//多少位表示一个元素
		double c = bloomFilter.getExpectedBitsPerElement();
		//function num
		int k = bloomFilter.getK();
				
		//大小
		int size = bloomFilter.size();
		
		//实际的添加的数目
		int count = bloomFilter.count();
		
		System.out.println("c="+c);
		System.out.println("k="+k);
		System.out.println("size="+size);
		System.out.println("count="+count);
		System.out.println(bloomFilter.getBitSet());
	}
}
