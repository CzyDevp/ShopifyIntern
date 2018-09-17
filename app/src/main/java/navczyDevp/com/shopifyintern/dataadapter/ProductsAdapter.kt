package navczyDevp.com.shopifyintern.dataadapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.product_item.view.*
import navczyDevp.com.shopifyintern.R
import navczyDevp.com.shopifyintern.model.Product


class ProductsAdapter(private val context: Context,private val product:List<Product>?) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_item, parent, false))
    }
    override fun onBindViewHolder(productViewHolder: ProductViewHolder, position: Int) {
        var totalInventory:Int?
        productViewHolder.title.text= product?.get(position)?.title
        totalInventory=product?.get(position)?.variants?.asSequence()?.map { it->it.inventory_quantity }?.sum()
        productViewHolder.inventoryStock.text="Total Count: ${totalInventory.toString()}"
        Glide.with(context)
                .load(product?.get(position)?.image?.src)
                .placeholder(R.drawable.shopify).centerCrop().override(100,100)
                .into(productViewHolder.pImage)
    }

    override fun getItemCount():Int =  product?.size?:0
}

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title : TextView = view.title
    val inventoryStock : TextView = view.inventory
    val pImage: ImageView = view.image
    }


