package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    /**
     * POST
     * @RequestMapping으로 구현하기
     * http://localhost:8080/api/post-api/domain
     */
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    /**
     * @RequestBody를 활용한 POST 메서드 구현
     * HTTP의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑함
     *
     * Map 객체는 요청을 통해 어떤 값이 들어오는지 특정하기 힘들때 사용함
     *
     * http://localhost:8080/api/v1/post-api/member
     */
    @PostMapping("/member") // -> method 요소를 정의하지 않아도 됨
    public String postMember(@RequestBody Map<String, Object> postData){

        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    /**
     * DTO 객체를 활용한 POST API 구현
     * http://localhost:8080/api/v1/post-api/member2
     */
    @PostMapping("/member2")
    public String postMember2(MemberDto memberDto){
        return memberDto.toString();
    }

}
