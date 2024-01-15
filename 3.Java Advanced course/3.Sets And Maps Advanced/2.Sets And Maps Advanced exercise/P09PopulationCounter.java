import java.util.*;
import java.util.stream.Collectors;

public class P09PopulationCounter {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Country> countries = new LinkedHashMap<>();
        String line = scanner.nextLine();

        while (!line.equals("report")) {

            String[] parts = line.split("\\|");

            String cityName = parts[0];
            String countryName = parts[1];
            int population = Integer.parseInt(parts[2]);

            if (!countries.containsKey(countryName)) {
                countries.put(countryName, new Country(countryName));
            }

            Country country = countries.get(countryName);
            country.cities.add(new City(cityName, population));
            country.totalPopulation += population;

            line = scanner.nextLine();
        }

        List<Country> sortedCountries = new ArrayList<>(countries.values());
        sortedCountries.sort(Comparator.comparing((Country c) -> c.totalPopulation).reversed());

        for (Country country : sortedCountries) {
            System.out.println(country.name + " (total population: " + country.totalPopulation + ")");

            country.sortCities();
            for (City city : country.cities) {
                System.out.println("=>" + city.name + ": " + city.population);
            }
        }
    }


}

class City {
    String name;
    int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }
}

class Country {
    String name;
    List<City> cities = new ArrayList<>();
    long totalPopulation;

    public Country(String name) {
        this.name = name;
        this.totalPopulation = 0;
    }

    public void sortCities() {
        this.cities = cities.stream()
                .sorted(Comparator.comparing((City c) -> c.population).reversed()).collect(Collectors.toList());

    }
}