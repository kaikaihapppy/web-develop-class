package com.example.jpa.repository;

import com.example.jpa.domin.Discuss;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface DiscussRepository extends JpaRepository<Discuss, Integer> {
    public List<Discuss> findByAuthorNotNull();

    @Query("SELECT c FROM t_comment c WHERE c.aId = ?1")
    public List<Discuss> getDiscussPaged(Integer aid, Pageable pageable);


    @Transactional
    @Modifying
    @Query("UPDATE t_comment c SET c.author = ?1 WHERE c.id = ?2")
    public int updateDiscuss(String author, Integer id);

    @Transactional
    @Modifying
    @Query("DELETE t_comment c WHERE c.id = ?1")
    public int deleteDiscuss(Integer id);
}
