# GreenHouseApp

The purpose of the GreenHouseApp is to record and display temperature and humidity
in a greenhouse, to make sure it's never too warm, cold, humid or dry.
Whenever the temperature or humidity fluxuates outside a given range, you get a 
notification so you can go and fix the problem inside the greenhouse. The 
GreenHouseApp was made for a school project, as part of the exam.


## Abstract
Temperatures in Norway are fluxuating constantly. Mornings can be freezing cold,
but when the sun is out mid-day, it's suddenly warm. Growing your own plants can
be challenging when you constantly have to monitor the conditions for optimal
growth. In this project we propose a helpful application that monitors
temperature and humidity in a greenhouse. The idea is that when the application
is running, you have access to a constant stream of information regarding the
greenhouses condition. In our app, the information we care about is how hot it
is, and how humid it is - inside our greenhouse. 

The application shows readings from the sensors whenever the button is pressed,
updating every time you press the button.

Some possible future implementations we have considered are developing the
application for mobile devices and notifying the user whenever the data is out of 
the ideal range.

## Table Of Contents
* [Introduction](#Introduction)

* [Theory and Technology](#Theory-and-Technology)

* [Methodology](#Methodology)

* [Results](#Results)

* [Discussion](#Discussion)

* [Conclusion and Future Work](#Conclusion-and-Future-Work)

* [References](#References)


## Introduction
  
Our application will mainly work in greenhouses, where the need to constantly 
monitor the temperature and humidity is important. This is a task that traditionally
is incredibly tedious. But with the advancements in wireless technology, we can
develop sensors that record and transmit this information automatically. It's
important that greenhouses keep their temperature and humidity stable, as the range
of ideal temperature and humidity is 20-24 degrees and 80-95% *[respectively](https://learn.eartheasy.com/articles/top-10-greenhouse-gardening-mistakes/)*.
Our main target is greenhouses, but our solution could also be implemented into other 
domains and fields if needed. The sensor nodes can operate just as good in a house, 
office building or an engine room. This makes our application versatile, 
and viable choice for a broad customer base. 

In this report, we first dive in to the theory and technology that made the application
possible. Then we briefly explain the reasoning behind the temperature and humidity
ranges in domain knowledge, before talking about our work method and results, reflecting
on the finished product, as well as possible future implements to the project.


## Theory and Technology

### MQTT Broker

 An MQTT broker is a simple publish-subscribe, machine to machine network protocol, mainly
 used for message queuing service. In our case we publish and subscribe to two different 
 topics on the broker "tcp://129.241.152.12:1883". One for each sensor, 
 "group21/greenhouse/sensors/temperature" and "group21/greenhouse/sensors/humidity".

 MQTT stands for MQ telemetry transport. The protocol is basically a set of rules that 
 defines and decides how devices publishes and subscribes to data over the web. As seen 
 in the brokers address MQTT uses TCP to establish a connection between the sensors and 
 the MQTT broker.


  
### Domain Knowledge

 The optimal temperature for the greenhouses we aim to supply is around 20 degrees Celsius.
 This can fluctuate between 18 and 24 degrees, which is still acceptable. To regulate the 
 temperature you could use a greenhouse air conditioner, shaders to block out the sun, 
 ventilation system, misting or fogging. The ideal greenhouse humidity is around 80%. 
 This is where we achieve the highest growth rate for normal greenhouse plants. 
 To maintain and regulate the humidity you can use misting techniques or a humidifier.
  
### JavaFX

 To present the data to the user we created a JavaFX application where the user can fetch
 the data and read it. We used Scene Builder to make the FXML files that we later 
 implemented in the application. This saved us the tedious work of having to manually code
 the size and appearance of the button and textarea, as well as visualise the design for us.


### TCP/IP
  
  *[TCP/IP](https://www.fortinet.com/resources/cyberglossary/tcp-ip)* is a set of protocols that acts as a framework for organizing connection between servers. 
  It consist of the following two protocols:
  
  IP (Internet Protocol) makes it possible to connect different underlying networks to a common 
  logical network. The underlying networks can be based on different technologies.
  
  TCP (Transmission Control Protocol) is a protocol that ensures reliable transport
  of data signals between user programs that communicate via the logical network.
  
### Data Simulation
 The two sensors are simulated with virtual data. To provide realistic data a max and min double
 are set for both the temperature and humidity sensor. Random data between those limits are 
 provided to the server. To make the data consistant around the most realistic temperature and 
 humidity, a normal number is set. The data provided from the simulation will be close to the 
 normal constribution with the help of a random delta. Generated by this formula 
 (max - min) / 50.0.
  
# Methodology

The project was done in intervals, whenever we had periods of free time. Because of other exams
and deadlines, we didn't work on a organized week to week basic. Most of the coding were done by
two people, while the other two people did most of the documentation. Much of the coding was a 
group effort, which according to the commits is credited to one person at a time, while it 
actually was done by multiple people in most instances. The project didn't require any user tests
or expirements, because the sensors are entirely simulated. We still experimented with a lot of 
different solutions, most of which we could not make work, meaning we didn???t even have anything 
to commit. Multiple meetings were had with no concrete progress to show, but every time we got 
together and worked we came closer to understanding enough to create an end result. For other 
students or peers be able to understand the results of the project, a basic understanding of 
Java programming and Java FX is sufficient.


# Results

The application shows a stream of sensor readings, giving the user insight
to their greenhouse remotely. <img width="678" alt="Skjermbilde greenhouseapp" src="https://user-images.githubusercontent.com/102230830/205992480-7f788379-a424-4c2a-8710-57b49abf7168.PNG">


Each virtual sensor sends data to it??s own topic, using the mqtt publisher. To 
reviece the data from the mqtt broker, we use the mqttsubscriber. In our case 
he client handler is the *[mqttsubsciber](https://www.eclipse.org/paho/index.php?page=clients/java/index.php)* (extension to the subscriber). The data
does not auto-update, because temperature and humidity would not change
drastically in a short amount of time - therefore, we decided that you only need
to press the button in our GUI once to get a one-time reading from the sensors.
Pressing the button again updates the readings, and prints the results to a
textarea.


# Discussion

We have made a well-functioning application that serves it purpose. The code we 
have written has been documented and cleaned up making it clear and concise to 
read, as well as do further work on. The teamwork has been great, we have 
enjoyed each others company and the time spent together. During the duration of
this project, we have had a healthy mix of fun and serious. From the start of 
the project our conversations have been open, and everyone has had a say in the
groups decisions. The amount of work in this project has been extensive. We have
solved this by delegating the work mass between the group members. While 
delegating the work we took the following into consideration: preferences, 
strengths, weaknesses and convenience.

Our time management have been sporadic due to more pressing deadlines and exams.
We have often not found time to work on this project due to these reasons. Due
to our sporadic work times this has affected our efficiency because we had to 
catch up to what we were working on last time every time we met to work on the
project. Notably, we did meet up to work multiple times without any commits. 
Sometimes we would spend time working on solutions that did not work, and 
other times we would simply spend time trying to understand how to implement 
possible solutions.


# Conclusion and Future Work

The product we ended up with, is an application that shows you the readings from
the virtual sensors whenever you press the button to update the readings. The data
is generated from the program, sent to an MQTT broker, and then sent back, to be
displayed in the GUI. You can then continue pressing the button to keep updating 
the readings, giving you constant access to the data, remotely.

For future work, we would like to develop an app that can run on mobile devices.
The app works great from a desktop with an IDE installed, but realistically,
the user wouldn't have a need to check temperature and humidity of their
greenhouse from a desktop every time. Ideally, they would check it on the
go, wherever they happen to be. The best solution for that problem is to
be able to use the GreenHouseApp from a mobile device. Also, we would like to
implement better security features. As of now, all you have to do is to start 
the application to get the data displayed. In the future we would implement a
login page, to prevent unauthorized users to access the data

We would also like to notify users whenever the sensor readings are outside
of the ideal range, but we didn't come up with a good solution for this. We imagine
a push notification on your mobile device would be perfect for the intendended use
of this application.

# References

https://learn.eartheasy.com/articles/top-10-greenhouse-gardening-mistakes/

https://www.eclipse.org/paho/index.php?page=clients/java/index.php

https://www.fortinet.com/resources/cyberglossary/tcp-ip
