import java.io.IOException;
import java.util.logging.*;

public class ZooLogger {

    private static Handler handler;
    private static Logger logger;


    /**
     * Singleton
     */
    private ZooLogger(){}

    public static Logger getLogger(){
        try{
            if (logger == null){
                logger = Logger.getLogger(ZooLogger.class.getName());
                handler = new FileHandler("log.txt", true);
                //Formats logfile to readable text
                handler.setFormatter(new SimpleFormatter());
                //Decides how much the logger should log (All, some, etc)
                handler.setLevel(Level.ALL);
                logger.addHandler(handler);
                logger.setLevel(Level.ALL);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return logger;
    }

    public static void closeHandler(){handler.close();}
}
