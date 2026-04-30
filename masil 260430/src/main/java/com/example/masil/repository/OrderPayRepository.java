package com.example.masil.repository;

import com.example.masil.entity.OrderPay;
import com.example.masil.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderPayRepository extends JpaRepository<OrderPay, Long> {
    List<OrderPay> findBySiteUser(SiteUser siteUser);
}