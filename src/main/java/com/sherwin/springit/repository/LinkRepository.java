package com.sherwin.springit.repository;

import com.sherwin.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface LinkRepository extends JpaRepository<Link,Long> {

    Link findByTitleContaining(String title);
    List<Link> findAllByTitleContainingOrderByCreationDateDesc(String title);
    ArrayList<Link> findAllByTitleContaining(String title);
}
