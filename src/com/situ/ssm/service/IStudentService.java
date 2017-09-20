package com.situ.ssm.service;

import java.util.List;

import com.situ.ssm.pojo.Accounts;
import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.Kecheng;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

public interface IStudentService {
	PageBean<Student> getStudentPageBean(SearchCondition searchCondition);

	List<Accounts> findAccountsByName(String name);
	
	List<Banji> findBanji();

	void addStudent(Student student);

	void deleteStudentById(Integer id);

	boolean checkStudentName(String name);

	void deleteAllStudent(String[] selectIds);

	Student findById(Integer id);

	void updateStudent(Student student);

	PageBean getPageBeanBanji(int pageIndex, int pageSize);

	void deleteBanji(Integer id);

	void addBanji(Banji banji);

	boolean checkBanjiName(String name);

	Banji findBanjiById(Integer id);

	void updateBanji(Banji banji);

	PageBean getPageBeanKecheng(int pageIndex, int pageSize);

	void addKecheng(Kecheng kecheng);

	void deleteKecheng(Integer id);

	void updateKecheng(Kecheng kecheng);

	Kecheng findKechengById(Integer id);

	boolean checkKechengName(String name);

	List<Student> findAllStudent();

	PageBean getPageBeanStudentBanjiKecheng(int pageIndex, int pageSize);

	PageBean getPageBeanJiaowuBanjiSearch(int pageIndex, int pageSize, Integer studentSearch);

	List<Kecheng> findKecheng();

	void addBanjiKecheng(Integer banji, Integer kecheng);

	PageBean getPageBeanBanjiKecheng(int pageIndex, int pageSize);

	void deleteBanjiKecheng(Integer banji_id, Integer kecheng_id);

	PageBean getPageBeanBanjiKechengSearch(int pageIndex, int pageSize, Integer banjiSearch);
}
