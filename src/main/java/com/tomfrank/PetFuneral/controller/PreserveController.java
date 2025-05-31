package com.tomfrank.PetFuneral.controller;

import com.tomfrank.PetFuneral.dto.PreserveRequest;
import com.tomfrank.PetFuneral.service.PreserveService;
import com.tomfrank.PetFuneral.util.ResponseWrapper;
import io.jsonwebtoken.Claims;
import com.tomfrank.PetFuneral.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service")
@CrossOrigin(origins = "http://localhost:8080")
public class PreserveController {
    private final PreserveService preserveService;
    private final JwtUtil jwtUtil;

    @Autowired
    public PreserveController(PreserveService preserveService , JwtUtil jwtUtil){
        this.preserveService = preserveService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/preserve")
    public ResponseWrapper<Void> preserve(@RequestHeader("Authorization") String authHeader,
                                          @Validated @RequestBody PreserveRequest req){
        String token = authHeader.replace("Bearer ", "");
        Claims claims = jwtUtil.parseToken(token);
        Integer userId = Integer.valueOf(claims.getSubject());
        req.setUserId(userId);
        preserveService.preserve(req);
        return ResponseWrapper.ok();
    }
}
