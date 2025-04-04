package com.dashboard.nextjs_spring.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.nextjs_spring.dto.InvoiceCustomerDto;
import com.dashboard.nextjs_spring.dto.InvoiceStatusDto;
import com.dashboard.nextjs_spring.repository.InvoiceRepository;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService (InvoiceRepository invoiceRepository) {
      this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceCustomerDto> getLatestInvoicesWithCustomerInfo() {
        // リポジトリからネイティブSQLの結果を取得
        List<Object[]> results = invoiceRepository.findLatestInvoicesWithCustomerInfo();

        // Object[] を DTO に変換
        return results.stream()
                .map(result -> new InvoiceCustomerDto(
                        (String) result[0],  // amount
                        (String) result[1],  // name
                        (String) result[2],  // image_url
                        (String) result[3],  // email
                        (String) result[4]   // id
                ))
                .collect(Collectors.toList());
    }

    public List<InvoiceStatusDto> getInvoiceStatus() {
      // リポジトリからネイティブSQLの結果を取得
      List<Object[]> results = invoiceRepository.findInvoiceStatus();
      // Object[] を DTO に変換
      return results.stream()
              .map(result -> new InvoiceStatusDto(
                      ((BigDecimal) result[0]).toString(),  // paid
                      ((BigDecimal) result[1]).toString()   // pending
              ))
              .collect(Collectors.toList());
    }
 
}
