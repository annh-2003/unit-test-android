package com.sun.training.ut.ui.excercise_six

import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.ui.base.BaseViewModel

const val FIRST_MONEY_POINT = 2000
const val FIRST_FREE_TIME = 60
const val SECOND_MONEY_POINT = 5000
const val SECOND_FREE_TIME = 120
const val WATCH_MOVIE_FREE_TIME = 180

/**
◎Exercise
Tại trung tâm mua sắm "Tây Hồ", hiện đang cung cấp dịch vụ trông xe miễn phí trong một khoảng thời gian nhất định,
tuỳ thuộc vào tổng số tiền mua sắm và việc khách hàng có xem phim tại trung tâm không.
Các điều kiện được ghi ở bên dưới:
---
●Điều kiện tiên quyết：
①：Trường hợp tổng số tiền mua sắm từ 2,000円/yên trở lên, miễn phí phí gửi xe trong 60 phút.
②：Trường hợp tổng số tiền mua sắm từ 5,000円/yên trở lên, miễn phí gửi xe trong 120 phút.
③：Nếu khách hàng có xem phim, miễn phí gửi xe thêm 180 phút, cộng bổ sung vào cùng với tổng số tiền mua sắm.
 */
class ExerciseSixViewModel : BaseViewModel() {


}