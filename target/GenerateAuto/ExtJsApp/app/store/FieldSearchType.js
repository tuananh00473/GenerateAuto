/**
* Created by Generate Code Tool.
* Author: Le Hoang Hai - QsoftVietNam
*/
Ext.define('AM.store.FieldSearchType', {
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
          value: "itemComboBox"
      }, {
          id: 3,
          value: "itemDateField"
      }
    ];
        this.loadData(data);
        return options.callback(this.data.items, {}, true);
    }
});