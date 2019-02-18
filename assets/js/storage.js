/*jslint
   browser: true,
   devel: true,
   nomen: true
*/
/*global _ */

"use strict";

var Storage = (function () {
    /*
    var observers = {};

    function subscribe(key, observer) {
        if (!observers[key]) {
            observers[key] = [];
        }
        observers[key].push(observer);
    }

    function notify(key) {
        _.each(observers[key], function (observer) {
            observer(key);
        });
    }

    function onSomethingChange(observer) {
        subscribe("something", observer);
    }
    */

    function setGlotIOToken(token) {
        localStorage.setItem("glot-io-token", token);
    }

    function getGlotIOToken() {
        return localStorage.getItem("glot-io-token");
    }

    function getEditorFontSize() {
        var fs = localStorage.getItem("editor-font-size");
        if (fs) {
            return parseInt(fs, 10);
        }
        return 15;
    }

    function setEditorFontSize(size) {
        localStorage.setItem("editor-font-size", size);
    }

    return {
        setGlotIOToken: setGlotIOToken,
        getGlotIOToken: getGlotIOToken,
        getEditorFontSize: getEditorFontSize,
        setEditorFontSize: setEditorFontSize,
    };
}());