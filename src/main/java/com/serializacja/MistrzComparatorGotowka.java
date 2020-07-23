package com.serializacja;

import java.util.Comparator;

public class MistrzComparatorGotowka implements Comparator<Mistrz> {

    @Override
    public int compare(Mistrz o1, Mistrz o2) {
        return o2.getGotowka() - o1.getGotowka();
    }
}
