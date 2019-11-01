package com.crudspringboot.crudapp;

import com.crudspringboot.crudapp.entity.Admin;
import com.crudspringboot.crudapp.entity.Student;
import com.crudspringboot.crudapp.entity.StudentData;
import com.crudspringboot.crudapp.service.AdminService;
import com.crudspringboot.crudapp.service.StudentDataService;
import com.crudspringboot.crudapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AppController {
    @Autowired
    private StudentDataService studentDataService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentData>> viewHomePage(Model model){
        List<StudentData> studentDataList = studentDataService.listAll();
        model.addAttribute("studentDataList",studentDataList);
        return new ResponseEntity<List<StudentData>>(studentDataList,HttpStatus.OK);
    }

    @GetMapping("/student")
    @ResponseBody
    public Optional<StudentData> findStudentByMatric(@RequestParam(value = "matric") String matric){

        return  studentDataService.findStudentByMatric(matric);
    }

    @PostMapping("/student/editscore")
    @ResponseBody
    public StudentData findStudentByMatricAndEditScore(@RequestParam(value = "matric") String matric, @RequestParam (value = "score") int score){

        Optional<StudentData> studentData =  studentDataService.findStudentByMatric(matric);

        if(studentData.isPresent()){
            StudentData data = studentData.get();
            data.setScore(score);
            studentDataService.addCourse(data);
            return data;
        }

        else {
            return null;
        }
    }





    @GetMapping("/admin")
    public String viewHomePageAdmin(Model model){
        List<StudentData> studentDataList = studentDataService.listAll();
        model.addAttribute("studentDataList",studentDataList);
        return  "index_admin.html";
    }

    @GetMapping("/new")
    public String showNewCourseForm(Model model){
        StudentData studentData = new StudentData();
        model.addAttribute("studentData", studentData);
        return "new_course";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("studentData") StudentData studentData){
        System.out.println(studentData.getCoursec());
        studentDataService.addCourse(studentData);
        return "redirect:/student";

    }

    @RequestMapping(value = "/savescore", method = RequestMethod.POST)
    public String updateCourse(@ModelAttribute("studentData") StudentData studentData){
        studentDataService.addCourse(studentData);
        return "redirect:/admin";

    }
    @GetMapping("/")
    public String showLogInForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "login";
    }

    @GetMapping("/loginadmin")
    public String showLogInFormAdmin(Model model){
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "login_admin";
    }


    @GetMapping(value = "/edit/{id}")
    public ModelAndView editProduct(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_data");

        StudentData data= studentDataService.findCourseById(id);

        modelAndView.addObject("studentData",data);
        return modelAndView;

    }
//Admin editing
    @RequestMapping(value = "/editadmin/{id}")
    public ModelAndView editCourseAdmin(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_data_admin");
        StudentData data= studentDataService.findCourseById(id);
        System.out.println(data.getScore());
        modelAndView.addObject("studentData",data);
        return modelAndView;

    }



    @RequestMapping(value = "/delete/{id}")
    public String deleteCourse(@PathVariable(name = "id") Long id){
           studentDataService.delete(id);

    return "redirect:/student";

    }
    @RequestMapping(value = "/continue", method = RequestMethod.POST)
    public String loginForm(@ModelAttribute("student") Student studentData){
        System.out.println(studentData.getMatric());
        Student student = studentService.getUserWithMatricAndPassword(studentData.getMatric(),studentData.getPassword());
        if (student!=null){
            return "redirect:/student";
        }
        else
            return "error";
    }


    @RequestMapping(value = "/continueadmin", method = RequestMethod.POST)
    public String loginFormAdmin(@ModelAttribute("admin") Admin adminData){
        System.out.println(adminData.getAdmin());
        Admin admin = adminService.getAdminWithIdnumAndPassword(adminData.getAdmin(),adminData.getPassword());
        if (admin!=null){
            return "redirect:/admin";
        }
        else
            return "error";
    }

//    @PostMapping("/adddata")
//    public String addNewData(@RequestBody StudentData studentData){
//        studentDataService.addProduct(studentData);
//        return "Data added successfully";
//    }

}
