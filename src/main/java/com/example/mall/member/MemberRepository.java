package com.example.mall.member;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class MemberRepository {
    private Map<String, Member> memberTable
            = new HashMap<>();

    @PersistenceContext
    EntityManager em;

    @PersistenceUnit
    EntityManagerFactory emf;
    
    
    @Autowired
    DataSource dataSource;

    public void makeConnection(){
        DataSourceUtils.getConnection(dataSource);
    }


    public void save(Member member) {

        em.persist(member);
//        Member savedMember = em.find(Member.class,member.getId());
//
//        return savedMember.getUserId();
    }


    public Member findByUserId(String userId) {
        try {
            return em.createQuery("select m from Member m where m.userId = :userId", Member.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public boolean login(Member requestMember) {
        Member member = findByUserId(requestMember.getUserId());

        return member != null && Objects.equals(member.getPw(), requestMember.getPw());
    }

    public Member findById(int id){
        return em.find(Member.class, id);
    }
}
