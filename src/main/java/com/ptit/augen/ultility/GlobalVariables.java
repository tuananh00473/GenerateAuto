package com.ptit.augen.ultility;

import com.ptit.augen.model.Field;

import java.sql.Connection;
import java.util.List;

/**
 * User: AnhNT
 * Date: 10/16/13
 * Time: 7:53 PM
 */
public class GlobalVariables
{
    public static String CurrentDataModel = "";
    public static String CurrentDatabaseType = "";
    public static String ProviderString = "";
    public static String Password = "";
    public static String UserID = "";
    public static String ServerName = "";
    public static String InitialCatalog = "";
    public static String ConnString = "";
    public static int Status = Constants.ConnectionEmpty;
    public static String FolderName = "";
    public static Connection connection = null;
    public static List<Field> listNormalFields = null;
    public static List<Field> listFullFields = null;

}
