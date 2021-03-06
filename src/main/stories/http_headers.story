
Narrative: 
In order to protect my data
As a user
I want to verify that HTTP headers adequately protect my data from attackers 

Meta: @story http_headers

Scenario: Restrict other sites from placing it in an iframe in order to prevent ClickJacking attacks
Meta: @id headers_xframe_options @cwe-693-clickjack @browser_only
Given a new browser or client instance
When the secure base Url is accessed and the HTTP response recorded
Then the X-Frame-Options header is either SAMEORIGIN or DENY

Scenario: Enable built in browser protection again Cross Site Scriping
Meta: @id headers_xss_protection @cwe-693-x-xss-protection @browser_only
Given a new browser or client instance
When the secure base Url is accessed and the HTTP response recorded
Then the HTTP X-XSS-Protection header has the value: 1; mode=block

Scenario: Force the use of HTTPS for the base secure Url
Meta: @id headers_sts @cwe-693-strict-transport-security @browser_only
Given a new browser or client instance
When the secure base Url is accessed and the HTTP response recorded
Then the Strict-Transport-Security header is set

Scenario: Restrict HTML5 Cross Domain Requests to only trusted hosts
Meta: @id headers_cors @cwe-942-cors @browser_only
Given a new browser or client instance
When the secure base Url is accessed and the HTTP response recorded
Then the Access-Control-Allow-Origin header must not be: *

Scenario: Enable anti-MIME sniffing prevention in browsers
Meta: @id headers_nosniff @cwe-693-nosniff @browser_only
Given a new browser or client instance
When the secure base Url is accessed and the HTTP response recorded
Then the HTTP X-Content-Type-Options header has the value: nosniff