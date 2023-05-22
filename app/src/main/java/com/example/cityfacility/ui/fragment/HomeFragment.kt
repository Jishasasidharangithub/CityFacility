package com.example.cityfacility.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.cityfacility.R
import com.example.cityfacility.databinding.FragmentHomeBinding
import com.example.cityfacility.ui.adapter.PackageAdapter
import com.example.cityfacility.ui.adapter.SliderAdapter
import com.example.cityfacility.ui.adapter.SubServiceAdapter
import com.example.cityfacility.ui.modelclass.PackageItem
import com.example.cityfacility.ui.modelclass.SliderItem
import com.example.cityfacility.ui.modelclass.SubServiceItem
import kotlinx.coroutines.delay

class HomeFragment : Fragment(), PackageAdapter.PackageAdapterListener {

    private var binding: FragmentHomeBinding? = null
    private var slidingDotsCount = 0
    private lateinit var slidingImageDots: Array<ImageView?>

    private val subServiceAdapter: SubServiceAdapter by lazy { SubServiceAdapter() }
    private val packageAdapter: PackageAdapter by lazy { PackageAdapter(this ) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setSpinner()
        handleEvents()
    }

    override fun viewMoreClick(foodTime: PackageItem, pos: Int) {
        //logThis(workoutItem.title)
        findNavController().navigate(R.id.basicFragment)
    }

    private fun handleEvents(){
        binding?.tvViewall?.setOnClickListener {
            findNavController().navigate(R.id.ourServicesFragment)
        }

        binding?.ivNotification?.setOnClickListener {
            findNavController().navigate(R.id.notificationFragment)
        }

        binding?.ivSearch?.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
        }

    }

    private fun initViews() {
        /*****RECYCLER HOME ITEMS********/
        binding?.rvSet?.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, LinearLayoutManager.HORIZONTAL, false)
            adapter = subServiceAdapter
            serviceData()
        }
        /*****RECYCLER HOME PACKAGE ITEMS********/
        binding?.rvPackages?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = packageAdapter
            packageData()
        }


        binding?.vpSlide?.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            registerOnPageChangeCallback(slidingCallback)
            autoScroll(viewLifecycleOwner, 2000)
        }
        val bannerImages = arrayListOf(
            SliderItem(1, R.drawable.image1),
            SliderItem(2, R.drawable.image2),

            )
        setupSlider(bannerImages)
    }

    fun serviceData() {
        val subList = listOf(
            SubServiceItem(
                R.drawable.ic_sanitizer,
                "Disinfection",
            ), SubServiceItem(
                R.drawable.ic_sanitizer,
                "Air Conditioning",
            ), SubServiceItem(
                R.drawable.ic_sanitizer,
                "Cleaning Service",
            ), SubServiceItem(
                R.drawable.ic_sanitizer,
                "Electrical",
            ), SubServiceItem(
                R.drawable.ic_sanitizer,
                "Handyman",
            ), SubServiceItem(
                R.drawable.ic_sanitizer,
                "Home Improvement",
            )
        )


        subServiceAdapter.updateList(subList)
    }

    fun packageData() {
        val packageList = listOf(
            PackageItem(
                R.drawable.ic_card_giftcard,
                "BASIC",
                "AED 250"
            ), PackageItem(
                R.drawable.ic_card_giftcard,
                "STANDARD",
                "AED 400"
            ), PackageItem(
                R.drawable.ic_card_giftcard,
                "EXECUTIVE",
                "AED 800"
            )
        )

        packageAdapter.updateList(packageList)
    }


    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {

            for (i in 0 until slidingDotsCount) {
                slidingImageDots[i]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.non_active_dot
                    )
                )
            }

            slidingImageDots[position]?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.active_dot
                )
            )
        }
    }

    private fun setupSlider(bannerList: ArrayList<SliderItem>) {
        binding?.vpSlide?.let {
            it.apply {
                adapter = SliderAdapter(bannerList)
            }
            slidingDotsCount = bannerList.size
            slidingImageDots = emptyArray()
            slidingImageDots = arrayOfNulls(slidingDotsCount)
            binding?.llSlideIndicator?.removeAllViews()
            for (i in 0 until slidingDotsCount) {
                slidingImageDots[i] = ImageView(requireContext())
                slidingImageDots[i]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.non_active_dot
                    )
                )
                val params =
                    LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )

                params.setMargins(8, 0, 8, 0)
                binding?.llSlideIndicator?.addView(slidingImageDots[i], params)
            }
            slidingImageDots[0]?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.active_dot
                )
            )
        }
    }

    private fun setSpinner() {
        val location = listOf("Choose location", "Abu Dhabi", "Abu Dhabi", "Abu Dhabi", "Abu Dhabi")
        binding?.locationSpinner?.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, location)

        binding?.locationSpinner?.setSelection(0)

        binding?.locationSpinner?.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedLocation = location[position]
                    // Handle the selected gender
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // Do nothing
                }
            }
    }

    fun ViewPager2.autoScroll(lifecycleScope: LifecycleOwner, interval: Long) {
        lifecycleScope.lifecycleScope.launchWhenResumed {
            scrollIndefinitely(interval)
        }
    }

    suspend fun ViewPager2.scrollIndefinitely(interval: Long) {
        try {
            while (true) {
                delay(interval)
                val numberOfItems = adapter?.itemCount ?: 0
                if (numberOfItems > 0) {
                    val nextItem = (currentItem + 1) % numberOfItems
                    setCurrentItem(nextItem, true)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
