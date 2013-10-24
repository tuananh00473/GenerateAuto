package com.ptit.augen.service;

import com.ptit.augen.model.Field;
import com.ptit.augen.model.Table;
import com.ptit.augen.ultility.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String updateFile(@RequestParam int type, @RequestParam String tableName, @RequestParam String content)
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
        return "hello";
    }

    @RequestMapping(value = "/Connection/UpdateSetting", method = RequestMethod.GET)
    public String updateSetting(ModelMap model)
    {
        return "hello";
    }

    @RequestMapping(value = "/Connection/GenerateCode", params = {"ProjectLocationId", "ProjectNameId", "BasePackageId"}, method = RequestMethod.GET)
    public String generateCode(@RequestParam String ProjectLocationId, @RequestParam String ProjectNameId, @RequestParam String BasePackageId)
    {
        GlobalVariables.projectLocation = ProjectLocationId;
        GlobalVariables.projectName = ProjectNameId;
        GlobalVariables.packageName = BasePackageId;

        String packageDirection = StringExecuteConverter.convertFromPackageToDirection(BasePackageId);

        GlobalVariables.PROJECT_OUTPUT = ProjectLocationId + "\\" + ProjectNameId + "\\" + packageDirection;
        GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_ENTITY = ProjectLocationId + "\\" + ProjectNameId + "\\" + packageDirection + "\\entity\\";
        GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_DAO = ProjectLocationId + "\\" + ProjectNameId + "\\" + packageDirection + "\\dao\\";
        GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_BUSINESS = ProjectLocationId + "\\" + ProjectNameId + "\\" + packageDirection + "\\business\\";
        GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_CONTROLLER = ProjectLocationId + "\\" + ProjectNameId + "\\" + packageDirection + "\\controller\\";
        GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_PERSISTENCE = ProjectLocationId + "\\" + ProjectNameId + "\\" + packageDirection + "\\controller\\";
        GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_POM = ProjectLocationId + "\\" + ProjectNameId + "\\" + packageDirection + "\\controller\\";
        GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_SPRINGCONFIG = ProjectLocationId + "\\" + ProjectNameId + "\\" + packageDirection + "\\controller\\";

        ArrayList<Table> tables = GlobalVariables.tables;
        for (Table table : tables)
        {
            StringTemplateService.generateEntity(GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_ENTITY, GlobalVariables.packageName, table.getTableName(), table.getFields());
            StringTemplateService.generateDAO(GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_DAO, GlobalVariables.packageName, table.getTableName());

            String typeKey = "";
            for (Field field : table.getFields())
            {
                if (field.getIsKey())
                {
                    typeKey = field.getFieldType();
                }
            }

            StringTemplateService.generateServiceInterface(GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_BUSINESS, GlobalVariables.packageName, table.getTableName(), typeKey);
            StringTemplateService.generateServiceImplements(GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_BUSINESS, GlobalVariables.packageName, table.getTableName(), typeKey);
        }
        StringTemplateService.generatePersistence(GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_PERSISTENCE, GlobalVariables.packageName, tables);
        StringTemplateService.generatePom(GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_POM, GlobalVariables.projectName);
        StringTemplateService.generateSpringConfig(GlobalVariables.TOMCAT_PATH_OUT_PUT_SERVER_SPRINGCONFIG, GlobalVariables.projectName, GlobalVariables.driver, GlobalVariables.ConnString, GlobalVariables.UserID, GlobalVariables.Password);

        JavaCopyFileFilterByType.copy(Constants.ALL_FILE, Constants.TARGET_LOCATION, GlobalVariables.PROJECT_OUTPUT);
        return "hello";
    }
}
