Project Tokonyadia-boot

Additional features : 
- Send Email
- Get All Costumer & total payment by merchant id

API Documentation : api_documentation.txt

How to Run this Project :
- Clone Project and run project
    - challenge-tokonyadia-boot [branch : email-feature]
    - tokonyadia-boot-consumer [branch : master]
    - [handson] opo-cash [branch : master]

- run zookepeer, server and create topics
    - cd [kafka-folder]
    - [Tab 1] $ bin/zookeeper-server-start.sh config/zookeeper.properties
    - [Tab 2] $ bin/kafka-server-start.sh config/server.properties
    - [Tab 3] $ bin/kafka-topics.sh --create --topic simple-notification --bootstrap-server localhost:9092
    - [Tab 4] $ bin/kafka-console-producer.sh --topic simple-notification --bootstrap-server localhost:9092
    - [Tab 5] $ bin/kafka-console-consumer.sh --topic simple-notification --from-beginning --bootstrap-server localhost:9092

- Import tokonyadia.sql 

- hit api purchase and see your wallet and email
    - Create Purchase ([feature] Debit wallet & Send Email)
    - POST : http://localhost:8080/customer/{id}/purchases
    - Body : 
            {
            "purchaseDetails": [
                {
                    "quantity": 2,
                    "product": {
                        "id" : "4028e490792ce11f01792ce2cba90002"
                    }
                },
                {
                    "quantity": 1,
                    "product": {
                        "id" : "4028e490792ce11f01792ce2cba80001"
                    }
                }
                
            ]
        }
    
    - Find all customer and total payment by merchant id
    - GET : http://localhost:8080/merchant/{id}/customers 
    

- [additional] If in your database null data, you must be create customer, merchant & product, create wallet
    - Create Customer
    - POST : http://localhost:8080/customer 
    - Body : 
            {
                "firstName" : "dirgantara",
                "lastName" : "siahaan",
                "birthDate" : "2020-09-09",
                "address" : "jakarta",
                "username" : "dirga",
                "password" : "P@ssw0rd",
                "status" : 1,
                "email" : "siahaandirgantara@gmail.com",
                "phoneNumber": "08123231231"
            }

    
    - Create Merchant and Product
    - POST : http://localhost:8080/merchant
    - Body :
            {
                "merchantName": "shooes store",
                "ownerName": "bambang",
                "siupNumber": "123",
                "phoneNumber": "0812123",
                "address": "jakarta",
                "products": [
                    {
                        "name": "product A",
                        "description": "celana jeans",
                        "image": "gambar",
                        "stock": 100,
                        "price": 1000
                    },
                    {
                        "name": "product B",
                        "description": "baju batik",
                        "image": "gambar",
                        "stock": 100,
                        "price": 1000
                    }
                ]
            }

    - Create Wallet
    - POST : http://localhost:8081/wallet
    - Body : 
            {
                "phoneNumber" : "08123231231",
                "balance" : 10000000
            }





