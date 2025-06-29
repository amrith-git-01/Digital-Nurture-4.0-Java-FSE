BEGIN 
  FOR c IN (SELECT * FROM Loans L JOIN Customers C ON L.CustomerID = 
C.CustomerID) LOOP 
    IF MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60 THEN 
      UPDATE Loans 
      SET InterestRate = InterestRate - 1 
      WHERE LoanID = c.LoanID; 
    END IF; 
  END LOOP; 
END;
/