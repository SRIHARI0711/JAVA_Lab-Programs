-- Create the database if it doesn't exist (SQL Server syntax)
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'Representative')
BEGIN
    CREATE DATABASE Representative;
END
GO

-- Switch to the Representative database
USE Representative;

-- Drop tables if they exist to avoid errors (optional, remove if not needed)
DROP TABLE IF EXISTS Cust;
DROP TABLE IF EXISTS Rep;

-- Create the Rep table
CREATE TABLE Rep (
    repno INT PRIMARY KEY,
    repname VARCHAR(50) NOT NULL,
    state VARCHAR(30),
    comm VARCHAR(30),
    rate VARCHAR(30)
);

-- Create the Cust table with foreign key to Rep
CREATE TABLE Cust (
    cust_no INT PRIMARY KEY,
    cust_name VARCHAR(50) NOT NULL,
    state VARCHAR(30),
    cred VARCHAR(30),
    repno INT,
    FOREIGN KEY (repno) REFERENCES Rep(repno)
);

-- Display tables to confirm creation
SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE';