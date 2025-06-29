BEGIN 
  FOR l IN (SELECT * FROM Loans WHERE EndDate <= SYSDATE + 30) LOOP 
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || l.LoanID || ' is due soon for Customer 
ID ' || l.CustomerID); 
  END LOOP; 
END; 
/