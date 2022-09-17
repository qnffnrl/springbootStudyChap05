package com.springboot.api.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    /**
     * @PathVariable과 @RequestParam을 활용한 DELETE 메서드 구현
     * http://localhost:8080/api/v1/delete-api/{String 값}
     */
    @DeleteMapping("/{variable}")
    public String deleteMember(@PathVariable String variable){
        return variable;
    }

    /**
     * http://localhost:8080/api/v1/delete-api/request?email=value
     */
    @DeleteMapping("/request")
    public String getRequestParam(@RequestParam String email){
        return "e-mail : " + email;
    }

}
