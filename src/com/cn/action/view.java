package com.cn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.bean.Student;
import com.cn.dao.StudenDao;
import com.cn.dao.mySQlDataBase;
import com.cn.daointerface.DatabasesDao;
import com.cn.util.Page;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class view
 */
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletContext context=this.getServletContext();
		 int currentPage = 1;  
		   String index = request.getParameter("index");
			if (index != null) {
				currentPage = Integer.valueOf(index);// 记录当前页
			}
		    String[] tables={"Student"};
		   // String[] fields={"id","studentName","hobby"};
		     String flag="mysql";
		     String fields=context.getInitParameter("fields");
		    //取得总记录数，创建Page对象  
		    int totalRow = mySQlDataBase.getCount(flag);//通过select count 取得总记录数  
		    Page page = new Page(totalRow, currentPage);
		    String SQL="limit "+page.getBeginIndex()+", "+page.getPageSize();
		    DatabasesDao da=new mySQlDataBase();
		    List<Student> list=   da.findDataBase(page, SQL, tables, fields, flag);
		 //  List<Student> list= StudenDao.getStudentsByPage(page);
		    System.out.println(list);
		    request.setAttribute("mylist", list);
			request.setAttribute("index", new Integer(currentPage));
			request.setAttribute("pageCount", new Integer(page.getTotal()));
			request.setAttribute("count", new Integer(page.getTotalRow()));
		    System.out.println(list);
		    request.getRequestDispatcher("/view.jsp").forward(request, response);
	}
		
		

}
