package com.situ.ssm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.ssm.pojo.Banji;
import com.situ.ssm.pojo.Student;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.vo.PageBean;
import com.situ.ssm.vo.SearchCondition;

@Controller
@RequestMapping(value="/student")
public class StudentController {
    @Resource(name="studentService")
    private IStudentService studentService;
    //入口
    @RequestMapping(value="/updateStudent2")
	public String updateStudent2(Integer id, String name, Integer age, String gender, String address, Integer banji, String birthday){
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
		   Date date = null;
		   try {
		      date = simpleDateFormat.parse(birthday);
		   } catch (ParseException e) {
		      e.printStackTrace();
		   }
		   Student student = new Student(id,name, age, gender, address, date, banji);
		   studentService.updateStudent(student);
		return "redirect:/student/searchByCondition.action";
	}
	
	@RequestMapping(value="/updateStudent")
	public ModelAndView updateStudent(Integer id, ModelAndView modelAndView){
		Student student = studentService.findById(id);
		System.out.println(student);
		Integer banjiNow = student.getBanji().getId();
		List<Banji> banjiList = studentService.findBanji();
		System.out.println("banjiNow" + banjiNow);
		modelAndView.addObject("banjiNow", banjiNow);
		modelAndView.addObject("banjiList", banjiList);
	    modelAndView.addObject("student", student);
	    modelAndView.setViewName("updateStudentJsp");
	    return modelAndView;
	}
	
	@RequestMapping(value="/deleteAllStudent")
	public String deleteAllStudent(String[] selectIds){
		System.out.println(selectIds);
		if (selectIds != null)  {
			studentService.deleteAllStudent(selectIds);
		}
		return "redirect:/student/searchByCondition.action";
	}
	
	@RequestMapping(value="/checkStudentName")
	public void checkStudentName(String name, HttpServletRequest request, HttpServletResponse resp) throws IOException{
		boolean isExit = studentService.checkStudentName(name);
		resp.setContentType("charset=utf-8");
		resp.getWriter().write("{\"isExit\":" + isExit + "}");
	}
	
	@RequestMapping(value="/deleteStudent")
	public String deleteStudent(Integer id){
		System.out.println("id : " + id);
		studentService.deleteStudentById(id);
		return "redirect:/student/searchByCondition.action";
	}
	
	@RequestMapping(value="/addStudent2")
	public String addStudent2(String name, Integer age, String gender, String address, Integer banji_id, String birthday){
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
		   Date date = null;
		   try {
		      date = simpleDateFormat.parse(birthday);
		   } catch (ParseException e) {
		      e.printStackTrace();
		   }
		   Student student = new Student(name, age, gender, address, date, banji_id);
		   studentService.addStudent(student);
		return "redirect:/student/searchByCondition.action";
	}
	
	
	@RequestMapping(value="/addStudent")
	public ModelAndView addStudnt(ModelAndView modelAndView){
		List<Banji> banjiList = studentService.findBanji();
		modelAndView.addObject("banjiList", banjiList);
		modelAndView.setViewName("addStudentJsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/searchByCondition")
	public ModelAndView searchByCondition(ModelAndView modelAndView, String name, String age, String gender, String address, String banji, String pageIndex,String pageSize){
		
	    SearchCondition searchCondition = new SearchCondition(name, age, gender, address, banji);

			int pageIndex1 = 1;
			if (pageIndex!= null && !pageIndex.equals("")) {
				pageIndex1 = Integer.parseInt(pageIndex);
			}
			int pageSize1 = 3;
			if (pageSize != null && !pageSize.equals("")) {
				pageSize1 = Integer.parseInt(pageSize);
			}
			searchCondition.setPageIndex(pageIndex1);
			searchCondition.setPageSize(pageSize1);
			PageBean pageBean = studentService.getStudentPageBean(searchCondition);
			System.out.println(pageBean);
			System.out.println(searchCondition);
			List<Banji> banjiList = studentService.findBanji();
			modelAndView.addObject("banjiList", banjiList);
			modelAndView.addObject("searchCondition", searchCondition);
			modelAndView.addObject("pageBean", pageBean);
			modelAndView.setViewName("findStudentJsp");
			return modelAndView;
	}
}

