package com.ptit.augen.ultility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;

/**
 * User: Anhnt
 * Date: 9/20/13
 * Time: 1:09 AM
 */

public class WriteFileJava
{

    public static void WritToFile(String path, String fileName, String content)
    {
        try
        {
            makePath(path);
            FileWriter fstream = new FileWriter(path + fileName);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(content);
            out.close();
        }
        catch (Exception e)
        {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void makePath(String path)
    {
        String regex = Matcher.quoteReplacement("\\");
        String[] subPath = path.split(regex);
        String prePath = subPath[0] + regex;
        for (int i = 1; i < subPath.length; i++)
        {
            prePath = prePath.concat(subPath[i] + regex);
            File file = new File(prePath);
            file.mkdir();
        }
    }
}
