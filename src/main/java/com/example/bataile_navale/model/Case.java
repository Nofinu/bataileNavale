package com.example.bataile_navale.model;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Data
public class Case {
    private int x;
    private int y;
    private boolean isBoat;
    private boolean isDiscover;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return isBoat() == aCase.isBoat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBoat());
    }
}
