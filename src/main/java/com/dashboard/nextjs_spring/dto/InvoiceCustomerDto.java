package com.dashboard.nextjs_spring.dto;

import lombok.Data;

@Data
public class InvoiceCustomerDto {
  private String amount;
  private String name;
  private String image_url;
  private String email;
  private String id;

  public InvoiceCustomerDto(String amount, String name, String image_url, String email, String id) {
      this.amount = amount;
      this.name = name;
      this.image_url = image_url;
      this.email = email;
      this.id = id;
  }
}