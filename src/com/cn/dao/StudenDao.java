package com.cn.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cn.bean.Student;
import com.cn.util.DbUtil;
import com.cn.util.Page;
public class StudenDao {

	
	
	
	public static  List<Student> getStudentsByPage(Page page) {  
        List<Student> students = new ArrayList<Student>();  
        try {  
            String sql = "SELECT id,studentName,hobby FROM Student limit "+page.getBeginIndex()+","+page.getPageSize(); 
            System.out.println(sql);
            Connection conn = null;  
            try {  
                conn = DbUtil.getconn("s");  
                Statement statement = conn.createStatement();  
                statement.setMaxRows(page.getEndIndex());//关键代码，设置最大记录数为当前页记录的截止下标  
                ResultSet resultSet = statement.executeQuery(sql); 
//                System.out.println(resultSet);
//                System.out.println(page.getBeginIndex()+":::::::::::"+page.getEndIndex());
//                if (page.getBeginIndex() > 0) {  
//                	resultSet.absolute(page.getBeginIndex());//关键代码，直接移动游标为当前页起始记录处  
//                }  
                while (resultSet.next()) { 
                	Student stu=new Student();
                	stu.setId(resultSet.getInt(1));
                     stu.setStudentName(resultSet.getString(2)); 
                     stu.setHobby(resultSet.getString(3));
                    students.add(stu); 
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
