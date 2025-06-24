Feature: NHS Job Search Functionality

  Scenario: Search job with preferences and sort by newest
    Given I am a jobseeker on NHS Jobs website
    When I put my preferences into the Search functionality
    Then I should get a list of jobs which matches my preferences
    And sort my search results with the newest Date Posted
