import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieexample.Util
import com.example.movieexample.models.Restaurant
import com.example.movieexample.databinding.ItemRestaurantBinding

class MyAdapter(var data:List<Restaurant>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
val util = Util()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size
    fun updateData(newData: List<Restaurant>) {
        data = newData
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            textView2.text = data[position].nom
            textView3.text = data[position].description
            textView4.text = data[position].address
            restaurantCategories.text = data[position].category
           // closedBg.setImageResource(data[position].logo)
            //root.setOnClickListener {
            //    val intent = Intent(it.context, MenuActivity::class.java)
            //    intent.putExtra("restaurantId",data[position]._id)
            //    it.context.startActivity(intent)
            //}
            imageView3.setOnClickListener {
                util.openFacebook(it.context,"fb://page/218641444910278")
            }
            imageView1.setOnClickListener {
                util.callPhoneNumber(it.context ,data[position].phone)
            }
            imageView2.setOnClickListener {
                util.openGmailApp(it.context)
            }
            imageView4.setOnClickListener {
                util.openGoogleMaps(it.context,data[position].latitude,data[position].longitude)
            }
        }
    }

    class MyViewHolder(val binding: ItemRestaurantBinding) : RecyclerView.ViewHolder(binding.root)

}