package file_processing;


import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessing {

    Logger logger = Logger.getLogger(FileProcessing.class);


    public ArrayList<String> getInputWords(Resource resource) throws IOException{
        ArrayList<String> input_words_tab = new ArrayList();
        InputStream in = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String lineTest = null;
        while ((lineTest = reader.readLine()) != null) {
            input_words_tab.add(lineTest);
        }
        reader.close();
        return (input_words_tab);
    }

    public void showResourceData(ArrayList<String> list) throws IOException {
        //Je prefere l'utilisation du logger au System.out
        for(String string : list) {
            logger.info(string);
        }
    }

    public static ArrayList<String> compareWords(String[] banned_words, ArrayList<String> file_input) throws IOException
    {
        /*A Noter, on aurait pu enlever l'index 0, qui est le nom du fichier
        pour ne pas avoir a le considerer comme mot exclu
        */
        int i;
        boolean bool = false;
        ArrayList<String> result = new ArrayList<String>();
        for(String string : file_input) {
            bool = false;
            for(i = 0; i < banned_words.length; i++){
                if(string.equals(banned_words[i])){
                    bool = true;
                }
            }
            if(!bool) result.add(string);
        }
        return result;
    }



}
