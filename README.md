Library Management by JAVA
Project Description
This project is a state-driven Library Management System implemented in Java. It models the lifecycle of library books while incorporating design patterns such as Singleton, Observer, and State to ensure modular, efficient, and scalable design.

The system efficiently manages books, tracks their states, and logs state transitions using a centralized logger. Observers monitor book state changes dynamically, ensuring robust notification mechanisms.

Features
1. Design Patterns
Singleton:
LibraryLogger ensures a single instance for efficient and centralized logging.
Observer:
Observers (SourceObserver and DestObserver) track and log state transitions dynamically.
State:
Each book operates in distinct states (OnShelf, Borrowed, GotBack), with behavior defined per state.
2. State Transitions
Books transition through the following states:

OnShelf: The initial state of a book.
Borrowed: Book is issued to a user.
GotBack: Book is returned and ready to be shelved again.
Custom exceptions are used to handle invalid operations for specific states.

Class Overview
LibraryBook:
Core class representing a book. Manages state transitions and notifies observers.
LBState:
Interface for book states.
OnShelf, GotBack, Borrowed:
Concrete implementations of the state interface.
LibraryLogger:
Implements the Singleton pattern for logging system events.
Observer and Subject:
Interfaces for implementing the Observer pattern.
SourceObserver and DestObserver:
Concrete observers that track leaving and entering states.
Technologies Used
Java
Object-Oriented Design Principles
How to Run
see test case, use MAVEN 
run
"mvn test" to run
