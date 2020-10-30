package com.akashbakshi.products.repository

import com.akashbakshi.products.model.Product
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

interface ProductRepository:MongoRepository<Product,String> {
    fun findOneById(id:ObjectId):Product
}