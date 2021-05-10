create keyspace react with replication={'class': 'SimpleStrategy', 'replication_factor': 3};
use react;
create table transaction(name text, uuid text, status text, primary key(name, uuid));
insert into transaction(name, uuid, status) values ('12313', 'II2323RIUB3RB2BI-OEI2H3E2HEUHO', 'PENDENTE');
insert into transaction(name, uuid, status) values ('12313', 'II2323RIUB3RB2BI-OOWEFUHMLLASO', 'PENDENTE');
