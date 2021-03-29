package com.dictionary.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DictionaryRepositoryImpl implements DictionaryRepository{
    static TreeMap<String, String> vocabulary = new TreeMap<>();
    static List<String> listKeys = new ArrayList<>();
    static {
        vocabulary.put("no", "khong");
        vocabulary.put("hello", "Xin Chao");
        vocabulary.put("run", "Chay");
        vocabulary.put("go", "Di");
        vocabulary.put("slap", "Tat, danh");
        vocabulary.put("hug", "Om");
        vocabulary.put("love", "Yeu");
    }

    @Override
    public String translate(String input) {
        for (Map.Entry<String, String> entry : vocabulary.entrySet()){
            if (entry.getKey().equals(input)){
                return entry.getValue();
            }
        }
        return "";
    }

    @Override
    public List<String> getKey() {
        for (Map.Entry<String, String> entry : vocabulary.entrySet()){
            listKeys.add(entry.getKey());
        }
        return listKeys;
    }


}
