package com.ptit.augen.service;


import com.ptit.augen.model.Field;
import com.ptit.augen.model.Table;
import com.ptit.augen.ultility.Constants;
import com.ptit.augen.ultility.JavaWriteFile;
import org.antlr.stringtemplate.StringTemplate;

import java.util.ArrayList;

public class StringTemplateService
{


    public static void generateModel(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("model");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = tableName + ".js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_MODEL, fileName, content);
    }

    public static void generateStore(String tableName)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("store");
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = tableName + ".js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_STORE, fileName, content);
    }

    public static void generateController(String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("controller");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = tableName + ".js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
    }

    public static void generateMenuController(ArrayList<Table> tables)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("menuController");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "Menu.js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_CONTROLLER, fileName, content);
    }

    public static void generateScreenList(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("list");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "List" + tableName + ".js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateScreenAdd(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("add");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "Add" + tableName + ".js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateScreenEdit(String tableName, ArrayList<Field> listNormalFields)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("edit");
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listNormalFields);

        String content = template.toString();
        String fileName = "Edit" + tableName + ".js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, fileName, content);
    }

    public static void generateMenu(ArrayList<Table> tables)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("menu");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "TopMenu.js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_MENU, fileName, content);
    }

    public static void generateConstant()
    {
        StringTemplate template = Constants.groupOther.getInstanceOf("constant");

        String content = template.toString();
        String fileName = "Constant.js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_OTHER_COMMON, fileName, content);
    }

    public static void generateVariable()
    {
        StringTemplate template = Constants.groupOther.getInstanceOf("variable");

        String content = template.toString();
        String fileName = "Variables.js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_OTHER_COMMON, fileName, content);
    }

    public static void generateIndexHTML()
    {
        StringTemplate template = Constants.groupOther.getInstanceOf("index");

        String content = template.toString();
        String fileName = "index.jsp";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_OTHER_JSP_PAGES, fileName, content);
    }

    public static void generateIndexJS(ArrayList<Table> tables)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("index");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "index.js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_INDEX, fileName, content);
    }

    public static void generateViewPort(ArrayList<Table> tables)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("viewport");
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "Viewport.js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_VIEWPORT, fileName, content);
    }

    public static void generateHTML(String type, String tableName)
    {
        StringTemplate template = Constants.groupTest.getInstanceOf("html");
        template.setAttribute("type", type);
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = "index" + type + tableName + ".html";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_TEST, fileName, content);
    }

    public static void generateJavascript(String type, String tableName)
    {
        StringTemplate template = Constants.groupTest.getInstanceOf("javascript");

        boolean IsAdd = (Constants.TypeAdd.equals(type)) ? true : false;
        boolean IsEdit = (Constants.TypeEdit.equals(type)) ? true : false;
        boolean IsList = (Constants.TypeList.equals(type)) ? true : false;

        template.setAttribute("IsAdd", IsAdd);
        template.setAttribute("IsEdit", IsEdit);
        template.setAttribute("IsList", IsList);
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = "index" + type + tableName + ".js";

        JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_TEST, fileName, content);
    }

    public static void generateEntity(String path, String packageName, String tableName, ArrayList<Field> listFullFields)
    {
        StringTemplate template = Constants.groupServer.getInstanceOf("entity");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tableName", tableName);
        template.setAttribute("fields", listFullFields);

        String content = template.toString();
        String fileName = tableName + ".java";

        JavaWriteFile.WritToFile(path, fileName, content);
    }

    public static void generateDAO(String path, String packageName, String tableName)
    {
        StringTemplate template = Constants.groupServer.getInstanceOf("DAOInterface");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = tableName + "DAO.java";

        JavaWriteFile.WritToFile(path, fileName, content);
    }

    public static void generateServiceInterface(String path, String packageName, String tableName)
    {
        StringTemplate template = Constants.groupServer.getInstanceOf("ServiceInterface");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = tableName + "Service.java";

        JavaWriteFile.WritToFile(path, fileName, content);
    }

    public static void generateServiceImplements(String path, String packageName, String tableName)
    {
        StringTemplate template = Constants.groupServer.getInstanceOf("ServiceImpl");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tableName", tableName);

        String content = template.toString();
        String fileName = tableName + "ServiceImpl.java";

        JavaWriteFile.WritToFile(path, fileName, content);
    }

    public static void generatePersistence(String path, String packageName, ArrayList<Table> tables)
    {
        StringTemplate template = Constants.groupServer.getInstanceOf("Persistence");
        template.setAttribute("packageName", packageName);
        template.setAttribute("tables", tables);

        String content = template.toString();
        String fileName = "persistence.xml";

        JavaWriteFile.WritToFile(path, fileName, content);
    }

    public static void generatePom(String path, String projectName)
    {
        StringTemplate template = Constants.groupServer.getInstanceOf("Pom");
        template.setAttribute("projectName", projectName);

        String content = template.toString();
        String fileName = "pom.xml";

        JavaWriteFile.WritToFile(path, fileName, content);
    }

    public static void generateSpringConfig(String path, String packageName, String driver, String url, String username, String password)
    {
        StringTemplate template = Constants.groupServer.getInstanceOf("SpringConfig");
        template.setAttribute("packageName", packageName);
        template.setAttribute("driver", driver);
        template.setAttribute("url", url);
        template.setAttribute("username", username);
        template.setAttribute("password", password);

        String content = template.toString();
        String fileName = "mvc-dispatcher-servlet.xml";

        JavaWriteFile.WritToFile(path, fileName, content);
    }

    public static void generateServerController(String path, String tableName, ArrayList<Field> listFullFields)
    {
        // viet Controller theo SpringMVC
//        StringTemplate template = Constants.groupServer.getInstanceOf("controller");
//        template.setAttribute("tableName", tableName);
//        template.setAttribute("fields", listFullFields);
//
//        String content = template.toString();
        String fileName = tableName + ".js";

        JavaWriteFile.WritToFile(path, fileName, "");
    }

    public static void generateJsonResultEntity(String path, String packageName)
    {
        StringTemplate template = Constants.groupClient.getInstanceOf("jsonResult");
        template.setAttribute("packageName", packageName);

        String content = template.toString();
        String fileName = "JsonResult.java";

        JavaWriteFile.WritToFile(path, fileName, content);
    }
}
