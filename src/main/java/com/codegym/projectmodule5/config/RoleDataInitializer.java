// src/main/java/com/codegym/projectmodule5/config/RoleDataInitializer.java
package com.codegym.projectmodule5.config;

import com.codegym.projectmodule5.entity.Role;
import com.codegym.projectmodule5.enums.RoleEnum;
import com.codegym.projectmodule5.repository.RoleRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RoleDataInitializer implements ApplicationRunner {

    private final RoleRepository roleRepository;

    public RoleDataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        for (RoleEnum r : RoleEnum.values()) {
            if (!roleRepository.existsByName(r)) {
                roleRepository.save(new Role(r));
                System.out.println("Seeding role: " + r);
            }
        }
    }
}
