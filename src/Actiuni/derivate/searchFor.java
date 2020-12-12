package Actiuni.derivate;

import Actiuni.Action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;


public class searchFor extends Action {
    /// nm -> name > dir path where files are
    /// pm -> param -> text we are searching for
    public searchFor(String nm, String pm) {
        super(nm, pm);
    }

    public List<String> getFilesFromFolder(final File folder) {
        List<String> files = new LinkedList<>();
        for (final File fileEntry : folder.listFiles()) {
            files.add(fileEntry.getPath());
        }
        return files;
    }

    public String readFile(String filePath) {
        StringBuilder textFile = new StringBuilder();
        try {
            BufferedReader objReader = new BufferedReader(new FileReader(filePath));
            String strCurrentLine;
            while ((strCurrentLine = objReader.readLine()) != null) {
                textFile.append(strCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFile.toString();
    }

    public List<String> getFilesThatContain(String text, List<String> files){
        List<String> outFiles = new LinkedList<>();
        for(String file : files){
            String textFile = this.readFile(file);
            if(textFile.contains(text)){
                outFiles.add(file);
            }
        }
        return outFiles;
    }



    public void _do(){
        File theDir = new File(this.name);
        List<String> files = this.getFilesFromFolder(theDir);
        List<String> chosenFiles = this.getFilesThatContain(this.param, files);
        for(String file : chosenFiles){
            System.out.println(file);
        }
    }
}
