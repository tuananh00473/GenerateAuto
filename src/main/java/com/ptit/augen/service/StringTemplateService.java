package com.ptit.augen.service;


import com.ptit.augen.model.Field;
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

    public final static String PATH_OUT_PUT_CLIENT_MODEL = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\sourcegenerated\\Temp\\app\\model\\";
    public final static String PATH_OUT_PUT_CLIENT_STORE = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\sourcegenerated\\Temp\\app\\store\\";
    public final static String PATH_OUT_PUT_CLIENT_CONTROLLER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\sourcegenerated\\Temp\\app\\controller\\";
    public final static String PATH_OUT_PUT_CLIENT_SCREEN = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\sourcegenerated\\Temp\\app\\screen\\";

    public final static String PATH_OUT_PUT_SERVER_MODEL = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\sourcegenerated\\Temp\\Models\\";
    public final static String PATH_OUT_PUT_SERVER_DAO = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\sourcegenerated\\Temp\\DataAccess\\";
    public final static String PATH_OUT_PUT_SERVER_CONTROLLER = "D:\\Do_An\\17102013\\GenerateAuto\\src\\main\\java\\com\\ptit\\augen\\sourcegenerated\\Temp\\Controllers\\";

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
        String fileName = "Store" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_STORE, fileName, content);
    }

    public static void generateController(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = groupClient.getInstanceOf("controller");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = "Controller" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
    }

    public static void generateScreenList(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("list");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "List" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_SCREEN, fileName, content);
    }

    public static void generateScreenAdd(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("add");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "Add" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_SCREEN, fileName, content);
    }

    public static void generateScreenEdit(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupClient.getInstanceOf("edit");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "Edit" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_CLIENT_SCREEN, fileName, content);
    }

    public static void generateServerModel(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = groupServer.getInstanceOf("model");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = "Server" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER_MODEL, fileName, content);
    }

    public static void generateServerDAO(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = groupServer.getInstanceOf("dao");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "ServerDAO" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER_DAO, fileName, content);
    }

    public static void generateServerController(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = groupServer.getInstanceOf("controller");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = "ServerController" + tableName + ".js";

        WriteFileJava.WritToFile(PATH_OUT_PUT_SERVER_CONTROLLER, fileName, content);
    }
}
