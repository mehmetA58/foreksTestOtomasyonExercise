@foreks
Feature:Foreks Digital Test Automation Exercise

  Scenario: Varantlar tabında  sıralamaları dogrula

    Given Kullanici aplikasyonu telefona kurar
    When  kullanici Varant Tabina tiklar
    When  kullanici yukselenler-dusenler subtabina tiklar
    Then  kullanici yukselenler icin siralamanin dogrulugunu test eder
    When  kullanici dusenler subtabina tiklar
    Then  kullanici dusenler icin siralamanin dogrulugunu test eder
    And   kullanici aplikasyonu kapatir
