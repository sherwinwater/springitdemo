package com.sherwin.springit.repository;

import com.sherwin.springit.domain.Link;
import com.sherwin.springit.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
