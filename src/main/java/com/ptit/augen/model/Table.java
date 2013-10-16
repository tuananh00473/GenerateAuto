package com.ptit.augen.model;

import java.util.List;

/**
 * User: AnhNT
 * Date: 10/16/13
 * Time: 7:30 PM
 */
public class Table
{
    private String TableName;
    private List<Field> Fields;

    public String getTableName()
    {
        return TableName;
    }

    public void setTableName(String tableName)
    {
        TableName = tableName;
    }

    public List<Field> getFields()
    {
        return Fields;
    }

    public void setFields(List<Field> fields)
    {
        Fields = fields;
    }
}
