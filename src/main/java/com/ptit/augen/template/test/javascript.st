/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
Ext.Loader.setConfig({ enabled: true });
Ext.application({
    name: 'AM',
    appFolder: '../app',
    controllers: [
        '$tableName$' 
    ],
    launch: function () {
		$if(IsAdd)$		Ext.create('AM.view.screen.Add$tableName$').show();$endif$
		$if(IsEdit)$	Ext.create('AM.view.screen.Edit$tableName$').show();$endif$
		$if(IsList)$	Ext.create('AM.view.screen.List$tableName$', {
			renderTo: Ext.getBody()
		});$endif$        
    }
});