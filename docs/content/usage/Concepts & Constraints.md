| Concepts                                                           |                                                                                                                                                      |
| ------------------------------------------------------------------ |------------------------------------------------------------------------------------------------------------------------------------------------------|
| [[Concept - ChannelMapsToChannel\|ChannelMapsToChannel]]           | Merges channel descriptors with the same address (e.q. in different files) by a `:MAPS_TO` relation.                                                   |
| [[Concept - OperationSendsToOperation\|OperationSendsToOperation]] | Merges sending operations to the receiving operation.                                                                                                |
| [[Concept - ReferenceResolvesToTarget\|ReferenceResolvesToTarget]] | Creates a `:RESOLVES_TO` relation between a reference object and the actual, referenced object (which is not a Reference itself) over any path length. |


| Constraints                                                                 |                                                                                                                             |
| --------------------------------------------------------------------------- |-----------------------------------------------------------------------------------------------------------------------------|
| [[Constraint - ReferenceChainsMustBeLimited\|ReferenceChainsMustBeLimited]] | Reference chains must not contain more than one reference. <br/> Therefore, references must not reference other references. |



