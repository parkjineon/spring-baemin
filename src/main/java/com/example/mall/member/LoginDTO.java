package com.example.mall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDTO {

    @NotBlank(message = "ID는 필수 입력입니다.")
    @JsonProperty("user_id")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Size(min=8, message = "최소 8자리 이상 입력해주세요.")
    private String pw;

    public Member convertToEntity() {
        return new Member(
                userId,
                pw
        );
    }
}
