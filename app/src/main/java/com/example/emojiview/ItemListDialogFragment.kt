package com.example.emojiview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import com.example.emojiview.databinding.EmojiViewBinding
import com.google.android.material.chip.Chip


class ItemListDialogFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var binding: EmojiViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EmojiViewBinding.inflate(inflater, container, false)
        binding.badEmoji.setOnClickListener(this)
        binding.closeButton.setOnClickListener(this)
        binding.selectButton.setOnClickListener(this)
        binding.averageEmoji.setOnClickListener(this)
        binding.goodEmoji.setOnClickListener(this)

        return binding.root

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.badEmoji -> {
                expandFeedbackBox(R.drawable.bad_emoji)
                showFeedBackFilterText(R.id.badEmoji)
            }
            R.id.averageEmoji -> {
                expandFeedbackBox(R.drawable.average_emoji)
                showFeedBackFilterText(R.id.averageEmoji)
            }
            R.id.goodEmoji -> {
                expandFeedbackBox(R.drawable.good_emoji)
                showFeedBackFilterText(R.id.goodEmoji)
            }

            R.id.closeButton -> {
                dismiss()
            }
            R.id.selectButton -> {
                // get Selected Chips test for the feedback
                binding?.chipGroup?.children
                    ?.toList()
                    ?.filter { (it as Chip).isChecked }
                    ?.forEach { it ->
                        Log.d("Test", "${(it as Chip).text}")
                    }
            }
        }
    }


    // This function show feedback filter text according to the emoji type which user is clicked etc bad,good
    private fun showFeedBackFilterText(emojiId: Int) {
        when (emojiId) {
            R.id.badEmoji -> {
                binding.chipVideoNotLoad.show()
                binding.chipPoorExplain.show()
                binding.chipHandWriting.show()
                binding.chipAudio.show()
                binding.chipTeachSpeed.show()
                binding.heading.text = "oh! What went wrong?"

            }
            R.id.averageEmoji -> {
                binding.chipLoadindTime.show()
                binding.chipExplain.show()
                binding.chipVideoQaulity.show()
                binding.chipAudio.show()
                binding.chipEnageLecture.show()
                binding.heading.text = "Where can we improve?"

            }
            R.id.goodEmoji -> {
                binding.chipExplain.show()
                binding.chipTeachStyle.show()
                binding.chipDiagram.show()
                binding.chipVideoQaulity.show()
                binding.chipTeachSpeed.show()
                binding.heading.text = "yay! What worked for you?"

            }
        }
    }


    private fun expandFeedbackBox(selectedEmoji: Int) {
        binding.selectedEmoji.setImageResource(selectedEmoji)
        binding.selectedEmoji.visibility = View.VISIBLE
        binding.heading.gravity = Gravity.START
        binding.ratingInputLayout.visibility = View.VISIBLE
        binding.badEmoji.visibility = View.GONE
        binding.averageEmoji.visibility = View.GONE
        binding.goodEmoji.visibility = View.GONE
        changeTopMargin()
    }

    private fun changeTopMargin() {
        (binding.selectButton.layoutParams as ConstraintLayout.LayoutParams).apply {
            topMargin = 8.toDp(requireContext())
        }
    }

    // Extention Functions
    private fun Chip.show() {
        this.visibility = View.VISIBLE
    }

    private fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
    ).toInt()

}