 create keyspace react with replication={'class': 'SimpleStrategy', 'replication_factor': 3};
 use react;
 create table transaction(name text primary key, uuid text, status text);
