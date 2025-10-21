class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java"); 
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.produceShape("circle");
        Shape shape2 = shapeFactory.produceShape("rectangle");

        shape1.draw();
        shape2.draw();
    }
}

interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Rectanglecle");
    }
}


class ShapeFactory{
    public Shape produceShape(String shapeName){
        if(shapeName == null){
            return null;
        }
        switch(shapeName){
            case "circle": return new Circle();
            case "rectangle": return new Rectangle();
            default: return null;
        }
    }
}

