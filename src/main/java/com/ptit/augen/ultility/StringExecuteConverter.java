package com.ptit.augen.ultility;

import java.util.regex.Matcher;

/**
 * User: Anhnt
 * Date: 9/20/13
 * Time: 1:09 AM
 */
public class StringExecuteConverter
{
    public static String convertToUpperCaseFirstCharacter(String inputString)
    {
        char[] stringArray = inputString.toCharArray();
        stringArray[0] = Character.toUpperCase(stringArray[0]);
        String outputString = new String(stringArray);
        return outputString;
    }

    public static String convertFromPackageToDirection(String packageString)
    {
        String stringConverted = packageString.replaceAll(Matcher.quoteReplacement("."), Matcher.quoteReplacement("\\"));
        return stringConverted;
    }

    public static String convertFromDirectionToPackage(String directionString)
    {
        String stringConverted = directionString.replaceAll(Matcher.quoteReplacement("\\"), Matcher.quoteReplacement("."));
        return stringConverted;
    }

    public static String convertTypeOfDataToJavaType(String typeDataInput)
    {
        if (compare(typeDataInput, "INT") || compare(typeDataInput, "numeric"))
        {
            return "int";
        }
        if (compare(typeDataInput, "VARCHAR") || compare(typeDataInput, "TEXT") || compare(typeDataInput, "bpchar"))
        {
            return "String";
        }
        if (compare(typeDataInput, "BIGINT") || compare(typeDataInput, "int8") || compare(typeDataInput, "bigserial") || compare(typeDataInput, "int4") || compare(typeDataInput, "long"))
        {
            return "Long";
        }
        if (compare(typeDataInput, "BOOLEAN") || compare(typeDataInput, "bool"))
        {
            return "boolean";
        }
        if (compare(typeDataInput, "DOUBLE"))
        {
            return "double";
        }
        if (compare(typeDataInput, "DATE") || compare(typeDataInput, "DATETIME") || compare(typeDataInput, "timestamp") || compare(typeDataInput, "timestamptz"))
        {
            return "Date";
        }
        return typeDataInput;
    }

    public static String convertTypeOfDataToExtentionJSType(String typeDataInput)
    {
        if (compare(typeDataInput, "INT") || compare(typeDataInput, "numeric"))
        {
            return "int";
        }
        if (compare(typeDataInput, "VARCHAR") || compare(typeDataInput, "TEXT") || compare(typeDataInput, "bpchar"))
        {
            return "string";
        }
        if (compare(typeDataInput, "BIGINT") || compare(typeDataInput, "int8") || compare(typeDataInput, "bigserial") || compare(typeDataInput, "int4") || compare(typeDataInput, "long"))
        {
            return "auto";
        }
        if (compare(typeDataInput, "BOOLEAN") || compare(typeDataInput, "bool"))
        {
            return "boolean";
        }
        if (compare(typeDataInput, "DOUBLE"))
        {
            return "double";
        }
        if (compare(typeDataInput, "DATE") || compare(typeDataInput, "DATETIME") || compare(typeDataInput, "timestamp") || compare(typeDataInput, "timestamptz"))
        {
            return "date";
        }
        return typeDataInput;
    }

    public static boolean compare(String string, String otherString)
    {
        return string.toLowerCase().equals(otherString.toLowerCase());
    }
}
