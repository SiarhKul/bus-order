package com.example.busorder.controllers;


import com.example.busorder.models.dto.RouteRequestDTO;
import com.example.busorder.models.entities.Route;
import com.example.busorder.service.RouteService;
import com.example.busorder.util.ErrorResponse;
import com.example.busorder.util.CreteRouteException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Routes")
@RestController
@RequestMapping("/api/routes")
@AllArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @ApiResponse(responseCode = "200", description = "Available user routes")
    @Operation(summary = "route", description = "Route destination")
    @GetMapping()
    List<Route> getAllRoute() {
        return routeService.getAllRoutes();
    }

    @ApiResponse(responseCode = "200", description = "Route was created")
    @Operation(summary = "Create route based on list of city", description = "Return a created Route")
    @PostMapping
    Route createRoute(@RequestBody @Valid RouteRequestDTO routeRequestDTO, BindingResult bindingResult) {



        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new CreteRouteException(errorMsg.toString());
        }

        return routeService.createRoute(routeRequestDTO);
    }

}
