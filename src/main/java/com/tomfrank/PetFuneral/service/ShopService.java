package com.tomfrank.PetFuneral.service;

import com.tomfrank.PetFuneral.dto.*;

public interface ShopService {
    void buy(BuyRequest req);

    int query(QueryRequest req);
}
