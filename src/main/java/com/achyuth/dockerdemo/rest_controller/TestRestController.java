package com.achyuth.dockerdemo.rest_controller;

import com.achyuth.dockerdemo.dao.TestDao;
import com.achyuth.dockerdemo.model.TestClass;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class TestRestController {

    @Autowired
    private TestDao testDao;

    @PostMapping("/{name}")
    public ResponseEntity<TestClass> addList(@PathVariable String name){
        TestClass testClass = new TestClass();
        testClass.setName(name);
        testDao.save(testClass);
        return new ResponseEntity<>(testClass, HttpStatus.OK);
    }

    @Operation(summary = "Create Menu", description = "Creation Of Domino's Menu Card. ", responses = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "PageNotFound"),
            @ApiResponse(responseCode = "500", description = "Server Error") })
    @GetMapping
    public ResponseEntity<List<TestClass>> getAll(){
        return new ResponseEntity<>(testDao.findAll(), HttpStatus.OK);
    }


}
