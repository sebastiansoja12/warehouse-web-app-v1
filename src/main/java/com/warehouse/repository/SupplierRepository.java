package com.warehouse.repository;

import com.warehouse.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Supplier findBySupplierCode(String supplierCode);

    void deleteBySupplierCode(String supplierCode);
}
