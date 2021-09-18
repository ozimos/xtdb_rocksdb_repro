# xtdb_rocksdb_repro

Error Repro Repo for SIGSEV on XTDB RocksDB Index


## Setup

Create a docker postgres DB for the repo. For more info see this article https://towardsdatascience.com/how-to-run-postgresql-and-pgadmin-using-docker-3a6a8ae918b5

A docker-compose file is provided in the repo
Run the command below in the root repo directory

    $ docker compose up

## Usage

The SIGSEV happens during testing

Run the test:

    $ bin/kaocha


### Bugs

...



