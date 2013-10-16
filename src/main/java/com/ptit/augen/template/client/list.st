/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam
* Coder: Nguyen Tuan Anh - QsoftVietNam
*/ 
Ext.define('AM.view.screen.List$tableName$', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.screenList$tableName$',
    store: '$tableName$',
    initComponent: function () {
        Ext.applyIf(this, {
            columns: [{
                header: '#',
                xtype: 'rownumberer',
                align: 'left'
            }, $fields:{ field | { 
				header: '$field.LabelName$', 
				dataIndex: '$field.FieldName$',
                flex: 1
			}};separator=", \n			"$
			,{
                header: 'Sửa',
                flex: 1,
                xtype: 'actioncolumn',
                align: 'center',
                items: [{
                    icon: 'bitmaps/tool_edit.png',
                    tooltip: 'Sửa thông tin'
                }],
                handler: function (grid, row, col) {
                    Ext.ComponentQuery.query('screenList$tableName$')[0].fireEvent('btnEditClick', grid.getStore().getAt(row).data);
                }
            }, {
                header: 'Xóa',
                flex: 1,
                xtype: 'actioncolumn',
                align: 'center',
                items: [{
                    icon: 'bitmaps/tool_delete.png',
                    tooltip: 'Xóa bản ghi'
                }],
                handler: function (grid, row, col) {
                    Ext.ComponentQuery.query('screenList$tableName$')[0].fireEvent('btnDeleteClick', grid.getStore().getAt(row).data);
                }
            }],
            dockedItems: [{
                xtype: 'pagingtoolbar',
                dock: 'bottom',
                store: '$tableName$',
                displayInfo: true,
                displayMsg: 'Hiển thị từ {0} - {1} trên tổng số {2} bản ghi',
                emptyMsg: "Không có dữ liệu",
                beforePageText: 'Trang',
                afterPageText: 'trên tổng số {0} trang',
                prevText: 'Trang trước',
                nextText: 'Trang sau',
                refreshText: 'Cập nhật',
                firstText: 'Trang đầu',
                lastText: 'Trang cuối'
            }, {
                xtype: 'toolbar',
                dock: 'top',
                frame: false,
                items: [{
                    xtype: 'button',
                    text: 'Thêm',
                    cls: 'button-right',
                    scale: 'medium',
                    icon: 'bitmaps/tool_add.png',
                    handler: function () {
                        Ext.ComponentQuery.query('screenList$tableName$')[0].fireEvent('btnAddClick');
                    }
                }, 
                {
                    xtype: 'button',
                    text: 'In',
                    cls: 'button-right',
                    scale: 'medium',
                    icon: 'bitmaps/tool_print.png',
                    handler: function () {
                        Ext.ComponentQuery.query('screenList$tableName$')[0].fireEvent('btnPrintClick');
                    }
                }, 
                '->', $fields:{ field | $if(field.HasSearch)${ 
					xtype: '$field.SearchType$',
                    id: 'Search$tableName$$field.FieldName$Id',
                    width: 300,
                    labelWidth: 100,
                    fieldLabel: '$field.LabelName$'
					//listConfig: {
                        //width: 178,
                        //itemCls: "combobox-item-style"
                    //},
                    //store: 'viewStore.SearchTypeActive',
                    //queryMode: 'local',
                    //displayField: 'Value',
                    //valueField: 'Id',
                    //value: -1
				},$else$$endif$};separator="\n				"$
				, {
                    xtype: 'button',
                    text: 'Tìm Kiếm',
                    cls: 'button-right',
                    scale: 'medium',
                    icon: 'bitmaps/search.png',
                    handler: function () {
                        Ext.ComponentQuery.query('screenList$tableName$')[0].fireEvent('btnFilterClick');
                    }
                }]
            }]
        });
        this.callParent(arguments);
    }
});