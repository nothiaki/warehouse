## MESSAGING

# CONSUMER
ms-product.create -> receive a List of Product and save in DB
ms-product.process -> process the product and save in DB
ms-product.fail -> rollback the products saved

# PRODUCER
ms-category.fail -> rollback saga if fail
ms-notify.process -> receive a history and process it
