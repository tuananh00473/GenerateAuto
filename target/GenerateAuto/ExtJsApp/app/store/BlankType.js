/**
* Created by Generate Code Tool.
* Author: Le Hoang Hai - QsoftVietNam
*/
Ext.define('AM.store.BlankType', {
    extend: 'Ext.data.Store',
    requires: ["AM.model.BooleanType"],
    model: 'AM.model.BooleanType',
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
          value: true
      }, {
          id: 2,
          value: false
      }
    ];
        this.loadData(data);
        return options.callback(this.data.items, {}, true);
    }
});