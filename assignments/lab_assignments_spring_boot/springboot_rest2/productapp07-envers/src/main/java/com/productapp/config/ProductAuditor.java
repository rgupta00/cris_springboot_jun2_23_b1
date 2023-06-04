package com.productapp.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

//-----------2. Create the imp of AuditorAware that can communicate to spring sec to get current loggedin user-------
public class ProductAuditor implements AuditorAware<String> {
    //fraemwrork call it

    @Override
    public Optional<String> getCurrentAuditor() {
        //spring sec... SecurityContextHolder give me logged in user
        return Optional.of("sumit");
    }
}
