package P07InterfacesAndAbstraction.P02CarShopExtended;

public class Audi extends CarImpl implements Rentable{
    private Integer minRentPerDay;
    private Double minPricePerDay;
    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentPerDay, Double minPricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentPerDay = minRentPerDay;
        this.minPricePerDay = minPricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentPerDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.minPricePerDay;
    }
}
