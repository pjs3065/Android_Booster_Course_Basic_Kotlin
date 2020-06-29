package com.practice.demogridview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(private val context: Context) : BaseAdapter() {

    //이미지 배열
    private val images = arrayOf(
        R.drawable.android,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground)

    //뷰들을 어떻게 보여줄지?, 레이아웃은 어떻게 나타낼지 설정하는 코드
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView:ImageView

        //재사용할 수 있는 ImageView가 없다면 새로 생성
        if(convertView == null){
            imageView = ImageView(context)
            imageView.run{
                layoutParams = ViewGroup.LayoutParams(200,200)
                scaleType = ImageView.ScaleType.FIT_CENTER
                setPadding(10,10,10,10)
            }
        }else{
            //재사용할 수 있는 ImageView가 있다면 재사용한다.
            imageView = convertView as ImageView
        }

        //이미지 인자로 넘어온 position에 맞게 이미지를 설정한다.
        imageView.setImageResource(images[position])
        return imageView
    }

    override fun getItem(position: Int): Any = images[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = images.size
}