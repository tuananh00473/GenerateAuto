/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace HoangHai.Models
{
    public class $tableName$
    {
		$fields:{ field | $if(field.IsKey)$[Key] $else$ $endif$
public $field.ServerFieldType$ $field.FieldName$ { get; set; }};separator="\n"$ 
    }
}