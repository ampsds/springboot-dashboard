package com.dashboard.nextjs_spring.dto;

import lombok.Data;

@Data
public class InvoiceStatusDto {
  String paid;
  String pending;

  public InvoiceStatusDto(String paid, String pending) {
    this.paid = paid;
    this.pending = pending;
  }
}
