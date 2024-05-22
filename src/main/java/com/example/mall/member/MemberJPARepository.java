package com.example.mall.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberJPARepository extends JpaRepository<Member,Integer> {

    Optional<Member> findByUserId(String userId);
    Member findById(int id);

    @Query("select m from Member m where m.userId = :userId and m.pw = :pw ")
    Member login(@Param("userId") String userId, @Param("pw") String pw);
}
