# GreenHouseApp

The purpose of the GreenHouseApp is to record and display temperature and humidity in a greenhouse, to make sure it's never too warm, cold, humid or dry.
Whenever the temperature or humidity fluxuates outside a given range, you get a notification so you can go and fix the problem inside the greenhouse. The GreenHouseApp was made for a school project, as part of the exam.


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

* Short introduction in the rest of the report, preferably with links to the
  other chapters. For example, "We propose an Internet-of-Things system using
  temperature and humidity sensors. First we describe the used
  protocols, ["theory and technology"]. Then we describe our work process
  in ["Methodology"]. Then the obtained [results] are presented, followed by
  [reflection and discussion of possible improvements]." Note: don't copy this
  text, write your own!
  
Our application will mainly work in greenhouses, where the need to constantly 
monitor the temperature and humidity is important. This is a task that traditionally
is incredibly tedious. But with the advancements in wireless technology, we can
develop sensors that record and transmit this information automatically. It's
important that greenhouses keep their temperature and humidity stable, as the range
of ideal temperature and humidity is 20-24 degrees and 80-95% respectively. (ref)
Our main target is greenhouses, but our solution could also be implemented into other 
domains and fields if needed. The sensor nodes can operate just as good in a house, 
office building or an engine room. This makes our application versatile, 
and viable choice for a broad customer base. 

In this report, we first dive in to the theory and technology that made the application
possible. Then we briefly explain the reasoning behind the temperature and humidity
ranges in domain knowledge, before talking about our work method and results, reflecting
on the finished product, as well as possible future implements to the project.


## Theory and Technology

Here you write about the "things" you have used in your project. At the same
time these are things that another person must know about to be able to
understand your project.  
Some principles to follow:

* Write about all the relevant theory, technologies and protocols that your
  project builds upon. For example, if you transfer data in JSON format using
  the HTTP protocol, you should mention this and other protocols that it depends
  on:
    * HTTP
    * JSON
    * TCP
    * IP
    * Ethernet or wireless protocols you have used (is it 802.11x or something
      else?)
* Remember to mention the "why" - how is this "thing" you write about relevant
  to your project? What does this protocol provide for your project? For
  example, if you mention TCP - how is it important for your project? What if
  you took away TCP, what would happen? What does TCP ensure for you?
* Assume that the reader is your peer student - a computer science bachelor
  student, midway through the study. Someone taking this course next year should
  be able to read your report and understand it.
* Don't go too deep. For example, you don't need to explain a lot of detail of
  object-oriented programming. Every computer science student should know what
  it is.
* Prefer short description of many protocols instead of deep description of few
  protocols.
* Are there any specific aspects which are relevant for your project? If not,
  don't describe those. For example, students sometimes spend several pages
  describing the different methods (GET, POST, PUT) of HTTP protocol. Is that
  important for your project? Do you use all these methods? If not, don't write
  about these.
* Is there any domain-knowledge the reader should know to understand the
  project? For example, if you are monitoring temperature in a greenhouse, what
  is known about it? Is the optimal temperature +20..30C, or is it -10..0C?
  
 ### DOMAIN KNOWLEGDE
 
 The optimal temperature for the greenhouses we aim to supply is around 20 degrees Celsius.
 This can fluctuate between 18 and 24 degrees, which is still acceptable. To regulate the 
 temperature you could use a greenhouse air conditioner, shaders to block out the sun, 
 ventilation system, misting or fogging. The ideal greenhouse humidity is around 80%. 
 This is where we achieve the highest growth rate for normal greenhouse plants. 
 To maintain and regulate the humidity you can use misting techniques or a humidifier.
  

# Methodology

The project was done in intervals, whenever we had periods of free time. Because of
other exams and deadlines, we didn't work on a organized week to week basic.
Most of the coding were done by two people, while the other two people did most of
the documentation. Much of the coding was a group effort, which according to the
commits is credited to one person at a time, while it actually was done by multiple
people in most instances.
The project didn't require any user tests or expirements, because the sensors are
entirely simulated. To be able to understand the results of the project, a basic
understanding of java programming is sufficient.


# Results

The application shows data from sensor readings, giving the user insight
to their greenhouse remotely. (screenshot of readings)

Each virtual sensor sends data to it´s own topic, using the mqtt publisher. To 
reviece the data from the mqtt broker, we use the mqttsubscriber. In our case 
the client handler is the mqttsubsciber (extension to the subscriber). The data
does not auto-update, because temperature and humidity would not change
drastically in a short amount of time - therefore, we decided that you only need
to press the button in our GUI once to get a one-time reading from the sensors.
Pressing the button again updates the readings, and prints the results to a
textarea.


# Discussion

Here you can reflect on the result. What is working well? What is not working
well and why?


# Conclusion and Future Work

** SHORT SUMMARY OF WORK DONE SO FAR **
The product we ended up with, is an application that shows you the readings from
the virtual sensors whenever you press the button to update the readings. The data
is generated from the program, sent to an MQTT broker, and then sent back, to be
displayed in the GUI.

For future work, we would like to develop an app that can run on mobile devices.
The app works great from a desktop with an IDE installed, but realistically,
the user wouldn't have a need to check temperature and humidity of their
greenhouse from a desktop every time. Ideally, they would check it on the
go, wherever they happen to be. The best solution for that problem is to
be able to use the GreenHouseApp from a mobile device.

We would also like to notify users whenever the sensor readings are outside
of the ideal range, but we didn't come up with a good solution for this.


# References

https://learn.eartheasy.com/articles/top-10-greenhouse-gardening-mistakes/

https://www.eclipse.org/paho/index.php?page=clients/java/index.php
