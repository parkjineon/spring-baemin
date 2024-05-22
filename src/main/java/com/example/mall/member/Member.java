package com.example.mall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Getter
@Setter
public class Member {
    @Id
    private int id;
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;

    @Autowired
    public Member(){

    }

    public Member(String userId, String pw){
        this.userId = userId;
        this.pw = pw;
    }

    public Member(String userId, String pw, String name, String email, String contact){
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public Member fromDTOToEntity(MemberDTO memberDTO){
        return new Member(
                memberDTO.getUserId(),
                memberDTO.getPw(),
                memberDTO.getName(),
                memberDTO.getEmail(),
                memberDTO.getContact()
        );

    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
