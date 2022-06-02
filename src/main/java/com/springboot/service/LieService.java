package com.springboot.service;

import com.springboot.model.Lie;

import java.util.List;

public interface LieService {
    Lie saveLie(Lie lie);
    void deleteLie(long id);
    Lie getLie(long id);
    List<Lie> getAllLies();
}
