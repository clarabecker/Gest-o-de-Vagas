package com.clarabecker.gestao_vagas.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarabecker.gestao_vagas.modules.company.entities.JobEntity;
import com.clarabecker.gestao_vagas.modules.company.useCases.CreateJobUseCase;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/job")

public class JobController {
    @Autowired
    private CreateJobUseCase createJobUseCase;
    
    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity) {
        return this.createJobUseCase.execute(jobEntity);
    } 
}
