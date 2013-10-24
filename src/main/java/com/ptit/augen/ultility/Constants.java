package com.ptit.augen.ultility;

import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

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
    public static final String PATH_TEMPLATE_CLIENT = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\template\\client";
    public static final String PATH_TEMPLATE_SERVER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\template\\server";
    public static final String PATH_TEMPLATE_TEST = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\template\\test";
    public static final String PATH_TEMPLATE_OTHER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\template\\other";

    public static final StringTemplateGroup groupClient = new StringTemplateGroup("groupClient", PATH_TEMPLATE_CLIENT, DefaultTemplateLexer.class);
    public static final StringTemplateGroup groupServer = new StringTemplateGroup("groupServer", PATH_TEMPLATE_SERVER, DefaultTemplateLexer.class);
    public static final StringTemplateGroup groupTest = new StringTemplateGroup("groupTest", PATH_TEMPLATE_TEST, DefaultTemplateLexer.class);
    public static final StringTemplateGroup groupOther = new StringTemplateGroup("groupOther", PATH_TEMPLATE_OTHER, DefaultTemplateLexer.class);

    public static final String TOMCAT_PATH_OUT_PUT_CLIENT_MODEL = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\model\\";
    public static final String TOMCAT_PATH_OUT_PUT_CLIENT_STORE = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\store\\";
    public static final String TOMCAT_PATH_OUT_PUT_CLIENT_CONTROLLER = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\controller\\";
    public static final String TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\view\\screen\\";
    public static final String TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_MENU = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\view\\menu\\";
    public static final String TOMCAT_PATH_OUT_PUT_CLIENT_INDEX = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\";
    public static final String TOMCAT_PATH_OUT_PUT_CLIENT_VIEWPORT = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\view\\";
    public static final String TOMCAT_PATH_OUT_PUT_OTHER_COMMON = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\common\\";
    public static final String TOMCAT_PATH_OUT_PUT_OTHER_INDEX = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\";

    public static final String TOMCAT_PATH_OUT_PUT_TEST = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\test\\";

    public static final String SOURCE_LOCATION = "D:\\Library\\do_an_libraries";
    public static final String TARGET_LOCATION = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp";

    public static final int ViewTabAdd = 0;
    public static final int ViewTabEdit = 1;
    public static final int ViewTabList = 2;

    public static final String TypeAdd = "Add";
    public static final String TypeEdit = "Edit";
    public static final String TypeList = "List";
    public static final String ALL_FILE = null;

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
