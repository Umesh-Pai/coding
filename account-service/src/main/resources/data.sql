insert into account(Account_ID, Account_Number, User_ID, Account_Name, Account_Type, Currency, Available_Balance, Balance_Date)
values(200001, 10001590, 'user001', 'AUSavings590', 'Savings', 'AUD', 1000.00, TO_DATE('10/10/2020', 'DD/MM/YYYY'));
insert into account(Account_ID, Account_Number, User_ID, Account_Name, Account_Type, Currency, Available_Balance, Balance_Date)
values(200002, 10001690, 'user001', 'SGCurrent690', 'Current', 'SGD', 2000.00, TO_DATE('10/10/2020', 'DD/MM/YYYY'));
insert into account(Account_ID, Account_Number, User_ID, Account_Name, Account_Type, Currency, Available_Balance, Balance_Date)
values(200003, 10001790, 'user001', 'AUSavings790', 'Savings', 'AUD', 3000.00, TO_DATE('10/10/2020', 'DD/MM/YYYY'));
insert into account(Account_ID, Account_Number, User_ID, Account_Name, Account_Type, Currency, Available_Balance, Balance_Date)
values(200004, 10002590, 'user002', 'AUSavings590', 'Savings', 'AUD', 1000.00, TO_DATE('10/10/2020', 'DD/MM/YYYY'));
insert into account(Account_ID, Account_Number, User_ID, Account_Name, Account_Type, Currency, Available_Balance, Balance_Date)
values(200005, 10002690, 'user002', 'SGCurrent690', 'Current', 'SGD', 1500.00, TO_DATE('10/10/2020', 'DD/MM/YYYY'));
insert into account(Account_ID, Account_Number, User_ID, Account_Name, Account_Type, Currency, Available_Balance, Balance_Date)
values(200006, 10003590, 'user003', 'AUSavings590', 'Savings', 'AUD', 2000.00, TO_DATE('10/10/2020', 'DD/MM/YYYY'));
insert into account(Account_ID, Account_Number, User_ID, Account_Name, Account_Type, Currency, Available_Balance, Balance_Date)
values(200007, 10003690, 'user003', 'SGCurrent690', 'Current', 'SGD', 2500.00, TO_DATE('10/10/2020', 'DD/MM/YYYY'));

insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10001, 10001590, TO_DATE('1/10/2020', 'DD/MM/YYYY'), 100.00, 'Debit', 'Myki Transaction');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10002, 10001590, TO_DATE('5/10/2020', 'DD/MM/YYYY'), 200.00, 'Credit', 'ANZ Salary');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10003, 10001690, TO_DATE('2/10/2020', 'DD/MM/YYYY'), 150.00, 'Debit', 'Amazon Australia');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10004, 10001690, TO_DATE('4/10/2020', 'DD/MM/YYYY'), 250.00, 'Credit', 'Ikea Refund');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10005, 10001790, TO_DATE('3/10/2020', 'DD/MM/YYYY'), 170.00, 'Debit', 'Starbucks');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10006, 10001790, TO_DATE('5/10/2020', 'DD/MM/YYYY'), 270.00, 'Credit', 'Credit Interest');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10007, 10002590, TO_DATE('6/10/2020', 'DD/MM/YYYY'), 150.00, 'Debit', 'Hoyts');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10008, 10002590, TO_DATE('8/10/2020', 'DD/MM/YYYY'), 250.00, 'Credit', 'ANZ Salary');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10009, 10003690, TO_DATE('7/10/2020', 'DD/MM/YYYY'), 160.00, 'Debit', 'Hoyts');
insert into TRANSACTION(Transaction_ID, Account_Number, Value_Date, Transaction_Amount, Transaction_Type, Transaction_Narrative)
values(10010, 10003690, TO_DATE('9/10/2020', 'DD/MM/YYYY'), 260.00, 'Credit', 'Amazon Australia Refund');
