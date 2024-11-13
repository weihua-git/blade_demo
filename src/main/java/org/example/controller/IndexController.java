package org.example.controller;

import com.hellokaton.blade.annotation.Path;
import com.hellokaton.blade.annotation.request.Body;
import com.hellokaton.blade.annotation.request.Form;
import com.hellokaton.blade.annotation.request.PathParam;
import com.hellokaton.blade.annotation.request.Query;
import com.hellokaton.blade.annotation.route.GET;
import com.hellokaton.blade.annotation.route.POST;
import com.hellokaton.blade.mvc.RouteContext;
import com.hellokaton.blade.mvc.ui.ResponseType;
import com.hellokaton.blade.mvc.ui.RestResponse;

@Path
public class IndexController {

    @GET("/login")
    public String login() {
        return "login.html";
    }

    @POST(value = "/login", responseType = ResponseType.JSON)
    public RestResponse doLogin(RouteContext ctx) {
        // do something
        return RestResponse.ok();
    }

    @GET("/user")
    public void savePerson(@Query Integer age){
        System.out.println("age is:" + age);
    }

    @POST("/save")
    public void savePerson(@Form String username, @Form Integer age){
        System.out.println("username is:" + username + ", age is:" + age);
    }

    @GET("/users/:username/:page")
    public void userTopics(@PathParam String username, @PathParam Integer page){
        System.out.println("username is:" + username + ", page is:" + page);
    }

    @POST("/body")
    public void readBody(@Body String data){
        System.out.println("data is:" + data);
    }

}