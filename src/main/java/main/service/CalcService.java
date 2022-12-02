package main.service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int sumInts(int x, int y) {
        return x + y;
    }
}
