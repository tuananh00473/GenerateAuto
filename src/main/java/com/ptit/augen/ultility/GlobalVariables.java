package com.ptit.augen.ultility;

import com.ptit.augen.model.Table;

import java.sql.Connection;
import java.util.ArrayList;

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
    public static ArrayList<Table> tables = null;

    public static String packageName = "";
    public static String projectName = "";
    public static String driver = "";
}
