/*
 ** jQuery Form Plugin
 *	Author: Raunak Shakya
 *	Email: rkshakya99@gmail.com
 */

;(function ($) {

    var FORM_METHOD_POST = "POST";

    var defaults = {
        name: "",
        ajaxOptions: {
            url: "",
            type: FORM_METHOD_POST,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        },
        title: "",
        fields: [],
        submitLabel: "Submit",
        labelDivClass: "inputLabel",
        inputDivClass: "inputElement",
        submitButtonClass: "inputSubmit",
        /*created: function () {
         },*/
        successMessage: "Thanks for your time, form submitted successfully!",
        successClass: null,
        errorMessage: "Thanks for your time, unfortunately error occurred!",
        errorClass: null
    };

    function Form(element, options) {
        var widget = this;

        widget.settings = $.extend(true, {}, defaults, options);
        widget.element = element;

        widget.element.on("submit", function (e) {
            e.preventDefault();
            console.log("submitting form...");

            //console.log(widget.element);
            var dataObj = {
                    data: JSON.stringify({name: "Raunak"}) // TODO(RS) get form data
                },
                ajaxSettings = $.extend({}, widget.settings.ajaxOptions, dataObj);

            $.ajax(ajaxSettings).done(function (response) {
                doCallback(widget.element, widget.settings.successMessage, widget.settings.successClass);
            }).fail(function (response) {
                var returnVal = widget.element.triggerHandler("responseerror.form", response);
                if (returnVal != false) {
                    doCallback(widget.element, widget.settings.errorMessage, widget.settings.errorClass);
                }
            });

        });

        $.each(widget.settings, function (key, val) {
            if (typeof val == "function") {
                widget.element.on(key + ".form", function (e, params) {
                    val(e, widget.element, params);
                });
            }
        });

        this.init();
    }

    function getFormData(form) {

        var unindexed_array = form.serializeArray();
        var indexed_array = {};

        jQuery.map(unindexed_array, function (n, i) {
            indexed_array[n['name']] = n['value'];
        });

        return indexed_array;
    }

    function doCallback(element, message, classname) {
        element.find("form").remove();

        element.append($("<p/>", {
            text: message,
            "class": classname
        }));
    }

    Form.prototype.init = function () {

        var settings = this.settings;

        $("<h1/>", {
            text: settings.title
        }).appendTo(this.element);

        $("<hr/>").appendTo(this.element);

        var form = $("<form/>", {
            id: settings.name,
            name: settings.name
        }).appendTo(this.element);

        for (var i = 0; i < settings.fields.length; i++) {
            var inputGroup = $("<div/>").addClass("inputGroup");

            var inputLabelDiv = $("<div/>").addClass(settings.labelDivClass);
            $("<label/>", {
                text: settings.fields[i].label + ": "
            }).appendTo(inputLabelDiv);

            var inputElementDiv = $("<div/>").addClass(settings.inputDivClass);
            $("<input/>", {
                name: "input" + settings.fields[i].label.replace(/ /g, ""),
                type: settings.fields[i].type
            }).appendTo(inputElementDiv);

            inputLabelDiv.appendTo(inputGroup);
            inputElementDiv.appendTo(inputGroup);

            inputGroup.appendTo(form);
        }

        var submitButtonDiv = $("<div/>").addClass("inputGroup");
        $("<button/>", {
            text: settings.submitLabel,
            name: "inputSubmitButton",
            "class": settings.submitButtonClass
        }).appendTo(submitButtonDiv);

        submitButtonDiv.appendTo(form);

        //this.element.trigger("created.form");

    };

    $.fn.form = function (options) {
        return new Form(this, options);
    }

}(jQuery));