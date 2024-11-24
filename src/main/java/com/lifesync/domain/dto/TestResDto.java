package com.lifesync.domain.dto;

import com.lifesync.domain.entities.TestTable;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class TestResDto {
    private String testName;
    private LocalDate testBirth;
    private String gender;

    public static TestResDto of(TestTable testTable){
        return TestResDto.builder()
                .testName(testTable.getTestName())
                .testBirth(testTable.getTestBirth())
                .gender(testTable.getGender())
                .build();
    }
}
