/**
 * DeftJS Application class for the Phoenix application.
 */

Ext.define("AM.Application", {
    extend: "Deft.mvc.Application",
    requires: [
        "AM.config.AppConfig",
        "AM.view.Viewport",
        "AM.service.NotificationService",
        "AM.service.ScenarioService",
        "AM.context.ScenarioContext",
        "AM.store.FieldSearchType",
        "AM.store.FieldType",
        "AM.store.BlankType",
        "AM.store.HasSearchType",
        "AM.store.SettingStore"
    ],
    /**
     * init() runs when Ext.onReady() is called.
     */

    init: function ()
    {
        this.beforeInit();
        Deft.Injector.configure(this.buildInjectorConfiguration());
        Deft.promise.Deferred.enableLogging = false;
        return this.afterInit();
    },
    /**
     * @protected
     * Returns the configuration object to pass to Deft.Injector.configure(). Override in subclasses to alter the Injector configuration before returning the config object.
     * @return {Object} The Injector configuration object.
     */

    buildInjectorConfiguration: function ()
    {
        var config;
        config = {
            appConfig: {
                className: "AM.config.AppConfig",
                parameters: [
                    {
                        environment: AM.config.AppConfig.PRODUCTION_ENV
                    }
                ]
            },
            scenarioService: "AM.service.ScenarioService",
            scenarioContext: "AM.context.ScenarioContext",
            fieldSearchTypeStore: "AM.store.FieldSearchType",
            fieldTypeStore: "AM.store.FieldType",
            blankTypeStore: "AM.store.BlankType",
            hasSearchTypeStore: "AM.store.HasSearchType",
            settingStore: "AM.store.SettingStore",
            notificationService: "AM.service.NotificationService"
        };
        return config;
    },
    /**
     * @protected
     * Runs at the start of the init() method. Override in subclasses if needed.
     */

    beforeInit: function ()
    {
    },
    /**
     * @protected
     * Runs at the end of the init() method. Useful to create initial Viewport, start Jasmine tests, etc.
     */

    afterInit: function ()
    {
        Ext.tip.QuickTipManager.init();
        AM.config.AppConfig.MASK = new Ext.LoadMask(Ext.getBody(), { msg: "Waiting ..." });
        Ext.create("AM.view.Viewport");
        var delay;

        CodeMirror.commands.autocomplete = function (cm)
        {
            CodeMirror.showHint(cm, CodeMirror.hint.javascript);
        };
        AM.config.AppConfig.CODE_MIRROR_ADD = CodeMirror.fromTextArea(document.getElementById("pageAddId"), {
            lineNumbers: true,
            theme: "night",
            extraKeys: {
                "F11": function (cm)
                {
                    cm.setOption("fullScreen", !cm.getOption("fullScreen"));
                },
                "Esc": function (cm)
                {
                    if (cm.getOption("fullScreen"))
                    {
                        cm.setOption("fullScreen", false);
                    }
                }
            },
            extraKeys: { "Ctrl-Space": "autocomplete" }
        });
        AM.config.AppConfig.CODE_MIRROR_ADD.setSize(null, 600);
        AM.config.AppConfig.CODE_MIRROR_ADD.on("change", function ()
        {
            clearTimeout(delay);
            delay = setTimeout(updatePreviewAdd, 3000);
        });

        Ext.getCmp('centerId').setActiveTab('tabEditId');
        AM.config.AppConfig.CODE_MIRROR_EDIT = CodeMirror.fromTextArea(document.getElementById("pageEditId"), {
            lineNumbers: true,
            theme: "night",
            extraKeys: {
                "F11": function (cm)
                {
                    cm.setOption("fullScreen", !cm.getOption("fullScreen"));
                },
                "Esc": function (cm)
                {
                    if (cm.getOption("fullScreen"))
                    {
                        cm.setOption("fullScreen", false);
                    }
                }
            },
            extraKeys: { "Ctrl-Space": "autocomplete" }
        });
        AM.config.AppConfig.CODE_MIRROR_EDIT.setSize(null, 600);
        AM.config.AppConfig.CODE_MIRROR_EDIT.on("change", function ()
        {
            clearTimeout(delay);
            delay = setTimeout(updatePreviewEdit, 3000);
        });

        Ext.getCmp('centerId').setActiveTab('tabListId');
        AM.config.AppConfig.CODE_MIRROR_LIST = CodeMirror.fromTextArea(document.getElementById("pageListId"), {
            lineNumbers: true,
            theme: "night",
            extraKeys: {
                "F11": function (cm)
                {
                    cm.setOption("fullScreen", !cm.getOption("fullScreen"));
                },
                "Esc": function (cm)
                {
                    if (cm.getOption("fullScreen"))
                    {
                        cm.setOption("fullScreen", false);
                    }
                }
            },
            extraKeys: { "Ctrl-Space": "autocomplete" }
        });
        AM.config.AppConfig.CODE_MIRROR_LIST.setSize(null, 600);
        AM.config.AppConfig.CODE_MIRROR_LIST.on("change", function ()
        {
            clearTimeout(delay);
            delay = setTimeout(updatePreviewList, 1000);
        });
        Ext.getCmp('centerId').setActiveTab('tabAddId');
        AM.config.AppConfig.APP_LOAD_STATUS = true;
        AM.config.AppConfig.COOKIES.set('ViewType', 'Add');
        AM.config.AppConfig.CURRENT_EDITOR = AM.config.AppConfig.CODE_MIRROR_ADD;

        function updatePreviewAdd()
        {
            AM.config.AppConfig.MASK.show();
            Ext.Ajax.request({
                url: '/Connection/UpdateFile',
                params: {
                    type: 0,
                    tableName: AM.config.AppConfig.COOKIES.get('TableName'),
                    content: AM.config.AppConfig.CODE_MIRROR_ADD.getValue()
                },
                success: function (response, opts)
                {
                    AM.config.AppConfig.MASK.hide();
                    var previewFrame = document.getElementById('preview');
                    var preview = previewFrame.contentDocument || previewFrame.contentWindow.document;
                    preview.open();
                    preview.write('<iframe width="100%" height="600px" src="sourcegenerated/Temp/test/indexAdd' + AM.config.AppConfig.COOKIES.get('TableName') + '.html"></iframe>');
                    preview.close();
                },
                failure: function (response, opts)
                {
                    AM.config.AppConfig.MASK.hide();
                }
            });
        }

        function updatePreviewEdit()
        {
            AM.config.AppConfig.MASK.show();
            Ext.Ajax.request({
                url: '/Connection/UpdateFile',
                params: {
                    type: 1,
                    tableName: AM.config.AppConfig.COOKIES.get('TableName'),
                    content: AM.config.AppConfig.CODE_MIRROR_ADD.getValue()
                },
                success: function (response, opts)
                {
                    AM.config.AppConfig.MASK.hide();
                    var previewFrame = document.getElementById('preview');
                    var preview = previewFrame.contentDocument || previewFrame.contentWindow.document;
                    preview.open();
                    preview.write('<iframe width="100%" height="600px" src="sourcegenerated/Temp/test/indexEdit' + AM.config.AppConfig.COOKIES.get('TableName') + '.html"></iframe>');
                    preview.close();
                },
                failure: function (response, opts)
                {
                    AM.config.AppConfig.MASK.hide();
                }
            });
        }

        function updatePreviewList()
        {
            AM.config.AppConfig.MASK.show();
            Ext.Ajax.request({
                url: '/Connection/UpdateFile',
                params: {
                    type: 2,
                    tableName: AM.config.AppConfig.COOKIES.get('TableName'),
                    content: AM.config.AppConfig.CODE_MIRROR_ADD.getValue()
                },
                success: function (response, opts)
                {
                    AM.config.AppConfig.MASK.hide();
                    var previewFrame = document.getElementById('preview');
                    var preview = previewFrame.contentDocument || previewFrame.contentWindow.document;
                    preview.open();
                    preview.write('<iframe width="100%" height="600px" src="sourcegenerated/Temp/test/indexList' + AM.config.AppConfig.COOKIES.get('TableName') + '.html"></iframe>');
                    preview.close();
                },
                failure: function (response, opts)
                {
                    AM.config.AppConfig.MASK.hide();
                }
            });
        }
    }
});
