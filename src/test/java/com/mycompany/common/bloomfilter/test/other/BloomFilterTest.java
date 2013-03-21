package com.mycompany.common.bloomfilter.test.other;

import org.junit.Test;

import com.mycompany.common.bloomfilter.test.BloomFilter;

/**
 * 利用Bloom Filter 添加对象时, 需要重写 toString方法,因为Bloom Filter是需要根据 toString 进行比较的
 * @author wangjb
 *
 */
public class BloomFilterTest {

	
	@Test
	public void testBloomFilterObject(){
		double falsePositiveProbability = 0.0001;
		int expectedSize = 100*100;//100*100*100*100;
		
		BloomFilter<UrlVO> bloomFilter = new BloomFilter<UrlVO>(falsePositiveProbability, expectedSize);

		int id = 1;
		String url = "http://www.sina.com.cn";
		UrlVO vo = new UrlVO();
		
		vo.setId(id);
		vo.setUrl(url);
		
		bloomFilter.add(vo);
		
		if (bloomFilter.contains(vo)) { // Always returns true
		    System.out.println("BloomFilter contains foo!"); 
		    System.out.println("Probability of a false positive: " + bloomFilter.expectedFalsePositiveProbability());
		}

		System.out.println("========");
		
		UrlVO vo2 = new UrlVO();
		int id_2 = 2;
		String url_2 = "http://www.sohu.com.cn";
		vo2.setId(id_2);
		vo2.setUrl(url_2);
		if (bloomFilter.contains(vo2)) { // Always returns true
		    System.out.println("BloomFilter contains sohu!"); 
		    System.out.println("Probability of a false positive: " + bloomFilter.expectedFalsePositiveProbability());
		}else{
			System.out.println("not contain vo2 ");
		}
	}
	
	@Test
	public void testGetExpectRelatedInfo(){
		double falsePositiveProbability = 0.0005;
		int expectedSize = 100*100;//100*100*100*100;
		
		BloomFilter<String> bloomFilter = new BloomFilter<String>(falsePositiveProbability, expectedSize);
		bloomFilter.add("foo");
		
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
		
	}
	

	@Test
	public void testBloomFilter(){
		
		/*
		 * BloomFilter 添加对象时，可以需要重写 toString
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
