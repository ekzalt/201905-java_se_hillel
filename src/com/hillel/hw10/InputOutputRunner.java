package com.hillel.hw10;

import com.hillel.hw06.park.TaxiPark;
import com.hillel.hw06.vehicle.IVehicle;

import java.util.Arrays;

public class InputOutputRunner {
    public void run() {
        String lineDelimiter = "\r\n";
        String argumentSeparator = ",";
        String inputFilePath = "input_cars.txt";
        String outputFilePath = "output_cars.txt";

        FileService fs = new FileService();
        VehicleFactory factory = new VehicleFactory();
        TaxiPark park = new TaxiPark();

        String text = fs.readFile(inputFilePath);
        String[] lines = fs.split(text, ";" + lineDelimiter);
        IVehicle[] vehicles = new IVehicle[lines.length];

        for (int i = 0; i < lines.length; i++) {
            vehicles[i] = factory.create(fs.split(lines[i], argumentSeparator));
        }

        park.setCars(vehicles);
        vehicles = park.sortByFuel();

        for (int i = 0; i < lines.length; i++) {
            lines[i] = vehicles[i].toString();
        }

        fs.writeFile(outputFilePath, String.join(lineDelimiter, lines));
    }
}
