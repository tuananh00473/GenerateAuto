package com.ptit.augen.service;

import com.ptit.augen.model.Field;
import com.ptit.augen.model.JsonResult;
import com.ptit.augen.model.Table;
import com.ptit.augen.ultility.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * User: Admin
 * Date: 10/19/13
 * Time: 4:23 PM
 */

@Controller
@RequestMapping(value = "/")
public class MainController
{
    @RequestMapping(value = "/Connection/UpdateFile", params = {"type", "tableName", "content"}, method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResult updateFile(@RequestParam int type, @RequestParam String tableName, @RequestParam String content)
    {
        switch (type)
        {
            case Constants.ViewTabAdd:
                JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, "Add" + tableName + ".js", content);
                break;
            case Constants.ViewTabEdit:
                JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, "Edit" + tableName + ".js", content);
                break;
            case Constants.ViewTabList:
                JavaWriteFile.WritToFile(Constants.TOMCAT_PATH_OUT_PUT_CLIENT_VIEW_SCREEN, "List" + tableName + ".js", content);
                break;
        }
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus("success");
        return jsonResult;
    }

    @RequestMapping(value = "/Connection/UpdateSetting", params = {"tableName", "fieldsChanged"}, method = RequestMethod.POST)
    public JsonResult updateSetting(@RequestParam String tableName, @RequestParam ArrayList<Field> fieldsChanged)
    {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus("success");
        return jsonResult;
    }

    @RequestMapping(value = "/Connection/GenerateCode", params = {"ProjectLocationId", "ProjectNameId", "BasePackageId"}, method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResult generateCode(@RequestParam String ProjectLocationId, @RequestParam String
            ProjectNameId, @RequestParam String BasePackageId)
    {
        GlobalVariables.projectLocation = ProjectLocationId;
        GlobalVariables.projectName = ProjectNameId;
        GlobalVariables.packageName = BasePackageId;

        setUpLocation(ProjectLocationId, ProjectNameId, BasePackageId);

        ArrayList<Table> tables = GlobalVariables.tables;
        for (Table table : tables)
        {
            StringTemplateService.generateEntity(GlobalVariables.PATH_OUT_PUT_SERVER_ENTITY, GlobalVariables.packageName, table.getTableName(), table.getFields());
            StringTemplateService.generateDAO(GlobalVariables.PATH_OUT_PUT_SERVER_DAO, GlobalVariables.packageName, table.getTableName());
            StringTemplateService.generateServiceInterface(GlobalVariables.PATH_OUT_PUT_SERVER_BUSINESS, GlobalVariables.packageName, table.getTableName());
            StringTemplateService.generateServiceImplements(GlobalVariables.PATH_OUT_PUT_SERVER_BUSINESS_IMPL, GlobalVariables.packageName, table.getTableName());
            StringTemplateService.generateServerController(GlobalVariables.PATH_OUT_PUT_SERVER_CONTROLLER, GlobalVariables.packageName, table.getTableName(), table.getFields());
            JavaCopyFileFilterByType.copySingleFileWithOtherName(Constants.GENERATE_MENU_BUTTON, GlobalVariables.GENERATE_BITMAPS, table.getTableName() + ".png");
        }
        StringTemplateService.generateMainController(GlobalVariables.PATH_OUT_PUT_SERVER_MAIN_CONTROLLER, GlobalVariables.packageName);
        StringTemplateService.generateJsonResultEntity(GlobalVariables.PATH_OUT_PUT_SERVER_ENTITY, GlobalVariables.packageName);
        StringTemplateService.generatePersistence(GlobalVariables.PATH_OUT_PUT_SERVER_PERSISTENCE, GlobalVariables.packageName, tables);
        StringTemplateService.generatePom(GlobalVariables.PATH_OUT_PUT_SERVER_POM, GlobalVariables.projectName);
        StringTemplateService.generateSpringConfig(GlobalVariables.PATH_OUT_PUT_SERVER_SPRINGCONFIG, GlobalVariables.packageName, GlobalVariables.driver, GlobalVariables.ConnString, GlobalVariables.UserID, GlobalVariables.Password);

        JavaCopyFileFilterByType.copy(Constants.ALL_FILE, Constants.GENERATE_APP, GlobalVariables.GENERATE_APP);
        JavaCopyFileFilterByType.copy(Constants.ALL_FILE, Constants.GENERATE_JS, GlobalVariables.GENERATE_JS);
        JavaCopyFileFilterByType.copy(Constants.ALL_FILE, Constants.GENERATE_CSS, GlobalVariables.GENERATE_CSS);
        JavaCopyFileFilterByType.copy(Constants.ALL_FILE, Constants.GENERATE_BITMAPS, GlobalVariables.GENERATE_BITMAPS);
        JavaCopyFileFilterByType.copy(Constants.ALL_FILE, Constants.GENERATE_JSP_PAGES, GlobalVariables.GENERATE_JSP_PAGES);

        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus("success");
        return jsonResult;
    }

    private void setUpLocation(String ProjectLocationId, String ProjectNameId, String BasePackageId)
    {
        String packageDirection = StringExecuteConverter.convertFromPackageToDirection(BasePackageId);
        GlobalVariables.PROJECT_OUTPUT = ProjectLocationId + "\\" + ProjectNameId;
        GlobalVariables.PATH_OUT_PUT_SERVER_ENTITY = ProjectLocationId + "\\" + ProjectNameId + "\\" + Constants.SRC_MAIN_JAVA + "\\" + packageDirection + "\\entity\\";
        GlobalVariables.PATH_OUT_PUT_SERVER_DAO = ProjectLocationId + "\\" + ProjectNameId + "\\" + Constants.SRC_MAIN_JAVA + "\\" + packageDirection + "\\dao\\";
        GlobalVariables.PATH_OUT_PUT_SERVER_BUSINESS = ProjectLocationId + "\\" + ProjectNameId + "\\" + Constants.SRC_MAIN_JAVA + "\\" + packageDirection + "\\business\\";
        GlobalVariables.PATH_OUT_PUT_SERVER_BUSINESS_IMPL = GlobalVariables.PATH_OUT_PUT_SERVER_BUSINESS + "\\impl\\";
        GlobalVariables.PATH_OUT_PUT_SERVER_CONTROLLER = ProjectLocationId + "\\" + ProjectNameId + "\\" + Constants.SRC_MAIN_JAVA + "\\" + packageDirection + "\\controller\\";
        GlobalVariables.PATH_OUT_PUT_SERVER_MAIN_CONTROLLER = ProjectLocationId + "\\" + ProjectNameId + "\\" + Constants.SRC_MAIN_JAVA + "\\" + packageDirection + "\\";
        GlobalVariables.PATH_OUT_PUT_SERVER_PERSISTENCE = ProjectLocationId + "\\" + ProjectNameId + "\\" + Constants.SRC_MAIN_WEBAPP + "\\META-INF\\";
        GlobalVariables.PATH_OUT_PUT_SERVER_POM = ProjectLocationId + "\\" + ProjectNameId + "\\";
        GlobalVariables.PATH_OUT_PUT_SERVER_SPRINGCONFIG = ProjectLocationId + "\\" + ProjectNameId + "\\" + Constants.SRC_MAIN_WEBAPP + "\\WEB-INF\\";

        GlobalVariables.GENERATE_APP = GlobalVariables.PROJECT_OUTPUT + "\\" + Constants.SRC_MAIN_WEBAPP + "\\app";
        GlobalVariables.GENERATE_JS = GlobalVariables.GENERATE_APP + "\\js";
        GlobalVariables.GENERATE_CSS = GlobalVariables.GENERATE_APP + "\\css";
        GlobalVariables.GENERATE_BITMAPS = GlobalVariables.GENERATE_APP + "\\bitmaps";
        GlobalVariables.GENERATE_JSP_PAGES = GlobalVariables.PROJECT_OUTPUT + "\\" + Constants.SRC_MAIN_WEBAPP + "\\WEB-INF\\pages";
    }
}
