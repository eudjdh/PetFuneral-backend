package com.tomfrank.PetFuneral.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tomfrank.PetFuneral.dto.*;
import com.tomfrank.PetFuneral.entity.Product;
import com.tomfrank.PetFuneral.exception.BusinessException;
import com.tomfrank.PetFuneral.mapper.ProductMapper;
import com.tomfrank.PetFuneral.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

@Service
public class ShopServiceImpl implements ShopService {
    private final ProductMapper productMapper;

    public ShopServiceImpl(ProductMapper productMapper){
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public void buy(BuyRequest req){
        // 查询对应商品
        Product product = productMapper.selectById(req.getProductId());
        // 检查库存
        Integer stock = product.getStock();
        if (stock == null || stock <= 0) {
            throw new BusinessException("库存不足，无法购买");
        }
        // 库存减一并更新
        product.setStock(stock - 1);
        int updated = productMapper.updateById(product);
        if (updated == 0) {
            throw new BusinessException("购买失败，请重试");
        }
    }

    @Override
    public int query(QueryRequest req){
        Product product = productMapper.selectById(req.getProductId());
        return product.getStock();
    }
}
