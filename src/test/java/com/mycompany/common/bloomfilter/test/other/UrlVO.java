package com.mycompany.common.bloomfilter.test.other;

/**
 * 利用Bloom Filter需要重写 toString方法,因为Bloom Filter是需要根据 toString 进行比较的
 * @author wangjb
 *
 */
public class UrlVO {

	private int id;
	private String url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	//BloomFilter
	public String toString(){
		return url;
	}
	
	
	
}
