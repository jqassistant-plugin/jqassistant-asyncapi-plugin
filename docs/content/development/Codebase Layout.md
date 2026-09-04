---
title: jQAssistant AsyncAPI  Plugin
---
# Codebase Layout
The codebase of the plugin is structured the following way:
- `docs/`: contains the documentation you're reading right now - *Thanks!*
-  `src/`: contains the Java-based jQA-Plugin 
   - `main/`: implementation of the jQA-Plugin
      - `java/org/jqassistant/plugin/asyncapi/api`:  AsyncAPI scope and all Descriptor interfaces
      - `java/org/jqassistant/plugin/asyncapi/impl/json`:  POJOs that model the elements of an AsyncAPI contract (utilizing usage of the work of [Springwolf](https://github.com/springwolf/springwolf-core) - *Thanks!*
      - `java/org/jqassistant/plugin/asyncapi/impl/mapper`:  MapStruct-based mappers and resolvers for POJO-to-Descriptor Mappings (*contains main logic of the plugin*)
         - `decorator`: Decorators for setting AsyncAPI elements' path names to Descriptors
   - `test`: integration tests for th jQA-Plugin