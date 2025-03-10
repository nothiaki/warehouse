#### PRODUCTS

POST /products
```json
{
  "products": [
    {
      "name": String,
      "quantity": Long,
      "category": String
    }
  ]
}
```
reponse: 202ACCEPTED

DELETE /products
```json
{
  "products": [
    {
      "name": String,
      "quantity": Long,
      "category": String
    }
  ]
}
```
reponse: 202ACCEPTED

GET /history/{id}
response: 200OK

#### MESSAGING

CONSUMER

api-gateway.end-saga -> receive the sucessfully history and end saga

PRODUCER

ms-product.create -> send a List of Products to product service create in DB
ms-category.process -> send an history to category service process

