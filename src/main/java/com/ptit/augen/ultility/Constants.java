package com.ptit.augen.ultility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: AnhNT
 * Date: 10/16/13
 * Time: 7:32 PM
 */
public class Constants
{
    public static int ConnectionEmpty = 0;
    public static int ConnectionError = 1;
    public static int ConnectionSuccess = 2;

    public static List<String> DATA_FIELD_TYPE = new ArrayList<String>(Arrays.asList(
            "textfield",
            "htmleditor",
            "combobox",
            "datefield",
            "filefield",
            "checkboxfield",
            "radiofield"
    ));

    public static List<String> DATA_SEARCH_TYPE = new ArrayList<String>(Arrays.asList(
            "textfield",
            "combobox",
            "datefield"
    ));

    public static List<String> DATA_VIEW_TYPE = new ArrayList<String>(Arrays.asList(
            "Add",
            "Edit",
            "List"
    ));
}
