package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.RemedioEntity;
import com.example.demo.interfaces.IRemedioService;

@Service
public class RemedioServiceImpl implements IRemedioService {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:6789/api/v1/entities/remedio";

    @Override
    public List<RemedioEntity> findAll() {
        RemedioEntity[] response = restTemplate.getForObject(URL + "/", RemedioEntity[].class);
        return Arrays.asList(response);
    }

    @Override
    public RemedioEntity findById(Long id) {
        return restTemplate.getForObject(URL + "/" + id, RemedioEntity.class);
    }

    @Override
    public RemedioEntity save(RemedioEntity remedio) {
        return restTemplate.postForObject(URL + "/", remedio, RemedioEntity.class);
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(URL + "/" + id);
    }
}