Feature: Console logs in devtools

Scenario Outline: Verify Console errors
 
Given Browser is open and user navigate to "<w3website>"
Then get and verify console logs


Examples:
| w3website |
| https://www.w3.org/standards/webdesign/htmlcss |
| https://www.w3.org/standards/webofdevices/multimodal |
| https://www.w3.org/standards/badpage |



Scenario Outline: get response code
 
Given Browser is open and user navigate to "<w3website>"
Then get and verify response code "<w3website>"


Examples:
| w3website |
| https://www.w3.org/standards/webdesign/htmlcss |
| https://www.w3.org/standards/webofdevices/multimodal |
| https://www.w3.org/standards/badpage |




Scenario Outline: get all links
 
Given Browser is open and user navigate to "<w3website>"
Then get all links


Examples:
| w3website |
| https://www.w3.org/standards/webdesign/htmlcss |
| https://www.w3.org/standards/webofdevices/multimodal |
| https://www.w3.org/standards/badpage |

