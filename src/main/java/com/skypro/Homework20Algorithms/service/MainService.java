package com.skypro.Homework20Algorithms.service;

import com.skypro.Homework20Algorithms.stringList.StringList;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final StringList stringList;

    public MainService(StringList stringList) {
        this.stringList = stringList;
    }

    public String[] add(String str) {
        stringList.add(str);
        return stringList.toArray();
    }
    public String[] remove(Integer num) {
        stringList.remove(1);
        return stringList.toArray();
    }
    public String[] set(Integer num, String newStr) {
      stringList.set(num, newStr);
      return stringList.toArray();
    }
}
