package com.ptit.augen.service;

import com.ptit.augen.model.Field;
import com.ptit.augen.model.Table;
import com.ptit.augen.ultility.Constants;
import com.ptit.augen.ultility.GlobalVariables;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: AnhNT
 * Date: 10/16/13
 * Time: 10:32 PM
 */
@Controller
@RequestMapping(value = "/")
public class DatabaseConnector
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Data(ModelMap model)
    {
        return "hello";
    }

    @RequestMapping(value = "/Connection/ConnectPostgres", params = {"provider", "servername", "databasename", "username", "password"}, method = RequestMethod.GET)
    public
    @ResponseBody
    String createConection(@RequestParam String provider, @RequestParam String servername, @RequestParam String databasename, @RequestParam String username, @RequestParam String password) throws JSONException
    {
        JSONObject connectionStatus = new JSONObject();
        try
        {
//            jdbc:postgresql://host:port/database
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:" + provider + "://" + servername + "/" + databasename;
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null)
            {
                connectionStatus.put("success", true);
                GlobalVariables.Status = Constants.ConnectionSuccess;
                GlobalVariables.UserID = username;
                GlobalVariables.Password = password;
                GlobalVariables.ProviderString = provider;
                GlobalVariables.ServerName = servername;
                GlobalVariables.ConnString = url;
                GlobalVariables.InitialCatalog = databasename;
                return connectionStatus.toString();
            }
        }
        catch (Exception e)
        {
        }
        connectionStatus.put("success", false);
        GlobalVariables.Status = Constants.ConnectionError;
        return connectionStatus.toString();
    }

    @RequestMapping(value = "/Connection/ViewCurrentConnection", method = RequestMethod.GET)
    public
    @ResponseBody
    String viewCurrentConnection()
    {
        if (GlobalVariables.Status == Constants.ConnectionEmpty)
        {
            return "Connection string is empty ! Plesae setup new connection !";
        }
        else if (GlobalVariables.Status == Constants.ConnectionError)
        {
            return "Connection error ! Plesae setup new connection !";
        }
        return GlobalVariables.ConnString;
    }

    @RequestMapping(value = "/Connection/LoadDatabase", method = RequestMethod.GET)
    public
    @ResponseBody
    String loadDatabase() throws JSONException, SQLException
    {
        JSONObject loadDatabaseResponse = new JSONObject();
        if (GlobalVariables.Status == Constants.ConnectionEmpty)
        {
            loadDatabaseResponse.put("status", "empty");
            loadDatabaseResponse.put("data", new ArrayList());
            return loadDatabaseResponse.toString();
        }
        if (GlobalVariables.Status == Constants.ConnectionError)
        {
            loadDatabaseResponse.put("status", "error");
            loadDatabaseResponse.put("data", new ArrayList());
            return loadDatabaseResponse.toString();
        }
        String url = "jdbc:" + GlobalVariables.ProviderString + "://" + GlobalVariables.ServerName + "/" + GlobalVariables.InitialCatalog;
        Connection connection = DriverManager.getConnection(url, GlobalVariables.UserID, GlobalVariables.Password);

        List<Table> tables = getTables(connection);
        GlobalVariables.FolderName = "/Temp";
        for (Table table : tables)
        {
            List<Field> listNormalFields = new ArrayList<Field>();
            List<Field> listFullFields = new ArrayList<Field>();
            for (Field field : table.getFields())
            {
                if (field.getIsKey() != true)
                {
                    listNormalFields.add(field);
                }
                listFullFields.add(field);
            }
        }

        loadDatabaseResponse.put("status", "success");
        loadDatabaseResponse.put("data", new ArrayList());
        return loadDatabaseResponse.toString();
    }

    public List<Table> getTables(Connection connection) throws SQLException
    {
        DatabaseMetaData dataBaseMetaData = connection.getMetaData();

        //productName
        String productName = dataBaseMetaData.getDatabaseProductName();
        System.out.println(productName);

        //productVersion
        String productVersion = dataBaseMetaData.getDatabaseProductVersion();
        System.out.println(productVersion);

        List<Table> metaTableList = new ArrayList<Table>();

        String[] types = {"TABLE"};
        ResultSet resultSetTable = dataBaseMetaData.getTables(null, null, "%", types);

        while (resultSetTable.next())
        {
            Table table = new Table();
            String tableName = resultSetTable.getString(3); // 1: none 2: schema 3: table name 4: table type (TABLE, VIEW)
            table.setTableName(tableName);

            String fieldPrimaryKeyName = null;
            ResultSet resultSetPrimaryKey = dataBaseMetaData.getPrimaryKeys("", "", tableName);
            while (resultSetPrimaryKey.next())
            {
                fieldPrimaryKeyName = resultSetPrimaryKey.getString("COLUMN_NAME");
            }

            ResultSet resultSetColumn = dataBaseMetaData.getColumns(null, null, tableName, "%");
            List<Field> fields = new ArrayList<Field>();
            while (resultSetColumn.next())
            {
                Field field = new Field();

//                System.out.println(resultSetColumn.getString(1));
//                System.out.println(resultSetColumn.getString(2));       // public
//                System.out.println(resultSetColumn.getString(3));      //  name table
//                System.out.println(resultSetColumn.getString(4));        // name field
//                System.out.println(resultSetColumn.getString(5));       //
//                System.out.println(resultSetColumn.getString(6));       // type field
//                System.out.println(resultSetColumn.getString(7));       // max size field
//                System.out.println(resultSetColumn.getString(8));
//                System.out.println(resultSetColumn.getString(9));
//                System.out.println(resultSetColumn.getString(10));
//                System.out.println(resultSetColumn.getString(11));
//                System.out.println(resultSetColumn.getString(12));
//                System.out.println(resultSetColumn.getString(13));
//                System.out.println(resultSetColumn.getString(14));
//                System.out.println(resultSetColumn.getString(15));
//                System.out.println("=============================");

                String columnName = resultSetColumn.getString(4);
                String columnType = resultSetColumn.getString(6);

                field.setFieldName(columnName);  // 1. none 2. .. 3. .. 4. column name 5. .. 6. type data
                field.setFieldType(columnType);
                setPrimaKeyField(field, columnName, fieldPrimaryKeyName);

                fields.add(field);
            }
            table.setFields(fields);
            metaTableList.add(table);
        }
        return metaTableList;
    }

    private void setPrimaKeyField(Field field, String columnName, String fieldPrimaryKeyName)
    {
        if (fieldPrimaryKeyName.equals(columnName))
        {
            field.setIsKey(true);
        }
        else
        {
            field.setIsKey(false);
        }
    }
}
