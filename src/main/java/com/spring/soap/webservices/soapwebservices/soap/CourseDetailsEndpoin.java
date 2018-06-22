package com.spring.soap.webservices.soapwebservices.soap;

import com.danyweb.courses.*;
import com.spring.soap.webservices.soapwebservices.soap.bean.Course;
import com.spring.soap.webservices.soapwebservices.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

/**
 * Created by bautisj on 6/13/2018.
 */
@Endpoint
public class CourseDetailsEndpoin {

    @Autowired
    CourseDetailsService service;

    @PayloadRoot(namespace = "http://danyweb.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest
            (@RequestPayload GetCourseDetailsRequest request) {

        Course course = service.findById(request.getId());
        return mapCourseDetails(course);
    }

    private GetCourseDetailsResponse mapCourseDetails(Course course){
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        response.setCourseDetails(mapCourse(course));
        return response;
    }

    @PayloadRoot(namespace = "http://danyweb.com/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse processAllCourseDetailsRequest
            (@RequestPayload GetAllCourseDetailsRequest request) {
        List<Course> courses = service.findAll();
        return mapAllCourseDetails(courses);
    }

    public GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses){
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        for(Course course:courses){
            CourseDetails mapCourse = mapCourse(course);
            response.getCourseDetails().add(mapCourse);
        }
        return response;
    }


    public CourseDetails mapCourse(Course course){
    GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        return courseDetails;
    }


}
