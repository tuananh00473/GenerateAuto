package com.ptit.augen.service;


import com.ptit.augen.model.Field;
import com.ptit.augen.model.Table;
import com.ptit.augen.ultility.WriteFileJava;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

import java.util.ArrayList;

public class StringTemplateService
{
    public final static String PATH_TEMPLATE_CLIENT = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\template\\client";
    public final static String PATH_TEMPLATE_SERVER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\template\\server";
    public final static String PATH_TEMPLATE_TEST = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\template\\test";
    public final static String PATH_TEMPLATE_OTHER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\template\\other";
    public static StringTemplateGroup groupClient = new StringTemplateGroup("groupClient", PATH_TEMPLATE_CLIENT, DefaultTemplateLexer.class);
    public static StringTemplateGroup groupServer = new StringTemplateGroup("groupServer", PATH_TEMPLATE_SERVER, DefaultTemplateLexer.class);
    public static StringTemplateGroup groupTest = new StringTemplateGroup("groupTest", PATH_TEMPLATE_TEST, DefaultTemplateLexer.class);
    public static StringTemplateGroup groupOther = new StringTemplateGroup("groupOther", PATH_TEMPLATE_OTHER, DefaultTemplateLexer.class);

    public final static String PATH_OUT_PUT_CLIENT_MODEL = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\model\\";
    public final static String PATH_OUT_PUT_CLIENT_STORE = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\store\\";
    public final static String PATH_OUT_PUT_CLIENT_CONTROLLER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\controller\\";
    public final static String PATH_OUT_PUT_CLIENT_VIEW_SCREEN = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\view\\screen\\";
    public final static String PATH_OUT_PUT_CLIENT_VIEW_MENU = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\view\\menu\\";
    public final static String PATH_OUT_PUT_CLIENT_INDEX = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\";
    public final static String PATH_OUT_PUT_CLIENT_VIEWPORT = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\view\\";
    public final static String PATH_OUT_PUT_OTHER_COMMON = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\common\\";
    public final static String PATH_OUT_PUT_OTHER_INDEX = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\app\\";

    public final static String PATH_OUT_PUT_SERVER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\server\\";
    public final static String PATH_OUT_PUT_SERVER_CONTROLLER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\webapp\\sourcegenerated\\Temp\\Controllers\\";

    public final static String TOMCAT_PATH_OUT_PUT_CLIENT_MODEL = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\model\\";
    public final static String TOMCAT_PATH_OUT_PUT_CLIENT_STORE = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\store\\";
    public final static String TOMCAT_PATH_OUT_PUT_CLIENT_CONTROLLER = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\controller\\";
    public final static String TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\view\\screen\\";
    public final static String TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_MENU = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\view\\menu\\";
    public final static String TOMCAT_PATH_OUT_PUT_CLIENT_INDEX = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\";
    public final static String TOMCAT_PATH_OUT_PUT_CLIENT_VIEWPORT = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\view\\";
    public final static String TOMCAT_PATH_OUT_PUT_OTHER_COMMON = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\common\\";
    public final static String TOMCAT_PATH_OUT_PUT_OTHER_INDEX = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\app\\";

    public final static String TOMCAT_PATH_OUT_PUT_SERVER = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\server\\";
    public final static String TOMCAT_PATH_OUT_PUT_SERVER_CONTROLLER = "D:\\qsoft\\setup\\apache-tomcat-6.0.37\\webapps\\ROOT\\sourcegenerated\\Temp\\Controllers\\";

