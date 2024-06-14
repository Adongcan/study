package com.ztkj.victe.ui.health

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.victe.msit.retrofitlibrary.utils.RetrofitTools
import com.ztkj.victe.MyApplication
import com.ztkj.victe.R
import com.ztkj.victe.ui.health.model.Health
import kotlinx.android.synthetic.main.finance5.*
import java.text.SimpleDateFormat
import java.util.logging.SimpleFormatter

class Finan4Fragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.finance5,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    var type=1;

    fun getData() {
        var formate = SimpleDateFormat("yyyy-MM-dd");
        var map = HashMap<String, String>();
        map.put("userid","${MyApplication.user.userid}")
        RetrofitTools.post(
            "getAllHealth",
            map,
            Health::class.java,
            object : RetrofitTools.IRetrofitResponse {
                override fun <T> success(succ: T) {
                    var finances = succ as List<Health>
//                Log.e("TAG","==${finances.size}=")
                    var datas = ArrayList<Double>();
                    var mDesciptions = ArrayList<String>()
                    var colors = ArrayList<Int>()

                    if (finances != null && finances.size > 0) {
                        finances.forEach {
                            if (type==1){
                                datas.add(it.xuey.toDouble())
                                linechart.setBarTitle("血压折线图")
                            }else if (type==2){
                                datas.add(it.xuet.toDouble())
                                linechart.setBarTitle("血糖折线图")
                            }else if (type==3){
                                datas.add(it.xuez.toDouble())
                                linechart.setBarTitle("血脂折线图")
                            }

                            mDesciptions.add(formate.format(formate.parse(it.sendtime)))
                            colors.add(generateRandomColor())
                        }

                    } else {
                        datas.add(0.0)
                        mDesciptions.add("暂无数据")
                    }
                    linechart.setDatas(datas, mDesciptions)

                    rg.setOnCheckedChangeListener { radioGroup, i ->
                        if (i==R.id.rb1){
                            type=1
                        }else if (i==R.id.rb2){
                            type=2
                        }else if (i==R.id.rb3){
                            type=3
                        }
                    }
//                frameNewBase.setDatas(datas,mDesciptions,true)
                }

                override fun failure(msg: String) {

                }

                fun generateRandomColor(): Int {
                    val alpha = (0..255).random()
                    val red = (0..255).random()
                    val green = (0..255).random()
                    val blue = (0..255).random()
                    return Color.argb(alpha, red, green, blue)
                }

            })

    }

}