package com.example.busorder.validators;

import com.example.busorder.models.dto.RouteRequestDTO;
import com.example.busorder.repository.RouteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@AllArgsConstructor
@Component
public class RouterValidator implements Validator {

    private final RouteRepository routeRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return RouteRequestDTO.class.equals(clazz);
    };

    @Override
    public void validate(Object target, Errors errors) {



    }
}
