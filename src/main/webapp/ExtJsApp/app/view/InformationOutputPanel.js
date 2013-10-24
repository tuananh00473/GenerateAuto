/**
 * Created by Generate Code Tool.
 * Author: Le Hoang Hai - QsoftVietNam
 */
Ext.define('AM.view.InformationOutputPanel', {
    extend: 'Ext.window.Window',
    alias: 'widget.screenInformationOutputPanel',
    title: 'Information Output',
    controller: "AM.controller.InformationOutputPanelController",
    width: 520,
    height: 220,
    items: [
        {
            xtype: 'form',
            id: 'myForm',
            url: '/Connection/ConnectPostgres',
            layout: 'vbox',
            items: [
                {
                    xtype: 'textfield',
                    itemId: 'ProjectNameId',
                    name: 'ProjectNameId',
                    value: 'AppGenerated',
                    labelWidth: 150,
                    width: 500,
                    allowBlank: false,
                    msgTarget: 'none',
                    fieldLabel: 'Project Name'
                },
                {
                    xtype: 'textfield',
                    itemId: 'BasePackageId',
                    name: 'BasePackageId',
                    value: 'com.springapp.mvc',
                    labelWidth: 150,
                    width: 500,
                    allowBlank: false,
                    msgTarget: 'none',
                    fieldLabel: 'Base Package'
                },
                {
                    xtype: 'textfield',
                    itemId: 'ProjectLocationId',
                    name: 'ProjectLocationId',
                    value: 'D:/Do_An/24_10_2013',
                    labelWidth: 150,
                    width: 500,
                    allowBlank: false,
                    msgTarget: 'none',
                    fieldLabel: 'Project Location'
                }
            ]
        }
    ],
    dockedItems: {
        xtype: 'toolbar',
        dock: 'bottom',
        ui: 'footer',
        items: ['->', {
            xtype: 'button',
            itemId: 'btnGenerateOk',
            width: 100,
            text: 'Generate'
        }, {
            xtype: 'button',
            itemId: 'btnGenerateCancel',
            width: 100,
            text: 'Cancel'
        }]
    }
})
;