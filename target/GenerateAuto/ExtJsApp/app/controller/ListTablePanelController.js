Ext.define("AM.controller.ListTablePanelController", {
    extend: "AM.controller.AbstractController",
    control: {
        view: {
            live: true,
            boxready: "loadInitialData"
        }
    },
    init: function () {
        return this.callParent(arguments);
    },
    loadInitialData: function () {
        //alert(1);
    }
});
