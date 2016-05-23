drop table IF EXISTS Batch_JOB_EXECUTION_CONTEXT;
drop table IF EXISTS Batch_JOB_EXECUTION_PARAMS;
drop table IF EXISTS Batch_JOB_EXECUTION_SEQ;
drop table IF EXISTS Batch_JOB_SEQ;
drop table IF EXISTS Batch_STEP_EXECUTION_CONTEXT;
drop table IF EXISTS Batch_STEP_EXECUTION_SEQ;
drop table IF EXISTS Batch_STEP_EXECUTION;
drop table IF EXISTS Batch_JOB_EXECUTION;
drop table IF EXISTS Batch_JOB_INSTANCE;
DROP TABLE IF EXISTS people;
CREATE TABLE people  (
    person_id BIGINT auto_increment NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);
