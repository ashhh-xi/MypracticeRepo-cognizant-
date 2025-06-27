--exercise 3-control procedures
--Scenario 1: ProcessMonthlyInterest for Savings Accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  -- Apply 1% interest to all Savings accounts
  UPDATE Accounts
  SET Balance = Balance * 1.01
  WHERE AccountType = 'Savings';
END;
/
--usage
BEGIN
  ProcessMonthlyInterest;
END;

/
--Scenario 2: UpdateEmployeeBonus by Department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department IN VARCHAR2,
  p_bonus_percent IN NUMBER
) IS
BEGIN
  -- Increase salary by bonus % for employees in the specified department
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus_percent / 100)
  WHERE Department = p_department;
END;
/
-- Usage Example:
BEGIN
  UpdateEmployeeBonus('IT', 10); -- Add 10% bonus to IT dept
END;
/
--Scenario 3: TransferFunds Between Two Accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) IS
  v_balance NUMBER;
BEGIN
  -- Check balance in source account
  SELECT Balance INTO v_balance
  FROM Accounts
  WHERE AccountID = p_from_account;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
  END IF;

  -- Deduct from source account
  UPDATE Accounts
  SET Balance = Balance - p_amount
  WHERE AccountID = p_from_account;

  -- Add to target account
  UPDATE Accounts
  SET Balance = Balance + p_amount
  WHERE AccountID = p_to_account;

END;
/
-- Usage Example:
BEGIN
  TransferFunds(1, 2, 100); -- Transfer $100 from Account 1 to Account 2
END;
/



