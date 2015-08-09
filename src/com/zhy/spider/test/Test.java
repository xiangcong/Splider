package com.zhy.spider.test;

import java.util.List;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import com.zhy.spider.bean.LinkTypeData;
import com.zhy.spider.core.ExtractService;
import com.zhy.spider.rule.Rule;

public class Test
{
	/*
	@org.junit.Test
	public void getDatasByClass()
	{
		Rule rule = new Rule(
				"http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
		new String[] { "query.enterprisename","query.registationnumber" }, new String[] { "兴网","" },
				"cont_right", Rule.CLASS, Rule.POST);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}*/
	/*
	@org.junit.Test
	public void getDatasByClass()
	{
		Rule rule = new Rule(
				"http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
		null, null,
				"cont_right", Rule.CLASS, Rule.POST);
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}*/
/*
	@org.junit.Test
	public void getDatasByCssQuery()
	{
		Rule rule = new Rule("http://www.11315.com/search",
				new String[] { "name" }, new String[] { "兴网" },
				"div.g-mn div.con-model", Rule.SELECTION, Rule.GET); 
		List<LinkTypeData> extracts = ExtractService.extract(rule);
		printf(extracts);
	}*/
	/*
	@org.junit.Test
	public void getDatasByClass()
	{
		Rule rule = new Rule(
				"https://zhaocaibao.alipay.com/pf/productList.htm",
		null, null,
			"content-second-type", Rule.CLASS, Rule.GET);
		//null, -1, Rule.GET);
		int i = 0;
		while(i++ < 100000000){
			List<LinkTypeData> extracts = ExtractService.extract(rule);
			printf(extracts);
			i = 0;
		}
	}*/
	
	@org.junit.Test
	//获取招财宝数据并存到本地文档
	public void getDatasByClass()
	{		

		long i = 0;
		while(true){
			//大约5分钟执行一次
			if(i++ == 22500000000L){
				List<LinkTypeData> extracts = ExtractService.extract(new Rule(
    					"https://zhaocaibao.alipay.com/pf/productList.htm",
    					null, null,
    						"content-second-type", Rule.CLASS, Rule.GET));
				printf(extracts);
				i = 0;
			}
		}		
	}

	public void printf(List<LinkTypeData> datas)
	{
		
		try{
			File file =new File("zhaocaibao.txt");
		   if(!file.exists()){
		      file.createNewFile();
		   }
		   System.out.println("时间=" + new Date() );
			 FileWriter fileWritter = new FileWriter(file.getName(),true);
             BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
             String test = "时间=" + new Date() +"\r\n";
             bufferWritter.write(test);
           //  bufferWritter.newline();
             
		   
			for (LinkTypeData data : datas)
			{
				
				System.out.println(data.getLinkText());
				

				String test2 = data.getLinkText() + "\r\n";
	             bufferWritter.write(test2);
	             
	             
	
				//System.out.println(data.getLinkHref());
				System.out.println("***********************************");
			}
			bufferWritter.close();
			
		}
		catch(IOException e){
			System.out.println("error!!");
		    e.printStackTrace();
		}
		

	}
	
	
}
