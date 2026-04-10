package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.RemedioEntity;

public interface IRemedioService {

    public List<RemedioEntity> findAll();

    public RemedioEntity findById(Long id);

    public RemedioEntity save(RemedioEntity remedio);

    public void deleteById(long id);
}