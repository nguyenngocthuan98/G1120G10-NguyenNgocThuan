package com.dictionary.repository;

import java.util.List;

public interface DictionaryRepository {
    String translate (String input);
    List<String> getAllKey();
}
