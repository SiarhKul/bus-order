package com.example.busorder.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Schedule")
@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {


    @Operation(summary = "Get schedule of bus", description = "User gets some data about the bus schedule.Proved destination time, departure time, time, amount of passengers")
    @ApiResponse(responseCode = "200", description = "A Successfully response provides bus schedule date")
    @PostMapping
    public String getSchedule(){
        return  "Response";
    }


}
