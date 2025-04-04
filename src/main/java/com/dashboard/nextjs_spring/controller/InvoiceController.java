package com.dashboard.nextjs_spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dashboard.nextjs_spring.dto.*;
import com.dashboard.nextjs_spring.entity.Invoice;
import com.dashboard.nextjs_spring.repository.InvoiceRepository;
import com.dashboard.nextjs_spring.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private InvoiceRepository invoiceRepository;
    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(
        InvoiceRepository invoiceRepository,
        InvoiceService invoiceService)
    {
        this.invoiceRepository = invoiceRepository;
        this.invoiceService = invoiceService;

    }    

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable String id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable String id, @RequestBody Invoice invoiceDetails) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoice.setCustomer_id(invoiceDetails.getCustomer_id());
        invoice.setAmount(invoiceDetails.getAmount());
        invoice.setStatus(invoiceDetails.getStatus());
        invoice.setDate(invoiceDetails.getDate());
        return invoiceRepository.save(invoice);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable String id) {
        invoiceRepository.deleteById(id);
    }

    @GetMapping("/latest")
    public List<InvoiceCustomerDto> getLatestInvoicesWithCustomerInfo() {
        return invoiceService.getLatestInvoicesWithCustomerInfo();
    }

    @GetMapping("/status")
    public List<InvoiceStatusDto> getInvoiceStatus() {
        return invoiceService.getInvoiceStatus();
    }

}