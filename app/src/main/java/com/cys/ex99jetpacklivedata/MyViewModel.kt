package com.cys.ex99jetpacklivedata

import androidx.lifecycle.MutableLiveData
import java.util.Date

class MyViewModel {
    //Live Data : ObservableXXX 와 다르게 라이프 사이클에 따라 효율적으로 UI를 갱신

    val name: MutableLiveData<String> = MutableLiveData("sam")
    val age: MutableLiveData<Int> = MutableLiveData(20)

    //  1.1데이터 변경 콜백 메소드
    fun changeName() {
        name.value = "ROBIN"
        //ObservableXXX 와 다르게 값을 변경해도 자동 갱신하지 않음
        //자동 갱신 방법2가지
        //1.LiveData 변수를 관찰하는 observe() 메소드를 통해 관찰 UI갱신
        //2.LiveData 의 변화를 반영할 LifeCycleOwner를 미리 지정
    }

    fun increaseAge() {
        age.value = age.value!!.toInt() + 1
    }

    //2.리사이클러 뷰에 LiveData 변수 적용
    val items: MutableLiveData<MutableList<Item>> =
        MutableLiveData(mutableListOf(Item("sam", "Hello")))

    //2.1 아이템 추가하면 화면 자동갱신
    fun addItem() {
        val list = items.value
        list?.add(0, Item("NEW", Date().toString()))
        ///items.value=list
        items.postValue(list)
    }
}