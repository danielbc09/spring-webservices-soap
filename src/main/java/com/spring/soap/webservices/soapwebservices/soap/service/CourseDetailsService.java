package com.spring.soap.webservices.soapwebservices.soap.service;

import com.spring.soap.webservices.soapwebservices.soap.bean.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by bautisj on 6/14/2018.
 */
@Component
public class CourseDetailsService {

    private  static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1, "Spring", "100 Steps");
        courses.add(course1);

        Course course2 = new Course(2, "Spring MVC", "10 Examples");
        courses.add(course2);

        Course course3 = new Course(3, "Spring Boot", "89 Steps");
        courses.add(course3);

        Course course4 = new Course(4, "Maven", "Maven vs Gradle");
        courses.add(course4);
    }


    public Course findById(int id){
        for (Course course:courses){
            if(course.getId() == id)
                return course;
        }
        return null;
    }

    public  List<Course> findAll(){
        return courses;
    }

    public int deleteById(int id){
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()){
            Course course = iterator.next();
            if (course.getId() == id){
                iterator.remove();
                return 1;
            }
        }
        return 0;
    }
}
