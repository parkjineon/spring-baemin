package com.example.mall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    MemberJPARepository memberJPARepository;

    @Transactional
    public Optional<Member> join(Member member) {
        memberJPARepository.save(member);
        return memberJPARepository.findByUserId(member.getUserId());
    }

    public boolean checkDuplicateId(String userId) {
        Optional<Member> existMember
            = memberJPARepository.findByUserId(userId);

        if(existMember.isEmpty()){
            return false;
        }

        return true;
    }

    public Member login(Member requestMember) {
        return memberJPARepository.login(requestMember.getUserId(),requestMember.getPw());
    }

    public Optional<Member> findById(int id){
        return memberJPARepository.findById(id);
    }
}
