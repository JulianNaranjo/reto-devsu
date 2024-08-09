## Conclusions

Performing a manual exploratory test to see the requested flow, some errors are found within the application that are not part of the automated test, such as:
- Programming variables visible in the UI, such as the description of one of the products "carry.allTheThings() with the sleek, streamlined Sly Pack that melds"
- Additionally, when the buyer's information is filled in, there is no number validation for the first and last name.

## Comments
- Most locators had unique IDs, which made it easy to implement them in the code.
- In general terms the flow seemed quite simple to me, so I tried to implement a framework as complete as possible from the structure and parameterizing as many things as possible.
- No comments were included, we tried to make the classes and methods as understandable as possible