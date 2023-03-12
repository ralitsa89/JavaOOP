package P08ExerciseInterfacesAndAbstraction.P04FoodShortage;

public class Citizen implements Identifiable, Birthable, Person, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;


    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
}
