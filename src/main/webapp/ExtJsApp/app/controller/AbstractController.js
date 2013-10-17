Ext.define("AM.controller.AbstractController", {
  extend: "Deft.mvc.ViewController",
  inject: [
    "scenarioContext",
    "scenarioService",
    "notificationService"
  ],
  config: {
    scenarioContext: null,
    scenarioService: null,
    notificationService: null
  },
  init: function() {
    return this.callParent(arguments);
  }
});
