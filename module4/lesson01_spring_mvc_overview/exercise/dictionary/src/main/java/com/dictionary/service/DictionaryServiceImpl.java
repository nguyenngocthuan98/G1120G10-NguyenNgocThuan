package com.dictionary.service;

import com.dictionary.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Override
    public String translate(String input) {
        return this.dictionaryRepository.translate(input);
    }

    @Override
    public List<String> getAllKey() {
        return this.dictionaryRepository.getAllKey();
    }
}
