package com.example.mall.member;

import ch.qos.logback.core.joran.sanity.Pair;
import com.example.mall.utils.ApiUtils;

import com.example.mall.utils.HandleException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.mall.utils.ApiUtils.error;
import static com.example.mall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {

    MemberService memberService;

//    @PostMapping("/join/res/en") // Before
//    public ResponseEntity<String> joinByResponseEntity(@RequestBody MemberDTO memberDTO) {
//        log.info(memberDTO.toString());
//
//        if(isDuplicateId(memberDTO))
//            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
//        Member requestMember = memberDTO.convertToEntity();
//        String userId = memberService.join(requestMember);
//        return new ResponseEntity<>(userId, HttpStatus.OK);
//    }

    @PostMapping("/login")
    public ApiUtils.ApiResult<String> login(@RequestBody LoginDTO loginDTO){
        Member requestMember = loginDTO.convertToEntity();

        boolean isSuccess = memberService.login(requestMember);

        if(!isSuccess){
            return error("로그인 실패", HttpStatus.BAD_REQUEST);
        }

        return success("로그인 성공");
    }


    @PostMapping("/join")
    public ApiUtils.ApiResult join(@Valid @RequestBody MemberDTO memberDto) {

        // ID 중복 체크
        if(isDuplicateId(memberDto)){
            return error("아이디 중복",HttpStatus.CONFLICT); // 409 에러
        }
        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.join(requestMember);
        return success(userId);
    }

    private boolean isDuplicateId(MemberDTO memberDTO) {
        return memberService.checkDuplicateId(memberDTO.getUserId());
    }

    @GetMapping("/datasource")
    public void makeConnection(){
        memberService.makeConnection();
    }


}
