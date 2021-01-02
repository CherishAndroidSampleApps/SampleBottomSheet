package com.sopt.samplebottomsheet

import android.animation.ArgbEvaluator
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.sopt.samplebottomsheet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var standardBottomSheet: ConstraintLayout
    private lateinit var testConstraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dataset = arrayListOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        val mainAdapter = MainAdapter(dataset)

        initialSettingStandardBottomSheet(binding, mainAdapter)

    }

    private fun initialSettingStandardBottomSheet(
        binding: ActivityMainBinding,
        mainAdapter: MainAdapter
    ) {
        testConstraintLayout = findViewById(R.id.test_constraint)
        standardBottomSheet = findViewById(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.peekHeight = 300
        bottomSheetBehavior.expandedOffset = 100
        bottomSheetBehavior.isHideable = false

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                //  BottomSheet 상태변화
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // 좀 더 스크롤을 어떻게 분리할지는 생각해봐야하는게 맞는거 같다

                // 오히려 이 문구가 없는게 좀 더 스크롤이 괜찮은거 같기도 하고????
                /*bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED*/
                /*transitionBottomSheetBackgroundColor(slideOffset)*/
                transitionBottomSheetParentView(slideOffset)
            }
        })
        /*        initRecyclerView(standardBottomSheet, mainAdapter)*/
    }

    private fun transitionBottomSheetParentView(slideOffset: Float){
        val argbEvaluator = ArgbEvaluator().evaluate(slideOffset,0xf0f0f0,Color.GRAY)
        testConstraintLayout.setBackgroundColor(argbEvaluator as Int)
    }

    /*private fun initRecyclerView(standardBottomSheet: ConstraintLayout?, mainAdapter: MainAdapter) {
        val recyclerView = standardBottomSheet?.findViewById<RecyclerView>(R.id.test_list)
        recyclerView?.apply {
            adapter = mainAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }*/

}