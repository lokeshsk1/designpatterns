import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java");
        Pizza plainPizza = new PlainPizza();
        Pizza cheesePizza = new CheeseDecorator(plainPizza);
        Pizza chickenCheesePizza = new ChickenDecorator(cheesePizza);

        System.out.println(plainPizza.getName() + " - Rs." + plainPizza.getCost());
        System.out.println(cheesePizza.getName() + " - Rs." + cheesePizza.getCost());
        System.out.println(chickenCheesePizza.getName() + " - Rs." + chickenCheesePizza.getCost());

    }
}

interface Pizza{
    int getCost();
    String getName();
}

class PlainPizza implements Pizza{

    @Override
    public int getCost(){
        return 300;
    }

    @Override
    public String getName(){
        return "Pizza";
    }

}

abstract class PizzaDecorator implements Pizza{

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int getCost(){
        return pizza.getCost();
    }

    @Override
    public String getName(){
        return pizza.getName();
    }
    
}

class CheeseDecorator extends PizzaDecorator{

    public CheeseDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public int getCost(){
        return super.getCost() + 50;
    }

    @Override
    public String getName(){
        return super.getName() + " with Cheese";
    }

}

class ChickenDecorator extends PizzaDecorator{

    public ChickenDecorator(Pizza pizza){
        super(pizza);
    }

    @Override
    public int getCost(){
        return super.getCost() + 60;
    }

    @Override
    public String getName(){
        return super.getName() + " with Chicken";
    }

}


