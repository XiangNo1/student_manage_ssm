package com.situ.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.ssm.dao.StudentDao;
import com.situ.ssm.pojo.Accounts;
import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.Kecheng;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Service("studentService")
public class StudentServiceImpl implements IStudentService{
    
    @Resource(name="studentDao")
    private StudentDao studentDao;
    
    
    @Override
	public List<Accounts> findAccountsByName(String name) {
    	List<Accounts> list = studentDao.findAccountsByName(name);
		return list;
	}
	
	@Override
	public PageBean getStudentPageBean(SearchCondition searchCondition) {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(searchCondition.getPageIndex());
		pageBean.setPageSize(searchCondition.getPageSize());
		//总条数
		int index =( searchCondition.getPageIndex() - 1) * searchCondition.getPageSize();
		int totalCount = studentDao.getSearchStudentCount(searchCondition);
		pageBean.setTotalCount(totalCount);
		int totalPage =(int) Math.ceil((double) totalCount /searchCondition.getPageSize() );
		pageBean.setTotalPage(totalPage);
		List<Student> list = studentDao.findSearchStudentList(index,searchCondition);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}


	@Override
	public List<Banji> findBanji() {
		return studentDao.findBanji();
	}

	@Override
	public void deleteStudentById(Integer id) {
		studentDao.deleteStudentById(id);
	}

	@Override
	public boolean checkStudentName(String name) {
		List<Student> list = studentDao.checkStudentName(name);
		System.out.println("StudentServiceImpl.checkStudentName()" + list);
		Boolean flag = false;
		for (Student student : list) {
			flag = true;
		}
		return flag;
	}
	
	@Override
	public void deleteAllStudent(String[] selectIds) {
		for (String id : selectIds) {
			studentDao.deleteStudentById(Integer.parseInt(id));
		}
	}

	@Override
	public Student findById(Integer id) {
		return studentDao.findById(id);
		}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	@Override
	public PageBean getPageBeanBanji(int pageIndex, int pageSize) {
		PageBean<Banji> pageBean = new PageBean<Banji>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		//总条数
		List<Banji> banjiList = studentDao.findBanji();
		int i = 0;
		for (Banji banji : banjiList) {
			i++;
		}
		int totalCount = i;
		pageBean.setTotalCount(totalCount);
		int totalPage =(int) Math.ceil((double) totalCount / pageSize );
		pageBean.setTotalPage(totalPage);
		int index =( pageIndex - 1) * pageSize;
		List<Banji> list = studentDao.findBanjiPageBeanList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void deleteBanji(Integer id) {
		studentDao.deleteBanji(id);
	}

	@Override
	public void addBanji(Banji banji) {
		studentDao.addBanji(banji);
	}

	@Override
	public boolean checkBanjiName(String name) {
		List<Banji> list = studentDao.checkBanjiName(name);
		Boolean flag = false;
		for (Banji banji : list) {
			flag = true;
		}
		return flag;
	}

	@Override
	public Banji findBanjiById(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.findBanjiById(id);
	}

	@Override
	public void updateBanji(Banji banji) {
		studentDao.updateBanji(banji);
	}

	@Override
	public PageBean getPageBeanKecheng(int pageIndex, int pageSize) {
		PageBean<Kecheng> pageBean = new PageBean<Kecheng>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		//总条数
		List<Kecheng> kechengList = studentDao.findKecheng();
		int i = 0;
		for (Kecheng kecheng : kechengList) {
			i++;
		}
		int totalCount = i;
		pageBean.setTotalCount(totalCount);
		int totalPage =(int) Math.ceil((double) totalCount / pageSize );
		pageBean.setTotalPage(totalPage);
		int index =( pageIndex - 1) * pageSize;
		List<Kecheng> list = studentDao.findKechengPageBeanList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void addKecheng(Kecheng kecheng) {
		studentDao.addKecheng(kecheng);
	}

	@Override
	public void deleteKecheng(Integer id) {
		studentDao.deleteKecheng(id);
	}

	@Override
	public void updateKecheng(Kecheng kecheng) {
		studentDao.updateKecheng(kecheng);
	}

	@Override
	public Kecheng findKechengById(Integer id) {
		// TODO Auto-generated method stub
		return studentDao.findKechengById(id);
	}

	@Override
	public boolean checkKechengName(String name) {
		List<Kecheng> list = studentDao.checkKechengName(name);
		boolean flag = false;
		for (Kecheng kecheng : list) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.findAllStudent();
	}

	@Override
	public PageBean getPageBeanStudentBanjiKecheng(int pageIndex, int pageSize) {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		//总条数
		int i = 0;
		List<Student> studentList = studentDao.findStudentBanjiKecheng();
		for (Student student : studentList) {
			i++;
		}
		int totalCount = i;
		pageBean.setTotalCount(totalCount);
		int totalPage =(int) Math.ceil((double) totalCount / pageSize ) + 1;
		pageBean.setTotalPage(totalPage);
		int index =( pageIndex - 1) * pageSize;
		List<Student> list = studentDao.findStudentBanjiKechengPageBeanList(index, pageSize);
		for (Student student : list) {
			System.out.println(student);
		}
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public PageBean getPageBeanJiaowuBanjiSearch(int pageIndex, int pageSize, Integer id) {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		//总条数
		int totalCount = 1; //studentDao.getJiaowuBanjiTotalCount(id);
		pageBean.setTotalCount(totalCount);
		int totalPage =(int) Math.ceil((double) totalCount / pageSize );
		pageBean.setTotalPage(totalPage);
		int index =( pageIndex - 1) * pageSize;
		System.out.println("id : " + id);
		List<Student> list = studentDao.findStudentBanjiKechengPageBeanListSearch(/*index, pageSize,*/ id);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public List<Kecheng> findKecheng() {
		// TODO Auto-generated method stub
		return studentDao.findKecheng();
	}

	@Override
	public void addBanjiKecheng(Integer banji, Integer kecheng) {
		// TODO Auto-generated method stub
		studentDao.addBanjiKecheng(banji, kecheng);
	}

	@Override
	public PageBean getPageBeanBanjiKecheng(int pageIndex, int pageSize) {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		//总条数
		int totalCount =1; //studentDao.getBanjiKechengTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage =(int) Math.ceil((double) totalCount / pageSize );
		pageBean.setTotalPage(totalPage);
		int index =( pageIndex - 1) * pageSize;
		List<Banji> list = studentDao.findBanjiKechengPageBeanList(index, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void deleteBanjiKecheng(Integer banji_id, Integer kecheng_id) {
		// TODO Auto-generated method stub
		studentDao.deleteBanjiKecheng(banji_id, kecheng_id);
	}

	@Override
	public PageBean getPageBeanBanjiKechengSearch(int pageIndex, int pageSize, Integer banji_id) {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		//总条数
		int totalCount =1; //studentDao.getBanjiKechengTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage =(int) Math.ceil((double) totalCount / pageSize );
		pageBean.setTotalPage(totalPage);
		int index =( pageIndex - 1) * pageSize;
		List<Banji> list = studentDao.findBanjiKechengPageBeanListSearch(banji_id);
		pageBean.setList(list);
		return pageBean;
	}
}

