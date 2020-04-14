package tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {
    public static void main(String args[])
    {
  
        	try {
        		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/data/populationdedebut.png")));
        		// normalement si le fichier n'existe pas, il est crée à la racine du projet
        		writer.close();
        		}
        		catch (IOException e)
        		{
        		e.printStackTrace();
        		}
    }
}
