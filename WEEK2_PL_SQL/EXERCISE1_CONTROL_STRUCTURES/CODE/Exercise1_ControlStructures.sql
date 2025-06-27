-- Create Tables
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER(10,2),
    LastModified DATE,
    IsVIP CHAR(1) DEFAULT 'N'
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR2(20),
    Balance NUMBER(10,2),
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT,
    TransactionDate DATE,
    Amount NUMBER(10,2),
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount NUMBER(10,2),
    InterestRate NUMBER(5,2),
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER(10,2),
    Department VARCHAR2(50),
    HireDate DATE
);

-- Insert Sample Data
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'), 1000, SYSDATE, 'N');
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20','YYYY-MM-DD'), 1500, SYSDATE, 'N');
INSERT INTO Customers VALUES (3, 'Elder Sam', TO_DATE('1950-01-01','YYYY-MM-DD'), 8000, SYSDATE, 'N');
INSERT INTO Customers VALUES (4, 'Richie Rich', TO_DATE('1980-05-05','YYYY-MM-DD'), 20000, SYSDATE, 'N');

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans VALUES (1, 1, 5000, 5.00, SYSDATE, ADD_MONTHS(SYSDATE, 60));
INSERT INTO Loans VALUES (2, 3, 7000, 6.50, SYSDATE, SYSDATE + 15);  -- Due soon
INSERT INTO Loans VALUES (3, 4, 15000, 4.50, SYSDATE, SYSDATE + 40); -- Not due soon

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15','YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20','YYYY-MM-DD'));

SET SERVEROUTPUT ON;

--exercise 1 
-- Scenario 1: Apply Interest Discount for Customers Over 60

BEGIN
  FOR rec IN (
    SELECT l.LoanID, l.InterestRate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE MONTHS_BETWEEN(SYSDATE, c.DOB)/12 > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = rec.InterestRate - 1
    WHERE LoanID = rec.LoanID;
  END LOOP;
END;
/
--Verify the Results
-- Check loan interest
SELECT LoanID, InterestRate FROM Loans;

-- Check VIPs
SELECT Name, IsVIP FROM Customers;

-- Loan due reminders
SELECT l.LoanID, c.Name, l.EndDate
FROM Loans l
JOIN Customers c ON l.CustomerID = c.CustomerID
WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

--Scenario 2: Promote Customers to VIP Based on Balance
-- Start the PL/SQL block
BEGIN

  -- Loop through all customers who have a balance greater than $10,000
  FOR rec IN (
    SELECT CustomerID
    FROM Customers
    WHERE Balance > 10000
  ) LOOP

    -- Update the IsVIP flag to 'Y' for qualifying customers
    UPDATE Customers
    SET IsVIP = 'Y'
    WHERE CustomerID = rec.CustomerID;

  END LOOP;

-- End the PL/SQL block
END;
/
--verify results 
SELECT Name, Balance, IsVIP FROM Customers;
--Scenario 3: Send Loan Due Reminders Within 30 Days 
-- Enable output to see printed reminders
SET SERVEROUTPUT ON;

-- Start the PL/SQL block
BEGIN

  -- Loop through all loans that are due within the next 30 days
  FOR rec IN (
    SELECT l.LoanID, c.Name AS CustomerName, l.EndDate
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP

    -- Print a reminder message for each qualifying loan
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Loan ID ' || rec.LoanID ||
      ' for customer ' || rec.CustomerName ||
      ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD')
    );

  END LOOP;

-- End the PL/SQL block
END;
/
--verify results 
SELECT * FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;


