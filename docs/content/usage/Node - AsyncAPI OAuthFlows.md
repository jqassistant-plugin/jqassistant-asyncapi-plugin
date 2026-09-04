# `:AsyncAPI:OAuthFlow` Node

-> holds all supported OAuth Flows

## Relations

| Name                      | Target Label(s)                                    | Cardinality | Description                                           |
|---------------------------|----------------------------------------------------|-------------|-------------------------------------------------------|
| `IMPLICIT_FLOW`           | [[Node - AsyncAPI OAuthFlow\|:AsyncAPI:OAuthFlow]] | 0..*        | configuration information for implicit flow           |
| `PASSWORD_FLOW`           | [[Node - AsyncAPI OAuthFlow\|:AsyncAPI:OAuthFlow]] | 0..*        | configuration information for password flow           |
| `CLIENT_CREDENTIALS_FLOW` | [[Node - AsyncAPI OAuthFlow\|:AsyncAPI:OAuthFlow]] | 0..1        | configuration information client credentials flow     |
| `AUTHORIZATION_CODE_FLOW` | [[Node - AsyncAPI OAuthFlow\|:AsyncAPI:OAuthFlow]] | 0..1        | configuration information for authorization code flow |
