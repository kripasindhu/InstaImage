//package com.app.instaimage.dialogs
//
//import android.app.Dialog
//import android.graphics.Color
//import android.graphics.drawable.ColorDrawable
//import android.os.Bundle
//import android.text.SpannableStringBuilder
//import android.view.View
//import androidx.core.text.bold
//import androidx.fragment.app.DialogFragment
//import com.app.instaimage.R
//import com.app.instaimage.databinding.FragmentConfirmDialogBinding
//import dagger.hilt.android.AndroidEntryPoint
//import javax.inject.Inject
//
//@AndroidEntryPoint
//class ConfirmDialogFragment111 @Inject constructor() :
//    DialogFragment(R.layout.fragment_confirm_dialog) {
//
//    private lateinit var binding: FragmentConfirmDialogBinding
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        binding = FragmentConfirmDialogBinding.bind(view)
////        dialog?.window?.attributes?.windowAnimations = R.style.DialogTheme
////
////        val user = arguments?.getString("user")
////
////        //Shows the name of the user
////        val alert = SpannableStringBuilder()
////            .append(getString(R.string.alert))
////            .append(" ")
////            .bold { append(user) }
////            .append("?")
////
////        binding.apply {
////            caution.text = alert
////            cancel.setOnClickListener {
////                dialog?.dismiss()
////            }
////            confirm.setOnClickListener {
////                dialog?.dismiss()
////            }
////        }
//    }
//
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val dialog = super.onCreateDialog(savedInstanceState)
//        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        return dialog
//    }
//
//}