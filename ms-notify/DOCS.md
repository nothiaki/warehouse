## MESSAGING

# CONSUMER
ms-notify.process -> receive an history and process it

# PRODUCER
api-gateway.end-saga -> if everything ok send to api gateway to end saga
ms-product.fail -> if it fail send a history to product rolllback
