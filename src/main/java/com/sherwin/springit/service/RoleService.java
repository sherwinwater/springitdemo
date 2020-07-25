package com.sherwin.springit.service;

import com.sherwin.springit.domain.User;
import com.sherwin.springit.repository.RoleRepository;
import com.sherwin.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoleService {

    private final Logger logger = LoggerFactory.getLogger(RoleService.class);
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}


