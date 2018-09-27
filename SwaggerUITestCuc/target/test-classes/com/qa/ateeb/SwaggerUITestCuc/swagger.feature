Feature: Testing SwaggerUI-hotels - 'http://localhost:8090/example/v1/hotels'

Scenario Outline: Test 'Post' requests using table
	Given a valid RequestSpec
	When a post request with city "<city>", description "<description>", id "<id>", name "<name>" and rating "<rating>" is sent
	Then the response will have Status Code of "<statusCode>"

	Examples:
	| city | description | id | name | rating | statusCode |
	| Manchester | cozy | 1 | Julio's | 2 | 201 |
	| Glasgow | stabby | 2 | Steve's | 1 | 201 |
	| York | castle | 3 | The King's Arms | 4 | 201 |

Scenario: Test 'Get all' request
	Given a valid RequestSpec
	When a get request is sent
	Then the response will have Status Code of 200

Scenario: Test 'Put' request
	Given a valid RequestSpec
	When a Put request is entered to update id 28's description
	Then the response will have Status Code of 204

Scenario Outline: Test 'Delete' request
	Given a valid RequestSpec
	When a Delete request is sent for id "<id>"
	Then the response will have Status Code of 204

	Examples:
	| id |
	| 58 |
	| 59 |
	| 60 |