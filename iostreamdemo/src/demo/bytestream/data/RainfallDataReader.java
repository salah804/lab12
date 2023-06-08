package demo.bytestream.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class RainfallDataReader {
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin";

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            int stationCount = 0;
            int districtCount = 0;

            while (dataInputStream.available() > 0) {
                // Read station data
                int stationId = dataInputStream.readInt();
                String stationName = dataInputStream.readUTF();
                String districtName = dataInputStream.readUTF();

                double totalRainfall = 0.0;
                int count = 0;

                System.out.println("Station ID: " + stationId);
                System.out.println("Station Name: " + stationName);
                System.out.println("District Name: " + districtName);

                System.out.println("Rainfall Data:");
                for (int day = 1; day <= 6; day++) {
                    double rainfall = dataInputStream.readDouble();
                    System.out.println("Day " + day + ": " + rainfall + " mm");
                    totalRainfall += rainfall;
                    count++;
                }

                if (count > 0) {
                    double averageRainfall = totalRainfall / count;
                    System.out.println("Average Rainfall: " + averageRainfall + " mm");
                } else {
                    System.out.println("No data available.");
                }

                System.out.println("---------------------------------------");

                stationCount++;
                districtCount++;
            }

            System.out.println("Number of Stations: " + stationCount);
            System.out.println("Number of Districts: " + districtCount);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the rainfall data: " + e.getMessage());
        }
    }
}