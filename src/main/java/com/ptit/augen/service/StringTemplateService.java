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

    public final static String PATH_OUT_PUT_CLIENT_MODEL = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\model\\";
    public final static String PATH_OUT_PUT_CLIENT_STORE = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\store\\";
    public final static String PATH_OUT_PUT_CLIENT_CONTROLLER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\controller\\";
    public final static String PATH_OUT_PUT_CLIENT_VIEW_SCREEN = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\view\\screen\\";
    public final static String PATH_OUT_PUT_CLIENT_VIEW_MENU = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\view\\menu\\";
    public final static String PATH_OUT_PUT_CLIENT_INDEX = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\";
    public final static String PATH_OUT_PUT_CLIENT_VIEWPORT = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\view\\";
    public final static String PATH_OUT_PUT_OTHER_COMMON = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\common\\";
    public final static String PATH_OUT_PUT_OTHER_INDEX = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\app\\";

    public final static String PATH_OUT_PUT_SERVER_MODEL = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\Models\\";
    public final static String PATH_OUT_PUT_SERVER_DAO = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\DataAccess\\";
    public final static String PATH_OUT_PUT_SERVER_CONTROLLER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\source generated\\Temp\\Controllers\\";

    public static void generateModel(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = groupClient.getInstanceOf("model");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_MODEL, fileName, content);
    }

    public static void generateStore(String tableName)
    {
        StringTemplate template = groupClient.getInstanceOf("store");
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_STORE, fileName, content);
    }

    public static void generateController(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = groupClient.getInstanceOf("controller");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
    }

    public static void generateMenuController(ArrayList<Table> tables)
    {
        StringTemplate template = groupClient.getInstanceOf("menuController");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "Menu.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
    }

    public static void generateScreenList(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("list");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "List" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateScreenAdd(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("add");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "Add" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateScreenEdit(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("edit");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "Edit" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateServerModel(String tableName, ArrayList<Field> listFullFields)
    {
        // viet model theo SpringMVC
//        StringTemplate template = groupServer.getInstanceOf("model");
//        template.setAttribute("tableName", tableName);
//        template.setAttribute("fields", listFullFields);
//
//        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER_MODEL, fileName, "");
    }

    public static void generateServerDAO(String tableName, ArrayList<Field> listNormalFields)
    {
        //viet DAO theo SpringMVC
//        StringTemplate template = groupServer.getInstanceOf("dao");
//        template.setAttribute("tableName", tableName);
//        template.setAttribute("fields", listNormalFields);
//
//        String content = template.toString();
        String fileName = tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER_DAO, fileName, "");
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
    }

    public static void generateMenu(ArrayList<Table> tables)
    {
        StringTemplate template = groupClient.getInstanceOf("menu");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "TopMenu.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEW_MENU, fileName, content);
    }

    public static void generateConstant()
    {
        StringTemplate template = groupOther.getInstanceOf("constant");

        String content = template.toString();
        String fileName = "Constant.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_OTHER_COMMON, fileName, content);
    }

    public static void generateVariable()
    {
        StringTemplate template = groupOther.getInstanceOf("variable");

        String content = template.toString();
        String fileName = "Variables.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_OTHER_COMMON, fileName, content);
    }

    public static void generateIndexHTML()
    {
        StringTemplate template = groupOther.getInstanceOf("index");

        String content = template.toString();
        String fileName = "index.jsp";

        WriteFileJava.WritToFile(PATH_OUT_PUT_OTHER_INDEX, fileName, content);
    }

    public static void generateIndexJS(ArrayList<Table> tables)
    {
        StringTemplate template = groupClient.getInstanceOf("index");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "index.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_INDEX, fileName, content);
    }

    public static void generateViewPort(ArrayList<Table> tables)
    {
        StringTemplate template = groupClient.getInstanceOf("viewport");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "Viewport.js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
    }

//    public static void generateHTML()
//    {
//        StringTemplate template = groupTest.getInstanceOf("html");
//
//        String content = template.toString();
//        String fileName = "html.js";
//
////        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
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
//    }
}
