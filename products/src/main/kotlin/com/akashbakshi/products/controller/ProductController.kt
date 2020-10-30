package com.akashbakshi.products.controller


import com.akashbakshi.products.model.Product
import com.akashbakshi.products.repository.ProductRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.ws.rs.Path

@RestController
@RequestMapping("v1/product")
class ProductController(val productRepo: ProductRepository) {

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id:String):Product = productRepo.findOneById(ObjectId(id))


    @GetMapping("/")
    fun getAllProducts():List<Product> = productRepo.findAll()

    @PostMapping("/")
    fun createProduct(@RequestBody newProduct: Product): Product{
        productRepo.insert(newProduct)
        return newProduct
    }


    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id:String,@RequestBody updatedProduct:Product):Product{
        val originalProduct = productRepo.findOneById(ObjectId(id))

        if(!updatedProduct.name.isEmpty())
            originalProduct.name = updatedProduct.name
        if(!updatedProduct.price.isNaN() && updatedProduct.price != 0.0)
            originalProduct.price = updatedProduct.price
        if(updatedProduct.quantity != 0)
            originalProduct.quantity = updatedProduct.quantity

        productRepo.save(originalProduct)
        return originalProduct
    }

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable id:String){
        productRepo.deleteById(id)
    }
}