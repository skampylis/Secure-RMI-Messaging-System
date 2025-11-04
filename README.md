# **Secure-RMI-Messaging-System**

## **Description**

A **Java** program that implements a messaging system using **Java RMI (Remote Method Invocation)** technology. Each user can create an account and exchange messages with other users. The system consists of a server that serves multiple clients simultaneously, and client applications that send requests to the server.

---

### 🚀 **Project Overview**

* **RMI Implementation**: Uses remote methods for communication between server and clients.
* **User Accounts**: Creation and management of authenticated users via `authToken`.
* **Message Exchange**: Incoming, read/unread messages, viewing, and deletion.

---

### 🔍 **Key Features**

* **Authentication**: Each user receives a unique `authToken` for login and interaction.
* **Full Message Management**: View inbox, read, and delete messages by ID.
* **Validation & Error Handling**: Checks username validity and message existence with proper error messages.

---

### 🛠️ **Technical Highlights**

* **Access Security**: All operations require an `authToken`, ensuring account protection against unauthorized access.
* **Client-Server System**: The server runs continuously, handling multiple client requests simultaneously.
* **Inbox Structure**: Messages are marked as *unread* until opened, maintaining read-status tracking.

---

### 📂 **Code Structure**

* **Client.java**: Client-side application. Accepts input through arguments, handles errors, and calls corresponding server functions based on FN_ID (1–6).
* **Server.java**: Server application. Listens on a specific port and handles multiple client requests concurrently.
* **MessagingInterface.java**: Remote interface defining the six main functions available to the client.
* **MessagingRemote.java**: Implementation of the remote interface. Handles authentication, interacts with the `Database`, and implements:

  * `CreateAccount` (account creation)
  * `ShowAccounts` (display all accounts)
  * `ShowInbox` (view messages)
  * `ReadMessage` (read message by ID)
  * `DeleteMessage` (delete message by ID)
* **Database.java**: Server-side account database. Manages a `HashMap` of `Account` objects, authentication checks, and message storage.
* **Account.java**: User account representation containing `username` and `messageBox` (list of `Message` objects).
* **Message.java**: Message model containing `sender`, `message`, `id`, and `isRead`, with functions for retrieving and updating read status.

---

**🏷️ Tags**: `Java`, `RMI`, `Messaging System`, `Client-Server`, `Distributed Systems`
**🌟 Concept**: *"A distributed messaging system designed to demonstrate Java RMI techniques, client-server architecture, and secure user data management."*
