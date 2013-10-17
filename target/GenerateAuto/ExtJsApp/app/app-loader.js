Ext.Loader.setConfig({
  enabled: true,
  paths: {
    "AM": "ExtJsApp/app"
  }
});

Ext.syncRequire(["Ext.Component", "Ext.ComponentManager", "Ext.ComponentQuery"]);
