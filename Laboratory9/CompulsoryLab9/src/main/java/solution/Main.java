package solution;
import constraints.ChocoSolver;
import entity.*;
import jpa.ImportData;
import managerfactory.EntityManager;
import repositories.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public List<CitiesEntity> citiesEntities = new LinkedList<>();

    public void importCities() throws IOException {
        long startTime = System.nanoTime();

        ImportData importingData = new ImportData();
        importingData.importDataCities();

        long stopTime = System.nanoTime();
        double elapsedTimeInSecond= (double) (stopTime - startTime) / 1_000_000_000;
        System.out.println("Took " + elapsedTimeInSecond + " seconds to import data into 'cities' table.");

        this.citiesEntities = importingData.getCitiesEntities();
    }

    public void importCountries() throws IOException {
        ImportData importingData = new ImportData();
        importingData.importDataCountries();
    }

    public List<CitiesEntity> findCities(int maximum, int inf, int sup) {
        List<CitiesEntity> citiesSet = new LinkedList<>();
        ChocoSolver cs = new ChocoSolver();

        Random rd = new Random();
        int generatedNr = rd.nextInt(maximum) + 1;

        CitiesEntity city = citiesEntities.get(generatedNr);
        citiesSet.add(city);

        for(int index = 0; index < maximum; index++) {
            if(!citiesSet.contains(citiesEntities.get(index))) {
                CitiesEntity city2 = citiesEntities.get(index);
                boolean check = cs.constraintObjects(city,city2,inf,sup);
                if(check){
                    citiesSet.add(city2);
                }
            }
        }

        return citiesSet;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        try {
            solution.importCountries();
            solution.importCities();

            CitiesEntityRepository cityRepo = new CitiesEntityRepository();
            System.out.println("Tokyo in 'cities' table? - " + cityRepo.existsByName("Tokyo"));
            System.out.println("ID 200 in 'cities' table? - " + cityRepo.existsById(200));

            CountriesEntityRepository countryRepo = new CountriesEntityRepository();
            System.out.println("Egypt in 'countries' table : " + countryRepo.findByName("Egypt"));
            System.out.println("ID 10 in 'countries' table : " + countryRepo.findById(10));

            ContinentsEntityRepository continentRepo = new ContinentsEntityRepository();
            System.out.println("Europe in 'continents' table? - " + continentRepo.existsByName("Europe"));
            System.out.println("ID 2 in 'continents' table? - " + continentRepo.existsById(2));

            System.out.println("\nCities list using Choco Solver:");
            List<CitiesEntity> foundCitiesList = solution.findCities(500, 10_000_000, 100_000_000);
            System.out.println(foundCitiesList);
        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            EntityManager.close();
        }
    }
}
