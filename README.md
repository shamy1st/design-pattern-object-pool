# Object Pool Design Pattern (Java)
**Object Pool** set of objects ready to use.
![](https://github.com/shamy1st/design-pattern-object-pool/blob/main/uml.png)
### Problem:
Database connection is costly, then we need to make a **JDBCConnectionPool**.

    public class Main {
        public static void main(String[] args) {
            JDBCConnectionPool pool = new JDBCConnectionPool(
                    "jdbc:mysql://localhost:3306/database_name?serverTimezone=UTC",
                    "user", "password");

            // Get a connection:
            Connection connection = (Connection) pool.checkOut();

            //Do some queries

            // Return the connection:
            pool.checkIn(connection);
        }
    }
### Solution:
![](https://github.com/shamy1st/design-pattern-object-pool/blob/main/uml-solution.png)
