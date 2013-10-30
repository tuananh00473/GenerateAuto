package com.ptit.augen.model;

import java.util.List;

/**
 * User: Admin
 * Date: 10/22/13
 * Time: 11:37 AM
 */
public class JsonResult
{
    public String status;
    public List data;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public List getData()
    {
        return data;
    }

    public void setData(List data)
    {
        this.data = data;
    }
}
