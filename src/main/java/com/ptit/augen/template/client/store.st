/**
* Created by Generate Code Tool.
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/
Ext.define('AM.store.$tableName$', {
    extend: 'Ext.data.Store',
    model: 'AM.model.$tableName$',
    pageSize: 15,
    proxy: {
        type: 'ajax',
        api: {
            read: '/$tableName$/GetAll'
        },
        reader: {
            type: 'json',
            root: 'data',
            totalProperty: 'total'
        }
    },
    autoLoad: false,    
    storeId: '$tableName$Store'
});