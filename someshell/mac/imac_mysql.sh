sudo chown -R xinsilinwang /usr/local/share/man/man8
chmod u+w /usr/local/share/man/man8
brew install mysql

brew services start mysql
mysql -u root

brew services info mysql

FLUSH PRIVILEGES;
ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';

CREATE USER 'lxx'@'%' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON *.* TO 'lxx'@'%';
FLUSH PRIVILEGES;


mysql_secure_installation
