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

    public static Logger getInstance(){

        if(logger == null){
            synchronized(Logger.class){
                if(logger == null){
                    logger = new Logger();
                }
                return logger;
            }
        }
        return logger;
    }

    public void printLogMessage(String LogMessage){
        System.out.println(LogMessage); 
    }
}

