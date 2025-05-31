package com.tomfrank.PetFuneral.service.impl;

import com.tomfrank.PetFuneral.dto.*;
import com.tomfrank.PetFuneral.entity.OrderService;
import com.tomfrank.PetFuneral.mapper.ServiceOrderMapper;
import com.tomfrank.PetFuneral.service.PreserveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

@Service
public class PreserveServiceImpl implements PreserveService{
    private final ServiceOrderMapper serviceOrderMapper;

    public PreserveServiceImpl(ServiceOrderMapper serviceOrderMapper)   {this.serviceOrderMapper = serviceOrderMapper;}

    @Override
    @Transactional
    public void preserve(PreserveRequest req){
        OrderService orderService = new OrderService();
        BeanUtils.copyProperties(req, orderService);
        serviceOrderMapper.insert(orderService);
    }
}
