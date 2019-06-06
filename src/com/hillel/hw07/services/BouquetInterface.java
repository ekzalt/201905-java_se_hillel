package com.hillel.hw07.services;

import com.hillel.hw07.beans.Flower;
import com.hillel.hw07.exceptions.BouquetException;
import com.hillel.hw07.beans.Accessory;

public interface BouquetInterface {
    void addFlower(Flower flower);
    void addAccessory(Accessory accessory);

    int calculateCost();

    Flower[] sortByFresh();
    Flower[] findByTallRange(int min, int max) throws BouquetException;
}
