package com.springboot.service;

import com.springboot.model.Truth;

import java.util.List;

public interface TruthService {
    Truth saveTruth(Truth truth);
    void deleteTruth(long id);
    Truth getTruth(long id);
    List<Truth> getAllTruths();
}
