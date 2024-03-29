package com.example.busorder.controllers;

import com.example.busorder.config.producer.KafkaRouteProducer;
import com.example.busorder.exceptions.CreateEntityException;
import com.example.busorder.models.dto.RouteRequestDTO;
import com.example.busorder.models.entities.Route;
import com.example.busorder.service.serviceInterfaces.RouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
    private final KafkaRouteProducer kafkaRouteProducer;

    @Operation(summary = "route[Admin]", description = "Route destination")
    @ApiResponse(responseCode = "200", description = "Available user routes")
    @GetMapping()
    List<Route> getAllRoute() {
        return routeService.getAllRoutes();
    }

    @Operation(summary = "Create route based on list of city[Admin]",
            description = "Return a created Route")
    @ApiResponse(responseCode = "200", description = "Route was created")
    @PostMapping
    Route createRoute(@RequestBody @Valid RouteRequestDTO routeRequestDTO,
                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new CreateEntityException(errorMsg.toString());
        }

        Route route = routeService.createRoute(routeRequestDTO);

        kafkaRouteProducer.sendRoute(route);

        return route;
    }
}
