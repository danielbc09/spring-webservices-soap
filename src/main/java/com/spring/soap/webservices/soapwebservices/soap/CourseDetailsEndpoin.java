package com.spring.soap.webservices.soapwebservices.soap;

import com.danyweb.courses.CourseDetails;
import com.danyweb.courses.GetCourseDetailsRequest;
import com.danyweb.courses.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by bautisj on 6/13/2018.
 */
@Endpoint
public class CourseDetailsEndpoin {

    @PayloadRoot(namespace = "http://danyweb.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest
            (@RequestPayload GetCourseDetailsRequest request) {

        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("Micro serivicos");
        courseDetails.setDescription("Course of Microservices !!");
        response.setCourseDetails(courseDetails);
        return response;
    }
}
