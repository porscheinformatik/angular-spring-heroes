import angularEslintPlugin from '@angular-eslint/eslint-plugin';
import angularTemplateEslintPlugin from '@angular-eslint/eslint-plugin-template';
import angularTemplateParser from '@angular-eslint/template-parser';
import path from 'node:path';
import tseslint from '@typescript-eslint/eslint-plugin';
import { fileURLToPath } from 'node:url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const angularRecommendedRules = Object.fromEntries(
  Object.entries(angularEslintPlugin.rules)
    .filter(([, rule]) => rule.meta?.docs?.recommended === 'recommended')
    .map(([name]) => [`@angular-eslint/${name}`, 'error']),
);

const angularTemplateRecommendedRules = Object.fromEntries(
  Object.entries(angularTemplateEslintPlugin.rules)
    .filter(([, rule]) => rule.meta?.docs?.recommended === 'recommended')
    .map(([name]) => [`@angular-eslint/template/${name}`, 'error']),
);

export default [
  {
    ignores: ['projects/**/*'],
    linterOptions: {
      reportUnusedDisableDirectives: 'off',
    },
  },
  ...tseslint.configs['flat/recommended'],
  {
    files: ['heroes-frontend/src/**/*.ts'],
    languageOptions: {
      parserOptions: {
        projectService: true,
        tsconfigRootDir: __dirname,
      },
    },
    plugins: {
      '@angular-eslint': angularEslintPlugin,
      '@angular-eslint/template': angularTemplateEslintPlugin,
    },
    processor: angularTemplateEslintPlugin.processors['extract-inline-html'],
    rules: {
      ...angularRecommendedRules,
      '@angular-eslint/prefer-on-push-component-change-detection': 'off',
      '@typescript-eslint/prefer-readonly': 'warn',
    },
  },
  {
    files: ['heroes-frontend/src/**/*.html'],
    languageOptions: {
      parser: angularTemplateParser,
    },
    plugins: {
      '@angular-eslint/template': angularTemplateEslintPlugin,
    },
    rules: angularTemplateRecommendedRules,
  },
];
