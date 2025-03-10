## MESSAGING

# CONSUMER
ms-category.process -> receive an history and process it
ms-category-fail -> receive an history(saga rollback) and rollback the current service

# PRODUCER
api-gateway.saga-fail -> receive an history and send the saga rollback to api gateway
ms-product.process -> receive an history process and send to ms-product
