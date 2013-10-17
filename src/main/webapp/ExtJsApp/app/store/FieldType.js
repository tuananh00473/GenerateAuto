/**
* Created by Generate Code Tool.
* Author: Le Hoang Hai - QsoftVietNam
*/
Ext.define('AM.store.FieldType', {
    extend: 'Ext.data.Store',
    requires: ["AM.model.FieldType"],
    model: 'AM.model.FieldType',
    autoLoad: false,
    proxy: {
        type: "memory"
    },
    sorters: [
    {
        property: "value",
        direction: "ASC"
    }
  ],
    load: function (options) {
        var data;
        data = [
      {
          id: 1,
          value: "itemTextField"
      }, {
          id: 2,
          value: "itemHtmlEditor"
      }, {
          id: 3,
          value: "itemComboBox"
      }, {
          id: 4,
          value: "itemDateField"
      }, {
          id: 5,
          value: "itemFileField"
      }, {
          id: 6,
          value: "itemCheckBoxField"
      }, {
          id: 7,
          value: "itemRadioField"
      }
    ];
        this.loadData(data);
        return options.callback(this.data.items, {}, true);
    }
});