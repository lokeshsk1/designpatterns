class Main {
    public static void main(String[] args) {
        System.out.println("Hello World in Java"); 
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println(logger1 == logger2);
        logger1.printLogMessage("Singleton pattern in action!");
    }
}

class Logger{

    protected static volatile Logger logger;

    private Logger(){
        System.out.println("Logger initialized!");
    }

    public static class Holder{
        public static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance(){
        return Holder.INSTANCE;
    }

    public void printLogMessage(String LogMessage){
        System.out.println(LogMessage); 
    }
}
