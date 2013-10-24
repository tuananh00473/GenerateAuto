Ext.define("AM.controller.TablePanelController", {
    extend: "AM.controller.AbstractController",
    control: {
        view: {
            listeners: {
                expand: 'onPanelExpand'
            }
        }
    },
    inject: ["settingStore"],
    config: {
        settingStore: null
    },
    init: function ()
    {
        return this.callParent(arguments);
    },
    onPanelExpand: function (p, eOpts)
    {
        var tableName = p.title;
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
