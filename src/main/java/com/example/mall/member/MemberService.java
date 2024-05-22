package com.example.mall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    @Transactional
    public String join(Member member) {
        memberRepository.save(member);

        return memberRepository.findByUserId(member.getUserId()).getUserId();
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember
            = memberRepository.findByUserId(userId);

        if (existMember == null)
            return false;
        else
            return true;
    }

    public void makeConnection() {
        memberRepository.makeConnection();
    }

    public boolean login(Member requestMember) {
        return memberRepository.login(requestMember);
    }
}
