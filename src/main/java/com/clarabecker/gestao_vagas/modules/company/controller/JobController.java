package com.clarabecker.gestao_vagas.modules.company.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarabecker.gestao_vagas.modules.company.dto.CreateJobDTO;
import com.clarabecker.gestao_vagas.modules.company.entities.JobEntity;
import com.clarabecker.gestao_vagas.modules.company.useCases.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/job")

public class JobController {
    @Autowired
    private CreateJobUseCase createJobUseCase;
    
    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        var companyID = request.getAttribute("company_id");

        var jobEntity = JobEntity.builder()
        .benefits(createJobDTO.getBenefits())
        .companyID(UUID.fromString(companyID.toString()))
        .description(createJobDTO.getDescription())
        .level(createJobDTO.getLevel())
        .build();

        return this.createJobUseCase.execute(jobEntity);
    } 
}
