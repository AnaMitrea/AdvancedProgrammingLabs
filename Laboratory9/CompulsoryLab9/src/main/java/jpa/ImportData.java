package jpa;

import entity.CitiesEntity;
import entity.CountriesEntity;
import repositories.CitiesEntityRepository;
import repositories.CountriesEntityRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ImportData {

    public List<CitiesEntity> citiesEntities=new LinkedList<>();

    /**
     * Method used to import data from a csv file into the Cities tables
     * @throws IOException  Exception
     */
    public void importDataCities() throws IOException {
        System.out.println("Importing data into cities table...");

        BufferedReader lineReader = new BufferedReader(new FileReader("C:\\Users\\Ana\\Desktop\\deImportat\\worldcities.csv"));
        String lineText;

        int id = 1;
        while ((lineText = lineReader.readLine()) != null) {
            List<String> data = Arrays.stream(lineText.split(",")).toList();

            String cityName = data.get(0);
            String latitude = data.get(1);
            String longitude = data.get(2);
            int idCountry = Integer.parseInt(data.get(3));
            String population = data.get(4);

            CitiesEntityRepository citiesEntityRepository = new CitiesEntityRepository();
            CitiesEntity citiesEntity = new CitiesEntity();
            citiesEntity.setId(id);
            citiesEntity.setName(cityName);
            citiesEntity.setLatitude(latitude);
            citiesEntity.setLongitude(longitude);
            citiesEntity.setIdCountry(idCountry);
            citiesEntity.setPopulation(population);

            citiesEntityRepository.create(citiesEntity);
            addToList(citiesEntity);

            id++;
        }
        lineReader.close();
        System.out.println("Finished importing data!");
    }

    /**
     * Method used to import data from a csv file into the Countries tables
     * @throws IOException  Exception
     */
    public void importDataCountries() throws IOException {
        System.out.println("Importing data into countries table...");

        BufferedReader lineReader = new BufferedReader(new FileReader("C:\\Users\\Ana\\Desktop\\deImportat\\worldcountries.csv"));
        String lineText;

        int id = 1;
        while ((lineText = lineReader.readLine()) != null) {
            List<String> data = Arrays.stream(lineText.split(",")).toList();

            String name = data.get(0);
            String code = data.get(1);
            int continentId = Integer.parseInt(data.get(2));

            CountriesEntityRepository countriesEntityRepository = new CountriesEntityRepository();
            CountriesEntity country = new CountriesEntity();
            country.setId(id);
            country.setName(name);
            country.setCode(code);
            country.setIdcontinent(continentId);

            countriesEntityRepository.create(country);
            id++;
        }
        lineReader.close();
        System.out.println("Finished importing data!");
    }

    public void addToList(CitiesEntity entity) {
      citiesEntities.add(entity);
    }

    public List<CitiesEntity> getCitiesEntities() {
        return citiesEntities;
    }
}
