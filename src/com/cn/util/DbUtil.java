package com.cn.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DbUtil {
	public static Connection getconn(String flag) {
		System.out.println(flag);
		String drivername=null;
		if(flag.equals("mysql")){
		 drivername = "com.mysql.jdbc.Driver";
		}else if(flag.equals("sqlserver")){
		drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";	
		}
		// 数据库驱动
	
		// 数据库用户名
		String username = "root";
		// 密码
		String password = "";
		// 数据库名
		// String dbName="mycity";
		// 定义数据库连接对象connection
		Connection conn = null;
		// 定义url设置数据库连接时编码
		String url = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8";
		try {
			// 加载驱动
			Class.forName(drivername);
			System.out.println("开始连接.......");
			conn = DriverManager.getConnection(url, username, password);// 获取连接
			System.out.println("连接成功。。。。");

		} catch (Exception e) {
			System.out.println("连接不成功！");
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		try {
			Statement st = DbUtil.getconn("ss").createStatement();
			System.out.println("测试结束");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static  Object MapToBean(Object bean, Map map) {  
        Map methods = new HashMap();  
        Method m[] = bean.getClass().getMethods();  
        for (int i = 0; i < m.length; i++) {  
            Method method = m[i];  
            String methodName = method.getName().toUpperCase();  
            methods.put(methodName, method);  
        }  
  
        Iterator it = null;  
        String key = "";  
        it = map.keySet().iterator();  
        while (it.hasNext()) {  
            key = (String) it.next();  
            String name = "GET" + key.toUpperCase();  
            if (methods.containsKey(name)) {  
                Method setMethod = (Method) methods.get("SET" + key.toUpperCase());  
                try {  
                    if(setMethod!=null){  
                        Object[] obj=null;  
                        obj=new Object[1];  
                        obj[0]=map.get(key);  
                    setMethod.invoke(bean, obj);  
                    }  
                    else{  
                        continue;  
                    }  
                } catch (IllegalAccessException e) {  
                    e.printStackTrace();  
                } catch (InvocationTargetException e) {  
                    e.printStackTrace();  
                }  
  
            }  
        }  
        return bean;  
    }  
	
	
/**
 * 工具类把rs转成List
 * @param rs
 * @return
 * @throws java.sql.SQLException
 */
	public static List resultSetToList(ResultSet rs) throws java.sql.SQLException{
	       if(rs==null){
	           return null;
	       }

	       ResultSetMetaData md = rs.getMetaData();
	       int columnCount = md.getColumnCount();

	       List list = new ArrayList();
	       Map rowData;
	       while (rs.next()){
	           rowData = new HashMap(columnCount);
	           for (int i=1; i<=columnCount; i++){
	        	   
	        		   rowData.put(md.getColumnName(i),rs.getObject(i));
	        	   
	        	  
	           }
	           list.add(rowData);
	       }
	       return list;
	   }
	
}
