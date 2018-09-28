package com.cdelhoyo.cursosboot.web;

import com.cdelhoyo.cursosboot.domain.Course;
import com.cdelhoyo.cursosboot.domain.Teacher;
import com.cdelhoyo.cursosboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	private TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService){
		this.teacherService = teacherService;
	}

	@GetMapping()
	@Transactional(readOnly = true)
	public Page<Teacher> findTeachers(String name, Pageable pageable) {
		return teacherService.findTeachers(name, pageable);
	}

	@GetMapping("/{id}")
	@Transactional(readOnly = true)
	public Teacher get(@PathVariable Long id) {
		return teacherService.get(id);
	}

	@PostMapping()
	@Transactional
	public Teacher add(@RequestBody Teacher teacher) {
		return teacherService.add(teacher);
	}

	@GetMapping("/{id}/courses")
	@Transactional(readOnly = true)
	public Page<Course> findCourses(@PathVariable Long id, String name, Pageable pageable) {
		return teacherService.findCourses(id, name, pageable);
	}

	@PostMapping("/{id}/courses")
	@Transactional
	public Course addCourse(@PathVariable Long id, @RequestBody Course course) {
		return teacherService.addCourse(id, course);
	}

}
