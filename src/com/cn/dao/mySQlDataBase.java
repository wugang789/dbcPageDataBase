package com.cn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.cn.bean.Student;
import com.cn.daointerface.DatabasesDao;
import com.cn.util.DbUtil;
import com.cn.util.Page;

public class mySQlDataBase implements DatabasesDao{

	@Override
	public   List<Student> findDataBase(Page page, String SQL,String[] tables,String fields,String flag){
		List list = null;
		   List<Student> students = new ArrayList<Student>(); 
		   String sqlserver="";
	        try {  
	        	String newtables=Arrays.toString(tables).substring(1);
	    		String mtNewtables=Arrays.toString(tables).substring(1,newtables.length());
	    		
	    		if(fields.length()==0||fields==null){
	    			 fields="*";
	    		 }
	    		
//	    	   	String newFiles=Arrays.toString(fields).substring(1);
//	    		 String myNewFiles=Arrays.toString(fields).substring(1,newFiles.length());
	    		 
	    	 	StringBuffer buf=null;
	    	 	
	            Connection conn = null;  
	            try {  
	            	if(flag.equals("mysql")){
	            		buf=new StringBuffer("select"+"  "+sqlserver+" "+fields+ "  from   "+mtNewtables+"  ");
	            		buf.append(SQL);
	            		System.out.println("mysql  "+buf.toString());
	            	}else if(flag.equals("sqlserver")){
	            		sqlserver="top"+" "+page.getPageSize()+"* ";
	            		buf=new StringBuffer("select"+"  "+sqlserver+" "+fields+ "  from   "+mtNewtables+"   ");
	            		buf.append(SQL);
	            		System.out.println("sqlserver"+buf.toString());
	            	}
	                conn = DbUtil.getconn(flag);  
	                Statement statement = conn.createStatement();  
	                statement.setMaxRows(page.getEndIndex());//关键代码，设置最大记录数为当前页记录的截止下标
	                System.out.println(buf.toString()+">>>>>>>>>...");
	                ResultSet resultSet = statement.executeQuery(buf.toString()); 
//	                System.out.println(resultSet);
//	                System.out.println(page.getBeginIndex()+":::::::::::"+page.getEndIndex());
//	                if (page.getBeginIndex() > 0) {  
//	                	resultSet.absolute(page.getBeginIndex());//关键代码，直接移动游标为当前页起始记录处  
//	                }  
	             
//	                	/Student stu=new Student();
//	                	stu.setId(resultSet.getInt(1));
//	                     stu.setStudentName(resultSet.getString(2)); 
//	                     stu.setHobby(resultSet.getString(3));
//	                    students.add(stu); 
	                	list = DbUtil.resultSetToList(resultSet);
	                	for (int i = 0; i < list.size(); i++) {
	            			Student st = (Student) DbUtil.MapToBean(
	            					new Student(), (Map) list.get(i));
	            			students.add(st);
	            		}
	             
	                resultSet.close();  
	                statement.close();  
	            } finally {  
	                if (conn != null) {  
	                    conn.close();  
	                }  
	            }  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return students;  
	}

	
	
	public static int getCount(String flag){
		String sql="select count(*) from Student";
		 Connection conn = null;  
		 int j=0;
         try {  
             conn = DbUtil.getconn(flag);  
             Statement statement = conn.createStatement();  
              ResultSet rs=statement.executeQuery(sql);
              while (rs.next()) {
				j= rs.getInt(1);
				
			}
             System.out.println(j);
         }catch (Exception e) {
       e.printStackTrace();
         }
		return j;
		
		
	}
	
	
	
	
	
}
