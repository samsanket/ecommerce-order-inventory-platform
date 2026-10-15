CREATE DATABASE order_db;
CREATE DATABASE inventory_db;
CREATE DATABASE payment_db;
CREATE DATABASE notification_db;
GRANT ALL PRIVILEGES ON DATABASE order_db TO ecommerce_user;
GRANT ALL PRIVILEGES ON DATABASE inventory_db TO ecommerce_user;
GRANT ALL PRIVILEGES ON DATABASE payment_db TO ecommerce_user;
GRANT ALL PRIVILEGES ON DATABASE notification_db TO ecommerce_user;
