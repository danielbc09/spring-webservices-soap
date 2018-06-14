package com.spring.soap.webservices.soapwebservices.soap;

import com.danyweb.courses.CourseDetails;
import com.danyweb.courses.GetCourseDetailsRequest;
import com.danyweb.courses.GetCourseDetailsResponse;
import com.spring.soap.webservices.soapwebservices.soap.bean.Course;
import com.spring.soap.webservices.soapwebservices.soap.service.CourseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
        return mapCourse(course);
    }

    public GetCourseDetailsResponse mapCourse(Course course){
    GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        response.setCourseDetails(courseDetails);
        return response;
    }


}
