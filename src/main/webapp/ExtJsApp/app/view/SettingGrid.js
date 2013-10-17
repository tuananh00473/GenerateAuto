/** 
* Created by Generate Code Tool. 
* Author: Le Hoang Hai - QsoftVietNam 
*/
Ext.define('AM.view.SettingGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.screenSettingGrid',
    autoScroll: true,
    controller: "AM.controller.SettingGridController",
    requires: ["Ext.grid.plugin.CellEditing", "Ext.selection.CellModel"],
    inject: ["fieldSearchTypeStore", "fieldTypeStore", "blankTypeStore", 'hasSearchTypeStore', 'settingStore'],
    config: {
        settingStore: null,
        fieldTypeStore: null,
        fieldSearchTypeStore: null,
        blankTypeStore: null,
        hasSearchTypeStore: null
    },
    cellEditing: Ext.create("Ext.grid.plugin.CellEditing", {
        clicksToEdit: 1
    }),
    cellModel: Ext.create("Ext.selection.CellModel", {
        enableKeyNav: true
    }),
    initComponent: function () {
        var me = this;
        Ext.apply(this, {
            store: me.getSettingStore(),
            columns: [
        {
            header: "Field Name",
            dataIndex: "FieldName"
        }, {
            header: "Data Type",
            dataIndex: "ServerFieldType"
        }, {
            header: "Primary Key",
            dataIndex: "IsKey",
            renderer: function (value, metaData, record, rowIdx, colIdx, store, view) {
                var result = '';
                if (value == true) {
                    result = '<b style="color:red;">Key</b>';
                } else {
                    result = '<b style="color:green;">Normal</b>';
                }
                return result;
            }
        }, {
            header: "Caption",
            dataIndex: "LabelName",
            editor: {
                emptyText: "Enter Caption",
                cls: "editorWithMargin"
            }
        }, {
            xtype: "numbercolumn",
            header: "Width",
            dataIndex: "FieldWidth",
            editor: {
                allowBlank: false,
                cls: "editorWithMargin",
                xtype: "numberfield",
                hideTrigger: true,
                minLength: 1,
                minValue: 0
            }
        }, {
            xtype: "numbercolumn",
            header: "Height",
            dataIndex: "FieldHeight",
            editor: {
                allowBlank: false,
                cls: "editorWithMargin",
                xtype: "numberfield",
                hideTrigger: true,
                minLength: 1,
                minValue: 0
            }
        }, {
            header: "Display Type",
            dataIndex: "ItemTypeId",
            width: 150,
            renderer: function (value, metaData, record, row, col, store, gridView) {
                var _ref;
                return (_ref = this.getFieldTypeStore().getById(value)) != null ? _ref.get("value") : void 0;
            },
            editor: {
                xtype: "combobox",
                store: this.getFieldTypeStore(),
                queryMode: "local",
                displayField: "value",
                valueField: "id",
                emptyText: "Select display type",
                forceSelection: true,
                cls: "editorWithMargin"
            }
        }, {
            header: "Allow Blank",
            dataIndex: "AllowBlankBooleanId",
            width: 150,
            renderer: function (value, metaData, record, row, col, store, gridView) {
                var _ref;
                return (_ref = this.getBlankTypeStore().getById(value)) != null ? _ref.get("value") : void 0;
            },
            editor: {
                xtype: "combobox",
                store: this.getBlankTypeStore(),
                queryMode: "local",
                displayField: "value",
                valueField: "id",
                emptyText: "Select option",
                forceSelection: true,
                cls: "editorWithMargin"
            }
        }, {
            header: "Active Search",
            dataIndex: "HasSearchId",
            width: 150,
            renderer: function (value, metaData, record, row, col, store, gridView) {
                var _ref;
                return (_ref = this.getHasSearchTypeStore().getById(value)) != null ? _ref.get("value") : void 0;
            },
            editor: {
                xtype: "combobox",
                store: this.getHasSearchTypeStore(),
                queryMode: "local",
                displayField: "value",
                valueField: "id",
                emptyText: "Select option",
                forceSelection: true,
                cls: "editorWithMargin"
            }
        }, {
            header: "Search Type",
            dataIndex: "SearchTypeId",
            width: 150,
            renderer: function (value, metaData, record, row, col, store, gridView) {
                var _ref;
                return (_ref = this.getFieldSearchTypeStore().getById(value)) != null ? _ref.get("value") : void 0;
            },
            editor: {
                xtype: "combobox",
                store: this.getFieldSearchTypeStore(),
                queryMode: "local",
                displayField: "value",
                valueField: "id",
                emptyText: "Select search type",
                forceSelection: true,
                cls: "editorWithMargin"
            }
        }, {
            xtype: "actioncolumn",
            itemId: "scenarioItemActionColumn",
            text: "Delete",
            width: 60,
            align: "center",
            sortable: false,
            items: [
            {
                itemId: "scenarioItemDeleteButton",
                icon: "ExtJsApp/resources/icons/delete.png",
                tooltip: "Delete Scenario Item",
                iconCls: "mousepointer x-grid-center-icon"
            }
          ]
        }
      ],
            columnLines: true,
            selModel: this.cellModel,
            plugins: [this.cellEditing],
            viewConfig: {
                stripeRows: true,
                emptyText: "<div class='x-grid-empty-custom'>There are no Setting Items defined yet.</div>",
                deferEmptyText: false
            },
            tbar: [{
                text: "Save setting",
                itemId: "btnSaveSetting",
                iconCls: "save-icon"
            }]
        });
        return this.callParent(arguments);
    }
});