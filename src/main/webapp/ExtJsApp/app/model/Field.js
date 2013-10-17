/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam 
*/
Ext.define('AM.model.Field', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'FieldName', type: 'string' },
		{ name: 'ServerFieldType', type: 'string' },
		{ name: 'IsKey', type: 'bool' },
		{ name: 'LabelName', type: 'string' },
		{ name: 'FieldWidth', type: 'string' },
		{ name: 'FieldHeight', type: 'string' },
		{ name: 'ItemTypeId', type: 'int' },
		{ name: 'AllowBlankBooleanId', type: 'int' },
		{ name: 'HasSearchId', type: 'int' },
		{ name: 'SearchTypeId', type: 'int' }
    ]
});