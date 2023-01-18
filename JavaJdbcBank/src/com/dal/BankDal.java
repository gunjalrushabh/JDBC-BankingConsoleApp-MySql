package com.dal;
import java.sql.SQLException;
import java.util.List;

import com.pojo.sbi;
public interface BankDal {

	List<sbi> showallaccount() throws SQLException;
	int insertaccount(sbi sobj);
	int deleteaccount(int id);
	int updateaccount(int id,sbi sbj);
	
	
}
