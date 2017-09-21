package com.situ.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.ssm.pojo.Accounts;
import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.Kecheng;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.vo.SearchCondition;

public interface StudentDao {
	int getSearchStudentCount(SearchCondition searchCondition);

	List<Student> findSearchStudentList(@Param(value="index")int index, @Param(value="searchCondition")SearchCondition searchCondition);

	List<Accounts> findAccountsByName(String name);

	void deleteStudentById(Integer id);

	void addStudent(Student student);

	List<Banji> findBanji();

	List<Student> checkStudentName(String name);

	Student findById(Integer id);

	void updateStudent(Student student);

	List<Banji> findBanjiPageBeanList(@Param(value="index")int index, @Param(value="pageSize")int pageSize);

	void deleteBanji(Integer id);

	void addBanji(Banji banji);

	List<Banji> checkBanjiName(String name);

	Banji findBanjiById(Integer id);

	void updateBanji(Banji banji);

	List<Kecheng> findKecheng();

	List<Kecheng> findKechengPageBeanList(@Param(value="index")int index, @Param(value="pageSize")int pageSize);

	void addKecheng(Kecheng kecheng);

	void deleteKecheng(Integer id);

	Kecheng findKechengById(Integer id);

	void updateKecheng(Kecheng kecheng);

	List<Kecheng> checkKechengName(String name);

	List<Student> findAllStudent();

	List<Student> findStudentBanjiKecheng();

	List<Student> findStudentBanjiKechengPageBeanList(@Param(value="index")int index, @Param(value="pageSize")int pageSize);

	List<Student> findStudentBanjiKechengPageBeanListSearch(/*int index, int pageSize, */Integer id);

	void addBanjiKecheng(@Param(value="banji_id")Integer banji, @Param(value="kecheng_id")Integer kecheng);

	List<Banji> findBanjiKechengPageBeanList(int index, int pageSize);

	void deleteBanjiKecheng(@Param(value="banji_id")Integer banji_id, @Param(value="kecheng_id")Integer kecheng_id);

	List<Banji> findBanjiKechengPageBeanListSearch(Integer banji_id);

	List<Banji> findBanjiStudentPageBeanList(int index, int pageSize);

	List<Banji> findBanjiStudentPageBeanListSearch(Integer banji_id);


	
}

