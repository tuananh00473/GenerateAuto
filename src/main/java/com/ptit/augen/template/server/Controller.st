package $packageName$.controller;

import $packageName$.business.*;
import $packageName$.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: Admin
 * Date: 10/26/13
 * Time: 5:23 PM
 */
@Controller
@RequestMapping("/")
public class $tableName$Controller
{
    @Autowired
    $tableName$Service _$tableName$Service;

    @RequestMapping(value = "/$tableName$/GetAll", params = {"page", "limit"}, method = RequestMethod.GET)
    public
    @ResponseBody
    JsonResult getAll_$tableName$(@RequestParam int page, @RequestParam int limit)
    {
        List<$tableName$> $tableName$s = _$tableName$Service.getAll();
        Collections.sort($tableName$s);
        int total = $tableName$s.size();
        List<$tableName$> $tableName$InPage = new ArrayList<$tableName$>();

        int indexStart = limit * (page - 1);
        int indexEnd = (total < indexStart + limit) ? total : indexStart + limit;
        for (int i = indexStart; i < indexEnd; i++)
        {
            $tableName$InPage.add($tableName$s.get(i));
        }

        JsonResult jsonResult = new JsonResult();
        jsonResult.setTotal(total);
        jsonResult.setSuccess(true);
        jsonResult.setData($tableName$InPage);
        return jsonResult;
    }

    @RequestMapping(value = "/$tableName$/Add", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResult add_$tableName$(HttpServletRequest request)
    {
        JsonResult jsonResult = new JsonResult();
        try
        {
            $tableName$ _$tableName$ = new $tableName$();
            $fields:{ field | $if(!field.IsKey)$
            _$tableName$.set$field.FieldName$(
            $if(field.IsString)$request.getParameter("Add$tableName$$field.FieldName$Id"));$endif$
            $if(field.IsLong)$Long.parseLong(request.getParameter("Add$tableName$$field.FieldName$Id")));$endif$
            $if(field.IsInt)$Integer.parseInt(request.getParameter("Add$tableName$$field.FieldName$Id")));$endif$
            $if(field.IsFloat)$Float.parseFloat(request.getParameter("Add$tableName$$field.FieldName$Id")));$endif$
            $if(field.IsBoolean)$Boolean.parseBoolean(request.getParameter("Add$tableName$$field.FieldName$Id")));$endif$
            $endif$
            }$
            _$tableName$Service.save(_$tableName$);

            jsonResult.setSuccess(true);
            jsonResult.setData(_$tableName$.getid());
            jsonResult.setStatusCaptcha(true);
            return jsonResult;
        }
        catch (Exception e)
        {
        }

        jsonResult.setSuccess(false);
        return jsonResult;
    }

    @RequestMapping(value = "/$tableName$/Edit", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResult edit_$tableName$(HttpServletRequest request)
    {
        JsonResult jsonResult = new JsonResult();
        try
        {
            $tableName$ _$tableName$ = _$tableName$Service.findById(Long.parseLong(request.getParameter("Edit$tableName$idId")));
            $fields:{ field | $if(!field.IsKey)$
            _$tableName$.set$field.FieldName$(
            $if(field.IsString)$request.getParameter("Edit$tableName$$field.FieldName$Id"));$endif$
            $if(field.IsLong)$Long.parseLong(request.getParameter("Edit$tableName$$field.FieldName$Id")));$endif$
            $if(field.IsInt)$Integer.parseInt(request.getParameter("Edit$tableName$$field.FieldName$Id")));$endif$
            $if(field.IsFloat)$Float.parseFloat(request.getParameter("Edit$tableName$$field.FieldName$Id")));$endif$
            $if(field.IsBoolean)$Boolean.parseBoolean(request.getParameter("Edit$tableName$$field.FieldName$Id")));$endif$
            $endif$}$
            _$tableName$Service.save(_$tableName$);

            jsonResult.setSuccess(true);
            jsonResult.setData(_$tableName$.getid());
            jsonResult.setStatusCaptcha(true);

            return jsonResult;
        }
        catch (Exception ignored)
        {
        }

        jsonResult.setSuccess(false);
        return jsonResult;
    }

    @RequestMapping(value = "/$tableName$/Delete", params = {"id"}, method = RequestMethod.POST)
    public
    @ResponseBody
    String delete_$tableName$(@RequestParam int id)
    {
        try
        {
            _$tableName$Service.remove((long) id);
            return "success";
        }
        catch (Exception ignored)
        {
            return "false";
        }
    }
}
