BEGIN 
  FOR c IN (SELECT * FROM Customers) LOOP 
    IF c.Balance > 10000 THEN 
      UPDATE Customers 
      SET IsVIP = 'Y' 
      WHERE CustomerID = c.CustomerID; 
      DBMS_OUTPUT.PUT_LINE('Customer ' || c.Name || ' promoted to VIP.'); 
    END IF; 
  END LOOP; 
END;
/