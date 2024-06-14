package com.ztkj.victe.ui.userinfo

import android.os.Bundle
import android.text.TextUtils
import com.victe.msit.retrofitlibrary.utils.RetrofitTools
import com.ztkj.victe.MyApplication
import com.ztkj.victe.R
import com.ztkj.victe.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.activity_update_pass.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePassActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_pass)
        TongJi()
        tongji_head_text.text = "修改密码"
        update_login_text.setOnClickListener {
            if(TextUtils.isEmpty(update_pass_old_edittext.text)){
                toast("原密码不能为空")
            }
            else if(TextUtils.isEmpty(update_pass_new_edittext.text)){
                toast("新密码不能为空")
            }
            else if(!update_pass_new_edittext.text.toString().trim().equals(update_pass_renew_edittext.text.toString().trim())){
                toast("两次密码出入不一致")
            }
            else if (!MyApplication.user.password!!.equals(update_pass_old_edittext.text.toString())){
                toast("原密码输入错误")
            }
            else{
                var map = HashMap<String,String>();
                map.put("userid",MyApplication.user.userid.toString())
                map.put("password",update_pass_renew_edittext.text.toString())
                RetrofitTools.get("updateUser",map,String::class.java,object :RetrofitTools.IRetrofitResponse{
                    override fun <T> success(succ: T) {
                        if ("true".equals(succ)){
                            toast("密码修改成功")
                            finish()
                        }
                        else{
                            toast("密码修改失败")
                        }
                    }

                    override fun failure(msg: String) {
                       toast(msg)
                    }

                },false)

            }
        }
    }
}
