CREATE SCHEMA biblioteca;

USE biblioteca;

UPDATE usuario 
SET rol = 'ADMIN' 
WHERE email = 'admin@admin.com';