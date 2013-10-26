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
    public static String driver = "";
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

    public static String projectLocation = "";
    public static String projectName = "";
    public static String packageName = "";

    public static String TOMCAT_PATH_OUT_PUT_SERVER_ENTITY = "";
    public static String TOMCAT_PATH_OUT_PUT_SERVER_DAO = "";
    public static String TOMCAT_PATH_OUT_PUT_SERVER_BUSINESS = "";
    public static String TOMCAT_PATH_OUT_PUT_SERVER_BUSINESS_IMPL = "";
    public static String TOMCAT_PATH_OUT_PUT_SERVER_CONTROLLER = "";
    public static String TOMCAT_PATH_OUT_PUT_SERVER_PERSISTENCE = "";
    public static String TOMCAT_PATH_OUT_PUT_SERVER_POM = "";
    public static String TOMCAT_PATH_OUT_PUT_SERVER_SPRINGCONFIG = "";

    public static String PROJECT_OUTPUT = "";


    public static String GENERATE_APP = "";
    public static String GENERATE_JS = "";
    public static String GENERATE_CSS = "";
    public static String GENERATE_BITMAPS = "";
    public static String GENERATE_JSP_PAGES = "";
}
