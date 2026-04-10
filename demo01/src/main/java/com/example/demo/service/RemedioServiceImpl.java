package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RemedioEntity;
import com.example.demo.interfaces.IRemedioService;
import com.example.demo.repository.RemedioRepository;

@Service
public class RemedioServiceImpl implements IRemedioService {

    @Autowired
    private RemedioRepository repository;

    @Override
    public List<RemedioEntity> findAll() {
        return (List<RemedioEntity>) repository.findAll();
    }

    @Override
    public RemedioEntity findById(Long id) {
        Optional<RemedioEntity> ope = repository.findById(id);
        return ope.orElse(null);
    }

    @Override
    public RemedioEntity save(RemedioEntity remedio) {
        return repository.save(remedio);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}