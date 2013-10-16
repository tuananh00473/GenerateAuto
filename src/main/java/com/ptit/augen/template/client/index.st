/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
Ext.Loader.setConfig({enabled:true});
Ext.application({
    name: 'AM',
    appFolder: 'app',
    autoCreateViewport: true,
    controllers: [
        'Menu', $tables:{ table | '$table.TableName$'};separator=","$ 
    ],
    launch: function () {
        Ext.get('mainBody').mask();
        MMVariables.mask = new Ext.LoadMask(Ext.getBody(), { msg: "Xin chờ trong giây lát ..." });
        MMVariables.mask.show();
        // init first page in here
        Ext.get('loading').remove();
        Ext.get('loading-mask').fadeOut({ remove: true });
        Ext.get('mainBody').unmask();
        MMVariables.mask.hide();
    }
});