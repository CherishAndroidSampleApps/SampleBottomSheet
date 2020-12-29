package com.sopt.samplebottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var modalBottomSheet: ModalBottomSheet
    private lateinit var standardBottomSheet : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialSettingStandardBottomSheet()

    }

    private fun initialSettingStandardBottomSheet(){
        // kotlin extension is deprecated , so we need to findViewById or viewBinding
        /**
         *
         * dialog_bottom_sheet은 bottom_sheet안에 들어갈 레이아웃
         *
         * include 구문을 통해 보다 레이아웃inflate 될떄의 효율성을 가져올 수 있음
         *
         * Coordinator layout 안에 들어가있어야함
         */
        standardBottomSheet = findViewById(R.id.standardBottomSheet)

        bottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.peekHeight = 300
        bottomSheetBehavior.expandedOffset = 100

        /**
         *
         * bottom sheet dialog에 callback 달아주는 방법
         *
         */
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })

        bottomSheetBehavior.removeBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }

    /**
     *
     * dismiss를 통해서 modal을 나타내어야 한다 공식문서 참조
     *
     */
    private fun initialSettingModalBottomSheet(){
        modalBottomSheet = ModalBottomSheet()
        modalBottomSheet.show(supportFragmentManager,ModalBottomSheet.TAG)
    }
}