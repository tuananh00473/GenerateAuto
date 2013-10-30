/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
Ext.define('AM.view.screen.Edit$tableName$', {
    extend: 'Ext.window.Window',
    alias: 'widget.screenEdit$tableName$',
    title: 'Sửa $tableName$',
    closeAction: 'hide',
    width: 520,
    height: 500,
    items: [{
        xtype: 'form',
        id: 'formEdit$tableName$Id',
        url: '/$tableName$/Edit',
        layout: 'vbox',
        items: [
        {
            xtype: 'hiddenfield',
            id: 'Edit$tableName$idId',
            name: 'Edit$tableName$idId'
        },
        {
            xtype: 'hiddenfield',
            id: 'Edit$tableName$ChallengeId',
            name: 'Edit$tableName$ChallengeId'
        },
        {
            xtype: 'hiddenfield',
            id: 'Edit$tableName$ResponseId',
            name: 'Edit$tableName$ResponseId'
        },$fields:{ field | $if(field.IsHTMLEditor)$
        {
            xtype: 'label',
            text: '$field.LabelName$',
            margin: '5 0 5 10',
            style: 'color:#003B75; font-family:Arial, Helvetica, sans-serif; font-size:13px; font-weight: bold;'
        },
        {
            xtype: 'panel',
            width: $field.FieldWidth$,
            height: $field.FieldHeight$,
            border: false,
            html: '<textarea id="tempEdit$tableName$$field.FieldName$Id" name="tempEdit$tableName$$field.FieldName$Id" style="width: 100%; height: $(field.FieldHeight + 10)$px;"></textarea>'
        },$else$
        {
            xtype: '$field.ItemType$',
            id: 'Edit$tableName$$field.FieldName$Id',
            name: 'Edit$tableName$$field.FieldName$Id',
            width: $field.FieldWidth$,
            height: $field.FieldHeight$,
            allowBlank: $field.AllowBlank$,
            $if(!field.AllowBlankBoolean)$			emptyText: '$field.LabelName$ không được để trống',$endif$                        
            msgTarget: 'none',
			$if(field.AllowBlankBoolean)$			fieldLabel: '$field.LabelName$' $else$			fieldLabel: '<b style="color: red;">*</b> $field.LabelName$' $endif$
        }$endif$};separator=",\n"$,
        {
            xtype: 'panel',
            width: 320,
            height: 130,
            border: false,
            html: '<div id="CaptchaEdit$tableName$"></div>'
        }]
    }],
    dockedItems: {
        xtype: 'toolbar',
        dock: 'bottom',
        ui: 'footer',
        items: ['->', {
            xtype: 'button',
            text: 'Sửa',
            handler: function () {
                Ext.ComponentQuery.query('screenEdit$tableName$')[0].fireEvent('btnSaveClick');

            }
        }, {
            xtype: 'button',
            text: 'Đóng',
            handler: function () {
                Ext.ComponentQuery.query('screenEdit$tableName$')[0].fireEvent('btnCloseClick');
            }
        }]
    },
    afterRender: function () {
        var captchaEl = Ext.get('CaptchaEdit$tableName$');
        var x = Recaptcha.create("6Lcxct0SAAAAAPaR3ym_MSwzWNN6SrTzZwh4-DY5",
            document.getElementById('CaptchaEdit$tableName$'),
            {
                theme: "red",
                callback: Recaptcha.focus_response_field
            }
        );
        this.callParent();
    }
});