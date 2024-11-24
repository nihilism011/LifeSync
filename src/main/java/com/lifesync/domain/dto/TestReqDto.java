package com.lifesync.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TestReqDto {
    private Long testId;
    private String testName;
    private LocalDate testBirth;
    private String gender;
}
