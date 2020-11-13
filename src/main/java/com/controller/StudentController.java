package com.controller;

import com.entity.Student;
import com.exception.ApiRequestException;
import com.exception.ApiRequestSuccessfull;
import com.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController{
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student/showall", method = RequestMethod.GET)
    public List<Student> getAll() {
        return studentService.showStudent();
    }

    @RequestMapping(value = "/student/id={id}", method = RequestMethod.GET)
    public Student getById(@PathVariable Long id) {
        return studentService.getByID(id);
    }
    @RequestMapping(value = "/student/mssv={mssv}", method = RequestMethod.GET)
    public Student getByMssv(@PathVariable String mssv) {
        return studentService.getByMssv(mssv);
    }


    @RequestMapping(value = "/student/find/name={name}", method = RequestMethod.GET)
    public List<Student> findbyname(@PathVariable String name) {
        return studentService.findbyname(name);
    }
    @RequestMapping(value = "/student/find/mssv={mssv}", method = RequestMethod.GET)
    public List<Student> findbymssv(@PathVariable String mssv) {
        return studentService.findbymssv(mssv);
    }
    @RequestMapping(value = "/student/find/cource={cource}", method = RequestMethod.GET)
    public List<Student> findbycource(@PathVariable String cource) {
        return studentService.findbycource(cource);
    }
    @RequestMapping(value = "/student/find/instute={instute}", method = RequestMethod.GET)
    public List<Student> findbyinstute(@PathVariable String instute) {
        return studentService.findbyinstute(instute);
    }
    @RequestMapping(value = "/student/find/phone={phone}", method = RequestMethod.GET)
    public List<Student> findbyphone(@PathVariable String phone) {
        return studentService.findbyphone(phone);
    }
    @RequestMapping(value = "/student/find/gender={gender}", method = RequestMethod.GET)
    public List<Student> findbygender(@PathVariable boolean gender) {

        throw new ApiRequestException("truong hop nay dang mac loi. se sua lai sau");
    }




    @RequestMapping(value = "/student/create", method = RequestMethod.POST)
    public void create(@RequestBody Student student){
        if (student.getName()== null){
            throw new ApiRequestException("name of student cant null. enter name");
        }
        if (student.getMssv()==null){
            throw new ApiRequestException("mssv of student cant null. enter mssv");
        }
        if (studentService.isExist(student.getMssv())){
            throw new ApiRequestException("this student with mssv: "+student.getMssv()+" is existed.");
        }
        studentService.create(student);
        throw new ApiRequestSuccessfull("create student successful");
    }

    @RequestMapping(value = {"/student/update/id={id}"}, method = RequestMethod.PUT)
    public void updatebyid(@RequestBody Student student,@PathVariable Long id){
        if (student.getName()== null){
            throw new ApiRequestException("name of student cant null. enter name");
        }
        if (student.getMssv()==null){
            throw new ApiRequestException("mssv of student cant null. enter mssv");
        }
        if (!studentService.isExist(student.getMssv())){
            throw new ApiRequestException("this student with mssv does not exist.");
        }
        if (id == null){
            throw new ApiRequestException("id cannot null");
        }
        Student buffer = studentService.getByID(id);
        buffer.setAll(student);
        studentService.create(buffer);

        throw new ApiRequestSuccessfull("update student successful");
    }

    @RequestMapping(value = {"/student/update/mssv={mssv}"}, method = RequestMethod.PUT)
    public void updatebymssv(@RequestBody Student student,@PathVariable String mssv){
        if (student.getName()== null){
            throw new ApiRequestException("name of student cant null. enter name");
        }
        if (studentService.getByMssv(mssv) == null ){
            throw new ApiRequestException("this mssv does not exist.");
        }

        Student student1 = studentService.getByMssv(mssv);
        student1.setAll(student);
        studentService.create(student1);

        throw new ApiRequestSuccessfull("update student successful");
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
        throw new ApiRequestSuccessfull("student with id: " + id +" is deleted");
    }
}
