INSERT INTO oauth2_registered_client
(id, client_id, client_id_issued_at,
client_secret, client_secret_expires_at,
client_name, client_authentication_methods, authorization_grant_types,
redirect_uris, post_logout_redirect_uris,
scopes,
client_settings,
token_settings)
VALUES('1d0ae4d0-0ec5-4f64-92aa-db46d718ebae', 'oidc-client', '2024-03-28 15:20:33',
'{bcrypt}$2a$12$JXWB0VWkJEOIHerKzl279OhFGFaSHkNFjTK9UUhXUfV6FJGFaogL6', NULL,
'oidc-client', 'client_secret_post,client_secret_basic', 'refresh_token,client_credentials,authorization_code',
'http://127.0.0.1:8080/login/oauth2/code/oidc-client', 'http://127.0.0.1:8080/',
'openid,profile',
'{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}',
'{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,"settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],"settings.token.access-token-time-to-live":["java.time.Duration",300.000000000],"settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat","value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],"settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000],"settings.token.device-code-time-to-live":["java.time.Duration",300.000000000]}');
