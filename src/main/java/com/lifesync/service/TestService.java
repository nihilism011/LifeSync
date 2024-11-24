package com.lifesync.service;

import com.lifesync.domain.dto.TestReqDto;
import com.lifesync.domain.dto.TestResDto;
import com.lifesync.domain.entities.TestTable;
import com.lifesync.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    final private TestRepository testRepository;

    public List<TestResDto> getTest(){
        return testRepository.findAll().stream().map(TestResDto::of).toList();
    }
    public boolean addTest(TestReqDto testReqDto) {
        try {
            testRepository.save(TestTable.of(testReqDto));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean putTest(Long testId, TestReqDto testReqDto){
        try{
            TestTable existingTestTable = testRepository.findById(testId).orElse(null);

            if (existingTestTable == null) {
                return false;
            }
            existingTestTable.update(testReqDto);
            testRepository.save(existingTestTable);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
