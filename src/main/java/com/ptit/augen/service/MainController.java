package com.ptit.augen.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Admin
 * Date: 10/19/13
 * Time: 4:23 PM
 */

@Controller
@RequestMapping(value = "/")
public class MainController
{
    @RequestMapping(value = "/Connection/UpdateFile", method = RequestMethod.GET)
    public String updateFile(ModelMap model)
    {
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
        return "hello";
    }
}
