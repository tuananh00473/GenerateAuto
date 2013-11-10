Ext.define("AM.view.Viewport", {
    extend: "Ext.container.Viewport",
    layout: 'border',
    requires: ["AM.view.SettingGrid"],
    controller: "AM.controller.ViewportController",
    initComponent: function ()
    {
        Ext.applyIf(this, {
            items: [
                {
                    region: 'north',
                    border: false,
                    margins: '0 0 5 0',
                    items: [
                        {
                            xtype: 'button',
                            text: 'File',
                            width: 100,
                            arrowAlign: 'right',
                            menu: [
                                {
                                    text: 'Exit',
                                    itemId: "btnExit"
                                }
                            ]
                        },
                        {
                            xtype: 'button',
                            width: 100,
                            text: 'Connection',
                            arrowAlign: 'right',
                            menu: [
                                {
                                    text: 'Open new connection',
                                    itemId: 'btnNewConnection'
                                },
                                {
                                    text: 'View current connection',
                                    itemId: 'btnViewConnection'
                                }
                            ]
                        },
                        {
                            xtype: 'button',
                            text: 'Load database',
                            itemId: 'btnLoadDatabase',
                            width: 100
                        },
                        {
                            xtype: 'button',
                            text: 'Generate code',
                            itemId: 'btnGenerateCode',
                            width: 100
                        },
                        {
                            xtype: 'button',
                            text: 'Help',
                            itemId: 'btnHelp',
                            width: 100
                        },
                        {
                            xtype: 'button',
                            text: 'About',
                            itemId: 'btnAbout',
                            width: 100
                        }
                    ]
                },
                {
                    region: 'west',
                    collapsible: true,
                    title: 'Tables List',
                    itemId: 'listTable',
                    width: 250
                },
                {
                    region: 'south',
                    title: 'Setting',
                    collapsible: true,
                    split: true,
                    height: 200,
                    minHeight: 100,
                    layout: 'fit',
                    items: [
                        {
                            xtype: "screenSettingGrid"
                        }
                    ]
                },
                {
                    region: 'east',
                    title: 'Preview',
                    collapsible: true,
                    split: true,
                    width: 550,
                    items: [
                        {
                            xtype: 'container',
                            layout: 'fit',
                            html: '<iframe id="preview" width="100%" height="500px"></iframe>'
                        }
                    ]
                },
                {
                    region: 'center',
                    id: 'centerId',
                    itemId: 'centerId',
                    xtype: 'tabpanel',
                    activeTab: 0,
                    items: [
                        {
                            title: 'Page Add',
                            id: 'tabAddId',
                            layout: 'fit',
                            html: '<textarea hidden="true" id="pageAddId" name="pageAddId">Content is empty</textarea>'
                        },
                        {
                            title: 'Page Edit',
                            id: 'tabEditId',
                            layout: 'fit',
                            html: '<textarea hidden="true" id="pageEditId" name="pageEditId">Content is empty</textarea>'
                        },
                        {
                            title: 'Page List',
                            id: 'tabListId',
                            layout: 'fit',
                            html: '<textarea hidden="true" id="pageListId" name="pageListId">Content is empty</textarea>'
                        }
                    ]
                }
            ]
        });
        return this.callParent(arguments);
    }
});
