# PincodeApp
this is basic pincode fetching app:
1. fecting pincode with the city name
2. fetching city name and details with pincode

the app is in development stage.
the functionality will be added one by one.


log: 11-feb-2022 @deepaksolanki9759@gmail.com
Today, I added new branch "Serialized".
Serialization in java is way where we can can store class objects in file(.txt/.ser) to persist the data even when the application is closed.
Serialization is also used in API when connecting to databases.
The advantages of using Serialization is since we are working on static data(i.e. pincode list)(only perfoming read Operation) instead of connecting to database and quering result we can use objects which will make our application database independent.
So, we have to once connect to database to serialize our objects into file. After that we can use Serialize file to extract our objects.
Now, the Big Question what about seaching time complexity.
For optimising Search time we have used Tries. where Time complexity comes down to the length of the CITY String. (Its a very Efficient for Seaching Strings)
So, we dont have to go through 150 k lines to seach for one city pincode.
