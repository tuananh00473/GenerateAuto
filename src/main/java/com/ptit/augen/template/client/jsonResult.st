package $packageName$.entity;

import java.util.List;

/**
 * User: Admin
 * Date: 10/22/13
 * Time: 11:37 AM
 */
public class JsonResult
{
    public int total;
    public boolean success;
    public Object data;
    public boolean statusCaptcha;

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public boolean isStatusCaptcha()
    {
        return statusCaptcha;
    }

    public void setStatusCaptcha(boolean statusCaptcha)
    {
        this.statusCaptcha = statusCaptcha;
    }
}