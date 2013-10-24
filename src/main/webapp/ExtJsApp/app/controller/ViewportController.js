Ext.define("AM.controller.ViewportController", {
    extend: "AM.controller.AbstractController",
    control: {
        btnExit: {
            click: "onbtnExitClick"
        },
        btnNewConnection: {
            click: "onbtnNewConnectionClick"
        },
        btnViewConnection: {
            click: "onbtnViewConnectionClick"
        },
        btnLoadDatabase: {
            click: "onbtnLoadDatabaseClick"
        },
        btnGenerateCode: {
            click: "onbtnGenerateCodeClick"
        },
        centerId: {
            tabchange: "onCenterPanelChange"
        },
        listTable: '#listTable'
    },
    init: function ()
    {
        return this.callParent(arguments);
    },
    inject: ["settingStore"],
    config: {
        settingStore: null
    },
    onCenterPanelChange: function (tabPanel, tab)
    {
        if (AM.config.AppConfig.APP_LOAD_STATUS == true)
        {
            var editor, view;
            if (tab.id == 'tabAddId')
            {
                editor = AM.config.AppConfig.CODE_MIRROR_ADD;
                view = 'Add';
            }
            else if (tab.id == 'tabEditId')
            {
                editor = AM.config.AppConfig.CODE_MIRROR_EDIT;
                view = 'Edit';
            }
            else
            {
                editor = AM.config.AppConfig.CODE_MIRROR_LIST;
                view = 'List';
            }
            AM.config.AppConfig.COOKIES.set('ViewType', view);
            AM.config.AppConfig.CURRENT_EDITOR = editor;
            AM.config.AppConfig.MASK.show();
            Ext.Ajax.request({
                url: 'sourcegenerated/Temp/app/view/screen/' + view + AM.config.AppConfig.COOKIES.get('TableName') + '.js',
                success: function (response, opts)
                {
                    Ext.getCmp('centerId').setActiveTab(tab.id);
                    AM.config.AppConfig.MASK.hide();
                    AM.config.AppConfig.CURRENT_EDITOR.setValue(response.responseText);
                },
                failure: function (response, opts)
                {
                    AM.config.AppConfig.MASK.hide();
                }
            });
        }
    },
    onbtnExitClick: function ()
    {
        Ext.MessageBox.confirm("Confirm", "Do you want to close this web?", function (button)
        {
            if (button === "yes")
            {
                close();
            }
        }, this);
    },
    onbtnNewConnectionClick: function ()
    {
        Ext.create("AM.view.ConnectionPanel").show();
    },
    onbtnViewConnectionClick: function ()
    {
        var _this = this;
        AM.config.AppConfig.MASK.show();
        Ext.Ajax.request({
            url: '/Connection/ViewCurrentConnection',
            success: function (response, opts)
            {
                AM.config.AppConfig.MASK.hide();
                Ext.Msg.alert('Info', response.responseText);
            },
            failure: function (response, opts)
            {
                AM.config.AppConfig.MASK.hide();
                _this.getNotificationService().error("Error", "System error ! Please try again !");
            }
        });
    },
    onbtnLoadDatabaseClick: function ()
    {
        var _this = this;
        AM.config.AppConfig.MASK.show();
        Ext.Ajax.request({
            url: '/Connection/LoadDatabase',
            success: function (response, opts)
            {
                var data = JSON.parse(response.responseText);
                if (data.status == 'empty')
                {
                    _this.getNotificationService().error("Error", "Connection string is empty !");
                }
                else if (data.status == 'error')
                {
                    _this.getNotificationService().error("Error", "Connection error !");
                }
                else
                {
                    _this.loadDataFromDB(data.data);
                    _this.getNotificationService().success("Success", "Load database successfull !");
                }
                AM.config.AppConfig.MASK.hide();
            },
            failure: function (response, opts)
            {
                AM.config.AppConfig.MASK.hide();
                _this.getNotificationService().error("Error", "System error ! Please try again !");
            }
        });
    },
    onbtnGenerateCodeClick: function ()
    {
        Ext.create("AM.view.InformationOutputPanel").show();
    },
    loadDataFromDB: function (data)
    {
        this.getListTable().removeAll();
        var menu = Ext.create('AM.view.ListTablePanel');
        Ext.Array.forEach(data, function (item, index)
        {
            var fields = '';
            Ext.Array.forEach(item.Fields, function (field)
            {
                fields += field.FieldName + '</br>';
            });
            var table = Ext.create('AM.view.TablePanel', {
                title: item.TableName,
                html: fields
            });
            menu.add(table);
        });
        this.getListTable().add(menu);

        var tableName = data[0].TableName;
        AM.config.AppConfig.COOKIES.set('TableName', tableName);
        this.getSettingStore().setProxy({
            type: 'ajax',
            api: {
                read: '/Connection/GetListFieldByTable?TableName=' + tableName
            },
            reader: {
                type: 'json',
                root: 'data'
            }
        });
        this.getSettingStore().load({
            scope: this,
            callback: function (records, operation, success)
            {
                AM.config.AppConfig.MASK.show();
                Ext.Ajax.request({
                    url: 'sourcegenerated/Temp/app/view/screen/Add' + tableName + '.js',
                    success: function (response, opts)
                    {
                        Ext.getCmp('centerId').setActiveTab('tabAddId');
                        AM.config.AppConfig.MASK.hide();
                        AM.config.AppConfig.CODE_MIRROR_ADD.setValue(response.responseText);
                    },
                    failure: function (response, opts)
                    {
                        AM.config.AppConfig.MASK.hide();
                    }
                });
            }
        });
    }
});
