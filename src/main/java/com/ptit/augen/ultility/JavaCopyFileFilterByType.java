package com.ptit.augen.ultility;

import java.io.*;

/**
 * User: Admin
 * Date: 10/25/13
 * Time: 1:47 AM
 */
public class JavaCopyFileFilterByType
{
    private static FileTypeOrFolderFilter filter = null;

    public static void copy(final String fileType, String fromPath, String outputPath)
    {
        filter = new FileTypeOrFolderFilter(fileType);
        File currentFolder = new File(fromPath);
        JavaMakePath.makePath(outputPath);
        File outputFolder = new File(outputPath);
        scanFolder(currentFolder, outputFolder);
    }

    private static void scanFolder(File currentFolder, File outputFolder)
    {
        File[] files = currentFolder.listFiles(filter);
        for (File file : files)
        {
            if (file.isDirectory())
            {
                File outPut = new File(outputFolder + File.separator + file.getName());
                outPut.mkdir();
                scanFolder(file, outPut);
            }
            else
            {
                copy(file, outputFolder);
            }
        }
    }

    private static void copy(File file, File outputFolder)
    {
        try
        {
            InputStream input = new FileInputStream(file);
            OutputStream out = new FileOutputStream(outputFolder + File.separator + file.getName());
            byte data[] = new byte[input.available()];
            input.read(data);
            out.write(data);
            out.flush();
            out.close();
            input.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private static final class FileTypeOrFolderFilter implements FileFilter
    {
        private final String fileType;

        private FileTypeOrFolderFilter(String fileType)
        {
            this.fileType = fileType;
        }

        public boolean accept(File pathname)
        {
            return (null == fileType) || (pathname.getName().endsWith("." + fileType)) || (pathname.isDirectory());
        }
    }

    public static void copySingleFileWithOtherName(String fromPath, String outputPath, String fileName)
    {
        File inputFile = new File(fromPath);
        JavaMakePath.makePath(outputPath);
        File outputFile = new File(outputPath + File.separator + fileName);
        try
        {
            InputStream input = new FileInputStream(inputFile);
            OutputStream out = new FileOutputStream(outputFile);
            byte data[] = new byte[input.available()];
            input.read(data);
            out.write(data);
            out.flush();
            out.close();
            input.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
