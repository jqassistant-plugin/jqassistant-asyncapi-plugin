# `:AsyncAPI:Info` Node

-> represents the info object providing metadata about the API including title, version, description, terms of service,
contact information, license information, tags and a reference to an external documentation.

## Properties

| Name             | Description                      |
|------------------|----------------------------------|
| `title`          | title of the AsyncApi            |
| `version`        | version of the AsyncApi          |
| `description`    | description of the AsyncApi      |
| `termsOfService` | terms of service of the AsyncApi |

## Relations

| Name                               | Target Label(s)                                                                                                                                          | Cardinality | Description                                                      |
|------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|------------------------------------------------------------------|
| `INCLUDES_CONTACT`                 | [[Node - AsyncAPI Contact\|:AsyncAPI:Contact]]<br>                                                                                                       | 0..1        | property with contact information                                |
| `INCLUDES_LICENSE`                 | [[Node - AsyncAPI License\|:AsyncAPI:License]]                                                                                                           | 0..1        | property with license information                                |
| `HAS_TAG`                          | [[Node - AsyncAPI Tag\|:AsyncAPI:Tag]]                                                                                                                   | 0..*        | set of tags                                                      |
| `REFERS_TO_EXTERNAL_DOCUMENTATION` | [[Node - AsyncAPI ExternalDocumentation\|:AsyncAPI:ExternalDocumentation]]<br/>/[[Node - AsyncAPI Reference\|:AsyncAPI:Reference:ExternalDocumentation]] | 0..1        | property holding a link to an external documentation / reference |
