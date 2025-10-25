import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java");
        User user1 = new User.Builder("Lokesh", 24).address("Chennai").pincode("603202").build();
        user1.displayInfo();

        User user2 = new User.Builder("Akash", 25).build();
        user2.displayInfo();

    }
}

class User{

    private final String name;
    private final int age;
    private final String address;
    private final String pincode;

    private User(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.pincode = builder.pincode;
    }

    public void displayInfo() {
        System.out.println("------User Info--------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Pincode: " + pincode);
    }


    public static class Builder{

        private final String name;
        private final int age;
        private String address = "NA";
        private String pincode = "NA";

        public Builder(String name, int age){
            this.name = name;
            this.age = age;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder pincode(String pincode){
            this.pincode = pincode;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
