## Purpose

Set up Zuul to handle OAuth with Pivotal SSO tile, to ensure authentication before routing.

## Running Locally

1. Modify `application.yml` to use the `clientId` and `clientSecret` from your p-identity instance
1. Run `./run_all.sh`
1. Visit `localhost:8080` to view splash page
1. Visit `localhost:9999` to view simpleApp
1. Stop with `pkill java`  (Inelegant, but effective)

## Configuring Cloud Foundry

1. Modify the manifest files to:
    1. Rename your applications
    1. Bind to your SSO tile service from `zuul/manifest.yml`
1. Manage your SSO service instance:
    1. Include the following Auth Redirect URIs:
        * your zuul application base URL
        * `http://localhost:8080`
    1. Set System Permissions as `uaa.resource` and `openid` (necessary?)
    1. Set Auto-Approved Scopes to all (necessary?)
1. Add the `INTERNAL_APP_URL` environment variable to your Zuul application on PCF, with the URL of the SimpleApp application 

## Next Steps

1. Secure external application connection with SSL and/or basic auth
1. Make simpleApp a resource server and reject requests that are not authenticated
1. Make a single-page app that has some pages that require auth and some that do not