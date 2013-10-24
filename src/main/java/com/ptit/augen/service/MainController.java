package com.ptit.augen.service;

import com.ptit.augen.model.Field;
import com.ptit.augen.model.Table;
import com.ptit.augen.ultility.Constants;
import com.ptit.augen.ultility.GlobalVariables;
import com.ptit.augen.ultility.JavaWriteFile;
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

    @RequestMapping(value = "/Connection/GenerateCode", method = RequestMethod.GET)
    public String generateCode(ModelMap model)
    {
        ArrayList<Table> tables = GlobalVariables.tables;
        for (Table table : tables)
        {
            StringTemplateService.generateEntity(GlobalVariables.packageName, table.getTableName(), table.getFields());
            StringTemplateService.generateDAO(GlobalVariables.packageName, table.getTableName());

            String typeKey = "";
            for (Field field : table.getFields())
            {
                if (field.getIsKey())
                {
                    typeKey = field.getFieldType();
                }
            }

            StringTemplateService.generateServiceInterface(GlobalVariables.packageName, table.getTableName(), typeKey);
            StringTemplateService.generateServiceImplements(GlobalVariables.packageName, table.getTableName(), typeKey);
        }
        StringTemplateService.generatePersistence(GlobalVariables.packageName, tables);
        StringTemplateService.generatePom(GlobalVariables.projectName);
        StringTemplateService.generateSpringConfig(GlobalVariables.projectName, GlobalVariables.driver, GlobalVariables.ConnString, GlobalVariables.UserID, GlobalVariables.Password);
        return "hello";
    }
}
