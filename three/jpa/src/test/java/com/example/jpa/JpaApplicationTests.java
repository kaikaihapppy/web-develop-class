package com.example.jpa;





import com.example.jpa.domin.Discuss;
import com.example.jpa.repository.DiscussRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class JpaApplicationTests {



    @Autowired
    private DiscussRepository discussRepository;

    @Test
    public void selectComment() {
        List<Discuss> list = discussRepository.findByAuthorNotNull();
        for (Discuss discuss : list) {
            System.out.println(discuss);
        }
        System.out.println();
        Optional<Discuss> optional = discussRepository.findById(1);
        System.out.println(optional.get());
    }

    @Test
    public void selectCommentPaged() {
        Pageable pageable = PageRequest.of(0, 4);
        List<Discuss> discussPaged = discussRepository.getDiscussPaged(1, pageable);
        System.out.println(discussPaged);
    }

    @Test
    public void updateComment() {
        int i = discussRepository.updateDiscuss("疯狂的拖拉机", 1);
        System.out.println(i);
    }

}
