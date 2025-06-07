Feature: This page includes all the scenarios to execute API Requests

  Background:
    Given I set Request Specifications with API Key "reqres-free-v1"


  @GetAPI @APIRequests
  Scenario Outline: Get Response from getRequest
    Then I trigger get reqest for "<Request Type>"
    And I validate response
    Examples:
      | Request Type    |
      | List users      |
      | Single user     |
      | List Resource   |
      | Single Resource |

  @POST_API @APIRequests
  Scenario Outline: Trigger Post Request
    Then I trigger POST request for "<Request Name>" and "<Data>"
    And I validate response
    Examples:
      | Request Name | Data            |
      | Create       | morpheus,leader |


  @PUT_API @APIRequests
  Scenario Outline: Trigger Put Request
    Then I trigger PUT request for "<Request Name>" and "<Data>"
    And I validate response
    Examples:
      | Request Name | Data                    |
      | Put          | morpheus,zion assistant |
