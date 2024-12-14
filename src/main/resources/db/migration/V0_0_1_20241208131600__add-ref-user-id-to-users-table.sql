-- add ref_user_id after id column
ALTER TABLE users
ADD COLUMN ref_user_id INT AFTER id;