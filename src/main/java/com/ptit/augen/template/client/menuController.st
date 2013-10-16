/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
Ext.define('AM.controller.Menu', {
    extend: 'Ext.app.Controller',
    views: ['menu.TopMenu'],
    refs: [{
        ref: 'TopMenu',
        selector: 'menuTopMenu'
    }],
    init: function () {
        var menu = this;
        this.control({
            'menuTopMenu': {
                $tables:{ table | btn$table.TableName$Click: function (button) {
                    menu.changeScreen(button, '$table.TableName$');
                    Ext.ComponentQuery.query('screenList$table.TableName$')[0].getStore().load();
                }};separator=",\n		"$
            }
        });
    },
    changeScreen: function (button, screen) {
        button.el.removeCls('button-icon-gray-style');
        button.el.addCls('button-icon-blue-style');
        var buttonNext = button.el.next();
        while (buttonNext != null) {
            buttonNext.removeCls('button-icon-blue-style');
            buttonNext.addCls('button-icon-gray-style');
            buttonNext = buttonNext.next();
        }
        var buttonPrev = button.el.prev();
        while (buttonPrev != null) {
            buttonPrev.removeCls('button-icon-blue-style');
            buttonPrev.addCls('button-icon-gray-style');
            buttonPrev = buttonPrev.prev();
        }
        Ext.getCmp('mainScreen').getLayout().setActiveItem(screen);
    }
});