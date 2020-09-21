package main_package;


import dao.FileLoader;
import export.FileOutput;
import file_processing.FileProcessing;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BasicConfigurator.configure();
        Logger logger = Logger.getLogger(Main.class);

        FileLoader fileLoader = (FileLoader) context.getBean("customResourceLoader");
        FileProcessing fileProcessing = new FileProcessing();
        FileOutput fileOutput = new FileOutput();
        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();

        try {
            input = fileProcessing.getInputWords(fileLoader.getResource(args[0]));
            fileProcessing.showResourceData(input);
            output = fileProcessing.compareWords(args, input);
        }catch (IOException ioe){
            logger.error("Erreur de lecture fichier");
            logger.error(ioe.getMessage());
        }

        fileOutput.export(output);
    }
}
