package navczyDevp.com.shopifyintern.activities

import navczyDevp.com.shopifyintern.model.MainModel
import navczyDevp.com.shopifyintern.model.Product

class UniqueTagProcess {
    companion object {
        fun tags( model: MainModel):List<String>{
            return model.products.asSequence()
                           .map { it->it.tags.split(", ") }
                           .flatMap { it->it.asSequence() }
                           .distinct().toList().sorted()
        }

        fun filteredProducts(tag:String,products:ArrayList<Product>):List<Product>{
            return products.asSequence()
                           .filter { it->it.tags.contains(tag)}
                           .toList()
        }
    }
}