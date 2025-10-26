import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        System.out.println("Hello World in Java");
        Car original = new Car("Hyndai", "i20", "petrol", 5);
        original.display();

        Car cloneCar = original.clone();
        cloneCar.setFuelType("diesel");
        cloneCar.setSeatCount(6);
        cloneCar.display();

    }
}

class Car implements Cloneable{

    private String brand;
    private String model;
    private String fuelType;
    private int seatCount;
    
    public Car(String brand, String model, String fuelType, int seatCount){
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.seatCount = seatCount;
    } 

    public void setFuelType(String fuelType){
        this.fuelType = fuelType;
    }

    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    public void display(){
        System.out.println(this.brand + " " + this.model + " with Fuel Type " + this.fuelType + " and " + this.seatCount + " seats");
    }

    @Override
    public Car clone() throws CloneNotSupportedException{
        return (Car)super.clone();
    }

}

