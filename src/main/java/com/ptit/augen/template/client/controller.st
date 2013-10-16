/**
* Created by Generate Code Tool.
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/
var popUpAdd$tableName$, popUpEdit$tableName$, nicEdit$tableName$, nicAdd$tableName$;
Ext.define('AM.controller.$tableName$', {
    extend: 'Ext.app.Controller',
    models: ['$tableName$'],
    stores: ['$tableName$'],
    views: ['screen.List$tableName$', 'screen.Add$tableName$', 'screen.Edit$tableName$'],
    init: function () {
        var me = this;
        this.control({
            'screenList$tableName$': {
                btnAddClick: function () {
                    if (!popUpAdd$tableName$) {
                        popUpAdd$tableName$ = Ext.create('AM.view.screen.Add$tableName$');
                    }
                    popUpAdd$tableName$.show();
					if (!nicAdd$tableName$) {
						$fields:{ field | $if(field.IsHTMLEditor)$nicAdd$tableName$ = new nicEditor({ maxHeight: 280, fullPanel: true }).panelInstance('tempAdd$tableName$$field.FieldName$Id');$endif$};separator="\n"$                        
                    }
                },
                btnPrintClick: function () {

                },
                btnFilterClick: function () {
                    Ext.get('mainBody').mask();
                    MMVariables.mask.show();
                    var store = Ext.ComponentQuery.query('screenList$tableName$')[0].getStore();
                    store.clearFilter();
					//do filter in here

					$fields:{ field | $if(field.HasSearch)$ 
					var search$field.FieldName$ = Ext.getCmp('Search$tableName$$field.FieldName$Id').getValue();
                    if (search$field.FieldName$ != -1 || !Ext.isEmpty(search$field.FieldName$)) {
                        store.filter([{
                            property: '$field.FieldName$', value: search$field.FieldName$
                        }]);
						//store.filter([{
                            //filterFn: function (item) {
                                //return (item.get("$field.FieldName$").toUpperCase().indexOf(search$field.FieldName$) != -1);
                            //}
                        //}]);
                    }
					$else$$endif$};separator="\n"$                    
                    Ext.get('mainBody').unmask();
                    MMVariables.mask.hide();
                },
                btnEditClick: function (record) {
                    if (!popUpEdit$tableName$) {
                        popUpEdit$tableName$ = Ext.create('AM.view.screen.Edit$tableName$');
                    }                    
                    popUpEdit$tableName$.show();
					if (!nicEdit$tableName$) {
                        $fields:{ field | $if(field.IsHTMLEditor)$nicEdit$tableName$ = new nicEditor({ maxHeight: 280, fullPanel: true }).panelInstance('tempEdit$tableName$$field.FieldName$Id');$endif$};separator="\n"$                        
                    }
					me.initFormEdit(record);
                },
                btnDeleteClick: function (record) {
                    Ext.create('Ext.window.MessageBox').confirm('Xác Nhận', 'Bạn có thực sự muốn xóa bản ghi này không?', function (btn, text) {
                        if (btn == 'yes') {
                            Ext.get('mainBody').mask();
                            MMVariables.mask.show();
                            Ext.Ajax.request({
                                url: '/$tableName$/Delete',
                                params: {
                                    Id: record.Id
                                },
                                success: function (response, opts) {
                                    var status = response.responseText;
                                    Ext.get('mainBody').unmask();
                                    MMVariables.mask.hide();
                                    if (status == "success") {
                                        Ext.ComponentQuery.query('screenList$tableName$')[0].getStore().load();
                                        Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Xóa bản ghi thành công !');
                                    } else {
                                        Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Xóa bản ghi không thành công ! Hãy thử lại');
                                    }
                                },
                                failure: function (response, opts) {
                                    Ext.get('mainBody').unmask();
                                    MMVariables.mask.hide();
                                    Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Xảy ra lỗi hệ thống ! Hãy thử lại lần sau');
                                }
                            });
                        }
                    });
                }
            },
            'screenAdd$tableName$': {
                hide: function () {
                    me.resetFormAdd();
                    popUpAdd$tableName$.close();
                },
                btnSaveClick: function () {
                    var form = Ext.getCmp('formAdd$tableName$Id').getForm();
                    if (form.isValid()) {
                        Ext.get('mainBody').mask();
                        MMVariables.mask.show();
                        Ext.getCmp('Add$tableName$ChallengeId').setValue(Recaptcha.get_challenge());
                        Ext.getCmp('Add$tableName$ResponseId').setValue(Recaptcha.get_response());
						$fields:{ field | $if(field.IsHTMLEditor)$Ext.getCmp('Add$tableName$$field.FieldName$Id').setValue(new nicEditors.findEditor('tempAdd$tableName$$field.FieldName$Id').getContent());$endif$};separator="\n"$						
                        form.submit({
                            success: function (fp, o) {
                                var status = o.result.success;
                                if (status == false) {
                                    Ext.get('mainBody').unmask();
                                    MMVariables.mask.hide();
                                    Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Tạo dữ liệu không thành công ! Hãy thử lại');
                                } else {
                                    if (o.result.statusCaptcha == false) {
                                        Ext.get('mainBody').unmask();
                                        MMVariables.mask.hide();
                                        Recaptcha.reload();
                                        Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Nhập chuỗi xác nhận không đúng ! Hãy thử lại');
                                    } else {
                                        Ext.ComponentQuery.query('screenList$tableName$')[0].getStore().load();
                                        popUpAdd$tableName$.close();
                                        me.resetFormAdd();
                                        Ext.get('mainBody').unmask();
                                        MMVariables.mask.hide();
                                        Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Thêm mới dữ liệu thành công !');
                                        Recaptcha.reload();
                                    }                                    
                                }
                            },
                            failure: function (form, action) {
                                Ext.get('mainBody').unmask();
                                MMVariables.mask.hide();
								Recaptcha.reload();
                                Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Xảy ra lỗi hệ thống ! Hãy thử lại lần sau');
                            }
                        });
                    } else {
                        Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Xin hãy nhập đầy đủ thông tin cần thiết !');
                    }
                },
                btnCloseClick: function () {
                    me.resetFormAdd();
                    popUpAdd$tableName$.close();
                }
            },
            'screenEdit$tableName$': {
                hide: function () {
                    me.resetFormEdit();
                    popUpEdit$tableName$.close();
                },
                btnSaveClick: function () {
                    var form = Ext.getCmp('formEdit$tableName$Id').getForm();
                    if (form.isValid()) {
                        Ext.get('mainBody').mask();
                        MMVariables.mask.show();
                        Ext.getCmp('Edit$tableName$ChallengeId').setValue(Recaptcha.get_challenge());
                        Ext.getCmp('Edit$tableName$ResponseId').setValue(Recaptcha.get_response());
						$fields:{ field | $if(field.IsHTMLEditor)$Ext.getCmp('Edit$tableName$$field.FieldName$Id').setValue(new nicEditors.findEditor('tempEdit$tableName$$field.FieldName$Id').getContent());$endif$};separator="\n"$
                        form.submit({
                            success: function (fp, o) {
                                var status = o.result.success;
                                if (status == false) {
                                    Ext.get('mainBody').unmask();
                                    MMVariables.mask.hide();
                                    Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Sửa dữ liệu không thành công ! Hãy thử lại');
                                } else {
                                    if (o.result.statusCaptcha == false) {
                                        Ext.get('mainBody').unmask();
                                        MMVariables.mask.hide();
                                        Recaptcha.reload();
                                        Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Nhập chuỗi xác nhận không đúng ! Hãy thử lại');
                                    } else {
                                        Ext.ComponentQuery.query('screenList$tableName$')[0].getStore().load();
                                        popUpEdit$tableName$.close();
                                        me.resetFormEdit();
                                        Ext.get('mainBody').unmask();
                                        MMVariables.mask.hide();
                                        Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Sửa dữ liệu thành công !');
                                        Recaptcha.reload();
                                    }                                                                         
                                }
                            },
                            failure: function (form, action) {
                                Ext.get('mainBody').unmask();
                                MMVariables.mask.hide();
								Recaptcha.reload();
                                Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Xảy ra lỗi hệ thống ! Hãy thử lại lần sau');
                            }
                        });
                    } else {
                        Ext.create('Ext.window.MessageBox').alert('Thông báo', 'Xin hãy nhập đầy đủ thông tin cần thiết !');
                    }
                },
                btnCloseClick: function () {
                    me.resetFormEdit();
                    popUpEdit$tableName$.close();
                }
            }
        });
    },
    resetFormAdd: function () {
        var form = Ext.getCmp('formAdd$tableName$Id').getForm();
        form.reset();
		$fields:{ field | $if(field.IsHTMLEditor)$new nicEditors.findEditor('tempAdd$tableName$$field.FieldName$Id').setContent('');$endif$};separator="\n"$
    },
    initFormEdit: function (record) {
		$fields:{ field | $if(field.IsHTMLEditor)$ new nicEditors.findEditor('tempEdit$tableName$$field.FieldName$Id').setContent(record.$field.FieldName$); 
		$else$ Ext.getCmp('Edit$tableName$$field.FieldName$Id').setValue(record.$field.FieldName$);$endif$};separator="\n"$        
    },
    resetFormEdit: function () {
        var form = Ext.getCmp('formEdit$tableName$Id').getForm();
        form.reset();
		$fields:{ field | $if(field.IsHTMLEditor)$new nicEditors.findEditor('tempEdit$tableName$$field.FieldName$Id').setContent('');$endif$};separator="\n"$		
    }
});
