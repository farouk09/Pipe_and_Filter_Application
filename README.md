# Pipe_and_Filter_Application

C'est une application programmée en JAVA pour une vidéothèque (magasin de vente de films, jeux...) implémentée avec une architecture Pipe & Filter. Les filtres sont les classes : GUI (JavaFX), QueryProcessor et TransactionProcessor (GUI | QueryProcessor | TransactionProcessor | GUI... cyclique). Le pipe est implémenté par le biais d'une file de chaines de caractères pour stocker les messages entre filtres et notifier le prochain pour faire son traitement.

It is an application programmed in JAVA for a video library (store selling films, games ...) implemented with a Pipe & Filter architecture. The filters are the classes: GUI (JavaFX), QueryProcessor and TransactionProcessor (GUI | QueryProcessor | TransactionProcessor | GUI ... cyclic). The pipe is implemented through a queue of strings to store messages between filters and notify the next one to do its processing.


java application of the manage a rental store movies and computer games with a pipe and Filter architecture

the functionalities of the application:
-  What are all the films in which an actor has played?
given?
-  Is there a game or movie with a given title that is
available for hire
-  What are all the films that a particular client has rented, with
their due dates?
-  What is a customer's account balance and what are all
overdue articles?
-  Rent and deliver an item by a customer
-  Add fines to your balance (late payment penalties)
-  Add an item to the stock and update the catalog
-  Add a customer
