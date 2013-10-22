package com.ptit.augen.service;

import com.ptit.augen.model.Field;
import com.ptit.augen.model.JsonResult;
import com.ptit.augen.model.Table;
import com.ptit.augen.ultility.Constants;
import com.ptit.augen.ultility.GlobalVariables;
import com.ptit.augen.ultility.StringExecuteConverter;
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

    @RequestMapping(value = "/Connection/ConnectPostgres", params = {"PostgresProviderNameId", "PostgresNameId", "PostgresInitialCatalogId", "PostgresUserNameId", "PostgresPasswordId"}, method = RequestMethod.POST)
    public
    @ResponseBody
    String createConection(@RequestParam String PostgresProviderNameId, @RequestParam String PostgresNameId, @RequestParam String PostgresInitialCatalogId, @RequestParam String PostgresUserNameId, @RequestParam String PostgresPasswordId) throws JSONException
    {
        JSONObject connectionStatus = new JSONObject();
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = PostgresProviderNameId + "://" + PostgresNameId + "/" + PostgresInitialCatalogId;
            Connection connection = DriverManager.getConnection(url, PostgresUserNameId, PostgresPasswordId);
            if (connection != null)
            {
                connectionStatus.put("success", true);
                GlobalVariables.Status = Constants.ConnectionSuccess;
                GlobalVariables.UserID = PostgresUserNameId;
                GlobalVariables.Password = PostgresPasswordId;
                GlobalVariables.ProviderString = PostgresProviderNameId;
                GlobalVariables.ServerName = PostgresNameId;
                GlobalVariables.ConnString = url;
                GlobalVariables.InitialCatalog = PostgresInitialCatalogId;
                GlobalVariables.connection = connection;
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
    JsonResult loadDatabase() throws JSONException, SQLException
    {
        JsonResult jsonResult = new JsonResult();
        if (GlobalVariables.Status == Constants.ConnectionEmpty)
        {
            jsonResult.setStatus("empty");
            jsonResult.setData(new ArrayList());
            return jsonResult;
        }
        if (GlobalVariables.Status == Constants.ConnectionError)
        {
            jsonResult.setStatus("error");
            jsonResult.setData(new ArrayList());
            return jsonResult;
        }
        Connection connection = GlobalVariables.connection;

        ArrayList<Table> tables = getTables(connection);
        GlobalVariables.FolderName = "/Temp";
        for (Table table : tables)
        {
            ArrayList<Field> listNormalFields = new ArrayList<Field>();
            ArrayList<Field> listFullFields = new ArrayList<Field>();
            for (Field field : table.getFields())
            {
                if (field.getIsKey() != true)
                {
                    listNormalFields.add(field);
                }
                listFullFields.add(field);
            }
            StringTemplateService.generateModel(table.getTableName(), listFullFields);
            StringTemplateService.generateStore(table.getTableName());
            StringTemplateService.generateController(table.getTableName(), listFullFields);
            StringTemplateService.generateScreenList(table.getTableName(), listNormalFields);
            StringTemplateService.generateScreenAdd(table.getTableName(), listNormalFields);
            StringTemplateService.generateScreenEdit(table.getTableName(), listNormalFields);

            StringTemplateService.generateServerModel(table.getTableName(), listFullFields);
            StringTemplateService.generateServerDAO(table.getTableName(), listNormalFields);
            StringTemplateService.generateServerController(table.getTableName(), listFullFields);
        }

        jsonResult.setStatus("success");
        jsonResult.setData(tables);
        return jsonResult;
    }

    public ArrayList<Table> getTables(Connection connection) throws SQLException
    {
        DatabaseMetaData dataBaseMetaData = connection.getMetaData();

        //productName
        String productName = dataBaseMetaData.getDatabaseProductName();
        System.out.println(productName);

        //productVersion
        String productVersion = dataBaseMetaData.getDatabaseProductVersion();
        System.out.println(productVersion);

        ArrayList<Table> metaTableList = new ArrayList<Table>();

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
            ArrayList<Field> fields = new ArrayList<Field>();
            while (resultSetColumn.next())
            {
                Field field = new Field();

                String columnName = resultSetColumn.getString(4);
                String columnType = resultSetColumn.getString(6);

                field.setFieldName(columnName);  // 1. none 2. .. 3. .. 4. column name 5. .. 6. type data
                field.setFieldType(StringExecuteConverter.convertTypeOfDataToExtentionJSType(columnType));
                field.setServerFieldType(StringExecuteConverter.convertTypeOfDataToJavaType(columnType));
                field.setIsKey(checkPrimaryKey(columnName, fieldPrimaryKeyName));

                field.setIsInt(false);
                field.setIsLong(false);
                field.setIsBoolean(false);
                field.setIsFloat(false);
                field.setIsString(false);

                if (field.getFieldType().equals("int"))
                {
                    field.setIsInt(true);
                }
                else if (field.getFieldType().equals("auto"))
                {
                    field.setIsLong(true);
                }
                else if (field.getFieldType().equals("boolean"))
                {
                    field.setIsBoolean(true);
                }
                else if (field.getFieldType().equals("double"))
                {
                    field.setIsFloat(true);
                }
                else if (field.getFieldType().equals("string"))
                {
                    field.setIsString(true);
                }

                if (!field.getFieldName().isEmpty() && !field.getIsKey())
                {
                    field.setLabelName(field.getFieldName());
                    field.setFieldWidth("500");
                    field.setFieldHeight("28");
                    field.setItemType(Constants.DATA_FIELD_TYPE.get(0));
                    field.setAllowBlank("false");
                    field.setAllowBlankBoolean(false);
                    field.setIsHTMLEditor(false);
                    field.setHasSearch(false);
                    field.setSearchType("");
                }
                fields.add(field);
            }
            table.setFields(fields);
            metaTableList.add(table);
        }
        return metaTableList;
    }

    private boolean checkPrimaryKey(String columnName, String fieldPrimaryKeyName)
    {
        if (fieldPrimaryKeyName.equals(columnName))
        {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/Connection/GetListFieldByTable", params = {"TableName"}, method = RequestMethod.GET)
    public
    @ResponseBody
    JsonResult getListFieldByTable(@RequestParam String TableName) throws SQLException, JSONException
    {
        JsonResult jsonResult = new JsonResult();
        Connection connection = GlobalVariables.connection;
        DatabaseMetaData dataBaseMetaData = connection.getMetaData();
        String fieldPrimaryKeyName = null;
        ResultSet resultSetPrimaryKey = dataBaseMetaData.getPrimaryKeys("", "", TableName);
        while (resultSetPrimaryKey.next())
        {
            fieldPrimaryKeyName = resultSetPrimaryKey.getString("COLUMN_NAME");
        }

        ResultSet resultSetColumn = dataBaseMetaData.getColumns(null, null, TableName, "%");
        ArrayList<Field> fields = new ArrayList<Field>();
        while (resultSetColumn.next())
        {
            Field field = new Field();

            String columnName = resultSetColumn.getString(4);
            String columnType = resultSetColumn.getString(6);

            field.setFieldName(columnName);  // 1. none 2. .. 3. .. 4. column name 5. .. 6. type data
            field.setFieldType(StringExecuteConverter.convertTypeOfDataToExtentionJSType(columnType));
            field.setServerFieldType(StringExecuteConverter.convertTypeOfDataToJavaType(columnType));
            field.setIsKey(checkPrimaryKey(columnName, fieldPrimaryKeyName));

            field.setIsInt(false);
            field.setIsLong(false);
            field.setIsBoolean(false);
            field.setIsFloat(false);
            field.setIsString(false);

            if (field.getFieldType().equals("int"))
            {
                field.setIsInt(true);
            }
            else if (field.getFieldType().equals("auto"))
            {
                field.setIsLong(true);
            }
            else if (field.getFieldType().equals("boolean"))
            {
                field.setIsBoolean(true);
            }
            else if (field.getFieldType().equals("double"))
            {
                field.setIsFloat(true);
            }
            else if (field.getFieldType().equals("string"))
            {
                field.setIsString(true);
            }

            if (!field.getFieldName().isEmpty() && !field.getIsKey())
            {
                field.setLabelName(field.getFieldName());
                field.setFieldWidth("500");
                field.setFieldHeight("28");
                field.setItemType(Constants.DATA_FIELD_TYPE.get(0));
                field.setAllowBlank("false");
                field.setAllowBlankBoolean(false);
                field.setIsHTMLEditor(false);
                field.setHasSearch(false);
                field.setSearchType("");
            }
            fields.add(field);
        }
        jsonResult.setStatus("success");
        jsonResult.setData(fields);
        return jsonResult;
    }
}
