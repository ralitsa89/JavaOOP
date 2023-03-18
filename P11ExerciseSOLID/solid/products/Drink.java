package P11ExerciseSOLID.solid.products;

public abstract class Drink {
    private final double density;
    private final double milliliters;

    protected Drink(double density, double milliliters) {
        this.density = density;
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    public double getDensity() {
        return density;
    }

    double getDrinkAmountInLiters(){
        return (1000 / this.getMilliliters()) * this.getDensity();
    }
}
