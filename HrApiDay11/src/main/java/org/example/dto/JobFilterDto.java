package org.example.dto;

import jakarta.ws.rs.QueryParam;

public class JobFilterDto {
    private @QueryParam("min_salary") Double min_salary;
    private @QueryParam("max_salary") Double max_salary;
    private @QueryParam("limit") Integer limit;
    private @QueryParam("offset") int offset;

    public Double getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Double min_salary) {
        this.min_salary = min_salary;
    }

    public Double getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Double max_salary) {
        this.max_salary = max_salary;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
