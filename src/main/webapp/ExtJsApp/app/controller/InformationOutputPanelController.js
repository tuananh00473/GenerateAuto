Ext.define("AM.controller.InformationOutputPanelController", {
    extend: "AM.controller.AbstractController",
    control: {
        btnGenerateOk: {
            click: "onbtnGenerateOkClick"
        },
        btnGenerateCancel: {
            click: "onbtnGenerateCancelClick"
        }
    },
    init: function ()
    {
        return this.callParent(arguments);
    },
    onbtnGenerateOkClick: function ()
    {
        var _this = this;
        AM.config.AppConfig.MASK.show();
        Ext.Ajax.request({
            url: '/Connection/GenerateCode',
            params: {
                ProjectLocationId: Ext.getCmp('ProjectLocationId').getValue(),
                ProjectNameId: Ext.getCmp('ProjectNameId').getValue(),
                BasePackageId: Ext.getCmp('BasePackageId').getValue()
            },
            success: function (response, opts)
            {
                AM.config.AppConfig.MASK.hide();
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
                    _this.getNotificationService().success("Success", "Generate code successfull !");
                    _this.getView().close();
                }
            },
            failure: function (response, opts)
            {
                AM.config.AppConfig.MASK.hide();
                _this.getNotificationService().error("Error", "System error ! Please try again !");
            }
        });
    },
    onbtnGenerateCancelClick: function ()
    {
        Ext.getCmp('myForm').getForm().reset();
        this.getView().close();
    }
});
