package com.example.mall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;
    MemberJPARepository memberJPARepository;

    @Transactional
    public String join(Member member) {
        memberRepository.save(member);
        Optional<Member> responseMember = memberJPARepository.findByUserId(member.getUserId());
        return responseMember.map(Member::getUserId).orElse(null);

    }

    public boolean checkDuplicateId(String userId) {
        Member existMember
            = memberRepository.findByUserId(userId);

        if (existMember == null)
            return false;
        else
            return true;
    }

    public Member login(Member requestMember) {
        return memberRepository.login(requestMember.getUserId(),requestMember.getPw());
    }
}
