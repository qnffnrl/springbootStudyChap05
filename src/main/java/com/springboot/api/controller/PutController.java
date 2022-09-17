package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    /**
     * @RequestBody를 활용한 PUT 메서드 구현
     * http://localhost:8080/api/v1/put-api/member
     */
    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, Object> putData){

        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();

    }

    /**
     * DTO 객체를 활용한 PUT 메서드 구현
     * http://localhost:8080/api/v1/put-api/member2
     */

    @PutMapping("/member2")
    public MemberDto postMember2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    /**
     * ResponseEntity를 활용한 PUT 메서드 구현
     * http://localhost:8080/api/v1/put-api/memebr3
     */

    @PutMapping("/member3")
    public ResponseEntity<MemberDto> postMember3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // -> 응답 코드를 202로 함
                .body(memberDto);
    }


}














