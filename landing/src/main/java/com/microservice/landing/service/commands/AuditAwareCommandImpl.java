package com.microservice.landing.service.commands;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareCommandImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("JustBADReboot");
    }
}
