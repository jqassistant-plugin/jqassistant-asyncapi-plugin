---
title: jQAssistant AsyncAPI  Plugin
---

# jQAssistant AsyncAPI Plugin

This is the AsyncAPI Plugin for [jQAssistant](https://jqassistant.org). It provides a scanner for AsyncAPI 3.0.0 files.

## Installation

To be able to use the plugin, it must be specified as a plugin to jQAssistant.
Additionally, it must be configured as a scan-include where jQAssistant can find the AsyncAPI-contracts.

```yaml
jqassistant:
  plugins:
    - group-id: org.jqassistant.plugin <1>
      artifact-id: jqassistant-asyncapi-plugin
      version: 1.0.0-M3
  scan:
    include:
      files:
        - asyncapi:contract::${project.basedir}/path/to/api.yml <2>
```
1. Dependency to the AsyncAPI plugin
2. Scan include of the AsyncAPI contract

## Usage

- [[Declaration Nodes]]

- [[Concepts & Constraints]]

## Development

- [[Codebase Layout]]

## Support

This plugin supports AsyncAPI files of specification version 3.0.0.
Due to this plugin still being in development, there is no support for json schema elements yet.

## References

This project utilizes usage of the work of [Springwolf](https://github.com/springwolf/springwolf-core).

This applies to most of the classes at src/main/java/org/jqassistant/plugin/asyncapi/impl/json,
which have been modified for own purposes. ***Thanks!***ed for own purposes. ***Thanks!***