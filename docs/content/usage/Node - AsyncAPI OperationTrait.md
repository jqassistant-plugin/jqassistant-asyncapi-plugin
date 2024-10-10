# `:AsyncAPI:OperationTrait` Node

-> represents a trait that can be applied to an operation

## Properties

| Name          | Description                             |
|---------------|-----------------------------------------|
| `title`       | title of the operation (human-friendly) |
| `summary`     | short summary of the operation          |
| `description` | detailed description of the operation   |

## Relations

| Name                               | Target Label(s)                                                            | Cardinality | Description                                                              |
|------------------------------------|----------------------------------------------------------------------------|-------------|--------------------------------------------------------------------------|
| `REFERS_TO_EXTERNAL_DOCUMENTATION` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]] | 0..1        | property holding a link to an external documentation                     |
| `HAS_TAG`                          | [[Node - AsyncAPI Tag\|:AsyncAPI:Tag]]                                     | 0..*        | tags for grouping/categorization of operations                           |
| `USING_SECURITY_SCHEME`            | [[Node - AsyncAPI SecurityScheme\|:AsyncAPI:SecurityScheme]]               | 0..1        | declaration of the security schemes of the operation                     |
| `HAS_BINDINGS`                     | [[Node - AsyncAPI OperationBindings\|:AsyncAPI:OperationBindings]]         | 0..1        | all specific definitions for each supported protocol `not yet supported` |

