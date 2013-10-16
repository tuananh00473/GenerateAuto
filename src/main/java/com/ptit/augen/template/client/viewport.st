/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
Ext.define('AM.view.Viewport', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.viewPort',
    initComponent: function () {
        var me = this;
        me.layout = 'border',
        Ext.apply(me, {
            items: [{
                region: 'north',
                margins: '5 5 5 5',
                xtype: 'menuTopMenu'
            }, {
                xtype: 'panel',
                id: 'mainScreen',
                region: 'center',
                border: 1,
                margins: '0 5 5 5',
                layout:'card',
                items: [$tables:{ table | {
                    xtype: 'screenList$table.TableName$',
                    itemId: '$table.TableName$'
                }};separator=", \n				"$],
                autoScroll: true
            }]
        });
        me.callParent(arguments);
        me.mon(me.getEl(), 'mouseover', function(e) {
            this.fireEvent('mouseover', e)
        }, me);
    }
});