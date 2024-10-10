---
title: jQAssistant AsyncAPI  Plugin
---

# jQAssistant AsyncAPI Plugin

This is the AsyncAPI Plugin for [jQAssistant](https://jqassistant.org).

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

> [!INFO]
> List of links to notes that describe the various nodes, relations, properties, concepts, and constraints that the plugin provides.
> This section may also link to additional usage guides, examples, etc. that may be relevant for developers *using* this plugin.
> Notes that part of this section shall be placed in the `usage` directory

## Development

> [!INFO]
> This optional section may be used to link to notes describing the internal structure of the plugin. This may include any explanations that are relevant for (future) *developers of this plugin*.
> Notes that part of this section shall be placed in the `development` directory
