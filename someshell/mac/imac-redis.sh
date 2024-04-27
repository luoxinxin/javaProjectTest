  brew install redis

  brew services start redis

#  Or, if you don't want/need a background service you can just run:
    /usr/local/opt/redis/bin/redis-server /usr/local/etc/redis.conf