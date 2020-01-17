"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const schematics_1 = require("@angular-devkit/schematics");
const core_1 = require("@angular-devkit/core");
// You don't have to export the function as default. You can also have more than one rule factory
// per file.
function service(_options) {
    return (tree, _context) => {
        const sourceTemplate = schematics_1.url("./files");
        const sourceParametrizedTemplates = schematics_1.apply(sourceTemplate, [
            schematics_1.template(Object.assign({}, _options, core_1.strings))
        ]);
        return schematics_1.mergeWith(sourceParametrizedTemplates)(tree, _context);
    };
}
exports.service = service;
//# sourceMappingURL=index.js.map