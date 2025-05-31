package com.tomfrank.PetFuneral.service;

import com.tomfrank.PetFuneral.dto.*;
import org.springframework.stereotype.Service;

@Service
public interface PreserveService {
    void preserve(PreserveRequest req);
}
