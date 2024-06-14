package com.ztkj.victe.ui.userinfo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.bumptech.glide.Glide
import com.mylhyl.circledialog.CircleDialog
import com.mylhyl.circledialog.view.listener.OnInputClickListener
import com.victe.msit.retrofitlibrary.utils.RetrofitTools
import com.ztkj.victe.MyApplication
import com.ztkj.victe.R
import com.ztkj.victe.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.activity_show_person.*
import okhttp3.MultipartBody

class ShowPersonActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TongJi()
        tongji_head_text.setText("个人信息")
        setContentView(R.layout.activity_show_person)
        show_person_username_tv.setText(MyApplication.user.username)
        show_person_nickname_tv.setText(MyApplication.user.nickname)
        show_person_age_tv.setText(MyApplication.user.age.toString())
        show_person_tel_tv.setText(MyApplication.user.tel)
        show_person_address_tv.setText(MyApplication.user.address)
        show_person_sex_tv.setText(MyApplication.user.sex)
        show_person_weight_tv.setText(MyApplication.user.weight.toString())
        show_person_height_tv.setText(MyApplication.user.height.toString())

        show_person_weight_tv.setOnClickListener {
            CircleDialog.Builder(this@ShowPersonActivity)
                .setTitle("体重")
                .setInputHint("请输入体重")
                .setPositiveInput("确定",object: OnInputClickListener {
                    override fun onClick(text: String?, v: View?) {
                        if (TextUtils.isEmpty(text)){
                            toast("内容不能为空")
                            return;
                        }
                        getdata("weight",text!!)
                        MyApplication.user.nickname = text;
                        show_person_nickname_tv.setText(text!!)
                    }
                })
                .setNegative("取消", null)
                .show()
        }

        show_person_nickname_tv.setOnClickListener {
            CircleDialog.Builder(this@ShowPersonActivity)
                .setTitle("昵称")
                .setInputHint("请输入昵称")
                .setPositiveInput("确定",object: OnInputClickListener {
                    override fun onClick(text: String?, v: View?) {
                        if (TextUtils.isEmpty(text)){
                            toast("内容不能为空")
                            return;
                        }
                        getdata("nickname",text!!)
                        MyApplication.user.nickname = text;
                        show_person_nickname_tv.setText(text!!)
                    }
                })
                .setNegative("取消", null)
                .show()
        }
        show_person_address_tv.setOnClickListener {
            CircleDialog.Builder(this@ShowPersonActivity)
                .setTitle("地址")
                .setInputHint("请输入地址")
                .setPositiveInput("确定",object: OnInputClickListener {
                    override fun onClick(text: String?, v: View?) {
                        if (TextUtils.isEmpty(text)){
                            toast("内容不能为空")
                            return;
                        }
                        getdata("address",text!!)
                        MyApplication.user.address = text;
                        show_person_address_tv.setText(text!!)
                    }
                })
                .setNegative("取消", null)
                .show()
        }
        show_person_tel_tv.setOnClickListener {
            CircleDialog.Builder(this@ShowPersonActivity)
                .setTitle("电话")
                .setInputHint("请输入电话")
                .setPositiveInput("确定",object: OnInputClickListener {
                    override fun onClick(text: String?, v: View?) {
                        if (TextUtils.isEmpty(text)){
                            toast("内容不能为空")
                            return;
                        }
                        getdata("address",text!!)
                        MyApplication.user.tel = text;
                        show_person_tel_tv.setText(text!!)
                    }
                })
                .setNegative("取消", null)
                .show()
        }
        show_person_age_tv.setOnClickListener {
            CircleDialog.Builder(this@ShowPersonActivity)
                .setTitle("年龄")
                .setInputHint("请输入年龄")
                .setPositiveInput("确定",object: OnInputClickListener {
                    override fun onClick(text: String?, v: View?) {
                        if (TextUtils.isEmpty(text)){
                            toast("内容不能为空")
                            return;
                        }
                        getdata("age",text!!)
                        MyApplication.user.age = text.toInt();
                        show_person_age_tv.setText(text!!)
                    }
                })
                .setNegative("取消", null)
                .show()
        }

        if(MyApplication.sumStep<500){
            Glide.with(this).load(R.mipmap.x1).error(R.mipmap.ic_launcher).into(show_person_xunz_tv)
            xunz_tv.setText("青铜")
        }else if(MyApplication.sumStep<1000){
            Glide.with(this).load(R.mipmap.x2).error(R.mipmap.ic_launcher).into(show_person_xunz_tv)
            xunz_tv.setText("白银")
        }else{
            Glide.with(this).load(R.mipmap.x3).error(R.mipmap.ic_launcher).into(show_person_xunz_tv)
            xunz_tv.setText("钻石")
        }

        var bmi = MyApplication.user.weight/MyApplication.user.height
        if("男".equals(MyApplication.user.sex)){
            if(bmi>=18&&bmi<=24){
                show_person_bmi_tv.setText("正常")
            }else if (bmi<18){
                show_person_bmi_tv.setText("营养不良")
            }else if(bmi>24&&bmi<=28){
                show_person_bmi_tv.setText("超重")
            }else{
                show_person_bmi_tv.setText("肥胖")
            }
        }else{
            if(bmi>=17.2&&bmi<=24){
                show_person_bmi_tv.setText("正常")
            }else if (bmi<17.2){
                show_person_bmi_tv.setText("营养不良")
            }else if(bmi>24&&bmi<=27.9){
                show_person_bmi_tv.setText("超重")
            }else{
                show_person_bmi_tv.setText("肥胖")
            }
        }

    }

    fun getdata(key:String,value:String){
        var parts = ArrayList<MultipartBody.Part>()
        var map = HashMap<String,String>()
        map.put("userid",MyApplication.user.userid.toString())
        map.put(key,value)
        RetrofitTools.upload("updateUser",map,parts,object :RetrofitTools.IRetrofitResponse{
            override fun <T> success(succ: T) {
                if("true".equals(succ)){
                    toast("修改成功")
                }else{
                    toast("修改失败")
                }
            }

            override fun failure(msg: String) {
              toast(msg)
            }

        })
    }
}
