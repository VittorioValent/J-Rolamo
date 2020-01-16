import { Rule, SchematicContext, Tree, url, apply, template, mergeWith } from '@angular-devkit/schematics';
import { Schema } from './schema';
import { strings } from '@angular-devkit/core';

export function viewTtorio(_options: Schema): Rule {
  return (tree: Tree, _context: SchematicContext) => {
    const sourceTemplate = url('./files');
    const sourceParametrizedTemplates = apply(sourceTemplate, [
      template({
        ..._options,
        ...strings
      })
    ]);

    return mergeWith(sourceParametrizedTemplates)(tree, _context);
  };
}
