/**
* Created by Generate Code Tool.
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/
Ext.define('AM.view.menu.TopMenu', {
    extend:'Ext.panel.Panel',
    alias:'widget.menuTopMenu',
    height: 62,
    border: 1,
    layout: {
        type: 'hbox'
    },
    items: [$tables:{ table | {
        xtype: 'button',
        text: '$table.TableName$',
        icon: 'bitmaps/$table.TableName$.png',
		height: 60,
		width: 90,
		scale: 'large',
		iconAlign: 'top',
        handler: function(){
            Ext.ComponentQuery.query('menuTopMenu')[0].fireEvent('btn$table.TableName$Click', this);
        }
    }};separator=", \n	"$]
});
