package com.ptit.augen.model;

import java.util.ArrayList;

/**
 * User: Admin
 * Date: 10/22/13
 * Time: 11:37 AM
 */
public class JsonResult
{
    private String status;
    private ArrayList data;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public ArrayList getData()
    {
        return data;
    }

    public void setData(ArrayList data)
    {
        this.data = data;
    }
}
