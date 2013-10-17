/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam 
*/
Ext.define('AM.view.ListTablePanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.screenListTablePanel',
    controller: "AM.controller.ListTablePanelController",
    defaults: {
        bodyStyle: 'padding:15px'
    },
    layout: {
        type: 'accordion'
    }
});