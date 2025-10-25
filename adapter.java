import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java");

        Laptop laptop = new Laptop();

        TypeCDevice typeCDrive = new TypeCFlashDrive();
        TypeAFlashDrive typeADrive = new TypeAFlashDrive();

        TypeCDevice adaptedTypeADrive = new TypeAtoCAdapter(typeADrive);

        laptop.readFlashDrive(typeCDrive);
        laptop.readFlashDrive(adaptedTypeADrive);
    }
}

interface TypeCDevice{
    void readFlashDrive();
}


class TypeCFlashDrive implements TypeCDevice{
    @Override
    public void readFlashDrive(){
        System.out.println("Reading Type C Flash drive");
    }
}

interface TypeADevice{
    void readFlashDrive();
}

class TypeAFlashDrive implements TypeADevice{
    public void readFlashDrive(){
        System.out.println("Reading Type A Flash drive");
    }
}

class TypeAtoCAdapter implements TypeCDevice{

    private TypeADevice typeADevice;

    TypeAtoCAdapter(TypeADevice typeADevice){
        this.typeADevice = typeADevice;
    }

    @Override
    public void readFlashDrive(){
        System.out.println("Using Adapter to read Type-A drive via Type-C port...");
        typeADevice.readFlashDrive();
    }
}

class Laptop{
    public void readFlashDrive(TypeCDevice typeCDevice){
        System.out.println("Laptop starts reading a flash drive...");
        typeCDevice.readFlashDrive();
    }
}
