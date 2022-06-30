# scalardb-resrevation

## Requirement

### Docker

- For Mac: Install Docker Desktop
- For Linux:

```
sudo apt-get update
sudo apt-get install docker
sudo apt-get install docker-compose
```

### JDK

- Install JDK

## Git Clone

```
git clone git@github.com:cirusthenter/scalardb-reservation.git
cd scalardb-reservation
```

## Docker Compose

```
sudo docker-compose up -d
```

- If you have this kind of error, look what is using the port `9042` by `sudo lsof -i -P -n | grep 9042`.

```
❯ sudo docker-compose up -d
Creating network "reservation-network" with the default driver
Creating cassandra-reservation ...
Creating cassandra-reservation ... error
WARNING: Host is already in use by another container

ERROR: for cassandra-reservation  Cannot start service cassandra: driver failed programming external connectivity on endpoint cassandra-reservation (de667ce95f32cd7bc0b1a56adcd1552808666d162bf80019897d3a118231b
Creating mysql-reservation     ... done

ERROR: for cassandra  Cannot start service cassandra: driver failed programming external connectivity on endpoint cassandra-reservation (de667ce95f32cd7bc0b1a56adcd1552808666d162bf80019897d3a118231ba5e): Error starting userland proxy: listen tcp4 0.0.0.0:9042: bind: address already in use
ERROR: Encountered errors while bringing up the project.
```

## Load Initial Data

初期データの読み込み

```
./gradlew run --args="LoadInitialData"
```

## Reserve

ユーザー2が席 3, 4, 5 を予約

```
./gradlew run --args="Reserve 2 3,4,5"
```

## Cancel Reservation

ユーザー2が席3, 5 の予約をキャンセル

```
./gradlew run --args="Cancel 2 3,5"
```

## History

ユーザー2の予約/予約削除の履歴を一覧表示

```
./gradlew run --args="GetHistories 2"
```

## ユーザー情報表示

ユーザー2の情報を表示

```
./gradlew run --args="GetCustomerInfo"
```