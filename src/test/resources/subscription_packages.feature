Feature: Validate subscription packages on STC TV website

Scenario: Verify subscription packages for different countries
  Given I am on the STC TV subscriptions page
  When I select the country "SA"
  Then I should see the subscription packages with correct type, price and currency for "SA"

  Given I am on the STC TV subscriptions page
  When I select the country "Kuwait"
  Then I should see the subscription packages with correct type, price and currency for "Kuwait"

  Given I am on the STC TV subscriptions page
  When I select the country "Bahrain"
  Then I should see the subscription packages with correct type, price and currency for "Bahrain"