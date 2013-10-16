package com.ptit.augen.model;

/**
 * User: AnhNT
 * Date: 10/16/13
 * Time: 7:21 PM
 */
public class Field
{
    private String FieldName;
    private String FieldType;
    private String ServerFieldType;
    private Boolean IsKey;
    private Boolean IsInt;
    private Boolean IsLong;
    private Boolean IsBoolean;
    private Boolean IsFloat;
    private Boolean IsString;

    private String LabelName;
    private String FieldWidth;
    private String FieldHeight;
    private String ItemType;
    private int ItemTypeId;
    private String AllowBlank;
    private Boolean AllowBlankBoolean;
    private int AllowBlankBooleanId;
    private Boolean IsHTMLEditor;
    private Boolean HasSearch;
    private int HasSearchId;
    private String SearchType;
    private int SearchTypeId;

    public String getFieldName()
    {
        return FieldName;
    }

    public void setFieldName(String fieldName)
    {
        FieldName = fieldName;
    }

    public String getFieldType()
    {
        return FieldType;
    }

    public void setFieldType(String fieldType)
    {
        FieldType = fieldType;
    }

    public String getServerFieldType()
    {
        return ServerFieldType;
    }

    public void setServerFieldType(String serverFieldType)
    {
        ServerFieldType = serverFieldType;
    }

    public Boolean getIsKey()
    {
        return IsKey;
    }

    public void setIsKey(Boolean isKey)
    {
        IsKey = isKey;
    }

    public Boolean getIsInt()
    {
        return IsInt;
    }

    public void setIsInt(Boolean isInt)
    {
        IsInt = isInt;
    }

    public Boolean getIsLong()
    {
        return IsLong;
    }

    public void setIsLong(Boolean isLong)
    {
        IsLong = isLong;
    }

    public Boolean getIsBoolean()
    {
        return IsBoolean;
    }

    public void setIsBoolean(Boolean isBoolean)
    {
        IsBoolean = isBoolean;
    }

    public Boolean getIsFloat()
    {
        return IsFloat;
    }

    public void setIsFloat(Boolean isFloat)
    {
        IsFloat = isFloat;
    }

    public Boolean getIsString()
    {
        return IsString;
    }

    public void setIsString(Boolean isString)
    {
        IsString = isString;
    }

    public String getLabelName()
    {
        return LabelName;
    }

    public void setLabelName(String labelName)
    {
        LabelName = labelName;
    }

    public String getFieldWidth()
    {
        return FieldWidth;
    }

    public void setFieldWidth(String fieldWidth)
    {
        FieldWidth = fieldWidth;
    }

    public String getFieldHeight()
    {
        return FieldHeight;
    }

    public void setFieldHeight(String fieldHeight)
    {
        FieldHeight = fieldHeight;
    }

    public String getItemType()
    {
        return ItemType;
    }

    public void setItemType(String itemType)
    {
        ItemType = itemType;
    }

    public int getItemTypeId()
    {
        return ItemTypeId;
    }

    public void setItemTypeId(int itemTypeId)
    {
        ItemTypeId = itemTypeId;
    }

    public String getAllowBlank()
    {
        return AllowBlank;
    }

    public void setAllowBlank(String allowBlank)
    {
        AllowBlank = allowBlank;
    }

    public Boolean getAllowBlankBoolean()
    {
        return AllowBlankBoolean;
    }

    public void setAllowBlankBoolean(Boolean allowBlankBoolean)
    {
        AllowBlankBoolean = allowBlankBoolean;
    }

    public int getAllowBlankBooleanId()
    {
        return AllowBlankBooleanId;
    }

    public void setAllowBlankBooleanId(int allowBlankBooleanId)
    {
        AllowBlankBooleanId = allowBlankBooleanId;
    }

    public Boolean getIsHTMLEditor()
    {
        return IsHTMLEditor;
    }

    public void setIsHTMLEditor(Boolean isHTMLEditor)
    {
        IsHTMLEditor = isHTMLEditor;
    }

    public Boolean getHasSearch()
    {
        return HasSearch;
    }

    public void setHasSearch(Boolean hasSearch)
    {
        HasSearch = hasSearch;
    }

    public int getHasSearchId()
    {
        return HasSearchId;
    }

    public void setHasSearchId(int hasSearchId)
    {
        HasSearchId = hasSearchId;
    }

    public String getSearchType()
    {
        return SearchType;
    }

    public void setSearchType(String searchType)
    {
        SearchType = searchType;
    }

    public int getSearchTypeId()
    {
        return SearchTypeId;
    }

    public void setSearchTypeId(int searchTypeId)
    {
        SearchTypeId = searchTypeId;
    }
}
