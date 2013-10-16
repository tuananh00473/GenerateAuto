/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using HoangHai.DataAccess;
using HoangHai.Models;
using HoangHai.Utility;

namespace HoangHai.Controllers
{
    public class $tableName$Controller : Controller
    {
        $tableName$DA objectDA = new $tableName$DA();
        public JsonResult GetAll(int page, int limit)
        {
            var result = objectDA.GetAll();
            return Json(new
            {
                total = result.Count,
                success = true,
                data = result.Skip(limit * (page - 1)).Take(limit)
            }, JsonRequestBehavior.AllowGet);
        }

        public JsonResult Get(int Id)
        {
            return Json(objectDA.Get(Id), JsonRequestBehavior.AllowGet);
        }

        [ValidateInputAttribute(false)]
        public JsonResult Add(FormCollection collection)
        {
            try
            {
                MyWebRequest myRequest = new MyWebRequest(
                "http://api-verify.recaptcha.net/verify",
                "POST",
                "privatekey=6Lcxct0SAAAAADeuDKJVWKJkIamMURES8HHy_vgc&remoteip=" + Request.UserHostAddress + "&challenge=" + collection["Add$tableName$ChallengeId"] + "&response=" + collection["Add$tableName$ResponseId"]);
                var captchaResult = myRequest.GetResponse();
                var statusCaptcha = captchaResult.Contains("true");
                if (statusCaptcha)
                {
                    var record = new $tableName$();
					$fields:{ field | 
						$if(field.IsInt)$record.$field.FieldName$ = Convert.ToInt32(collection["Add$tableName$$field.FieldName$Id"]);$else$$endif$$if(field.IsLong)$record.$field.FieldName$ = Convert.ToInt64(collection["Add$tableName$$field.FieldName$Id"]);$else$$endif$$if(field.IsBoolean)$record.$field.FieldName$ = Convert.ToBoolean(collection["Add$tableName$$field.FieldName$Id"]);$else$$endif$$if(field.IsFloat)$record.$field.FieldName$ = Convert.ToDouble(collection["Add$tableName$$field.FieldName$Id"]);$else$$endif$$if(field.IsString)$record.$field.FieldName$ = collection["Add$tableName$$field.FieldName$Id"];$else$$endif$
					}$ 					
                    var recordId = objectDA.Add(record);
                    return Json(new
                    {
                        success = true,
                        data = recordId,
                        statusCaptcha = statusCaptcha
                    }, JsonRequestBehavior.AllowGet);
                }
                return Json(new
                {
                    success = true,
                    statusCaptcha = statusCaptcha
                }, JsonRequestBehavior.AllowGet);
            }
            catch
            {
                return Json(new
                {
                    success = false
                }, JsonRequestBehavior.AllowGet);
            }            
        }

        [ValidateInputAttribute(false)]
        public JsonResult Edit(FormCollection collection)
        {
            try
            {
                MyWebRequest myRequest = new MyWebRequest(
                "http://api-verify.recaptcha.net/verify",
                "POST",
                "privatekey=6Lcxct0SAAAAADeuDKJVWKJkIamMURES8HHy_vgc&remoteip=" + Request.UserHostAddress + "&challenge=" + collection["Edit$tableName$ChallengeId"] + "&response=" + collection["Edit$tableName$ResponseId"]);
                var captchaResult = myRequest.GetResponse();
                var statusCaptcha = captchaResult.Contains("true");
                if (statusCaptcha)
                {
                    var record = objectDA.Get(Convert.ToInt32(collection["Edit$tableName$IdId"]));
                    $fields:{ field |
						$if(field.IsInt)$record.$field.FieldName$ = Convert.ToInt32(collection["Edit$tableName$$field.FieldName$Id"]);$else$$endif$$if(field.IsLong)$record.$field.FieldName$ = Convert.ToInt64(collection["Edit$tableName$$field.FieldName$Id"]);$else$$endif$$if(field.IsBoolean)$record.$field.FieldName$ = Convert.ToBoolean(collection["Edit$tableName$$field.FieldName$Id"]);$else$$endif$$if(field.IsFloat)$record.$field.FieldName$ = Convert.ToDouble(collection["Edit$tableName$$field.FieldName$Id"]);$else$$endif$$if(field.IsString)$record.$field.FieldName$ = collection["Edit$tableName$$field.FieldName$Id"];$else$$endif$
                    };$
					var recordId = objectDA.Edit(record);
                    return Json(new
                    {
                        success = true,
                        data = recordId,
                        statusCaptcha = statusCaptcha
                    }, JsonRequestBehavior.AllowGet);
                }
                return Json(new
                {
                    success = true,
                    statusCaptcha = statusCaptcha
                }, JsonRequestBehavior.AllowGet);
            }
            catch
            {
                return Json(new
                {
                    success = false
                }, JsonRequestBehavior.AllowGet);
            }            
        }
		
        public string Delete(int Id)
        {
            try
            {
                objectDA.Delete(Id);
                return "success";
            }
            catch (Exception ex)
            {
                return "fail";
            }
        }        
    }
}
