/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
Ext.define('AM.view.screen.Add$tableName$', {
    extend: 'Ext.window.Window',
    alias: 'widget.screenAdd$tableName$',
    title: 'Thêm $tableName$',
    closeAction: 'hide',
    width: 520,
    height: 500,
    items: [{
        xtype: 'form',
        id: 'formAdd$tableName$Id',
        url: '/$tableName$/Add',
        layout: 'vbox',
        items: [{
            xtype: 'hiddenfield',
            id: 'Add$tableName$ChallengeId',
            name: 'Add$tableName$ChallengeId'
        }, {
            xtype: 'hiddenfield',
            id: 'Add$tableName$ResponseId',
            name: 'Add$tableName$ResponseId'
        }, $fields:{ field | $if(field.IsHTMLEditor)$ {
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
            html: '<textarea id="tempAdd$tableName$$field.FieldName$Id" name="tempAdd$tableName$$field.FieldName$Id" style="width: 100%; height: $(field.FieldHeight + 10)$px;"></textarea>'
        }, 
		$else$ {
            xtype: '$field.ItemType$',
            id: 'Add$tableName$$field.FieldName$Id',
            name: 'Add$tableName$$field.FieldName$Id',
			width: $field.FieldWidth$,
            height: $field.FieldHeight$,
			allowBlank: $field.AllowBlank$,
			$if(!field.AllowBlankBoolean)$			emptyText: '$field.LabelName$ không được để trống',$endif$                        
            msgTarget: 'none',
			$if(field.AllowBlankBoolean)$			fieldLabel: '$field.LabelName$' $else$			fieldLabel: '<b style="color: red;">*</b> $field.LabelName$' $endif$            
        }$endif$};separator=", \n		"$, {
            xtype: 'panel',
            width: 320,
            height: 130,
            border: false,
            html: '<div id="CaptchaAdd$tableName$"></div>'
        }]
    }],
    dockedItems: {
        xtype: 'toolbar',
        dock: 'bottom',
        ui: 'footer',
        items: ['->', {
            xtype: 'button',
            text: 'Thêm',
            handler: function () {
                Ext.ComponentQuery.query('screenAdd$tableName$')[0].fireEvent('btnSaveClick');

            }
        }, {
            xtype: 'button',
            text: 'Đóng',
            handler: function () {
                Ext.ComponentQuery.query('screenAdd$tableName$')[0].fireEvent('btnCloseClick');
            }
        }]
    },
    afterRender: function () {
        var captchaEl = Ext.get('CaptchaAdd$tableName$');
        var x = Recaptcha.create("6Lcxct0SAAAAAPaR3ym_MSwzWNN6SrTzZwh4-DY5",
            document.getElementById('CaptchaAdd$tableName$'),
            {
                theme: "red",
                callback: Recaptcha.focus_response_field
            }
        );
        this.callParent();
    }
});