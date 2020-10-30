package com.akashbakshi.products.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="products")
data class Product (
    @Id
    val id:String = ObjectId.get().toHexString(),
    var name:String,
    var price:Double,
    var quantity:Int
)