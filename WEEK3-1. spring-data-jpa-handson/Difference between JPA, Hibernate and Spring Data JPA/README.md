# Difference between JPA, Hibernate, and Spring Data JPA

**JPA (Java Persistence API):**
- A specification (interface) for object-relational mapping (ORM) in Java.
- Defines standard APIs for persisting, retrieving, and managing data between Java objects and relational databases.
- Does not provide an implementation.

**Hibernate:**
- A popular ORM framework and the most widely used JPA implementation.
- Provides additional features beyond the JPA specification (e.g., caching, advanced mappings).
- Can be used directly or as a JPA provider.

**Spring Data JPA:**
- A Spring project that simplifies JPA-based data access layers.
- Provides repository abstractions, query methods, and reduces boilerplate code.
- Uses JPA (and typically Hibernate) under the hood.

## Summary Table
| Feature                | JPA                | Hibernate           | Spring Data JPA         |
|------------------------|--------------------|---------------------|-------------------------|
| Type                   | Specification      | Implementation      | Framework/Abstraction   |
| Provides API           | Yes                | Yes                 | Yes                     |
| Provides Implementation| No                 | Yes                 | No (uses JPA provider)  |
| Boilerplate Reduction  | No                 | Some                | Yes                     |
| Query Abstraction      | No                 | HQL/JPQL            | Method Names, @Query    | 