package com.hillel.hw10;

import java.util.ArrayList;

import com.hillel.hw06.park.TaxiPark;
import com.hillel.hw06.vehicle.IVehicle;

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
        ArrayList<IVehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            vehicles.add(factory.create(fs.split(lines[i], argumentSeparator)));
        }

        park.setCars(vehicles);
        vehicles = park.sort((IVehicle o1, IVehicle o2) -> {
            if (o1.getFuel() > o2.getFuel()) {
                return 1;
            } else if (o1.getFuel() < o2.getFuel()) {
                return -1;
            } else {
                return 0;
            }
        });

        for (int i = 0; i < lines.length; i++) {
            lines[i] = vehicles.get(i).toString();
        }

        fs.writeFile(outputFilePath, String.join(lineDelimiter, lines));
    }
}
