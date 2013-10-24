Ext.define("AM.controller.ConnectionPanelController", {
    extend: "AM.controller.AbstractController",
    control: {
        btnConnectionOk: {
            click: "onbtnConnectionOkClick"
        },
        btnConnectionCancel: {
            click: "onbtnConnectionCancelClick"
        },
        tabConnectionId: '#tabConnectionId'
    },
    init: function ()
    {
        return this.callParent(arguments);
    },
    onbtnConnectionOkClick: function ()
    {
        var _this = this;
        var form = this.getTabConnectionId().getActiveTab().getForm();
        if (form.isValid())
        {
            AM.config.AppConfig.MASK.show();
            form.submit({
                success: function (fp, o)
                {
                    AM.config.AppConfig.MASK.hide();
                    var status = o.result.success;
                    if (status == false)
                    {
                        _this.getNotificationService().error("Error", "Connection error !");
                    }
                    else
                    {
                        _this.getNotificationService().success("Success", "Connection attempt successful !");
                        _this.getView().close();
                    }
                },
                failure: function (form, action)
                {
                    AM.config.AppConfig.MASK.hide();
                    _this.getNotificationService().error("Error", "System error ! Please try again !");
                }
            });
        }
        else
        {
            Ext.Msg.alert('Notice', 'Please input needed information !');
        }
    },
    onbtnConnectionCancelClick: function ()
    {
        this.getTabConnectionId().getActiveTab().getForm().reset();
        this.getView().close();
    }
});
