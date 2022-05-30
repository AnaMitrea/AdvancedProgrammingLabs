package constraints;

import entity.CitiesEntity;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

public class ChocoSolver {

    public boolean constraintObjects(CitiesEntity city1, CitiesEntity city2 , int inf, int sup) {
        Model model = new Model("Choco Solver City Problem");

        int firstLetterCity1 = city1.getName().charAt(0);
        int firstLetterCity2 = city2.getName().charAt(0);
        IntVar letter1 = model.intVar("letter1", firstLetterCity1);
        IntVar letter2 = model.intVar("letter2", firstLetterCity2);
        model.arithm(letter1, "=", letter2).post(); // same first letter from name

        IntVar countryId1 = model.intVar("countryId1", city1.getIdCountry());
        IntVar countryId2 = model.intVar("countryId2", city2.getIdCountry());
        model.arithm(countryId1, "!=", countryId2).post();//different countries

        int population1 = Integer.parseInt(city1.getPopulation());
        int population2 = Integer.parseInt(city2.getPopulation());
        IntVar populationCity1 = model.intVar("populatonCity1", population1);
        IntVar populationCity2 = model.intVar("populatonCity2", population2);

        model.arithm(populationCity1, "+", populationCity2, ">", inf).post();
        model.arithm(populationCity1, "+", populationCity2, "<", sup).post();

        return model.getSolver().solve();
    }
}
