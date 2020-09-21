package export;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service("fileOutput")
public class FileOutput {

    private String name;
    private Path path = Paths.get("src/main/resources/file_output.txt");
    Logger logger = Logger.getLogger(FileOutput.class);

    boolean doesFileExist = Files.exists(path, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS });

    //On verifie la presence du fichier ou non.
    public void export(ArrayList<String> file_output) {
        if (doesFileExist){
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){
                for(String string : file_output){
                    writer.write(string);
                    writer.newLine();
                }
            } catch (IOException ioe) {
                logger.error("Erreur d'ecriture fichier deja cree");
                logger.error(ioe.getMessage());
            }
        } else {
            try{
                FileWriter writer = new FileWriter(path.toString());
                for(String string : file_output){
                    writer.write(string);
                    writer.write("\n");
                }
                writer.close();
            }catch (IOException ioe){
                logger.error("Erreur d'ecriture fichier non cree");
                logger.error(ioe.getMessage());
            }
        }
    }
}