package com.ptit.augen.ultility;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * User: Anhnt
 * Date: 9/20/13
 * Time: 1:09 AM
 */

public class JavaWriteFile
{

    public static void WritToFile(String path, String fileName, String content)
    {
        try
        {
            JavaMakePath.makePath(path);
            FileWriter fileWriter = new FileWriter(path + fileName);
            BufferedWriter out = new BufferedWriter(fileWriter);
            out.write(content);
            out.close();
            fileWriter.close();
        }
        catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
