# `:AsyncAPI:OAuthFlow` Node

-> represents a trait applicable to a Message Object

## Properties

| Name               | Description                                                                               |
|--------------------|-------------------------------------------------------------------------------------------|
| `authorizationUrl` | `required`:   authorization url                                                           |
| `tokenUrl`         | `required`:   token url                                                                   |
| `refreshUrl`       | url for receiving refresh tokens                                                          |
| `availableScopes`  | `required`: map between available scope names and a short description `not yet supported` |
