package com.springboot.service.impl;

import com.springboot.model.Lie;
import com.springboot.repository.LieRepository;
import com.springboot.service.LieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LieServiceImpl implements LieService {
    private LieRepository lieRepository;

    public LieServiceImpl(LieRepository lieRepository) {
        this.lieRepository = lieRepository;
    }

    @Override
    public Lie saveLie(Lie lie) {
        return lieRepository.save(lie);
    }

    @Override
    public void deleteLie(long id) {
        lieRepository.delete(getLie(id));
    }

    @Override
    public Lie getLie(long id) {
        return lieRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Lie> getAllLies() {
        return lieRepository.findAll();
    }
}
