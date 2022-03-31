package ca.qc.cstj.consortium.presentation.ui.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DeliveryDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val deliveryNumber = arguments?.getString(DELIVERY_NUMBER)
    }

    companion object {
        const val TAG = "DELIVERY_DIALOG_TAG"
        const val DELIVERY_NUMBER = "DELIVERY_NUMBER"
    }
}