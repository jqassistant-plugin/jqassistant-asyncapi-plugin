# `:AsyncAPI:Tag` Node

-> represents a tag object holding metadata.

## Properties

| Name          | Description            |
|---------------|------------------------|
| `name`        | name of the tag        |
| `description` | description of the tag |

## Relations

| Name                               | Target Label(s)                                                                                                                                            | Cardinality | Description                                                      |
|------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|------------------------------------------------------------------|
| `REFERS_TO_EXTERNAL_DOCUMENTATION` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]] <br/>/ [[Node - AsyncAPI Reference\|:AsyncAPI:Reference:ExternalDocumentation]] | 0..1        | property holding a link to an external documentation / reference |
