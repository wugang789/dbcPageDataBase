package com.cn.daointerface;

import java.util.List;

import com.cn.bean.Student;
import com.cn.util.Page;

public interface DatabasesDao {

	/**
	 * SQL,SQL���ݿ�ӿ�
	 */
	public List<Student> findDataBase(Page page,String SQL,String[] tables,String fields,String flag );
	
}
