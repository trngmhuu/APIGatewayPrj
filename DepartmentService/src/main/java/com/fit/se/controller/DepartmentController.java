package com.fit.se.controller;

import com.fit.se.entity.Department;
import com.fit.se.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<?> saveDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        List<Department> departmentList = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable int id) {
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable int id) {
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartmentById(@PathVariable int id, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartmentById(id, department);
        return ResponseEntity.ok(updatedDepartment);
    }
}
