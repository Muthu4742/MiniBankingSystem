# 🏦 Mini Banking System

A console-based banking system built using **Java, JDBC, and MySQL**.  
This project demonstrates core Java concepts, object-oriented programming, database connectivity, and secure coding practices like password hashing.

---

## ⚙️ Features

- 🧾 User account management (Create, View, Update, Delete)
- 💰 Banking operations: Deposit, Withdraw, Transfer, Check Balance
- 🔐 Password hashing using SHA-256 for secure credential storage
- 🧩 DAO (Data Access Object) pattern for clean database access
- 💻 Menu-driven console interface using Java

---

## 🧠 Tech Stack

- Java (Core Java, OOP)
- JDBC (Database connectivity)
- MySQL (Data storage)
- MySQL Workbench / XAMPP (for local database)
- Eclipse / IntelliJ / VS Code (IDE)

---

## 📂 Project Structure

```
MiniBankingSystem/
│
├── src/
│   ├── MiniBankingSystem/
│   │   ├── MainMenu.java       # Menu-driven UI
│   │   ├── User.java            # POJO class for user data
│   │   ├── UserDAO.java         # Handles all database operations
│   │   ├── SecurityUtil.java    # Password hashing logic
│
├── README.md
```

---

## 🗄️ Database Setup

1. Create a MySQL database named `bankserver`.
2. Create a table `user`:

```sql
CREATE TABLE user (
    acc_no VARCHAR(20) PRIMARY KEY,
    username VARCHAR(50),
    password_hash VARCHAR(256),
    full_name VARCHAR(100),
    email VARCHAR(100),
    balance DOUBLE DEFAULT 0
);
```

3. Update your database connection in `UserDAO.java`:
```java
private final String URL = "jdbc:mysql://localhost:3306/bankserver";
private final String USER = "root";
private final String PASS = "admin";
```

---

## ▶️ How to Run

1. Clone this repository  
   ```bash
   git clone https://github.com/YourUsername/MiniBankingSystem.git
   ```
2. Open it in your IDE (Eclipse / IntelliJ / VS Code).
3. Add MySQL JDBC driver to your classpath.
4. Run `MainMenu.java` and follow the console menu.

---

## 📌 Future Enhancements

- Add a GUI using Java Swing
- Implement user login system
- Add email verification
- Build a web version using Servlets and JSP

---

## ✍️ Author

**Muthuraja Alagudurai**  
📧 [Muthuraja4742@gmail.com](mailto:Muthuraja4742@gmail.com)  
🔗 [LinkedIn](https://www.linkedin.com/in/muthuraja4742)  
🔗 [GitHub](https://github.com/Muthu4742)
