package com.ptit.augen.model;

import java.util.ArrayList;

/**
 * User: AnhNT
 * Date: 10/16/13
 * Time: 7:30 PM
 */
public class Table
{
    private String TableName;
    private ArrayList<Field> Fields;

    public String getTableName()
    {
        return TableName;
    }

    public void setTableName(String tableName)
    {
        TableName = tableName;
    }

    public ArrayList<Field> getFields()
    {
        return Fields;
    }

    public void setFields(ArrayList<Field> fields)
    {
        Fields = fields;
    }
}
