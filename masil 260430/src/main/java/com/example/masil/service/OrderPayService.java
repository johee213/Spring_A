package com.example.masil.service;


import com.example.masil.dto.OrderPayDTO;
import com.example.masil.entity.OrderPay;

import com.example.masil.entity.SiteUser;

import com.example.masil.repository.OrderPayRepository;

import com.example.masil.repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderPayService {
    private final OrderPayRepository orderPayRepository;
    private final SiteUserRepository siteUserRepository;

    public List<OrderPay> list(String username) {

        SiteUser user = siteUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));


        return orderPayRepository.findBySiteUser(user);
    }

    public OrderPay view(long id){
        OrderPay orderPay = null;
        Optional<OrderPay> op = orderPayRepository.findById(id);
        if(op.isPresent()){
            orderPay = op.get();
        }
        return orderPay;
    }

    public void chugaProc(OrderPayDTO orderPayDTO, Long siteUserId) {
        SiteUser siteUser = siteUserRepository.findById(siteUserId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다. ID: " + siteUserId));

        orderPayRepository.save(createEntity(orderPayDTO, siteUser));
    }


    public void sujungProc(OrderPayDTO orderPayDTO, Long siteUserId) {
        SiteUser siteUser = siteUserRepository.findById(siteUserId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        orderPayRepository.save(createEntity(orderPayDTO, siteUser));
    }


    public void sakjeProc(Long id){
//        siteUser.setId(orderPayDTO.getId());
//        orderPayRepository.delete(createEntity(orderPayDTO, siteUser));
//        orderPayRepository.deleteById(orderPayDTO.getId());
        orderPayRepository.deleteById(id);
    }


    private OrderPay createEntity(OrderPayDTO orderPayDTO, SiteUser siteUser){
        OrderPay orderPay = new OrderPay();
        orderPay.setId(orderPayDTO.getId());
        orderPay.setCategory(orderPayDTO.getCategory());
        orderPay.setPrice(orderPayDTO.getPrice());
        orderPay.setPayday(LocalDateTime.now());
        orderPay.setSiteUser(siteUser);
        return orderPay;
    }


}
