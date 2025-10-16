# MiniBankingSystem

**Tech Stack:** Java, Hibernate, MySQL, SHA-256

## Setup

1. Install Java 17+ and Maven.
2. Create a MySQL database named `bankdb` (or change the name in `hibernate.cfg.xml`).
3. Update `src/main/resources/hibernate.cfg.xml` with your MySQL credentials if needed.
   - Current username: `root`
   - Current password: `admin`
4. Build and run:
```bash
mvn clean package
mvn exec:java -Dexec.mainClass="com.bank.Main"
```

## GitHub
Suggested repo name: `MiniBankingSystem`

Commands to initialize & push:
```bash
git init
git add .
git commit -m "Initial commit: Mini Banking System (Hibernate + MySQL + SHA-256)"
git branch -M main
git remote add origin https://github.com/Muthu4742/MiniBankingSystem.git
git push -u origin main
```

## Notes
- `hibernate.hbm2ddl.auto` is set to `update` (creates/updates tables automatically).
- Passwords are stored as SHA-256 hashes (not salted in this simple example — consider using stronger hashing (bcrypt) and salting for production).
