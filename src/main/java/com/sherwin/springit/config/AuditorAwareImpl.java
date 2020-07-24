package com.sherwin.springit.config;

import com.sherwin.springit.domain.User;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        if (SecurityContextHolder.getContext().getAuthentication() == null ||
                SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return Optional.of("admin@gmail.com");
        } else {
            return Optional.of(((User) SecurityContextHolder.getContext().
                    getAuthentication().getPrincipal()).getEmail());
        }
    }
}
