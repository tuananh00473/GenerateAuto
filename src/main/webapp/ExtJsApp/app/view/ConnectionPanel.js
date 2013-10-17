/**
 * Created by Generate Code Tool.
 * Author: Le Hoang Hai - QsoftVietNam
 */
Ext.define('AM.view.ConnectionPanel', {
    extend: 'Ext.window.Window',
    alias: 'widget.screenConnectionPanel',
    title: 'Connection',
    controller: "AM.controller.ConnectionPanelController",
    width: 520,
    height: 220,
    items: [
        {
            xtype: 'tabpanel',
            itemId: 'tabConnectionId',
            activeTab: 0,
            items: [
                {
                    title: 'Postgres',
                    xtype: 'form',
                    itemId: 'formPostgresConnectionId',
                    url: '/Connection/ConnectPostgres',
                    layout: 'vbox',
                    items: [
                        {
                            xtype: 'textfield',
                            itemId: 'SQLProviderNameId',
                            name: 'SQLProviderNameId',
                            value: 'SQLOLEDB',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Provider Name'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'SQLServerNameId',
                            name: 'SQLServerNameId',
                            value: 'localhost\\SQLEXPRESS',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Server Name'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'SQLInitialCatalogId',
                            name: 'SQLInitialCatalogId',
                            value: 'db_candimex',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Initial Catalog'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'SQLUserNameId',
                            name: 'SQLUserNameId',
                            value: 'hanoi',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Username'
                        },
                        {
                            xtype: 'textfield',
                            inputType: 'password',
                            itemId: 'SQLPasswordId',
                            name: 'SQLPasswordId',
                            value: 'hanoi',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Password'
                        }
                    ]
                },
                {
                    title: 'SQL Server',
                    xtype: 'form',
                    itemId: 'formSQLConnectionId',
                    url: '/Connection/ConnectSqlServer',
                    layout: 'vbox',
                    items: [
                        {
                            xtype: 'textfield',
                            itemId: 'SQLProviderNameId',
                            name: 'SQLProviderNameId',
                            value: 'SQLOLEDB',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Provider Name'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'SQLServerNameId',
                            name: 'SQLServerNameId',
                            value: 'localhost\\SQLEXPRESS',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Server Name'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'SQLInitialCatalogId',
                            name: 'SQLInitialCatalogId',
                            value: 'db_candimex',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Initial Catalog'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'SQLUserNameId',
                            name: 'SQLUserNameId',
                            value: 'hanoi',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Username'
                        },
                        {
                            xtype: 'textfield',
                            inputType: 'password',
                            itemId: 'SQLPasswordId',
                            name: 'SQLPasswordId',
                            value: 'hanoi',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Password'
                        }
                    ]
                },
                {
                    title: 'MS Access',
                    xtype: 'form',
                    itemId: 'formAccessConnectionId',
                    url: '/Connection/ConnectMSAccess',
                    layout: 'vbox',
                    items: [
                        {
                            xtype: 'textfield',
                            itemId: 'AccessProviderNameId',
                            name: 'AccessProviderNameId',
                            value: 'Microsoft.Jet.OLEDB.4.0',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Provider Name'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'AccessDatabaseNameId',
                            name: 'AccessDatabaseNameId',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Database Name'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'AccessUserNameId',
                            name: 'AccessUserNameId',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Username'
                        },
                        {
                            xtype: 'textfield',
                            inputType: 'password',
                            itemId: 'AccessPasswordId',
                            name: 'AccessPasswordId',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Password'
                        }
                    ]
                },
                {
                    title: 'Oracle',
                    xtype: 'form',
                    itemId: 'formOracleConnectionId',
                    url: '/Connection/ConnectOracle',
                    layout: 'vbox',
                    items: [
                        {
                            xtype: 'textfield',
                            itemId: 'OracleProviderNameId',
                            name: 'OracleProviderNameId',
                            value: 'OraOLEDB.Oracle',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Provider Name'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'OracleDatabaseNameId',
                            name: 'OracleDatabaseNameId',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Database Name'
                        },
                        {
                            xtype: 'textfield',
                            itemId: 'OracleUserNameId',
                            name: 'OracleUserNameId',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Username'
                        },
                        {
                            xtype: 'textfield',
                            inputType: 'password',
                            itemId: 'OraclePasswordId',
                            name: 'OraclePasswordId',
                            labelWidth: 150,
                            width: 500,
                            allowBlank: false,
                            msgTarget: 'none',
                            fieldLabel: 'Password'
                        }
                    ]
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
            itemId: 'btnConnectionOk',
            width: 100,
            text: 'OK'
        }, {
            xtype: 'button',
            itemId: 'btnConnectionCancel',
            width: 100,
            text: 'Cancel'
        }]
    }
});