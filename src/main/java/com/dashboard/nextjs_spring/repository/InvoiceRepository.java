package com.dashboard.nextjs_spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dashboard.nextjs_spring.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

  // Invoiceの直近5つを取得
  @Query(value = "SELECT i.amount, c.name, c.image_url, c.email, i.id " +
                  "FROM invoices i " +
                  "JOIN customers c ON i.customer_id::uuid = c.id::uuid " +
                  "ORDER BY i.date DESC " +
                  "LIMIT 5", nativeQuery = true)
  List<Object[]> findLatestInvoicesWithCustomerInfo();

  // 請求書のステータスごとの数を取得
  @Query(value = """
                SELECT 
                SUM(CASE WHEN status = 'paid' THEN amount::numeric ELSE 0::numeric END) AS "paid",
                SUM(CASE WHEN status = 'pending' THEN amount::numeric ELSE 0::numeric END) AS "pending"
                FROM invoices
          """, nativeQuery = true)
  List<Object[]> findInvoiceStatus();

}