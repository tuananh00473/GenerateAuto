/**
* Created by Generate Code Tool.
* Author: Le Hoang Hai - QsoftVietNam
*/
Ext.define('AM.store.SettingStore', {
    extend: 'Ext.data.Store',
    requires: ["AM.model.Field"],
    model: "AM.model.Field",
    autoLoad: false,
    inject: ["appConfig"],
    config: {
        appConfig: null
    },
    constructor: function (cfg) {
        if (cfg == null) {
            cfg = {};
        }
        this.initConfig(cfg);
        return this.callParent(arguments);
    },
    /**
    * Returns true the store contains unsynced {Phoenix.model.ScenarioItem} models.
    * @return {Boolean}
    */

    isSyncNeeded: function () {
        var result;
        result = false;
        if (this.getNewRecords().length || this.getModifiedRecords().length || this.getRemovedRecords().length || this.getUpdatedRecords().length) {
            result = true;
        }
        return result;
    }
});