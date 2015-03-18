Automated Application Security Scanning

Narrative: 
In order to protect user data
As an application owner
I want to ensure that the application does not suffer from common security vulnerabilities

Meta: @story app_scan @skip

GivenStories: navigate_app.story

Scenario: The application should not contain un-managed vulnerabilities
Meta: @id scan_sql_injection
Given a scanner with all policies disabled
And the URL regular expressions listed in the file: tables/exclude_urls.table are excluded from the scanner
And the SQL-Injection policy is enabled
And the attack strength is set to High
And the alert threshold is set to Medium
When the scanner is run
And false positives described in: tables/false_positives.table are removed
Then no Medium or higher risk vulnerabilities should be present


Scenario: The application should not contain Cross Site Scripting vulnerabilities
Meta: @id scan_xss @skip
Given a scanner with all policies disabled
And the URL regular expressions listed in the file: tables/exclude_urls.table are excluded from the scanner
And the Cross-Site-Scripting policy is enabled
And the attack strength is set to High
And the alert threshold is set to Medium
When the scanner is run
And false positives described in: tables/false_positives.table are removed
Then no Medium or higher risk vulnerabilities should be present


Scenario: The application should not contain path traversal vulnerabilities
Meta: @id scan_path_traversal @skip
Given a scanner with all policies disabled
And the URL regular expressions listed in the file: tables/exclude_urls.table are excluded from the scanner
And the Path-traversal policy is enabled
And the attack strength is set to High
And the alert threshold is set to Medium
When the scanner is run
And false positives described in: tables/false_positives.table are removed
Then no Medium or higher risk vulnerabilities should be present


Scenario: The application should not contain Server side include vulnerabilities
Meta: @id scan_ssi @skip
Given a scanner with all policies disabled
And the URL regular expressions listed in the file: tables/exclude_urls.table are excluded from the scanner
And the Server-side-include policy is enabled
And the attack strength is set to High
And the alert threshold is set to Medium
When the scanner is run
And false positives described in: tables/false_positives.table are removed
Then no Medium or higher risk vulnerabilities should be present


Scenario: The application should not contain external redirect vulnerabilities
Meta: @id scan_external_redirect @skip
Given a scanner with all policies disabled
And the URL regular expressions listed in the file: tables/exclude_urls.table are excluded from the scanner
And the External-redirect policy is enabled
And the attack strength is set to High
And the alert threshold is set to Medium
When the scanner is run
And false positives described in: tables/false_positives.table are removed
Then no Medium or higher risk vulnerabilities should be present
