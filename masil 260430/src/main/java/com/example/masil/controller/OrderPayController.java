package com.example.masil.controller;

import com.example.masil.dto.OrderPayDTO;
import com.example.masil.entity.OrderPay;
import com.example.masil.entity.SiteUser;
import com.example.masil.service.OrderPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderPayController {
    private final OrderPayService orderPayService;


    @GetMapping("/orderPay/list")
    public String list(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/";
        }
        List<OrderPay> list = orderPayService.list(principal.getName());
        model.addAttribute("list", list);
        return "orderPay/list";
    }

    @GetMapping("/order/view/{id}")
    public String view(
            Model model,
            @PathVariable("id") Long id
    ) {
        OrderPay orderPay = orderPayService.view(id);
        model.addAttribute("orderPay", orderPay);
        return "orderPay/view";
    }

    @GetMapping("/orderPay/chuga")
    public String chuga(Model model) {
        return "orderPay/chuga";
    }

    @GetMapping("/orderPay/sujung/{id}")
    public String sujung(
            Model model,
            @PathVariable("id") Long id
    ) {
        OrderPay orderPay = orderPayService.view(id);
        model.addAttribute("orderPay", orderPay);
        return "orderPay/sujung";
    }

    @GetMapping("/orderPay/sakje/{id}")
    public String sakje(
            Model model,
            @PathVariable("id") Long id
    ) {
        OrderPay orderPay = orderPayService.view(id);
        model.addAttribute("orderPay", orderPay);
        return "orderPay/list";
    }


    @PostMapping("/orderPay/chugaProc")
    public String chugaProc(OrderPayDTO orderPayDTO){
        orderPayService.chugaProc(orderPayDTO, orderPayDTO.getSiteUserId());
        return  "redirect:/orderPay/list";

    }

@PostMapping("/orderPay/sujungProc")
public String sujungProc(OrderPayDTO orderPayDTO){
//    SiteUser siteUser = new SiteUser();
//    siteUser.setId(orderPayDTO.getSiteUserId());
    orderPayService.sujungProc(orderPayDTO, orderPayDTO.getSiteUserId());
    return  "redirect:/orderPay/view/"+ orderPayDTO.getId();

}

//@PostMapping("/orderPay/sakjeProc")
//public String sakjeProc(OrderPayDTO orderPayDTO){
//    SiteUser siteUser = new SiteUser();
//    siteUser.setId(orderPayDTO.getSiteUserId());
//    orderPayService.sakjeProc(orderPayDTO, siteUser);
//    return  "redirect:/orderPay/list/";
//}

    @PostMapping("/orderPay/sakjeProc")
    public String sakjeProc(OrderPayDTO orderPayDTO) { // 폼에서 넘어온 주문 ID(기본키)
        orderPayService.sakjeProc(orderPayDTO.getId());
        return "redirect:/orderPay/list";
    }

}
