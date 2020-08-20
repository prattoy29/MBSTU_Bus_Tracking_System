# MBSTU Bus Tracking System
## Introduction
The app is all about the buses of Mawlana Bhashani Science & Technology University. 
In this app, we’ve tried to solve a problem that’s been arising for long.
Mainly the system consists of two apps. One is for the drivers of the buses and the other one is for the ones who intend to receive the location data and encode the info into UI.
The driver app fetches the location data on its’ way and on the other end the student app pulls out the location from database and shows the result in the map.

## Workflow of the app
![Diagram](https://user-images.githubusercontent.com/30951026/90795670-25c7ae00-e330-11ea-80f7-ca657fc6563b.PNG)

## The Driver App Screenshots
![Driver_app](https://user-images.githubusercontent.com/30951026/90796220-d766df00-e330-11ea-9840-a62d39dc95de.PNG)

## The Student App Screenshots
![Student_1](https://user-images.githubusercontent.com/30951026/90796230-dafa6600-e330-11ea-93b5-f33e5c5eb945.PNG)

![Student_2](https://user-images.githubusercontent.com/30951026/90796245-dfbf1a00-e330-11ea-8725-70de6d7af9e3.PNG)

## Limitation of the system
* The driver app requires an android handset for all the drivers. If the drivers can’t have an android cellphone of their own or if they can’t be interested to use their phone for this purpose, then we can’t implement the system.
* The driver app requires location access all the time. We’ve tried to use the network provider in this case, but it wasn’t possible as the network provider authority doesn’t allow that. So, we have used GPS in the system which may drain battery sometimes and that is still a challenge for us.
