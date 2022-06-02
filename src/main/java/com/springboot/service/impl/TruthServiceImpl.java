package com.springboot.service.impl;

import com.springboot.model.Truth;
import com.springboot.repository.TruthRepository;
import com.springboot.service.TruthService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruthServiceImpl implements TruthService {
    private TruthRepository truthRepository;

    public TruthServiceImpl(TruthRepository truthRepository) {
        this.truthRepository = truthRepository;
    }

    @Override
    public Truth saveTruth(Truth truth) {
        return truthRepository.save(truth);
    }

    @Override
    public void deleteTruth(long id) {
        truthRepository.delete(getTruth(id));
    }

    @Override
    public Truth getTruth(long id) {
        return truthRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Truth> getAllTruths() {
        return truthRepository.findAll();
    }
}
