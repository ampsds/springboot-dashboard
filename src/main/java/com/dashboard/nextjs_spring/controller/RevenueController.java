package com.dashboard.nextjs_spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dashboard.nextjs_spring.entity.Revenue;
import com.dashboard.nextjs_spring.repository.RevenueRepository;

import java.util.List;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {

    @Autowired
    private RevenueRepository revenueRepository;

    @GetMapping
    public List<Revenue> getAllRevenues() {
        return revenueRepository.findAll();
    }

    @PostMapping
    public Revenue createRevenue(@RequestBody Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    @GetMapping("/{id}")
    public Revenue getRevenueById(@PathVariable String id) {
        return revenueRepository.findById(id).orElseThrow(() -> new RuntimeException("Revenue not found"));
    }

    @PutMapping("/{id}")
    public Revenue updateRevenue(@PathVariable String id, @RequestBody Revenue revenueDetails) {
        Revenue revenue = revenueRepository.findById(id).orElseThrow(() -> new RuntimeException("Revenue not found"));
        revenue.setMonth(revenueDetails.getMonth());
        revenue.setRevenue(revenueDetails.getRevenue());
        return revenueRepository.save(revenue);
    }

    @DeleteMapping("/{id}")
    public void deleteRevenue(@PathVariable String id) {
        revenueRepository.deleteById(id);
    }
}