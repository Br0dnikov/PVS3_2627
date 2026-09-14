package Study_Brod.Parase;

public class Country {
    String name, continent;
    long population;
    double avgAge;

    public Country(String name, String continent, long population, double avgAge) {
        this.name = name;
        this.continent = continent;
        SetPopulation(population);
        SetAvgAge(avgAge);
    }

    public Country (String name, long population, double AvgAge){
        this.name = name;
        this.continent = "N/A";
        SetPopulation(population);
        SetAvgAge(avgAge);

    }

    public void SetAvgAge(double avgAge){
        if (avgAge >= 0 && avgAge<=100){
            this.avgAge = avgAge;
        }
        else {
            this.avgAge = 0.0d;
        }
    }

    public void SetPopulation(long Population){
        if (population >= 10_000 && avgAge<=2_000_000_000){
            this.population = population;
        }
        else {
            this.population = 0;
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", avgAge=" + avgAge +
                '}';
    }
}
