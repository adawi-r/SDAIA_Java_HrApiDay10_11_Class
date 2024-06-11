package org.example.Mapper;

import org.example.dto.EmployeeDto;
import org.example.models.Employee;
import org.example.models.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper (uses = {JobMapper.class})
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    EmployeeDto toEmpDto(Employee emp);

    @Mapping(source = "e.job_id" , target = "job_id")
    EmployeeDto toEmpDto(Employee e, Job j);

    Employee toModel(EmployeeDto dto);




}
