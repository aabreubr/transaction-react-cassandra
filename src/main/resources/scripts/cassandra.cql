create keyspace react with replication={'class': 'SimpleStrategy', 'replication_factor': 3};
use react;
create table transaction(name text, status text, uuid text, primary key(name));
insert into transaction(name, status, uuid) values ('12313', 'PENDENTE', 'II2323RIUB3RB2BI-OEI2H3E2HEUHO');
