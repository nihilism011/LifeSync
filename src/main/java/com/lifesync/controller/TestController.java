package com.lifesync.controller;

import com.lifesync.domain.dto.TestReqDto;
import com.lifesync.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {
    final private TestService testService;


    @GetMapping("test")
    public ResponseEntity<?> getTest() throws Exception{
        return ResponseEntity.ok(testService.getTest());
    }
    @PostMapping("test")
    public ResponseEntity<?> addTest(@ModelAttribute TestReqDto testReqDto) throws Exception{
        return ResponseEntity.ok( testService.addTest(testReqDto));
    }
    @PutMapping("test/{testId}")
    public ResponseEntity<?> putTest(@PathVariable Long testId,@ModelAttribute TestReqDto testReqDto)throws Exception{
        return ResponseEntity.ok( testService.putTest(testId,testReqDto));
    }

}
