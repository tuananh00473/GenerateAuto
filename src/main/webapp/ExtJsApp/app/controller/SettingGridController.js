Ext.define("AM.controller.SettingGridController", {
    extend: "AM.controller.AbstractController",
    control: {
        view: {
            boxready: "loadInitialData",
            beforeedit: 'onBeforeEdit'
        },
        btnSaveSetting: {
            click: 'onbtnSaveSettingClick'
        }
    },
    init: function ()
    {
        return this.callParent(arguments);
    },
    onBeforeEdit: function (editor, e)
    {
        if (e.record.get('IsKey') == true)
        {
            return false;
        }
    },
    loadInitialData: function ()
    {
        var _this = this;
        this.getView().setLoading(true);
        return this.getScenarioService().loadInitialData().then({
            success: function ()
            {
                return _this.getScenarioContext().initialDataLoaded();
            },
            failure: function (errorMessage)
            {
                return _this.getNotificationService().error("Error", errorMessage);
            }
        }).always(function ()
            {
                return _this.getView().setLoading(false);
            });
    },
    onbtnSaveSettingClick: function ()
    {
        var _this = this;
        var settings = new Array();
        Ext.Array.forEach(_this.getView().getStore().getUpdatedRecords(), function (item, index)
        {
            var setting = {
                FieldName: '',
                LabelName: '',
                FieldWidth: '',
                FieldHeight: '',
                ItemTypeId: 0,
                AllowBlankBooleanId: 0,
                HasSearchId: 0,
                SearchTypeId: 0
            };
            setting.FieldName = item.data.FieldName;
            setting.LabelName = item.data.LabelName;
            setting.FieldWidth = item.data.FieldWidth;
            setting.FieldHeight = item.data.FieldHeight;
            setting.ItemTypeId = item.data.ItemTypeId;
            setting.AllowBlankBooleanId = item.data.AllowBlankBooleanId;
            setting.HasSearchId = item.data.HasSearchId;
            setting.SearchTypeId = item.data.SearchTypeId;
            settings.push(setting);
        });
        if (settings.length != 0)
        {
            Ext.Ajax.request({
                url: '/Connection/UpdateSetting',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                jsonData: JSON.stringify(settings),
                params: {
                    tableName: AM.config.AppConfig.COOKIES.get('TableName')
                },
                success: function (response, opts)
                {
                    _this.getView().getStore().load({
                        scope: this,
                        callback: function (records, operation, success)
                        {
                            AM.config.AppConfig.MASK.show();
                            Ext.Ajax.request({
                                url: 'sourcegenerated/Temp/app/view/screen/' + AM.config.AppConfig.COOKIES.get('ViewType') + AM.config.AppConfig.COOKIES.get('TableName') + '.js',
                                success: function (response, opts)
                                {
                                    AM.config.AppConfig.MASK.hide();
                                    AM.config.AppConfig.CURRENT_EDITOR.setValue(response.responseText);
                                },
                                failure: function (response, opts)
                                {
                                    AM.config.AppConfig.MASK.hide();
                                }
                            });
                        }
                    });
                    _this.getNotificationService().success("Success", "Update setting successfull !");
                },
                failure: function (response, opts)
                {
                    _this.getNotificationService().error("Error", "System error ! Please try again !");
                }
            });
        }
    }
});
