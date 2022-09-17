package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api") // -> 클래스 레벨에서 선언되면 내부 메소드의 URL 앞에 공통 적용됨
public class GetController {

    /**
     * @RequestMapping http://localhost:8080/api/v1/api-get/hello
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET) // -> 스프링 4.3 버전 이후로 사용안함
    public String getHello() {
        return "Hello World";
    }

    /**
     * 매개변수가 없는 GET 메서드 구현 -> 실무에서 거의 사용 X (웹 통신의 목적은 데이터를 주고받기 위함)
     * http://localhost:8080/api/v1/api-get/name
     */
    @GetMapping("/name")
    public String getName() {
        return "Flature";
    }

    /**
     * @PathVariable을 활용한 GET 메서드 구현
     * http://locahost:8080/api/v1/api-get/variable1
     */
    @GetMapping("/variable1/{variable}") //--------------------> 변수명 통일
    public String getVariable(@PathVariable String variable) { //--> 변수명 통일
        return variable;
    }

    /**
     * @PathVariable 변수 명 통일 불가 시 / 특정 변수 명으로 선언하고 싶을때
     * http://localhost:8080/api/v1/api-get/variable2
     */
    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    /**
     * @RequestParam을 이용한 GET 메서드 구현
     * http://localhost:8080/api/vi/get-api/request1?name=value1&email=value2&organization=value3
     */
    @GetMapping("/request1")
    public String getRequestParam(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    /**
     * @RequestParam + Map을 이용한 GET 메서드 구현
     * http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
     */
    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {

        /**
         * StringBuilder
         * https://onlyfor-me-blog.tistory.com/317
         */
        StringBuilder sb = new StringBuilder();


        // *entrySet() => Map의 key와 value 모두 출력
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    /**
     * DTO 객체를 이용한 GET 메서드 구현
     * http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
     */
    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto) {
//        return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return memberDto.toString();
    }

    /**
     * 정리
     */

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test2")
    public String test2(@RequestParam String id){
        return id;
    }

    @GetMapping("/test3/{val}")
    public String test3(@PathVariable String val) {
        return val;
    }

    @GetMapping("/test4/{val2}")
    public String test4(@PathVariable("val2") String parameter){
        return parameter;
    }
}
