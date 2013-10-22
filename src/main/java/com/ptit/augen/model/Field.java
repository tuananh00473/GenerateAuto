package com.ptit.augen.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: AnhNT
 * Date: 10/16/13
 * Time: 7:21 PM
 */
public class Field
{
    private String FieldName;
    private String FieldType;   // Type in ExtJs
    private String ServerFieldType;  // Type in Java
    private Boolean IsKey;   // Primary Key
    private Boolean IsInt;
    private Boolean IsLong;
    private Boolean IsBoolean;
    private Boolean IsFloat;
    private Boolean IsString;

    private String LabelName;  // default set =  FieldName
    private String FieldWidth; // 500
    private String FieldHeight;      //28
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

    @JsonProperty("FieldName")
    public String getFieldName()
    {
        return FieldName;
    }

    public void setFieldName(String fieldName)
    {
        FieldName = fieldName;
    }

    @JsonProperty("FieldType")
    public String getFieldType()
    {
        return FieldType;
    }

    public void setFieldType(String fieldType)
    {
        FieldType = fieldType;
    }

    @JsonProperty("ServerFieldType")
    public String getServerFieldType()
    {
        return ServerFieldType;
    }

    public void setServerFieldType(String serverFieldType)
    {
        ServerFieldType = serverFieldType;
    }

    @JsonProperty("IsKey")
    public Boolean getIsKey()
    {
        return IsKey;
    }

    public void setIsKey(Boolean isKey)
    {
        IsKey = isKey;
    }

    @JsonProperty("IsInt")
    public Boolean getIsInt()
    {
        return IsInt;
    }

    public void setIsInt(Boolean isInt)
    {
        IsInt = isInt;
    }

    @JsonProperty("IsLong")
    public Boolean getIsLong()
    {
        return IsLong;
    }

    public void setIsLong(Boolean isLong)
    {
        IsLong = isLong;
    }

    @JsonProperty("IsBoolean")
    public Boolean getIsBoolean()
    {
        return IsBoolean;
    }

    public void setIsBoolean(Boolean isBoolean)
    {
        IsBoolean = isBoolean;
    }

    @JsonProperty("IsFloat")
    public Boolean getIsFloat()
    {
        return IsFloat;
    }

    public void setIsFloat(Boolean isFloat)
    {
        IsFloat = isFloat;
    }

    @JsonProperty("IsString")
    public Boolean getIsString()
    {
        return IsString;
    }

    public void setIsString(Boolean isString)
    {
        IsString = isString;
    }

    @JsonProperty("LabelName")
    public String getLabelName()
    {
        return LabelName;
    }

    public void setLabelName(String labelName)
    {
        LabelName = labelName;
    }

    @JsonProperty("FieldWidth")
    public String getFieldWidth()
    {
        return FieldWidth;
    }

    public void setFieldWidth(String fieldWidth)
    {
        FieldWidth = fieldWidth;
    }

    @JsonProperty("FieldHeight")
    public String getFieldHeight()
    {
        return FieldHeight;
    }

    public void setFieldHeight(String fieldHeight)
    {
        FieldHeight = fieldHeight;
    }

    @JsonProperty("ItemType")
    public String getItemType()
    {
        return ItemType;
    }

    public void setItemType(String itemType)
    {
        ItemType = itemType;
    }

    @JsonProperty("ItemTypeId")
    public int getItemTypeId()
    {
        return ItemTypeId;
    }

    public void setItemTypeId(int itemTypeId)
    {
        ItemTypeId = itemTypeId;
    }

    @JsonProperty("AllowBlank")
    public String getAllowBlank()
    {
        return AllowBlank;
    }

    public void setAllowBlank(String allowBlank)
    {
        AllowBlank = allowBlank;
    }

    @JsonProperty("AllowBlankBoolean")
    public Boolean getAllowBlankBoolean()
    {
        return AllowBlankBoolean;
    }

    public void setAllowBlankBoolean(Boolean allowBlankBoolean)
    {
        AllowBlankBoolean = allowBlankBoolean;
    }

    @JsonProperty("AllowBlankBooleanId")
    public int getAllowBlankBooleanId()
    {
        return AllowBlankBooleanId;
    }

    public void setAllowBlankBooleanId(int allowBlankBooleanId)
    {
        AllowBlankBooleanId = allowBlankBooleanId;
    }

    @JsonProperty("IsHTMLEditor")
    public Boolean getIsHTMLEditor()
    {
        return IsHTMLEditor;
    }

    public void setIsHTMLEditor(Boolean isHTMLEditor)
    {
        IsHTMLEditor = isHTMLEditor;
    }

    @JsonProperty("HasSearch")
    public Boolean getHasSearch()
    {
        return HasSearch;
    }

    public void setHasSearch(Boolean hasSearch)
    {
        HasSearch = hasSearch;
    }

    @JsonProperty("HasSearchId")
    public int getHasSearchId()
    {
        return HasSearchId;
    }

    public void setHasSearchId(int hasSearchId)
    {
        HasSearchId = hasSearchId;
    }

    @JsonProperty("SearchType")
    public String getSearchType()
    {
        return SearchType;
    }

    public void setSearchType(String searchType)
    {
        SearchType = searchType;
    }

    @JsonProperty("SearchTypeId")
    public int getSearchTypeId()
    {
        return SearchTypeId;
    }

    public void setSearchTypeId(int searchTypeId)
    {
        SearchTypeId = searchTypeId;
    }
}
