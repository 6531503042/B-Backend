package com.example.b.controller;

import com.example.b.exchanges.BaseResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class ApiCrudController {

    @GetMapping("/getById")
    public abstract BaseResponse<?> getById(@RequestParam String id);

    @DeleteMapping("/delete")
    public abstract BaseResponse<?> delete(@RequestParam String id);

    @PutMapping("/update")
    public abstract BaseResponse<?> update(@RequestParam String id);
}
