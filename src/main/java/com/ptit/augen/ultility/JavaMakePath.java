package com.ptit.augen.ultility;

import java.io.File;
import java.util.regex.Matcher;

/**
 * User: Admin
 * Date: 10/25/13
 * Time: 1:02 AM
 */
public class JavaMakePath
{
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