    public static void generateModel(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = groupClient.getInstanceOf("model");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_MODEL, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_MODEL, fileName, content);
    }

    public static void generateStore(String tableName)
    {
        StringTemplate template = groupClient.getInstanceOf("store");
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_STORE, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_STORE, fileName, content);
    }

    public static void generateController(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = groupClient.getInstanceOf("controller");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
    }

    public static void generateMenuController(ArrayList<Table> tables)
    {
        StringTemplate template = groupClient.getInstanceOf("menuController");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "Menu.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
    }

    public static void generateScreenList(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("list");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "List" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateScreenAdd(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("add");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "Add" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateScreenEdit(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("edit");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "Edit" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateMenu(ArrayList<Table> tables)
    {
        StringTemplate template = groupClient.getInstanceOf("menu");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "TopMenu.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEW_MENU, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_MENU, fileName, content);
    }

    public static void generateConstant()
    {
        StringTemplate template = groupOther.getInstanceOf("constant");

        String content = template.toString();
        String fileName = "Constant.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_OTHER_COMMON, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_OTHER_COMMON, fileName, content);
    }

    public static void generateVariable()
    {
        StringTemplate template = groupOther.getInstanceOf("variable");

        String content = template.toString();
        String fileName = "Variables.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_OTHER_COMMON, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_OTHER_COMMON, fileName, content);
    }

    public static void generateIndexHTML()
    {
        StringTemplate template = groupOther.getInstanceOf("index");

        String content = template.toString();
        String fileName = "index.jsp";

        WriteFileJava.WritToFile(PATH_OUT_PUT_OTHER_INDEX, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_OTHER_INDEX, fileName, content);
    }

    public static void generateIndexJS(ArrayList<Table> tables)
    {
        StringTemplate template = groupClient.getInstanceOf("index");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "index.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_INDEX, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_INDEX, fileName, content);
    }

    public static void generateViewPort(ArrayList<Table> tables)
    {
        StringTemplate template = groupClient.getInstanceOf("viewport");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "Viewport.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
    }

//    public static void generateHTML()
//    {
//        StringTemplate template = groupTest.getInstanceOf("html");
//
//        String content = template.toString();
//        String fileName = "html.js";
//
////        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
////        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
//    }
//
//    public static void generateJavascript()
//    {
//        StringTemplate template = groupTest.getInstanceOf("javascript");
//
//        String content = template.toString();
//        String fileName = "Javascrip.js";
//
////        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
////        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
//    }

    public static void generateEntity(String packageName, String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = groupServer.getInstanceOf("entity");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = tableName + ".java";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_SERVER, fileName, content);
    }

    public static void generateDAO(String packageName, String tableName)
    {
        StringTemplate template = groupServer.getInstanceOf("DAOInterface");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = tableName + "DAO.java";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_SERVER, fileName, content);
    }

    public static void generateServiceInterface(String packageName, String tableName, String typeKey)
    {
        StringTemplate template = groupServer.getInstanceOf("ServiceInterface");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tableName", tableName);
        template.setAttribute("typeKey", typeKey);

        String content = template.toString();
        String fileName = tableName + "Service.java";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_SERVER, fileName, content);
    }

    public static void generateServiceImplements(String packageName, String tableName, String typeKey)
    {
        StringTemplate template = groupServer.getInstanceOf("ServiceImpl");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tableName", tableName);
        template.setAttribute("typeKey", typeKey);

        String content = template.toString();
        String fileName = tableName + "ServiceImpl.java";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_SERVER, fileName, content);
    }

    public static void generatePersistence(String packageName, ArrayList<Table> tables)
    {
        StringTemplate template = groupServer.getInstanceOf("Persistence");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "persistence.xml";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_SERVER, fileName, content);
    }

    public static void generatePom(String projectName)
    {
        StringTemplate template = groupServer.getInstanceOf("Pom");
        template.setAttribute("projectName", projectName);

        String content = template.toString();
        String fileName = "pom.xml";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_SERVER, fileName, content);
    }

    public static void generateSpringConfig(String packageName, String driver, String url, String username, String password)
    {
        StringTemplate template = groupServer.getInstanceOf("SpringConfig");
        template.setAttribute("packageName", packageName);
        template.setAttribute("driver", driver);
        template.setAttribute("url", url);
        template.setAttribute("username", username);
        template.setAttribute("password", password);

        String content = template.toString();
        String fileName = "mvc-dispatcher-servlet.xml";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER, fileName, content);
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_SERVER, fileName, content);
    }

    public static void generateServerController(String tableName, ArrayList<Field> listFullFields)
    {
        // viet Controller theo SpringMVC
//        StringTemplate template = groupServer.getInstanceOf("controller");
//        template.setAttribute("tableName", tableName);
//        template.setAttribute("fields", listFullFields);
//
//        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER_CONTROLLER, fileName, "");
        WriteFileJava.WritToFile(TOMCAT_PATH_OUT_PUT_SERVER_CONTROLLER, fileName, "");
    }
}
