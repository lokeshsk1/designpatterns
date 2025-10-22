class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java"); 
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.execute();
        DataProcessor apiProcessor = new APIProcessor();
        apiProcessor.execute();
    }
}

abstract class DataProcessor{

    public void execute(){
        readData();
        processData();
        writeData();
    }

    public abstract void readData();
    public abstract void processData();

    public void writeData(){
        System.out.println("Data written to database"); 
    }
}

class CSVProcessor extends DataProcessor{
    @Override
    public void readData(){
        System.out.println("Reading from CSV file"); 
    }

    @Override
    public void processData(){
        System.out.println("Processing the CSV file"); 
    }
}

class APIProcessor extends DataProcessor{
    @Override
    public void readData(){
        System.out.println("Reading from API data"); 
    }

    @Override
    public void processData(){
        System.out.println("Processing the API data"); 
    }

    @Override
    public void writeData(){
        System.out.println("Written the API data somewhere"); 
    }
}

