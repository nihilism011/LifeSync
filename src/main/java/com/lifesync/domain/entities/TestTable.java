package com.lifesync.domain.entities;

import com.lifesync.domain.dto.TestReqDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "testTable")
public class TestTable extends DateBaseEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long testId;

    @Column (unique = true, nullable = false)
    private String testName;

    @Column (nullable = false)
    private LocalDate testBirth;

    @Column (nullable = false)
    private String gender;

    public void update(TestReqDto testReqDto){
        this.testName = testReqDto.getTestName();
        this.gender = testReqDto.getGender();
        this.testBirth = testReqDto.getTestBirth();
    }
    public static TestTable of(TestReqDto testReqDto){
        return TestTable.builder()
                .testName(testReqDto.getTestName())
                .testBirth(testReqDto.getTestBirth())
                .gender(testReqDto.getGender())
                .build();
    }
}
