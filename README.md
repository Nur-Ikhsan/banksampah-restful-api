# API Spec
API Spec Untuk Aplikasi Bank Sampah (BS) Mobile

## Authentication

Semua API Harus Menggunakan Autentikasi Ini

Request:
- Header :
  - X-Api-Key : "your secret api key"

## Trash
Berisi Dafar Harga Dari Sampah Yang Akan Di Jual

### Create Trash
Request :
- Method : POST
- Endpoint : '/api/trash'
- Header :
  - Content-Type : application/json
  - Accept : application/json
- Body :

```json
{
  "id" : "number, unique",
  "name" : "string",
  "price" : "long",
  "description" : "string"
}
```

Response : 

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "price" : "long",
    "description" : "string"
  }
}
```

### Get Trash
Request :
- Method : GET
- Endpoint : '/api/trash/{id_trash}'
- Header :
  - Accept : application/json

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "price" : "long",
    "description" : "string"
  }
}
```

### Update Trash
Request :
- Method : PUT
- Endpoint : '/api/trash/{id_trash}'
- Header :
  - Content-Type : application/json
  - Accept : application/json
- Body :

```json
{
  "name" : "string",
  "price" : "long",
  "description" : "string"
}
```

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "price" : "long",
    "description" : "string"
  }
}
```

### List Trash
Request :
- Method : GET
- Endpoint : '/api/trash'
- Header :
  - Accept : application/json
- Query Param :
  - size : number,
  - page : number

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id" : "number, unique",
      "name" : "string",
      "price" : "long",
      "description" : "string"
    },
    {
      "id" : "number, unique",
      "name" : "string",
      "price" : "long",
      "description" : "string"
    }
  ]
}
```

### Delete Trash
Request :
- Method : DELETE
- Endpoint : '/api/trash/{id_trash}'
- Header :
  - Accept : application/json

Response :

```json
{
  "code" : "number",
  "status" : "string"
}
```

## Location

Berisi Lokasi Bank Sampah Yang Tersedia

### Create Location
Request :
- Method : POST
- Endpoint : '/api/locations'
- Header :
  - Content-Type : application/json
  - Accept : application/json
- Body :

```json
{
  "id" : "number, unique",
  "name" : "string",
  "address" : "string",
  "open_time" : "time",
  "close_time" : "time",
  "contacts" : "string"
}
```

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "address" : "string",
    "open_time" : "time",
    "close_time" : "time",
    "contacts" : "string"
  }
}
```


### Get Location
Request :
- Method : GET
- Endpoint : '/api/locations/{id_location}'
- Header :
  - Accept : application/json

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "address" : "string",
    "open_time" : "time",
    "close_time" : "time",
    "contacts" : "string"
  }
}
```
### Update Location
Request :
- Method : PUT
- Endpoint : '/api/locations/{id_location}'
- Header :
  - Content-Type : application/json
  - Accept : application/json
- Body :

```json
{
  "name" : "string",
  "address" : "string",
  "open_time" : "time",
  "close_time" : "time",
  "contacts" : "string"
}
```

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "address" : "string",
    "open_time" : "time",
    "close_time" : "time",
    "contacts" : "string"
  }
}
```
### List Location
Request :
- Method : GET
- Endpoint : '/api/locations'
- Header :
  - Accept : application/json
- Query Param :
  - size : number,
  - page : number

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id" : "number, unique",
      "name" : "string",
      "address" : "string",
      "open_time" : "time",
      "close_time" : "time",
      "contacts" : "string"
    },
    {
      "id" : "number, unique",
      "name" : "string",
      "address" : "string",
      "open_time" : "time",
      "close_time" : "time",
      "contacts" : "string"
    }
  ]
}
```
### Delete Location
Request :
- Method : DELETE
- Endpoint : '/api/locations/{id_location}'
- Header :
  - Accept : application/json

Response :

```json
{
  "code" : "number",
  "status" : "string"
}
```


## Account

Berisi Akun Pengguna Yang Terdaftar

### Create Account
Request :
- Method : POST
- Endpoint : '/api/accounts'
- Header :
  - Content-Type : application/json
  - Accept : application/json
- Body :

```json
{
  "id" : "number, unique",
  "name" : "string",
  "email" : "string",
  "address" : "string",
  "phoneNumber" : "string",
  "password" : "string"
}
```

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "email" : "string",
    "address" : "string",
    "phoneNumber" : "string",
    "password" : "string"
  }
}
```
### Get Account
Request :
- Method : GET
- Endpoint : '/api/accounts/{id_account}'
- Header :
  - Accept : application/json

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "email" : "string",
    "address" : "string",
    "phoneNumber" : "string",
    "password" : "string"
  }
}
```
### Update Account
Request :
- Method : PUT
- Endpoint : '/api/accounts/{id_account}'
- Header :
  - Content-Type : application/json
  - Accept : application/json
- Body :

```json
{
  "name" : "string",
  "email" : "string",
  "address" : "string",
  "phoneNumber" : "string",
  "password" : "string"
}
```

Response :

```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "number, unique",
    "name" : "string",
    "email" : "string",
    "address" : "string",
    "phoneNumber" : "string",
    "password" : "string"
  }
}
```
### Delete Account
Request :
- Method : DELETE
- Endpoint : '/api/accounts/{id_account}'
- Header :
  - Accept : application/json

Response :

```json
{
  "code" : "number",
  "status" : "string"
}
```