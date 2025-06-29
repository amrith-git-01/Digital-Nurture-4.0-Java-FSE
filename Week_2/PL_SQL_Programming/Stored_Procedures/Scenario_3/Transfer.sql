CREATE OR REPLACE PROCEDURE TransferFunds(p_from NUMBER, p_to NUMBER, 
p_amt NUMBER) IS 
  v_balance NUMBER; 
BEGIN 
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from; 
  IF v_balance >= p_amt THEN 
    UPDATE Accounts SET Balance = Balance - p_amt WHERE AccountID = p_from; 
    UPDATE Accounts SET Balance = Balance + p_amt WHERE AccountID = p_to; 
    COMMIT; 
  ELSE 
    DBMS_OUTPUT.PUT_LINE('Insufficient balance.'); 
  END IF; 
EXCEPTION 
  WHEN NO_DATA_FOUND THEN 
    DBMS_OUTPUT.PUT_LINE('One of the accounts does not exist.'); 
  WHEN OTHERS THEN 
    DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM); 
    ROLLBACK; 
END; 
/