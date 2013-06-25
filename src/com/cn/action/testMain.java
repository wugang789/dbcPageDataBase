package com.cn.action;

import java.util.Arrays;

public class testMain {
	public static void main(String[] args) {
		String[] ss={"id","name","password"};
		String[] tables={"Student"};
		String newtables=Arrays.toString(tables).substring(1);
		String mtNewtables=Arrays.toString(tables).substring(1,newtables.length());
		
		String sqlserver="";
	   	String newFiles=Arrays.toString(ss).substring(1);
		 String myNewFiles=Arrays.toString(ss).substring(1,newFiles.length());
	 	StringBuffer buf=new StringBuffer("select"+"  "+sqlserver+"  "+myNewFiles+ "  from   "+mtNewtables+"");
		System.out.println(buf.toString());
		sqlserver="top 10";
		StringBuffer bufs=new StringBuffer("select"+"  "+sqlserver+"  "+myNewFiles+ "  from   "+mtNewtables+"");
		System.out.println(bufs.toString());
	}

}
